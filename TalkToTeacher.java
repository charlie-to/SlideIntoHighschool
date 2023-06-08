import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TalkToTeacher {
   JFrame frame;
   public static int x=0;
   public static int y = 0;
   public static int xPos = 0;
   public static int yPos =0;
   public static int stage =1;
   public static int score = 0;
   public static boolean hover1 = false;
   public static boolean hover2 = false;
   public static boolean isComplete = false;

   public TalkToTeacher(JFrame frame) {
      this.frame = frame;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsTalkToTeacher(true);
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
         g.setColor(new Color(250,240,150));
         g.fillRect(110, 110, 180, 200);// hair
         g.setColor(new Color(200, 170, 150));
         g.fillRect(180, 200, 40, 100);// neck
         // face
         g.fillOval(125, 125, 150, 150);
         g.setColor(Color.BLACK);
         g.fillOval(150, 160, 40, 40);
         g.fillOval(210, 160, 40, 40);
         g.fillRect(150, 220, 100, 20);
         // shirt
         g.setColor(new Color(200,150,230));
         g.fillRect(100, 300, 200, 200);
         g.setColor(new Color(100,200,100));
         g.fillRect(160, 300, 80, 200);

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
         g.drawString("TALK TO THE TEACHER", 200, 70);

         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 25));

         if (stage == 1) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Hello there!", 400, 160);
            g.drawString("I am Ms H!", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Nice to meet you", 370, 400);
            g.drawString("Ok.", 570, 400);
         } else if (stage == 2) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("I teach science? Do", 400, 160);
            g.drawString("you like science?", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Ew, science.", 370, 400);
            g.drawString("Science is great", 570, 400);
         } else if (stage == 3) {
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Go take a seat", 400, 160);
            g.drawString("over there!", 400, 250);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("No thanks", 370, 400);
            g.drawString("Okay!", 570, 400);
         } else if (stage == 4){
            g.setColor(Colours.backgroundBlue);
            g.fillRect(550, 350, 150, 75);
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            if(score >=2){
            g.drawString("You have made the", 400, 160);
            g.drawString("teacher happy!", 400, 250);
            }else{
            g.drawString("You have made the", 400, 160);
            g.drawString("teacher sad!", 400, 250);
            }
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Continue", 370, 400);

         }else {
            System.out.println("done: " + score);
            TalkToTeacher.isComplete = true;
         }
      }
   }
}