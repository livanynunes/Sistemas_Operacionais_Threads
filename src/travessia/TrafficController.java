package travessia;

public class TrafficController {

	private int nred = 0; // numero de carros vermelhos na ponte
	private int nblue = 0; // numero de carros azuis na ponte
	
	// variaveis para controlar starvation
	private int esperaAzul = 0; //conta o numero de carros azuis que estão na espera
	private int esperaVermelho = 0; // numero de carros vermelhos esperando 
	private boolean vezAzul = true;
	 
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
