import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    public Interface() {
        //Frame init
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        setTitle("Sudoku");
        setResizable(false);

        //Frame Position
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
    }

    public static void main(String[] args) {
        new Interface();
    }
}
