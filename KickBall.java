import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class KickBall {

/**
 * KickBall class of Slide Into Highschool, creates KickBall game 
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 7th, 2023
 * Time Spent: 1 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
   JFrame frame;
   public static int x=0;
   public static int y = 0;
   public static int xPos = 0;
   public static int yPos =0;
   public static int stage =1;
   public static int score =0;
   public static boolean isComplete = false;


     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
   public KickBall(JFrame frame) {
      this.frame = frame;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsKickBall(true);
   }

   public void run() {
      frame.getContentPane().add(new Drawing());
      frame.setVisible(true);
   }

   class Drawing extends JComponent {
      public void paint(Graphics g) {
         super.paintComponent(g);
         // BACKGROUND
         g.setColor(Colours.backgroundBlue);
         g.fillRect(0, 0, getWidth(), getHeight());
         // GRASS
         g.setColor(new Color (40,200,40));
         g.fillRect(0,400,800,100);
         //BALL
         g.setColor(new Color (200,200,100));
         g.fillOval(350,380,100,100);
         // WORDS
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 50));
         g.drawString("KICK THE BALL", 200, 70);
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 20));
         g.drawString("Click inside the goal to kick", 200, 140);
         


         if (stage == 1) {
            //GATE
            g.setColor(Color.GRAY);
            g.fillRect(100,200,600,40);
            g.fillRect(100,200,40,200);
            g.fillRect(660,200,40,200);
            
         } else if (stage == 2) {
            // BACKGROUND
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            // GRASS
            g.setColor(new Color (40,200,40));
            g.fillRect(0,400,800,100);
            // WORDS
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 50));
            g.drawString("KICK THE BALL", 200, 70);
            //BALL
            g.setColor(new Color (200,200,100));
            g.fillOval(350,380,100,100);
            //GATE
            g.setColor(Color.GRAY);
            g.fillRect(200,250,400,40);
            g.fillRect(200,250,40,150);
            g.fillRect(560,250,40,150);
         
         } else if (stage == 3) {
            // BACKGROUND
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            // GRASS
            g.setColor(new Color (40,200,40));
            g.fillRect(0,400,800,100);
            // WORDS
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 50));
            g.drawString("KICK THE BALL", 200, 70);
            //BALL
            g.setColor(new Color (200,200,100));
            g.fillOval(350,380,100,100);
            //GATE
            g.setColor(Color.GRAY);
            g.fillRect(300,300,200,40);
            g.fillRect(300,300,40,100);
            g.fillRect(460,300,40,100);
         
         } else if (stage == 4) {
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.fillRect(100,100,600,300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            if(score>=2){
            g.drawString("Congratulations!", 200, 230);
            g.drawString("You have successfully", 200, 280);
            g.drawString("kicked a ball!", 200, 330);
            }else{
            g.drawString("Oh no!", 200, 230);
            g.drawString("You did not kick the", 200, 280);
            g.drawString("ball successfully!", 200, 330);
            }
            g.setColor(Color.BLACK);
            g.fillRect(300,420,200,60);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Continue", 330, 440);
         
         }else {
            System.out.println("done");
            KickBall.isComplete = true;
         }
      }
   }
}