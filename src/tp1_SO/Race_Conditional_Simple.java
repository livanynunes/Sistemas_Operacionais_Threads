package tp1_SO;

public class Race_Conditional_Simple {

		Counter count = new Counter();		// instancia objeto, classe contadora
	
		public Race_Conditional_Simple() {
			
			// Classe Counter é quem implementa Runnable, logo passamos nosso objeto count para instaciar nossas threads
			
			Thread t1 = new Thread(count);	// cria thread 1
			Thread t2 = new Thread(count);	// cria thread 2
			
			t1.start();						// inicia thread 1
			t2.start();						// inicia thread 2
		}
		
		void resultado() {
			System.out.println("Resultado: " + count.getCount() );	// imprime resultado do count ao final dos incrementos!
		}
		
		
	

}
