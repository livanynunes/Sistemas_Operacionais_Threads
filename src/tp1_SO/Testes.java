package tp1_SO;

public class Testes {

	public static void main(String[] args) {
		
/////EXERCICIO A-1 RACE CONDITIONAL/////////////////////////////
//		Race_Conditional_Simple testeA1 = new Race_Conditional_Simple();
//		testeA1.resultado();
		
/////EXERCICIO A-2 RACE CONDITIONAL SOLVE/////////////////
//		RaceConditional_Peterson testeA2 = new RaceConditional_Peterson();

/////EXERCICIO B LIMITED BUFFER/////////////////
        Q q = new Q(); 		// creating buffer queue 
        new Consumer(q);	// starting consumer thread 
        new Producer(q);	// starting producer thread 
	}
}
