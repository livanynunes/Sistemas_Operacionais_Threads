package tp1_SO;

import java.io.*;
import java.util.concurrent.Semaphore;


public class Q{
	// um item 
    int item; 
      
    // semCon inicializa com 0 permissões  
    // para garantir que put() execute primeiro !  
    static Semaphore semCon = new Semaphore(0); 
      
    static Semaphore semProd = new Semaphore(1); 
      
    // método para pegar item do buffer 
    void get() 
    { 
        try { 
            // Antes que um consumidor possa pegar um item,  
            // isso deve ser permitido por .acquire() 
            semCon.acquire(); 
        }  
        catch(InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
          
        // consumidor pega um item 
        System.out.println("Consumidor pegou o item : " + item); 
          
        // Após pegar o item,  
        // consumidor informa semProd para notificar produtor que agora o buffer está disponivel 
        semProd.release(); 
    } 
      
    // método para adicionar item ao buffer 
    void put(int item) 
    { 
        try { 
            // Antes que o produtor possa adicionar um item, 
            // deve ser permitido por semProd.acquire()
            semProd.acquire(); 
        } catch(InterruptedException e) { 
            System.out.println("InterruptedException caught"); 
        } 
          
        // Produtor produz um item 
        this.item = item; 
          
        System.out.println("Producer produced item : " + item); 
          
        // Após o produtor produzir um item, 
        // esse informa ao consumidor que o buffer está liberado para poder pegar um item 
        semCon.release(); 
    } 

	
}
