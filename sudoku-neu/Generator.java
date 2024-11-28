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
		
		stack = stackPusher(stack);
		
		int maximum = stackCounter(stack);
		
		int x = (int) (Math.random() * maximum;
		
		return x;
	}
	
	static int[] stackMover(int[] stack , int target , boolean negativ) {
		
		int speicher = 0; 
		
		if (negativ == true) {
			for (int i = target; i > stack.length; i--) {
				speicher = stack[i-1];
				stack[i-1] = stack[i];
				stack[i] = speicher;
			}
			
			return stack;
		}
		
		for (int i = target; i < stack.length; i++) {
			speicher = stack[i];
			stack[i] = stack[i+1];
			stack[i+1] = speicher;
		}

		return stack;
	}
	
	static int[] stackPusher(int[] stack) {
		
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == 0) {
				stackMover(stack , stack[i] , false);
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
	
	static int[][] generate(int menge) {		// Menge muss {n E N: root(n) E N} sein.
		
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
				stackMover(tempFeld[i][j] , stackRandom(tempFeld[i][j]) , true);
				tempFeld = generatorFehlersuche(tempFeld , i , j);
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
	
	static int[][][] generatorFehlersuche(int[][][] feld , int indikatorX , int indikatorY) {
		
		for (int i = feld.length; i > 1; i--) {
			feld[indikatorX][indikatorY][i] = 0;
		}
		int indikatorWert = feld[indikatorX][indikatorY][0] - 1;
		
		// Reihe[]
		for (int i = 0; i < feld.length; i++) {
			if (i == indikatorX) {
				i++;
			}
			feld[i][indikatorY][indikatorWert] = 0;
		}
		
		// Spalte[][]
		for (int i = 0; i < feld.length; i++) {
			if (i == indikatorY) {
				i++;
			}
			feld[indikatorX][i][indikatorWert] = 0;
		}
		
		// Block-System
		int blockX = 0;
		int blockY = 0;
		int dimension = (int) (Math.sqrt(feld.length));
		boolean gate = false;
		
		// Block-Finder
		while (gate != true) {
			blockX++;
			if (indikatorX < dimension * blockX)) {
				gate = true;
			}
		}
		while (gate != false) {
			blockY++;
			if (indikatorY < dimension * blockY)) {
				gate = false;
			}
		}
		
		// Block-Cleaner
		for (int i = (blockX - 1) * dimension; i < blockX * dimension; i++) {
			for (int j = (blockY - 1) * dimension; j < blockY * dimension; j++) {
				
				if (i == indikatorX) i++;
				if (j == indikatorY) j++;
				
				feld[i][j][indikatorWert] = 0;
			}
		}
		
		return feld;
	}
	
		
	
	public static void main(String[] args) {
		feldPrinter(generate(9));
	}
	
}