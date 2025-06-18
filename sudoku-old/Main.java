import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

/**
 *
 * Description
 *
 * @version 1.0 from 05.02.2024
 * @author 
 */

public class Main extends JFrame {
  // start attributes
  // Anfang Attribute
  int breite = 9;
  int hoehe = 9;
  int modus = 1;
  int speicher = 1;
  int NotizAn = 0;
  int Leben = 2;
  int time = 0;
  int control = 0;

  Felder[][] buttons = new Felder[hoehe][breite];  //zweidimensionale Reihung für die Buttons des Spielfeldes
  Felder[] Zahl_buttons = new Felder[breite];
  
  private JLabel TLabel = new JLabel();    
  private Timer1 t = new Timer1();
                                       
  private JButton BNotizen = new JButton();
  private JButton BReset = new JButton();
  private JButton Check = new JButton();
  
  private JTextArea CFeld = new JTextArea();                                    // Code Komponenten
  private JScrollPane CPane = new JScrollPane(CFeld);                           // Die JTextArea ist im JScrollPane 
  private JButton Code1 = new JButton();
  private JButton Code2 = new JButton();
  
  private JButton Modi1 = new JButton();                                        // Modus Komponenten
  private JLabel MLabel = new JLabel();
  
  private JButton BGenerieren = new JButton();
  // end attributes
  
  public Main() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 730; 
    int frameHeight = 730;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Main");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);     
    cp.setBackground(Color.gray);
    
    // Anfang Komponenten
    
    int a = 10;
    int b = 10;
    for(int i = 0; i<breite; i++){                                              // Hauptfeld
      if (i%3 == 0) {
        a = a+5;
      } // end of if
      b = 10;
      for(int j = 0; j<hoehe; j++){
        if (j%3 == 0) {
          b = b+5;
        } // end of if
        buttons[j][i] = new Felder(); 
        buttons[j][i].setBounds((i*65)+a, (j*65)+b, 60,60);
        System.out.println("x: " + buttons[j][i].getX() + ", y: " + buttons[j][i].getY());
        buttons[j][i].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            jButton1_ActionPerformed(evt);
          }
        });     
        buttons[j][i].setEnabled(true);
        buttons[j][i].setBackground(Color.white);
        buttons[j][i].setx(i);
        buttons[j][i].sety(j);
        buttons[j][i].setFont(new Font("SANS_SERIF", Font.BOLD, 30));
        buttons[j][i].setText("0");                                             // Nullen im Text gelten als "leer"
        buttons[j][i].setForeground(Color.white);
        buttons[j][i].setBorderPainted(false);
        cp.add(buttons[j][i]);
        
      }
    }
    a = 10;
    for(int i = 0; i<breite; i++){                                              // Eingabefeld
      if (i%3 == 0) {
        a = a+5;
      } // end of if
      
      Zahl_buttons[i] = new Felder();                                           
      Zahl_buttons[i].setBounds((i*65)+a, 615, 60,60);
      
      Zahl_buttons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          jButton2_ActionPerformed(evt);
        }
      });
      Zahl_buttons[i].setEnabled(true);
      Zahl_buttons[i].setBackground(Color.white);
      Zahl_buttons[i].setForeground(Color.gray);
      Zahl_buttons[i].setx(i);
      Zahl_buttons[i].sety(10);
      String s = String.valueOf(i+1);
      Zahl_buttons[i].setText(s);
      Zahl_buttons[i].setFont(new Font("SANS_SERIF", Font.BOLD, 30));
      cp.add(Zahl_buttons[i]);
      //System.out.println(Zahl_buttons[i].getx());
    }
    
    BNotizen.setForeground(Color.gray);
    BNotizen.setBackground(Color.white);
    BNotizen.setBounds(615, 615, 85, 60);
    BNotizen.setFont(new Font("SANS_SERIF", Font.BOLD, 13));
    BNotizen.setText("Notizen");
    BNotizen.setBorderPainted(false);
    BNotizen.addMouseListener(new java.awt.event.MouseAdapter() {               // Veraendern des Hintergrundes beim Hovern
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        BNotizen.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        BNotizen.setForeground(Color.gray);
      }
    });
    BNotizen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(BNotizen);
    
    BReset.setBackground(Color.white);
    BReset.setForeground(Color.gray);
    BReset.setBounds(615, 15, 85, 60);
    BReset.setFont(new Font("SANS_SERIF", Font.BOLD, 13));
    BReset.setText("Reset");
    BReset.setBorderPainted(false);
    BReset.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        BReset.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        BReset.setForeground(Color.gray);
      }
    });
    BReset.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(BReset);
    
    Check.setBackground(Color.white);
    Check.setForeground(Color.green);
    Check.setBounds(615, 280, 85, 60);
    Check.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
    Check.setText("Check");
    Check.setBorderPainted(false);
    Check.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton8_ActionPerformed(evt);
      }
    });
    cp.add(Check);
    
    
    
    BGenerieren.setBackground(Color.white);
    BGenerieren.setForeground(Color.gray);
    BGenerieren.setBounds(615, 345, 85, 60);
    BGenerieren.setFont(new Font("SANS_SERIF", Font.BOLD, 13));
    BGenerieren.setText("Feld");
    BGenerieren.setBorderPainted(false);
    BGenerieren.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        BGenerieren.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        BGenerieren.setForeground(Color.gray);
      }
    });
    BGenerieren.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton9_ActionPerformed(evt);
      }
    });
    cp.add(BGenerieren);
    
    
    
    
    
    
    t.start();
    
    TLabel.setBounds(615, 80, 85, 60);
    TLabel.setBackground(Color.white);
    TLabel.setForeground(Color.black);
    TLabel.setOpaque(true);
    TLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 20));
    TLabel.setHorizontalAlignment(SwingConstants.CENTER);
    TLabel.setBorder(null);
    cp.add(TLabel);
    
    CFeld.setBounds(615,435,85,150);
    CFeld.setWrapStyleWord(true);
    CFeld.setLineWrap(true);
    //cp.add(CFeld);
    CPane.setBorder(null);
    CPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    CPane.setBounds(615,435,85,150);
    cp.add(CPane);
    
    
    Code1.setBounds(615,415,85,20);
    Code1.setBackground(Color.white);
    Code1.setText("Codieren");
    Code1.setForeground(Color.gray);
    Code1.setBorderPainted(false);
    Code1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        Code1.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        Code1.setForeground(Color.gray);
      }
    });
    Code1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton5_ActionPerformed(evt);
      }
    });
    cp.add(Code1);
    
    Code2.setBounds(615,585,85,20);
    Code2.setBackground(Color.white);
    Code2.setText("Einfügen");
    Code2.setForeground(Color.gray);
    Code2.setBorderPainted(false);
    Code2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        Code2.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        Code2.setForeground(Color.gray);
      }
    });
    Code2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton6_ActionPerformed(evt);
      }
    });
    cp.add(Code2);
    
    MLabel.setBounds(615, 215, 85, 30);
    MLabel.setText("Fehlermodus");
    MLabel.setBackground(Color.white);
    MLabel.setForeground(Color.black);
    MLabel.setOpaque(true);
    MLabel.setBorder(null);
    MLabel.setHorizontalAlignment(SwingConstants.CENTER);    
    cp.add(MLabel);
    
    Modi1.setBounds(615, 245, 85, 30);
    Modi1.setBackground(Color.white);
    Modi1.setForeground(Color.gray);
    Modi1.setText("Leben");
    Modi1.setBorderPainted(false);
    Modi1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        Modi1.setForeground(Color.black);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        Modi1.setForeground(Color.gray);
      }
    });
    Modi1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton7_ActionPerformed(evt);
      }
    });
    cp.add(Modi1);
    
    setVisible(true);
    // end of components
    
    SudokuGenerator g = new SudokuGenerator();
    
    
    
    while (t.getSek() < 1000) { 
      TLabel.setText(String.valueOf(t.getMin()) + ":" + String.valueOf(t.getSek()));
      if (time%2 == 1) break;
    } // end of while
  } // end of public Main
 
  // Anfang Methoden
  public static void main(String[] args) {
    new Main();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {                       // Hauptfeld
    Felder temp = (Felder) evt.getSource();
    temp.setBackground(Color.white);
    
    switch (NotizAn%2) {                                                        // Modi Abfrage
      case 0 : 
        temp.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
        if (temp.getText().equals(String.valueOf(speicher))){
          temp.setText("0");
          temp.setForeground(Color.white);
          if (modus == 0) {
            temp.setNotizenAUS();
            break;
          }
        } else {
          temp.setText(String.valueOf(speicher)); 
          temp.setForeground(Color.black); 
        } // end of if-else
        temp.setNotizenAUS();
        boolean a = false;
        if (fehlererkennung(temp) > 0) a = true;
        Hervorheben();
        if (modus == 1) break;
        if (a == true) temp.setForeground(Color.red);
        break;
      case 1 : 
        temp.setFont(new Font("SANS_SERIF", Font.ITALIC, 12));
        if (temp.getText() == "0") {                                            // falls die Notiz nur eine Stelle haben soll
          temp.setNotiz(speicher);
        } else {                                                                // ff.
          temp.addNotiz(speicher);
        } // end of if-else
        temp.NotizenModus(temp);
        temp.setForeground(Color.black);
        temp.setNotizenAN();
        Hervorheben();
        break;
    } // end of switch
  } // end of jButton1_ActionPerformed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {                       // Eingabefelder und Hervorheben
    for (int i = 0; i < 9; i++) {                                               // Hervorheben der Eingabefelder
      Zahl_buttons[i].setForeground(Color.gray);
    }   
    Felder temp = (Felder) evt.getSource();
    temp.setForeground(Color.black);
    speicher = Integer.valueOf(temp.getText());
    Hervorheben();
  } // end of jButton2_ActionPerformed
  
  public void jButton3_ActionPerformed(ActionEvent evt) {                       // Notizen Modus Switch
    NotizAn++;
    BNotizen.setBackground(Color.white);
    if (NotizAn%2 == 1) {
      BNotizen.setBackground(Color.lightGray);
    }
  }
  
  public void jButton4_ActionPerformed(ActionEvent evt) {                       // Reset
    for (int i = 0; i < 9; i++) {                                               // der Felder
      for (int j = 0; j < 9; j++) {
        buttons[i][j].setText("0");
        buttons[i][j].setForeground(Color.white);
        buttons[i][j].setBackground(Color.white);
        buttons[i][j].setNormal();
        buttons[i][j].clearNotiz();
        buttons[i][j].setEnabled(true);
      }
    }
    Leben = 2;                                                                  // und dem Checker
    Check.setForeground(Color.green);
    t.timer_restart();
  }
  
  public void jButton5_ActionPerformed(ActionEvent evt) {                       // Codieren
    SudokuCodierung hi = new SudokuCodierung();
    hi.translateCode(buttons);                                                  
    String a = hi.getCode();
    CFeld.setFont(new Font("SANS_SERIF", Font.PLAIN, 11));
    CFeld.setText(a);
  }
  
  public void jButton6_ActionPerformed(ActionEvent evt) {                       // Einfügen
    SudokuCodierung hi = new SudokuCodierung();
    String b = hi.decode(CFeld.getText());
    int c = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (c == b.length()) break;
        buttons[i][j].setForeground(Color.black);
        buttons[i][j].setFont(new Font("SANS_SERIF", Font.BOLD, 30));  
        buttons[i][j].setText(String.valueOf(b.charAt(c)));                     // Einzelne Zahlen werden eingefuegt
        buttons[i][j].setEnabled(false);                                        // die einzelnen Felder werden gefestigt
        if (buttons[i][j].getText().equals("0")) {                              // Nullen (leere Felder) werden enabled und ohne Farbe dargestellt
          buttons[i][j].setEnabled(true);
          buttons[i][j].setForeground(Color.white);          
        }
        buttons[i][j].setBackground(Color.white);
        c++;
      }
    }
  }
  
  public void jButton7_ActionPerformed(ActionEvent evt) {                       // Modus
    //Modi1.setEnabled(false);                                                  // permanenter Modi (man kann nicht konstant wechseln)
    switch (modus) {
      case 0 :                                                                  // normaler Modi mit implementierten Funktionen
        modus = 1;
        Modi1.setText("Leben");
        break;
      case 1 :                                                                  // hauptsaechlich zum Testen der Fehlererkennung (und fuer Leute wie Julien)
        modus = 0;
        Modi1.setText("Konstant");
        break;         
    }
  }
  
  public void jButton8_ActionPerformed(ActionEvent evt) {                       // Checker
    switch (Leben) {
      case 2 : 
        Leben--;
        int control = 0;                                                        // control ist notwendig, um das gesamte Feld zu checken,
        for (int i = 0; i < 9; i++) {                                           // sonst wird win() immer aufgerufen
          for (int j = 0; j < 9; j++) {
            if (fehlererkennung(buttons[i][j]) > 0) {                           // bei Modi = 1 (Leben), wird nicht angegeben, welches Feld inkorrekt ist 
              Check.setForeground(Color.orange);
              control++;
            }  
          }
        }
        if (control == 0) {                                                     // falls control = 0 gilt, ist jedes Feld korrekt
          win();
          break;
        } // end of if  
        Hervorheben(); 
        break;       
      case 1 : 
        Leben--;
        control = 0;
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (fehlererkennung(buttons[i][j]) > 0) {
              Check.setForeground(Color.red);
              control++;
            } 
          }
        } 
        if (control == 0) {
          win();
          break;
        } // end of if
        Hervorheben();
        break;    
      case 0 : 
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (fehlererkennung(buttons[i][j]) > 0) {
              for (i = 0; i < 9; i++) {                                         // LOSE Status
                for (j = 0; j < 9; j++) {                                       
                  buttons[i][j].setBackground(Color.red);
                  buttons[i][j].setForeground(Color.red);
                  buttons[i][j].setText("");
                  buttons[i][j].setEnabled(false);
                }
              }
              Leben = 4;
              time++;
            } else {
              win();
            } // end of if-else
          }
        }   
        break;
      case 4 :                                                                  //4er Status als Verhinderung von Fehlern durch erneutes Aufrufen
        break;
    } // end of switch
  }
  
  public void jButton9_ActionPerformed(ActionEvent evt) {      //generiert ein zufaelliges Feld zum Loesen
    int zws = 0;
    int[][] sudoku = SudokuGenerator.generateSudoku();  //Bekommt Feld aus SodokuGenerator-Klasse
    for (int i = 0; i < 9; i++) {
      for (int f = 0; f < 9; f++) {
        zws = sudoku[i][f];
        buttons[i][f].setText(String.valueOf(zws));           //ueberträgt Felder
        buttons[i][f].setForeground(Color.black);
        buttons[i][f].setFont(new Font("SANS_SERIF", Font.BOLD, 30));
        buttons[i][f].setEnabled(false);
        if (zws == 0) {  //macht 0en nicht sichtbar von freien Feldern
          buttons[i][f].setForeground(Color.white);
          buttons[i][f].setEnabled(true);
        } // end of if
      }
    }
  }
    
  public void win() {                                                           // WIN Status
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        buttons[i][j].setBackground(Color.green);
        buttons[i][j].setEnabled(false);                                        // Reset erforderlich zum Neustart
      }
    }
    time++;
  }
  
  public void Hervorheben() {                                                   // selbsterklaerender Name
    for (int i = 0; i < 9; i++) {                                               // reset von allen Feldern
      for (int j = 0; j < 9; j++) {
        buttons[i][j].setBackground(Color.white);
      }
    }
          
    for (int i = 0; i < 9; i++) {                                               // Hervorheben der Felder
      for (int j = 0; j < 9; j++) {
        if (buttons[i][j].getText().equals(String.valueOf(speicher)) || buttons[i][j].getNotiz().contains(speicher) == true) {
          buttons[i][j].setBackground(Color.lightGray);
        } // end of if
      }
    }
  }
  
public void Fehlercheck(Felder A, int RICHTWERT, int X_START, int Y_START, int X_GRENZE, int Y_GRENZE) {
  int zws = 0;
  int Xpos = A.getxpos();
  int Ypos = A.getypos();

  for (int x = X_START; x < X_GRENZE; x++) {
    for (int y = Y_START; y < Y_GRENZE; y++) {
      if (buttons [y][x] != buttons[Ypos][Xpos] && buttons[y][x].getFehlerStatus() == false && buttons[y][x].getNotizen() == false) {
        zws = Integer.valueOf(buttons [y][x].getText());
        if (RICHTWERT == zws) A.setFehler();
        if (A.getFehlerStatus() == true) {
          control++;
        } 
      }
      if (buttons[y][x].getNotizen() == true) {
        buttons[y][x].deleteNotiz(RICHTWERT);
        buttons[y][x].NotizenModus(buttons[y][x]);
      } 
    }
  }
}



  public int fehlererkennung(Felder a) {                                        // boolean ist nicht realisierbar wegen Notizentfernung (return statements)
    int eingabe = 0;
    if (a.getNotizen() == false) eingabe = Integer.valueOf(a.getText());
    int xpos = a.getxpos();
    int ypos = a.getypos();
    int zws = 0; 
    control = 0;
    
    for (int x = 0; x < 9; x++) {
      if (x != xpos && buttons[ypos][x].getFehlerStatus() == false && buttons[ypos][x].getNotizen() == false) {
        zws = Integer.valueOf(buttons[ypos][x].getText());
        if (eingabe == zws) a.setFehler();
        if (a.getFehlerStatus() == true) {
          control++;                                                            
        }
      } 
      if (buttons[ypos][x].getNotizen() == true) {                              // automatisches Entfernen von Notizen [1]
        buttons[ypos][x].deleteNotiz(eingabe);
        buttons[ypos][x].NotizenModus(buttons[ypos][x]);
      }
    }
    
    for (int y = 0; y < 9; y++) {
      if (y != ypos && buttons[y][xpos].getFehlerStatus() == false && buttons[y][xpos].getNotizen() == false) {
        zws = Integer.valueOf(buttons[y][xpos].getText());
        if (eingabe == zws) a.setFehler();
        if (a.getFehlerStatus() == true) {
          control++;
        } 
      }
      if (buttons[y][xpos].getNotizen() == true) {                              // [1], ...
        buttons[y][xpos].deleteNotiz(eingabe);
        buttons[y][xpos].NotizenModus(buttons[y][xpos]);
      } 
    }

    switch (ypos) {
      case 0 :
      case 1 :
      case 2 : 
        switch (xpos) {
          case 0 :
          case 1 :
          case 2 :
            Fehlercheck(a, eingabe, 0, 0, 3, 3);                                                              // 1,1
            break;
          case 3 :
          case 4 :
          case 5 :
            Fehlercheck(a, eingabe, 3, 0, 6, 3);                                                              // 1,2
            break;
          case 6 :
          case 7 :
          case 8 :
            Fehlercheck(a, eingabe, 6, 0, 9, 3);                                                              // 1,3
            break;  
        } 
        break;
      case 3 :
      case 4 :
      case 5 : 
        switch (xpos) {
          case 0 :
          case 1 :
          case 2 :
          Fehlercheck(a, eingabe, 0, 3, 3, 6);                                                              // 2,1
            break;
          case 3 :
          case 4 :
          case 5 :
          Fehlercheck(a, eingabe, 3, 3, 6, 6);                                                              // 2,2
            break;
          case 6 :
          case 7 :
          case 8 :
          Fehlercheck(a, eingabe, 3, 6, 6, 9);                                                              // 2,3
            break;
        } // end of switch
        break;
      case 6 :
      case 7 :
      case 8 :
        switch (xpos) {
          case 0 :
          case 1 :
          case 2 :
            Fehlercheck(a, eingabe, 0, 6, 3, 9);                                                             // 3,1
            break;
          case 3 :
          case 4 :
          case 5 :
            Fehlercheck(a, eingabe, 3, 6, 6, 9);                                                               // 3,2
            break;
          case 6 :
          case 7 :
          case 8 :
            Fehlercheck(a, eingabe, 6, 6, 9, 9);                                                               // 3,3
            break;
        } // end of switch
        break; 
    } // end of switch
    return control;
  }
  
  // end methods
  // Ende Methoden
} // end of class Main

