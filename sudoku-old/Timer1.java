import java.util.Timer;
import java.util.TimerTask;
public class Timer1 {
  int sekunden = 0;
  int minuten = 0;
  int time = 0;
  public void Timer1(String[] args) {        //Konstruktor
  
  }
  
  Timer timer1 = new Timer();
  TimerTask task = new TimerTask() {    //erstellt Timer der sekuendlich hochzaehlt
      public void run() {
        sekunden++;
       if (sekunden > 59) {
        minuten++;
        sekunden = 0; 
       } // end of if 
      if (time == 1) return;
      }
    } ;
  
  public void start() {                    //Metode zum starten vom Timer
    timer1.scheduleAtFixedRate(task,1000,1000);
  }
  
  public int getSek(){                  //Methode, um die Sekunden in der Anzeige zu sehen
    return sekunden;
  }
  
  public int getMin(){                 //Methode, um die Minuten in der Anzeige zu sehen
    return minuten;
  }
  
  public void timer_restart() {       //Methode, um den Timer neu beginnen zu lassen
    sekunden = 0;
    minuten = 0;
    time = 1;
  }
  
}