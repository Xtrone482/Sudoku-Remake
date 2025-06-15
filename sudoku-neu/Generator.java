import Felder.genFeld;

public class Generator {

	private static void feldPrinter(int[][] feld) {
		System.out.println();
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[0].length; j++) {
				System.out.print(feld[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int stackRandom(int[] stack) {
		if (stackCounter(stack) == 1) {
			return stackFinder(stack);
		}
		int maximum = stack.length;
		int x = (int) (Math.random() * maximum);
		
		if (stack[x] == 0) {
			return stackRandom(stack);
		}
		return x;
	}

	private static int stackCounter(int[] stack) {
		int counter = 0;
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != 0) {
				counter++;
			}
		}
		return counter;
	}
	
	private static int stackFinder(int[] stack) {
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != 0) {
				return i;
			}
		}
		return 0;
	}

	public static int[][] generate(int size) {		// size muss root(n) in N sein.
		// init
		genFeld Feld = new genFeld(size);
		genFeld[] backupFelder = new genFeld[size];
		int bCounter = 0;
		int random;
		int dim = (int) Math.sqrt(size);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					Feld.getFeld()[i][j][k] = k + 1;
				}
			}
			backupFelder[i] = new genFeld(size);
		}
		// core
		for (int x = 0; x < dim; x++) {
			for (int y = 0; y < dim; y++) {
				backupFelder[bCounter].setFeld(Feld.getFeld());
				backupFelder[bCounter].setPos(x, y);

				for (int l = x * dim ; l < (x+1) * dim; l++) {
					for (int m = y * dim; m < (y+1) * dim; m++) {
						random = stackRandom(Feld.getFeld()[l][m]);
						Feld.clean(l , m , random);

						if (!Feld.checkNFeld()) {	// Sequenz zum Backup
							Feld.setFeld(backupFelder[bCounter].getFeld());
							x = backupFelder[bCounter].getX();
							y = backupFelder[bCounter].getY();
							l = x * dim;
							m = y * dim;
							if (bCounter != 0) {
								bCounter--;
							}
							System.out.println("hi!");
						}
					}
				}
				bCounter++;
			}
		}
		return Feld.render();
	}
	
	public static void main(String[] args) {
		feldPrinter(generate(9));
	}
	
}