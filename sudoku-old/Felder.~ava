import javax.swing.JButton;
import java.util.Arrays;
import java.util.ArrayList;

public class Felder extends JButton{

  private int x;
  private int y;
  private boolean NotizZahl;
  private boolean Fehler;
  private ArrayList<Integer> Mehrfachfeld = new ArrayList<Integer>();
  
  public void Felder() {
  }
  
  
  public void setx(int a){                                                      // Alternative zu den x-Koordinaten
    x = a; 
  }
  public void sety(int a){
    y = a; 
  }
  public int getxpos(){
    return x;
  }
  public int getypos(){
    return y;
  }
  
  
  public void setFehler() {                                                     // Speicher bezueglich Ueberspringen von falschen Feldern
    Fehler = true;
  }
  public boolean getFehlerStatus() {
    return Fehler;
  }
  public void setNormal() {
    Fehler = false;
  }
  
  
  public void setNotizenAN() {                                                  // alter Speicher fuer Notizen
    NotizZahl = true;
  }
  public void setNotizenAUS() {
    NotizZahl = false;
  }
  public boolean getNotizen() {
    return NotizZahl;
  }
  
  public ArrayList<Integer> getNotiz() {                                        // neue Notizen mit Mehrfachfeld
    return Mehrfachfeld;
  }
  public void setNotiz(int a) {
    Mehrfachfeld.add(0,a);
  }
  public void addNotiz(int a) {
    if (Mehrfachfeld.contains(a) == true) {                                     // Verhinderung von doppelten Notizeintraegen
      Mehrfachfeld.remove(Mehrfachfeld.indexOf(a));
      return;
    } // end of if
    int b = Mehrfachfeld.size();
    int c = 0;
    for (int i = 0; i < b; i++) {                                               // Schleife zur Bestimmung der Position von Eintraegen,
      if (a > Mehrfachfeld.get(i)) {                                            // somit ist das Feld sortiert 
        c++;
      }
    } 
    Mehrfachfeld.add(c,a);
  }
  public void clearNotiz() {                                                    // loescht die gesamte ArrayList
    Mehrfachfeld.clear();
  }
  public void deleteNotiz(int a) {                                              // loescht bestimmte Elemente aus dem Mehrfachfeld
    if (Mehrfachfeld.indexOf(a) == -1) {                                        // contains() geht anscheinend nicht
      return;
    } // end of if
    int b = Mehrfachfeld.size();
    System.out.println(b); 
    int c = 0;
    while (a != Mehrfachfeld.get(c)) { 
      c++;
    } // end of while       
    Mehrfachfeld.remove(c);
  }
  
  public void NotizenModus(JButton a) {                                         // initialisiert den Notizmodus/ist der Grundbestand
    int z = 0;
    String ende = "<html>";
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {  
        if (z == Mehrfachfeld.size()) break;
        ende = ende + " " + String.valueOf(Mehrfachfeld.get(z));      
        z++;
      }    
      ende = ende + "<p>"; 
    }   
    ende = ende + "</html>";
    a.setText(ende);
  }   
}
