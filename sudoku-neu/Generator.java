public class Generator {
	
	static void feldPrinter(int[][] feld) {
		
		System.out.println();
		
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				System.out.print(feld[i][j] + " ");
			}
			
			System.out.println();
		}
	} 
	
	static void feldPrinter(int[][][] feld) {
		
		System.out.println();
		for (int k = 0; k < feld.length; k++) {
			for (int i = 0; i < feld.length; i++) {
				for (int j = 0; j < feld[0].length; j++) {
					System.out.print(feld[i][j][k] + " ");
				}
			
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static int stackRandom(int[] stack) {
		
		stack = stackPusher(stack);
		
		System.out.println("Defaultstack");
		for (int j = 0; j < stack.length; j++) {		
			System.out.print(stack[j] + " ");
		}
		System.out.println();
		
		int maximum = stackCounter(stack)-1;
		
		int x = (int) (Math.random() * maximum)+1;
		System.out.println();
		System.out.println("Zufallskey  " + x);
		return x;
	}
	
	public static int[] stackMover(int[] stack , int target , boolean negativ) {
		
		int speicher = 0; 
		
		if (negativ == true) {
			for (int i = target; i > 0; i--) {
				speicher = stack[i];
				stack[i] = stack[i-1];
				stack[i-1] = speicher;
			}
		}
		if(negativ == false) {
			for (int i = target; i < stack.length - 1; i++) {
				speicher = stack[i];
				stack[i] = stack[i+1];
				stack[i+1] = speicher;
			}
		}
		
		return stack;
	}
	
	public static int[] stackPusher(int[] stack) {
		
		for (int j = 0; j < stack.length; j++) {
			for (int i = 0; i < stackCounter(stack); i++) {
				if (stack[i] == 0) {
					stackMover(stack , i , false);
				}
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
	
	static int stackFinder(int[] stack , int target) {
		
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == target) {
				System.out.println("i:          " + i);
				return i-1;
			}
			System.out.print("! ");
		}
		System.out.println("Error: key not found in finder");
		return 0;
	}
	
	static int[][] generate(int menge) {		// Menge muss {n E N: root(n) E N} sein.
		
		int[][][] tempFeld = new int[menge][menge][menge];
		int Random;
		
		// Initialisierung
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				for (int k = 0; k < menge; k++) {
					tempFeld[i][j][k] = k + 1;
				}
			}
		}
		
		// Main
		//tempFeld[i][j] = stackMover(tempFeld[i][j] , Random , true);
		
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				
				feldPrinter(tempFeld);
				Random = stackRandom(tempFeld[i][j]);
				
				tempFeld = generatorFehlersuche(tempFeld , i , j , Random);
				

			} 
		}
		
		
		// Rückgabe
		int[][] finalFeld = new int[menge][menge];
		
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				finalFeld[i][j] = tempFeld[i][j][0];
			} 
		}
		
		return finalFeld;
	}
	
	static int[][][] generatorFehlersuche(int[][][] feld , int indikatorX , int indikatorY , int indikatorWert) {
		
		//int indikatorWert = feld[indikatorX][indikatorY][0];					//muss Überarbeitet werden
		System.out.println("Indikator   " + indikatorWert);
		System.out.println("Pradikator  " + feld[indikatorX][indikatorY][indikatorWert]);
		System.out.println();
		
		for (int i = 0; i < feld.length; i++) {
			System.out.print(i + ":" + feld[indikatorX][indikatorY][i] + ";  ");
			if (i != indikatorWert) {
				feld[indikatorX][indikatorY][i] = 0;
			}
		}
		
		
		
		// Reihe[]
		for (int i = 0; i < feld.length; i++) {
			if (i != indikatorX) {
				feld[i][indikatorY][indikatorWert] = 0;
			}
		}
		
		// Spalte[][]
		for (int i = 0; i < feld.length; i++) {
			if (i != indikatorY) {
				feld[indikatorX][i][indikatorWert] = 0;
			}
		}
		
		// Block-System
		int blockX = 0;
		int blockY = 0;
		int dimension = (int) (Math.sqrt(feld.length));
		boolean gate = false;
		
		// Block-Finder
		while (gate != true) {
			blockX++;
			if (indikatorX < dimension * blockX) {
				gate = true;
			}
		}
		while (gate != false) {
			blockY++;
			if (indikatorY < dimension * blockY) {
				gate = false;
			}
		}
		
		// Block-Cleaner
		for (int i = (blockX - 1) * dimension; i < blockX * dimension; i++) {
			for (int j = (blockY - 1) * dimension; j < blockY * dimension; j++) {
				if (!(i == indikatorX && j == indikatorY)) {
					feld[i][j][indikatorWert] = 0;
				}
			}
		}

		
		
		return feld;
	}
	
		
	
	public static void main(String[] args) {
		
		feldPrinter(generate(4));
		int[] test = {1,2,3,4,5,0,7,0,0,0,8,9};
		test = stackPusher(test);
		for (int i = 0; i < test.length; i++) {
			//System.out.println(test[i]);
		}
	}
	
}