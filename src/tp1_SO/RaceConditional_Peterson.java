package tp1_SO;

//	Solução de Peterson para seção critica
public class RaceConditional_Peterson{
	
 int turn;
 boolean flag[] = new boolean[2];
 int i=0,j=1;
 
 int counter=0;						// contador para dar ao processo um limite superior
 
 private class iTh extends Thread{	// thread i 
     public void run(){
             try{
                 do{
                     flag[i]= true;
                     turn=j;
                     while(flag[j]&&turn==j);	// Aguardando por j terminar
   
                     // Seção critica
                     System.out.println("I esta na critical section");
                     counter++;
                     System.out.println("contador: "+counter+"\n___________");
                    
                     flag[i]= false;
                     // Seção restante
                 }while(counter<1000000); 		//100 é o limite superior, para remover o loop infinito 
             }
             catch(Exception ex){
                 ex.printStackTrace();
             }
         }
     }
 private class jTh extends Thread{ // thread j
         public void run(){
             try{
                 do{
                     flag[j]= true;
                     turn=i;
                     while(flag[i]&&turn==i);	//Aguardando processo i terminar
                     //seção critica
                     System.out.println("J esta na critical section");

                     counter++;
                     System.out.println("contador: "+counter+"\n___________");
                     flag[j]= false;
                     //seção restante
                 }while(counter<1000000); 	//100 é o limite superior, para remover o loop infinito
             }
             catch(Exception ex){
                 ex.printStackTrace();
             }
         }
     }
 public RaceConditional_Peterson(){
     System.out.println("Iniciando Threads/Processos");
     Thread I= new iTh();
     Thread J = new jTh();
     I.start(); //inicia processo i
     J.start(); //inicia processo j
 }
    
}
