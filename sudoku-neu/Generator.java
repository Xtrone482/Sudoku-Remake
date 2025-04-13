import Felder.*;

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
	static void feldPrinter(int[][][] Feld) {
		int L = (int) (Math.sqrt(Feld.length));
		System.out.println();
		for (int k = 0; k < Feld.length; k++) {
			for (int i = 0; i < Feld.length; i++) {
				for (int j = 0; j < Feld.length; j++) {
					System.out.print(Feld[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static int stackRandom(int[] stack) {
		
		if (stackCounter(stack) == 1) {
			return stackFinder(stack);
		}
		/*
		System.out.println("Defaultstack");
		for (int j = 0; j < stack.length; j++) {		
			System.out.print(stack[j] + " ");
		}
		System.out.println();
		*/
		int maximum = stack.length;
		int x = (int) (Math.random() * maximum);
		
		if (stack[x] == 0) {
			if (stackCounter(stack) == 0) {
				System.out.println("Error: invalid stack ");
				return 10;
			}
			return stackRandom(stack);
		}
		return x;
	}
	
	public static int[] stackMover(int[] stack , int target) {
		
		int speicher = 0; 
		for (int i = target; i < stack.length - 1; i++) {
			speicher = stack[i];
			stack[i] = stack[i+1];
			stack[i+1] = speicher;
		}
		return stack;
	}
	
	public static int[] stackPusher(int[] stack) {
		
		for (int i = 0; i < stackCounter(stack); i++) {
			if (stack[i] == 0) {
				stackMover(stack , i);
			}
		}
		for (int j = 0; j < stack.length; j++) {
			if (stack[j] == 0 && j < stackCounter(stack)) {
				stackPusher(stack);
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
	
	static int stackFinder(int[] stack) {
		
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != 0) {
				return i;
			}
		}
		System.out.println("Error: Finder");
		return 0;
	}
	
	static int[][] generate(int menge) {		// Menge muss {n E N: root(n) E N} sein.
		
		int[][][] tempFeld = new int[menge][menge][menge];
		int random;
		int t = 1;
		int p = (int) (Math.sqrt(menge));
		
		// Initialisierung
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				for (int k = 0; k < menge; k++) {
					tempFeld[i][j][k] = k + 1;
				}
			}
		}
		
		for (int l = 0; l < menge; l++) {
			for (int m = 0; m < menge; m++) {	
				
				System.out.println(random + 1);
				tempFeld = generatorFehlersuche(tempFeld , l , m , random);
				//feldPrinter(tempFeld);
				//System.console().readLine();
			}
			t = 1;
		}
		
		// Rückgabe
		int[][] finalFeld = new int[menge][menge];
		for (int i = 0; i < menge; i++) {
			for (int j = 0; j < menge; j++) {
				finalFeld[i][j] = tempFeld[i][j][stackFinder(tempFeld[i][j])];
				if (finalFeld[i][j] == 0) {
					System.console().readLine();
					generate(menge);
				}
			} 
		}
		return finalFeld;
	}
	
	static int[][][] generatorFehlersuche(int[][][] feld , int indikatorX , int indikatorY , int indikatorWert) {
		
		for (int i = 0; i < feld.length; i++) {
			//System.out.print(i + ":" + feld[indikatorX][indikatorY][i] + ";  ");
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
		System.out.println("Block: " + blockX + " " + blockY);
		
		// Block-Cleaner
		for (int i = (blockX-1) * dimension; i < blockX * dimension; i++) {
			for (int j = (blockY-1) * dimension; j < blockY * dimension; j++) {
				if (i != indikatorX || j != indikatorY) {
					feld[i][j][indikatorWert] = 0;
				}
			}
		}
		return feld;
	}
	
	public static void main(String[] args) {
		int[][] generiertesFeld = generate(9);
		feldPrinter(generiertesFeld);
	}
	
}