import javax.swing.JButton;
public class Felder extends JButton{
  private int x;
  private int y;
  
  public void Felder() {
  }
  
  public void setx(int a){
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
}