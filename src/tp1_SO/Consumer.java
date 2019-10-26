package tp1_SO;

public class Consumer implements Runnable{
	Q q; 
    Consumer(Q q){ 
        this.q = q; 
        new Thread(this, "Consumidor").start();
    } 
      
    public void run() 
    { 
        for(int i=0; i < 5; i++)  
            q.get();	// consumer get items
    } 
}
