package travessia;

public class TrafficController {

	private int nred = 0; // number of red cars on bridge
	private int nblue = 0; // number of blue cars on bridge
	private int esperaAzul = 0; //conta o numero de carros azuis que estão na espera
	private int esperaVermelho = 0; // numero de carros vermelhos esperando 
	private boolean vezAzul = true;
	
	//monitor invariant: nred>= 0 and nblue>= 0 and not
	// (nred>0 and nblue>0)
	
	 
    public synchronized void entradaCarroVermelho() throws InterruptedException{
    	++esperaVermelho;
    	
    	while(nblue > 0 || (esperaAzul > 0 && vezAzul) ) {
    			wait(); // aguarda
    		}
    		--esperaVermelho;
    		++nred;
    }
    
    public synchronized void saidaCarroVermelho() {
    	--nred;
    	vezAzul = true;
    	if(nred ==0) {
    		notifyAll(); //prossegue
    	}
    }
    
    public synchronized void entradaCarroAzul() throws InterruptedException {
    	++esperaAzul;
    	while(nred>0 || (esperaVermelho>0 && !vezAzul) ) {
    		wait(); // aguarda
    	}
    	--esperaAzul;
    	++nblue;
    }
    
    public synchronized void saidaCarroAzul() {
    	--nblue;
    	vezAzul = false;
    	if(nblue ==0) {
    		notifyAll(); // destrava
    	}
    }

}
