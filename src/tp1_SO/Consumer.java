package tp1_SO;

public class Consumer implements Runnable{ 
	Q q; 				// instancia objeto pilha = nosso buffer
    Consumer(Q q){ 
        this.q = q; 
        new Thread(this, "Consumidor").start();
    } 
      
    public void run() 
    { 
        for(int i=0; i < 5; i++)  
            q.get();	// consumidor pega item no buffer 
    } 
}
