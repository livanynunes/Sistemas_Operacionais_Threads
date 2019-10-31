package tp1_SO;

//Classe para incrementar contador
public class Counter implements Runnable{
	    int count = 0;

//		@Override
		public void run() {						// Sempre que iniciar (start) thread, contador é incrementado até 1000000
			for (int i = 0; i < 1000000; i++) {	// Para testes bom utilizar 10000
				this.count = this.count + 1;	
			}
						
		}
	    
	    public void increment() {
	    	this.count += 1;
	    }
		
		public int getCount() {
	        return count;
	    }

}
