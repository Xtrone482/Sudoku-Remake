package Fenster;

import java.awt.*;
import javax.swing.JFrame;

public class SudokuFenster extends JFrame {
    
    private GrundPanel gp;

    public SudokuFenster(int[][] field){

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		int height = (int)screenSize.getHeight();

        setTitle("Sudoku");
		setVisible(true);
		setBounds(new Rectangle((int)width/4,(int)height/4,(int)width - (int)width/2, (int)height - (int)height/2));

        gp = new GrundPanel(this);
        gp.field = field;
        add(gp);
    }
}
