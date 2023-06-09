import java.awt.*;
import javax.swing.*;

public class MeetThePerson {

/**
 * MeetThePerson class of Slide Into Highschool, creates the meet the person game for the maze stage
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 7ht, 2023
 * Time Spent: 2.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
   JFrame frame;
   public static int x=0;
   public static int y = 0;
   public static int xPos = 0;
   public static int yPos =0;
   public static int score = 0;
   public static int stage =1;
   public static boolean hover1 = false;
   public static boolean hover2 = false;
   public static boolean isComplete = false;

   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
   public MeetThePerson(JFrame frame) {
      this.frame = frame;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsMeetPerson(true);
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
         // PERSON
         g.setColor(new Color(200, 170, 150));
         g.fillRect(180, 200, 40, 100);// neck
         // face
         g.fillOval(125, 125, 150, 150);
         g.setColor(Color.BLACK);
         g.fillOval(150, 160, 40, 40);
         g.fillOval(210, 160, 40, 40);
         g.fillRect(150, 220, 100, 20);
         // shirt
         g.fillRect(100, 300, 200, 200);
         g.setColor(Color.WHITE);
         g.fillRect(160, 300, 80, 200);
         g.setColor(Color.BLACK);
         g.fillRect(190, 300, 20, 200);
         g.fillOval(180, 300, 40, 40);

         // SIGN
         g.setColor(Color.BLACK);
         g.fillRect(350, 100, 350, 200);
         g.setColor(Color.BLACK);
         if (hover1)
            g.setColor(Color.GRAY);
         g.fillRect(350, 350, 150, 75);
         g.setColor(Color.BLACK);
         if (hover2)
            g.setColor(Color.GRAY);
         g.fillRect(550, 350, 150, 75);

         g.setColor(Color.BLACK);
         g.setFont(new Font("Roboto", Font.PLAIN, 15));

         // WORDS
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 50));
         g.drawString("MEET THE PERSON", 200, 70);

         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 25));

         if (stage == 1) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Hello, I am Jack!", 400, 160);
            g.drawString("How are you doing?", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("I am good", 370, 400);
            g.drawString("I am not good", 570, 400);
         } else if (stage == 2) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("That is cool! What", 400, 160);
            g.drawString("class do you have?", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Science class", 370, 400);
            g.drawString("Go away!", 570, 400);
         } else if (stage == 3) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Would you like to", 400, 160);
            g.drawString("walk to class together?", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("You are bald", 370, 400);
            g.drawString("Sure!", 570, 400);
         } else {
            System.out.println("done");
            MeetThePerson.isComplete = true;
         }
      }
   }
}