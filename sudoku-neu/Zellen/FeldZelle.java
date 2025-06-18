package Zellen;

import javax.swing.*;
import java.awt.*;

public class FeldZelle extends JButton {
    private int xValue;
    private int yValue;

    public FeldZelle(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        setEnabled(true);
        setBackground(Color.white);
        setForeground(Color.white);
        setText("0");
    }

    public int getxValue() {
        return xValue;
    }
    public int getyValue() {
        return yValue;
    }

    public void setPosition(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }
}
