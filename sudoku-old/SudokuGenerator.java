import java.util.Random;

public class SudokuGenerator {
  private static final int SIZE = 9;
  private static final int EMPTY_CELL = 0;
  private static int AnzahlLuecken = 30;      //Anzahl der freien Felder
  
  
  public static void main(String[] args) {
    int[][] sudoku = generateSudoku();
  }

  public static int[][] generateSudoku() {
    int[][] board = new int[SIZE][SIZE];
    solveSudoku(board);
    luecken(board, AnzahlLuecken);
    return board;
  }

  public static boolean solveSudoku(int[][] board) {        //generiert ein vollstaendiges Sudokufeld
    int row = -1;
    int col = -1;
    boolean isEmpty = true;
    
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (board[i][j] == EMPTY_CELL) {
          row = i;
          col = j;
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }
    
    if (isEmpty) {
      return true;
    }
    
    for (int num = 1; num <= SIZE; num++) {
      if (fehlererkennung(board, row, col, num) == true) {
        board[row][col] = num;
        if (solveSudoku(board)) {
          return true;
        } else {
          board[row][col] = EMPTY_CELL;
        }
      }
    }
    return false;
  }
  
  
  public static boolean fehlererkennung(int[][] Sudokufeld,int yy, int xx, int Zahl) { //prueft ob die Zahl passt
    int eingabe = Zahl;
    int xpos = xx;
    int ypos = yy;
    int zws = 0; 
    
    for (int z = 0; z < 9; z++) {     //Ueberpruefung fuer Zeilen
      if (z != xpos) {
        zws = Sudokufeld[ypos][z];
        if (eingabe == zws) {
          return false;
        }
      } // end of if
    }
    
    
    for (int x = 0; x < 9; x++) {   //Ueberpruefung fuer Spalten
      if (x != ypos) {
        zws = Sudokufeld[x][xpos];
        if (eingabe == zws) {
          return false;
        } // end of if
      } // end of if
    }
    
    if (xpos < 3 && ypos < 3 ) {       //Ueberpruefung Block 1,1
      for (int b = 0; b < 3; b++) {
        for (int c = 0; c < 3; c++) {
          if (Sudokufeld [b][c] != Sudokufeld [ypos][xpos]) {
            zws = Sudokufeld [b][c];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    } 
    
    
    if (ypos < 3 && xpos > 2 && xpos < 6) {         //Ueberpruefung Block 1,2
      for (int b = 3; b < 6; b++) {
        for (int c = 0; c < 3; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld [c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    } 
    
    
    if (ypos < 3 && xpos > 5 && xpos < 9) {     //Ueberpruefung Block 1,3
      for (int b = 6; b < 9; b++) {
        for (int c = 0; c < 3; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 && xpos > 5 && xpos < 9) {      //Ueberpruefung Block 2,3
      for (int b = 6; b < 9; b++) {
        for (int c = 3; c < 6; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 && xpos > 2 && xpos < 6) {         //Ueberpruefung Block 2,2
      for (int b = 3; b < 6; b++) {
        for (int c = 3; c < 6; c++) {
          if (Sudokufeld[c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 &&  xpos < 3) {            //Ueberpruefung Block 2,1
      for (int b = 0; b < 3; b++) {
        for (int c = 3; c < 6; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 3) {               //Ueberpruefung Block 3,1
      for (int b = 0; b < 3; b++) {
        for (int c = 6; c < 9; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 6 && xpos > 2) {          //Ueberpruefung Block 3,2
      for (int b = 3; b < 6; b++) {
        for (int c = 6; c < 9; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 9 && xpos > 5) {          //Ueberpruefung Block 3,3
      for (int b = 6; b < 9; b++) {
        for (int c = 6; c < 9; c++) {
          if (Sudokufeld [c][b] != Sudokufeld[ypos][xpos]) {
            zws = Sudokufeld[c][b];
            if (eingabe == zws) {
              return false;
            } // end of if
          } 
        }
      }
    }        
    
    return true;
  }
  
  private static void luecken(int[][] board, int Luecken) {        // Methode um freie Felder zu bekommen
    Random rand = new Random();
    int a = 0;
    while (a < Luecken) {
      int reihe = rand.nextInt(9);
      int spalte = rand.nextInt(9);
      if (board[reihe][spalte] != EMPTY_CELL) {           //setzt zufaellige Felder auf "0"
        board[reihe][spalte] = EMPTY_CELL;
        a++;
      }
    }
  }
}
