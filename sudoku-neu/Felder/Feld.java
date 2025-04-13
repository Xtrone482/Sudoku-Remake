package Felder;

public class Feld {
	private int size = 0;
	private int[][][] Feld;
	private boolean empty = true;
	
	//Konstruktoren
	public void Feld(int size){
		this.size = size;
		this.Feld = new int[size][size][size];
	}
	public void Feld(int[][][] Feld) {
		this.Feld = Feld;
		this.size = Feld.length;
		this.empty = isEmpty();
	}
	
	//Set-Methoden
	public void setFeld(int[][][] Feld) {
		this.size = Feld.length;
		this.Feld = Feld;
		this.empty = isEmpty();
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
	public void feldPrinter() {
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