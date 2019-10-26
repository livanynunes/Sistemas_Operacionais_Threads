package tp1_SO;

//Classe para incrementar contador
public class Counter implements Runnable{
//	public class Counter{
	    int count = 0;

//		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				this.count = this.count + 1;
			}
			
//			System.out.println("entrei na thread\n");
			
		}
	    
	    public void increment() {
	    	this.count += 1;
	    }
		
		public int getCount() {
	        return count;
	    }

}
