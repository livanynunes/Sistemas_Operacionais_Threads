package travessia;

public class TrafficController {

	private int nred = 0; // number of red cars on bridge
	private int nblue = 0; // number of blue cars on bridge
	
	//monitor invariant: nred>= 0 and nblue>= 0 and not
	// (nred>0 and nblue>0)
	
	// Carros vermelhos passarem de uma vez é coincidência 
    public synchronized void entradaCarroVermelho() throws InterruptedException{
    		while(nblue > 0) {
    			wait(); // trava
    		}
    		++nred;
    }
    
    public synchronized void saidaCarroVermelho() {
    	--nred;
    	if(nred ==0) {
    		notifyAll(); //destrava
    	}
    }
    
    public synchronized void entradaCarroAzul() throws InterruptedException {
    	while(nred>0) {
    		wait(); // trava
    	}
    	++nblue;
    }
    
    public synchronized void saidaCarroAzul() {
    	--nblue;
    	if(nblue ==0) {
    		notifyAll(); // destrava
    	}
    }

}
