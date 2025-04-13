package Felder;

public class BackupFeld extends Feld{
	private int XIndex;
	private int YIndex;
	
	//Konstruktoren
	public void BackupFeld(int size){
		Feld(size);
	}
	public void BackupFeld(int[][][] BackUpFeld){
		Feld(BackUpFeld);
	}
	public void BackupFeld(int[][][] Feld, int XIndex, int YIndex) {
		BackupFeld(Feld);
		this.XIndex = XIndex;
		this.YIndex = YIndex;
	}
	
	//get-Methoden
	public int getXIndex(){
		return XIndex;
	}
	public int getYIndex(){
		return YIndex;
	}
	
	//set-Methoden
	public void setIndex(int XIndex, int YIndex) {
		this.XIndex = XIndex;
		this.YIndex = YIndex;
	}
}