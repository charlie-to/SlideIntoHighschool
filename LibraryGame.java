import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class LibraryGame {
   JFrame frame;
   public static int x=0;
   public static int y = 0;
   public static int xPos = 0;
   public static int yPos =0;
   public static int stage =1;
   public static int score =0;
   public static int x1, x2, y1, y2;
   public static boolean[] books= new boolean[6];
   public static boolean isComplete = false;

   public LibraryGame(JFrame frame) {
      this.frame = frame;
      x1 = 120;
      x2 = 200;
      y1 = 120;
      y2 = 240;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsLibraryGame(true);
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
         // LOCKER
         g.setColor(Color.BLACK);
         g.fillRect(100,100,300,300);
         g.setColor(Color.GRAY);
         g.fillRect(110,110,280,130);
         g.fillRect(110,260,280,130);
         //BOOKS
         g.setColor(Color.RED);
         if(books[0]) g.setColor(Color.GRAY);
         g.fillRect(120,120,80,120);
         g.setColor(new Color(40,250,100));
         if(books[1]) g.setColor(Color.GRAY);
         g.fillRect(200,120,60,120);
         g.setColor(new Color(240,100,210));
         if(books[2]) g.setColor(Color.GRAY);
         g.fillRect(260,180,120,60);
         g.setColor(Color.GREEN);
         if(books[3]) g.setColor(Color.GRAY);
         g.fillRect(120,330,130,60);
         g.setColor(Color.YELLOW);
         if(books[4]) g.setColor(Color.GRAY);
         g.fillRect(250,270,70,120);
         g.setColor(Color.PINK);
         if(books[5]) g.setColor(Color.GRAY);
         g.fillRect(320,280,60,110);
         // WORDS
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 50));
         g.drawString("GET THE RIGHT BOOKS", 200, 70);
         
         if (stage == 1) {
            g.setColor(Color.RED);
            g.fillRect(500,100,200,300);
         } else if (stage == 2) {
            x1 = 250;
            x2 = 320;
            y1 = 270;
            y2 = 390;
            g.setColor(Color.YELLOW);
            g.fillRect(500,100,200,300);
         } else if (stage == 3) {
            x1 = 120;
            x2 = 250;
            y1 = 330;
            y2 = 390;
            g.setColor(Color.GREEN);
            g.fillRect(500,100,200,300);
         } else if (stage == 4) {
            x1 = 320;
            x2 = 380;
            y1 = 280;
            y2 = 390;
            g.setColor(Color.PINK);
            g.fillRect(500,100,200,300);
         } else if (stage == 5) {
            x1 = 260;
            x2 = 380;
            y1 = 180;
            y2 = 240;
            g.setColor(new Color(240,100,210));
            g.fillRect(500,100,200,300);
         } else if (stage == 6) {
            x1 = 200;
            x2 = 260;
            y1 = 120;
            y2 = 240;
            g.setColor(new Color(40,250,100));
            g.fillRect(500,100,200,300);
         }else if (stage == 7) {
            x1 = 0;
            x2 = 0;
            y1 = 0;
            y2 = 0;
            g.setColor(Color.BLACK);
            g.fillRect(100,100,600,300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 30));
            g.drawString("Congratulations, you have picked", 200, 200);
            g.drawString("all the right book for yourself", 350, 300);
            g.drawString("Continue", 200, 380);
            System.out.println("done");
            LibraryGame.isComplete = true;
         }else if (stage > 7) {
            System.out.println("done");
            LibraryGame.isComplete = true;
         }
      }
   }
}