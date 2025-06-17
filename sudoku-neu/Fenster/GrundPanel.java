package Fenster;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class GrundPanel extends JPanel{
    
    public int[][] field;
    public GrundPanel(SudokuFenster f){
        setBounds(new Rectangle(0,0,f.getWidth(), f.getHeight()));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        int boardSize = getHeight() - getHeight()/10;
        int boxSize = boardSize/9;
        g2.drawRect(getWidth()/2 - boardSize/2, getHeight()/20, boardSize, boardSize);
        if(field == null){
            System.out.println("ff");
                        return;
        }
        Font f = new Font(Font.MONOSPACED, Font.ROMAN_BASELINE, 20);
        g2.setFont(f);
        FontMetrics fm = g2.getFontMetrics();
        
        int borderCounter = 0;
        for(int i = 0; i < field.length; i++){
            int fieldColumnBegin = getWidth()/2 - boardSize/2;
            int fieldRowBegin = getHeight()/20;

            boolean lastBorderPrint = i == field.length-1;
            if(lastBorderPrint){
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(
                    fieldColumnBegin + boxSize*field.length, 
                    fieldRowBegin, 
                    fieldColumnBegin + boxSize*field.length, 
                    boardSize + fieldRowBegin
                );
                g2.drawLine(
                    fieldColumnBegin, 
                    fieldRowBegin + boxSize*field.length, 
                    fieldColumnBegin + boardSize, 
                    fieldRowBegin + boxSize*field.length
                );
            }

            if((borderCounter) % 3 == 0){
                g2.setStroke(new BasicStroke(3));
                // dicke Balken vertikal
                g2.drawLine(
                    fieldColumnBegin+ boxSize*i, 
                    fieldRowBegin,
                    fieldColumnBegin + boxSize*i, 
                    boardSize + fieldRowBegin
                );
                // dicke Balken horizontal
                g2.drawLine(
                    fieldColumnBegin, 
                    fieldRowBegin + boxSize*i, 
                    fieldColumnBegin + boardSize, 
                    fieldRowBegin + boxSize*i
                );
            }
            for(int j = 0; j < field[0].length; j++){

                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(1));
                g2.drawString(
                    Integer.toString(field[i][j]), 
                    //x
                    fieldColumnBegin+ boxSize*i + boxSize/2 - fm.stringWidth("0")/2, 
                    //y
                    getHeight()/20 + boxSize*j + fm.getAscent() + (boxSize - fm.getAscent())/2
                );

                // nummer boxen
                g2.drawRect(fieldColumnBegin+ boxSize*i, fieldRowBegin + boxSize*j, boxSize, boxSize);
            }
            borderCounter++;
        }
    }
}
