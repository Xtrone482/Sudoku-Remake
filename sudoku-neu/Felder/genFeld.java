package Felder;

public class genFeld {
	private int size = 0;
	private int[][][] Feld;
	private boolean empty = true;
	private int[][] nFeld;
	private int x = 0;
	private int y = 0;

	//Konstruktoren
	public genFeld(int size){
		this.size = size;
		this.Feld = new int[size][size][size];
		this.nFeld = new int[size][size];
	}
	public genFeld(int[][][] Feld) {
		this.Feld = Feld;
		this.size = Feld.length;
		this.empty = isEmpty();
		generateNFeld(Feld);
	}
	
	//Set-Methoden
	public void setFeld(int[][][] Feld) {
		this.size = Feld.length;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					this.Feld[x][y][z] = Feld[x][y][z];
				}
			}
		}
		this.empty = isEmpty();
		generateNFeld(Feld);
	}

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//Get-Methoden
	public boolean getEmpty(){
		return empty;
	}
	public int[][][] getFeld() {
		return Feld;
	}
	public int getSize() {
		return size;
	}
	public int[][] getNFeld() {
		generateNFeld(Feld);
		return nFeld;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	//Sonstige Methoden
	private boolean isEmpty() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (Feld[i][j][k] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private void generateNFeld(int[][][] Feld) {
		int[][] tempFeld = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (Feld[i][j][k] == 0) {
						tempFeld[i][j]++;
					}
				}
			}
		}
		nFeld = tempFeld;
	}

	public boolean checkNFeld() {
		generateNFeld(Feld);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (nFeld[i][j] == size) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] render() {
		int[][] tempFeld = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (Feld[i][j][k] != 0) {
						tempFeld[i][j] = Feld[i][j][k];
					}
				}
			}
		}
		return tempFeld;
	}

	public void clean(int x , int y , int wert) {
		// Reihe[]
		for (int i = 0; i < size; i++) {
			if (i != x) {
				this.Feld[i][y][wert] = 0;
			}
		}
		// Spalte[][]
		for (int i = 0; i < size; i++) {
			if (i != y) {
				this.Feld[x][i][wert] = 0;
			}
		}
		// Stack[][][]
		for (int i = 0; i < size; i++) {
			if (i != wert) {
				this.Feld[x][y][i] = 0;
			}
		}
		// Block-System
		int blockX = 0;
		int blockY = 0;
		int dimension = (int) (Math.sqrt(size));
		boolean gate = false;

		// Block-Finder
		while (!gate) {
			blockX++;
			if (x < dimension * blockX) {
				gate = true;
			}
		}
		while (gate) {
			blockY++;
			if (y < dimension * blockY) {
				gate = false;
			}
		}

		// Block-Cleaner
		for (int i = (blockX-1) * dimension; i < blockX * dimension; i++) {
			for (int j = (blockY-1) * dimension; j < blockY * dimension; j++) {
				if (i != x || j != y) {
					this.Feld[i][j][wert] = 0;
				}
			}
		}
	}

	public void clearFeld(){
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++){
				for (int k = 0; k < size; k++){
					Feld[i][j][k] = 0;
				}
			}
		}
		empty = true;
	}

	public void print() {
		System.out.println();
		for (int k = 0; k < Feld.length; k++) {
			for (int i = 0; i < Feld.length; i++) {
				for (int j = 0; j < Feld[0].length; j++) {
					System.out.print(Feld[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}