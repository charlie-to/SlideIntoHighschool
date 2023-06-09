

import java.awt.*;
import javax.swing.*;

public class TakeNotes {

/**
 * TakeNotes class of Slide Into Highschool, creates the Take Notes game for the escape stage of game
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 7th, 2023
 * Time Spent: 3 hrs
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
   public static boolean win = false;
     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
   public TakeNotes(JFrame frame) {
      this.frame = frame;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsTakeNotes(true);
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

         // SIGN
         g.setColor(Color.BLACK);
         g.fillRect(100,100,600,300);
         

         // WORDS
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 50));
         g.drawString("TAKE NOTES", 200, 70);


         if (stage == 1) {
            g.setFont(new Font("Roboto", Font.PLAIN, 20));
            g.drawString("An animal cell is a fundamental", 200, 200);
            g.drawString("unit of life in animals, composed", 200, 240);
            g.drawString("of various organelles and surrounded", 200, 280);
            g.drawString("by a cell membrane. It contains a", 200, 320);
            g.drawString("nucleus that contains the DNA.", 200, 360);
            g.setColor(Color.BLACK);
            g.fillRect(300,420,200,60);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Continue", 330, 450);
         } else if (stage == 2) {
            g.setColor(Colours.backgroundBlue);
            g.fillRect(100,200,600,100);
            g.setFont(new Font("Roboto", Font.PLAIN, 20));
            g.drawString("Animal cells -> surrounded by cell membrane", 200, 180);
            g.drawString("Animal cells -> surrounded by plastic", 200, 380);
         
         } else if (stage == 3) {
            g.setColor(Colours.backgroundBlue);
            g.fillRect(100,200,600,100);
            g.setFont(new Font("Roboto", Font.PLAIN, 20));
            g.drawString("Contains nucleus and DNA", 200, 180);
            g.drawString("Contains nucluis and NBA", 200, 380);
         
         } else if (stage == 4) {
            g.setColor(Colours.backgroundBlue);
            g.fillRect(100,200,600,100);
            g.setFont(new Font("Roboto", Font.PLAIN, 20));
            g.drawString("Fundamental unit of life", 200, 180);
            g.drawString("Fundamental unit of construction", 200, 380);
         
         }else if (stage == 5) {
            g.setColor(Color.BLACK);
            g.fillRect(100,100,600,300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            if(score>=2){
            g.drawString("Congratulations!", 200, 230);
            g.drawString("You have successfully", 200, 280);
            g.drawString("taken notes!", 200, 330);
            win = true;
            }else{
            g.drawString("Oh no!", 200, 230);
            g.drawString("Your notes were bad and", 200, 280);
            g.drawString("you failed the test! Try again", 200, 330);
            win = false;
            }
            g.setColor(Color.BLACK);
            g.fillRect(300,420,200,60);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Continue", 330, 450);
         
         }else {
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Press anywhere to continue",200,200);
            System.out.println(TakeNotes.isComplete);
            TakeNotes.isComplete = true;
         }
      }
   }
}