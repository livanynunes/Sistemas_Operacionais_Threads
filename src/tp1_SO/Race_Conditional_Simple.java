package tp1_SO;

public class Race_Conditional_Simple {

		Counter count = new Counter();
	
		public Race_Conditional_Simple() {
			
			
			Thread t1 = new Thread(count);
			Thread t2 = new Thread(count);
			
			t1.start();
			t2.start();
		}
		
		void resultado() {
			System.out.println("Resultado: " + count.getCount() );
		}
		
		
	

}
