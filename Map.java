import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Map {
   JFrame frame;
   public static int x =0;
   public static int y=0;
   public static int xPos =0;
   public static int yPos=0;
   public static int stage =1;
   public static int selected = 0;
   public static boolean[] found = new boolean[] { false, false, false, false };
   public static boolean win;
   public Map(JFrame frame) {
      this.frame = frame;
      // frame.addMouseListener(new ClickHandler());
      // Clear the frame
      Container contentPane = frame.getContentPane();
      contentPane.removeAll();
      this.frame.revalidate();
      this.frame.repaint();
      MainMenu.setIsMap(true);
   }

   public static boolean checkWin() {
      if (found[0] && found[1] && found[2] && found[3])
      {
         win = true;
         return true;
      }
      return false;
   }

   public void run() {
      frame.getContentPane().add(new Drawing());
      frame.setVisible(true);
   }

   // class ClickHandler extends MouseAdapter {
   //    public void mouseReleased(MouseEvent e) {

   //       x = e.getX();
   //       y = e.getY() - 25;
   //       if (stage == 1) {
   //          if (x > 650 && x < 700 && y > 100 && y < 200) {
   //             stage = 2;
   //          }
   //       } else {
   //          if (x > 650 && x < 700 && y > 100 && y < 150) {
   //             selected = 1;
   //          } else if (x > 650 && x < 700 && y > 180 && y < 230) {
   //             selected = 2;
   //          } else if (x > 650 && x < 700 && y > 260 && y < 310) {
   //             selected = 3;
   //          } else if (x > 650 && x < 700 && y > 340 && y < 390) {
   //             selected = 4;
   //          } else if (x > 110 && x < 190 && y > 110 && y < 190) {
   //             if (selected == 1)
   //                found[0] = true;
   //          } else if (x > 410 && x < 490 && y > 110 && y < 190) {
   //             if (selected == 2)
   //                found[1] = true;
   //          } else if (x > 310 && x < 390 && y > 310 && y < 390) {
   //             if (selected == 3)
   //                found[2] = true;
   //          } else if (x > 210 && x < 390 && y > 110 && y < 190) {
   //             if (selected == 4)
   //                found[3] = true;
   //          }
   //       }
   //       frame.repaint();

   //    }
   // }

   class Drawing extends JComponent {
      public void paint(Graphics g) {
         super.paintComponent(g);
         // BACKGROUND
         g.setColor(Colours.backgroundBlue);
         g.fillRect(0, 0, getWidth(), getHeight());
         // MAP
         g.setColor(Color.BLACK);
         g.fillRect(100, 100, 500, 300);
         g.setColor(Color.WHITE);
         g.setColor(new Color(255, 220, 220));
         g.fillRect(110, 110, 80, 80);// Rm 201
         g.fillRect(410, 110, 80, 80);// Rm 202
         g.fillRect(510, 110, 80, 80);// Rm 203
         g.fillRect(110, 310, 80, 80);// Rm 204
         g.fillRect(210, 310, 80, 80);// Rm 205

         g.setColor(new Color(210, 255, 210));
         g.fillRect(210, 110, 180, 80);// Gym

         g.setColor(new Color(255, 255, 200));
         g.fillRect(110, 210, 480, 80);// Hallway
         g.fillRect(310, 310, 80, 80);// Lobby

         g.setColor(new Color(190, 225, 255));
         g.fillRect(410, 310, 180, 80);// Library

         g.setColor(Color.BLACK);
         g.setFont(new Font("Roboto", Font.PLAIN, 15));
         g.drawString("Rm 203", 520, 155);
         g.drawString("Rm 204", 120, 355);
         g.drawString("Rm 205", 220, 355);
         g.drawString("Library", 450, 355);
         g.drawString("Hallway", 330, 255);

         // WORDS
         g.setColor(Color.WHITE);
         g.setFont(new Font("Roboto", Font.PLAIN, 50));
         g.drawString("MAP", 350, 70);

         if (stage == 1) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            g.drawString("Rm 201", 120, 155);
            g.drawString("Rm 202", 420, 155);
            g.drawString("Lobby", 320, 355);
            g.drawString("Gym", 280, 155);
            g.setColor(Color.BLACK);
            g.fillRect(650, 100, 50, 100);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 13));
            g.drawString("NEXT", 655, 130);
            g.drawString(">", 670, 170);
         } else {
            // BUTTONS
            g.setColor(Color.BLACK);
            if (selected == 1)
               g.setColor(Color.RED);
            if (found[0])
               g.setColor(Color.GREEN);
            g.fillRect(650, 100, 50, 50);
            g.setColor(Color.BLACK);
            if (selected == 2)
               g.setColor(Color.RED);
            if (found[1])
               g.setColor(Color.GREEN);
            g.fillRect(650, 180, 50, 50);
            g.setColor(Color.BLACK);
            if (selected == 3)
               g.setColor(Color.RED);
            if (found[2])
               g.setColor(Color.GREEN);
            g.fillRect(650, 260, 50, 50);
            g.setColor(Color.BLACK);
            if (selected == 4)
               g.setColor(Color.RED);
            if (found[3])
               g.setColor(Color.GREEN);
            g.fillRect(650, 340, 50, 50);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));
            if (found[0])
               g.drawString("Rm 201", 120, 155);
            if (found[1])
               g.drawString("Rm 202", 420, 155);
            if (found[2])
               g.drawString("Lobby", 320, 355);
            if (found[3])
               g.drawString("Gym", 280, 155);

            g.setFont(new Font("Roboto", Font.PLAIN, 13));
            g.setColor(Color.WHITE);
            g.drawString("Rm 201", 650, 130);
            g.drawString("Rm 202", 650, 210);
            g.drawString("Lobby", 655, 290);
            g.drawString("Gym", 660, 370);

         }
         if (win){
            System.out.println("bye");
            return;
         }
      }
   }
}