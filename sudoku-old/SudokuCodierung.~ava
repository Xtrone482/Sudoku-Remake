public class SudokuCodierung{
  private int x = 0;
  private int Spielfeld[][] = new int [9][9];
  
  
  public int[][] translateCode(Felder a[][]){                                   // Konstruktor mit Feldern
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (a[i][j].getNotizen() != true) Spielfeld[i][j] = Integer.valueOf(a[i][j].getText());     // ignorieren von Notizen > TODO
      }
    }
    return Spielfeld;
  }
  
  public int[][] translateCode(int a[][]){                                      // Konstruktor mit einer Reihung
    Spielfeld = a;
    return Spielfeld;
  }
  
  public String getCode(){                                                      // Uebersetzung Spielfeld in Code
    String code = "";
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        switch (Spielfeld[i][j]) {
          case 1 : 
            code = code + "10000";
            break;
          case 2 : 
            code = code + "10001";
            break;
          case 3 : 
            code = code + "10010";
            break;
          case 4 : 
            code = code + "10011";
            break;
          case 5 : 
            code = code + "10100";
            break;
          case 6 : 
            code = code + "10101";
            break;
          case 7 : 
            code = code + "10111";
            break;
          case 8 : 
            code = code + "11000";
            break;
          case 9 : 
            code = code + "11001";
            break;
          default: 
            code = code + "0";
            break;  
        } // end of switch
      }
    }
    return code;
  }
  
  public String decode(String a){                                               // Uebersetzung Code in Text
    String code = "";
    int counter = 0;
    while (counter < a.length()) {             
      if (a.charAt(counter) == 48) {
        code = code + "0";                                                      
        counter++;
      } else {                                                                  // noetig zu Differenzierung von 0 und !0
        String c = "";
        for (int i = 0; i < 5; i++) {                                           // unterschiedliche Laenge muss kompensiert werden
          c = c + String.valueOf(a.charAt(counter));
          counter++;
        }
        switch (c) {
          case "10000" : 
            code = code + "1";
            break;
          case "10001" : 
            code = code + "2";
            break;
          case "10010" : 
            code = code + "3";
            break;
          case "10011" : 
            code = code + "4";
            break;
          case "10100" : 
            code = code + "5";
            break;
          case "10101" : 
            code = code + "6";
            break;
          case "10111" : 
            code = code + "7";
            break;
          case "11000" : 
            code = code + "8";
            break;
          case "11001" : 
            code = code + "9";
            break;  
        } // end of switch
      }
    } // end of while
    return code;
  }  
}