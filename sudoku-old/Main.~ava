import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 *
 * Description
 *
 * @version 1.0 from 05.02.2024
 * @author 
 */

public class Main extends JFrame {
  // start attributes
  int breite = 9;
  int hoehe = 9;
  
  int speicher = 0;
  
  Felder[][] buttons = new Felder[hoehe][breite];  //zweidimensionale Reihung für die Buttons des Spielfeldes
  Felder[] Zahl_buttons = new Felder[breite];
  
  
  // end attributes
  
  public Main() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 635;
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
    // start components
    int a = 10;
    int b = 10;
    for(int i = 0; i<breite; i++){
      if (i%3 == 0) {
        a = a+5;
      } // end of if
      b = 10;
      for(int j = 0; j<hoehe; j++){
        if (j%3 == 0) {
          b = b+5;
      } // end of if
        //System.out.println("i:" + i + ", " + "j:" + j);
        buttons[j][i] = new Felder(); //erzeuge in jedem Feld der zweidimensionalen Reihung einen Button mit den folgenden Parametern
        buttons[j][i].setBounds((i*65)+a, (j*65)+b, 60,60);
        //System.out.println("x: " + buttons[j][i].getX() + ", y: " + buttons[j][i].getY());
        buttons[j][i].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            jButton1_ActionPerformed(evt);
          }
        });
        buttons[j][i].setEnabled(true);
        buttons[j][i].setBackground(Color.white);
        buttons[j][i].setx(i);
        buttons[j][i].sety(j);
        buttons[j][i].setText("0");
        
        cp.add(buttons[j][i]);
      }
    }
    a = 10;
    for(int i = 0; i<breite; i++){
      if (i%3 == 0) {
        a = a+5;
      } // end of if
      //System.out.println("i:" + i);
      Zahl_buttons[i] = new Felder(); //erzeuge in jedem Feld der zweidimensionalen Reihung einen Button mit den folgenden Parametern
      Zahl_buttons[i].setBounds((i*65)+a, 615, 60,60);
      System.out.println("x: " + Zahl_buttons[i].getX() + ", y: " + Zahl_buttons[i].getY());
      Zahl_buttons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          jButton2_ActionPerformed(evt);
        }
      });
      Zahl_buttons[i].setEnabled(true);
      Zahl_buttons[i].setBackground(Color.white);
      Zahl_buttons[i].setx(i);
      Zahl_buttons[i].sety(10);
      String s = String.valueOf(i+1);
      Zahl_buttons[i].setText(s);
      Zahl_buttons[i].setFont(new Font("SANS_SERIF", Font.BOLD, 30));
      cp.add(Zahl_buttons[i]);
      //System.out.println(Zahl_buttons[i].getx());
    }
    
    
  
    // end components
    
    setVisible(true);
  } // end of public Main
  
  // start methods
  
  
    
    
  
    
  public static void main(String[] args) {
    new Main();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    Felder temp = (Felder) evt.getSource();
    temp.setFont(new Font("SANS_SERIF", Font.BOLD, 30));
    temp.setText(String.valueOf(speicher));
    fehlererkennung(temp);
  } // end of jButton1_ActionPerformed
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    JButton temp = (JButton) evt.getSource();
    speicher = Integer.valueOf(temp.getText());
  } // end of jButton2_ActionPerformed
  
  
  
  public void fehlererkennung(Felder a) {
    //buttons [1][4].setBackground(Color.black);
    a.setBackground(Color.white);
    int eingabe = speicher;
    int xpos = a.getxpos();
    int ypos = a.getypos();
    System.out.println("xPosition: " +xpos);
    System.out.println("yPosition: " +ypos);
    int zws = 0; 
  
    for (int z = 0; z < 9; z++) {
      if (z == xpos) {
        //z++;
      } // end of if
      else {
        zws = Integer.valueOf(buttons [ypos][z].getText());
        System.out.println("Vergleich:" + zws);
        System.out.println("Eingabe: " + eingabe);
        System.out.println(z);
        if (eingabe == zws) {
          a.setBackground(Color.red);
          System.out.println("fehler");
        } // end of if
      } // end of if-else
    }
    
    
    for (int x = 0; x < 9; x++) {
      if (x == ypos) {
        //x++;
      } // end of if
      else {
        zws = Integer.valueOf(buttons [x][xpos].getText());
        //System.out.println(buttons [xpos][x]);
        if (eingabe == zws) {
          a.setBackground(Color.red);
           System.out.println("fehler");
        } // end of if
      } // end of if-else
    }
    
    if (xpos < 3 && ypos < 3 ) {
      for (int b = 0; b < 3; b++) {
        for (int c = 0; c < 3; c++) {
          if (buttons [b][c] == buttons[xpos][ypos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [b][c].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    } 
    
    
    if (ypos < 3 && xpos > 2 && xpos < 6) {
      for (int b = 3; b < 6; b++) {
        for (int c = 0; c < 3; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    } 
    
    
  if (ypos < 3 && xpos > 5 && xpos < 9) {
      for (int b = 5; b < 9; b++) {
        for (int c = 0; c < 3; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 && xpos > 5 && xpos < 9) {
      for (int b = 5; b < 9; b++) {
        for (int c = 3; c < 6; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 && xpos > 2 && xpos < 6) {
      for (int b = 3; b < 6; b++) {
        for (int c = 3; c < 6; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    }
    
    if (ypos > 2 && ypos < 6 &&  xpos < 3) {
      for (int b = 0; b < 3; b++) {
        for (int c = 3; c < 6; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 3) {
      for (int b = 0; b < 3; b++) {
        for (int c = 6; c < 9; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 6 && xpos > 2) {
      for (int b = 3; b < 6; b++) {
        for (int c = 6; c < 9; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    } 
    
    if (ypos > 5 && ypos < 9 &&  xpos < 9 && xpos > 5) {
      for (int b = 5; b < 9; b++) {
        for (int c = 6; c < 9; c++) {
          if (buttons [c][b] == buttons[ypos][xpos]) {
            System.out.println("gleichesFeld");
          } else {
             zws = Integer.valueOf(buttons [c][b].getText());
            if (eingabe == zws) {
               a.setBackground(Color.red);
            } // end of if
          } // end of if-else
        }
      }
    }        
   
    
  }
  
  // end methods
} // end of class Main

