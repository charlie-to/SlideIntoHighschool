import javax.swing.*;
import java.awt.*;

public class SplashScreen {
   public SplashScreen() {
      JFrame frame = new JFrame("Slide Into Highschool");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(1200, 840);
      frame.add(new Drawing());
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      new SplashScreen();
   }

   class Drawing extends JComponent {
      public void paint(Graphics g) {
         Color backBlue = new Color(0, 155, 232);
         Color floorYellow = new Color(244, 196, 48);
         Color potBrown = new Color(160, 100, 20);
         Color stemBrown = new Color(100, 50, 10);
         Color plantGreen = new Color(37, 82, 59);
         Color white = new Color(255, 255, 255);
         Font largeSerifFont = new Font("Serif", Font.BOLD, 50);
         g.setFont(largeSerifFont);
         /** Background */
         g.setColor(backBlue);
         g.fillRect(0, 0, 1200, 800);
         /** Floor */
         g.setColor(floorYellow);
         g.fillRect(0, 700, 1200, 800);
         /** Plant */
         int[] xQuad = { 100, 200, 180, 120 };
         int[] yQuad = { 600, 600, 700, 700 };
         g.setColor(potBrown);
         g.fillPolygon(xQuad, yQuad, 4);

         /** Stem */
         g.setColor(stemBrown);
         g.fillRect(140, 300, 20, 300);

         g.setColor(plantGreen);
         g.fillOval(100, 400, 100, 150);
         g.fillOval(100, 300, 100, 150);
         g.fillOval(100, 200, 100, 150);

         /** Plant */
         int[] xQuad1 = { 1000, 1100, 1080, 1020 };
         int[] yQuad1 = { 600, 600, 700, 700 };
         g.setColor(potBrown);
         g.fillPolygon(xQuad1, yQuad1, 4);

         /** Stem */
         g.setColor(stemBrown);
         g.fillRect(1040, 300, 20, 300);

         g.setColor(plantGreen);
         g.fillOval(1000, 400, 100, 150);
         g.fillOval(1000, 300, 100, 150);
         g.fillOval(1000, 200, 100, 150);

         /** Text */
         g.setColor(white);
         g.drawString("Slide", 550, 300);
         g.drawString("Into", 550, 400);
         g.drawString("High School", 500, 500);
      }
   }
}
