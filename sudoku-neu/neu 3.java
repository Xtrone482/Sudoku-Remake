public class Generator {
	
	static void feldPrinter(int[][] feld) {
		
		System.out.println("");
		
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				System.out.print(feld[i][j] + " ");
			}
			
			System.out.println("");
		}
	} 
	
	static int stackRandom(int[] stack) {
		
		int maximum = stackCounter(stack);		
		int minimum = 1;
		int range = maximum - minimum + 1;
		
		int x = (int) (Math.random() * range) + minimum;
		
		return x;
	}
	
	static int[] stackMover(int[] stack , int minimum , int target , boolean positiv) {
		
		int speicher = 0; 
		
		if (positiv == true) {
			
			for (int i = target; i < stack.length; i++) {
				speicher = stack[i];
				stack[i] = stack[i+1];
				stack[i+1] = speicher;
			}
			
		} else {
			
			for (int i = target; i > minimum; i--) {
				speicher = stack[i-1];
				stack[i-1] = stack[i];
				stack[i] = speicher;
			}
			
		}

		return stack;
	}
	
	static int[] stackPusher(int[] stack) {
		
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == 0) {
				stackMover(stack , null , stack[i] , true);
			}
		}
		
		return stack;
	}
	
	static int stackCounter(int[] stack) {
		
		int counter = 0;
		
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != 0) {
				counter++;
			}
		}
		
		return counter;
	}
	
	static int[][] generate(int menge) {
		
		int[][][] tempFeld = new int[menge][menge][menge];
		
		// Initialisierung
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				for (int k = 0; k < menge; k++) {
					tempFeld[i][j][k] = k + 1;
				}
			}
		}
		
		// Main
		int[] tempStack = new int[menge];
		
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				for (int k = 0; k < menge; k++) {
					tempStack[k] = tempFeld[i][j][k];
				}
				
				stackPusher(tempStack);
				stackRandom(tempStack);
				
				for (int m = 0; m < stackCounter(tempStack); m++) {
					
					generateFehlersuche(tempFeld , tempStack[m]);
					
				}
			} 
		}
		
		
		// Rückgabe
		int[][] finalFeld = new int[menge][menge];
		
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				finalFeld[i][j] = tempFeld[i][j][0]
			} 
		}
		
		return finalFeld;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(9));
	}
	
}