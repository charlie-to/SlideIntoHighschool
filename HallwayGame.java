import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class HallwayGame {

/**
 * HallwayGame class of Slide Into Highschool, Creates hallway game
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 4st, 2023
 * Time Spent: 1 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    JFrame frame;
    public static ArrayList<String> items = new ArrayList<String>(4);

   
     
     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public HallwayGame(JFrame frame) {
        this.frame = frame;
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsHallwayGame(true);
    }

    /**
     * checkWin method, checks if game is won
     *
     * @return boolean If game is won
     */
    public static boolean checkWin() {
        for (String i : items) {
            if (i.equals("videoGame") || i.equals("dog") || i.equals("headphones")) {
                return false;
            }
        }
        return true;
    }
    /**
     * runs the hallway game
     */
    public void run() {
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            g.setColor(Colours.darkerBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Colours.backgroundBlue);
            g.fillRect(20, 20, getWidth()-40, getHeight()-40);
            g.setColor(Color.WHITE);
            g.setFont(Colours.title2);
            g.drawString("Select 4 items you'll need for class", 120, 70);
            g.setColor(Color.GRAY);
            g.fillRect(180, 330, 440, 140);
            // DRAW SELECTED ITEMS
            int xPos = 180;
            for (String i : items) {
                try {
                    BufferedImage img = ImageIO.read(new File("images/items/" + i + ".png"));
                    Image newImage = img.getScaledInstance(110, 90, Image.SCALE_DEFAULT);
                    g.drawImage(newImage, xPos, 350, null);
                    xPos += 100;
                } catch (Exception e) {
                    System.out.println("Error with image");
                }
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/dog.png"));
                Image newImage = img.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 50, 100, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/notebook.png"));
                Image newImage = img.getScaledInstance(140, 140, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 160, 80, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/headphones.png"));
                Image newImage = img.getScaledInstance(140, 140, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 260, 85, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/textbooks.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 380, 90, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/pencilCase.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 520, 80, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/videoGame.png"));
                Image newImage = img.getScaledInstance(130, 130, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 300, 200, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            try {
                BufferedImage img = ImageIO.read(new File("images/items/water.png"));
                Image newImage = img.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
                g.drawImage(newImage, 460, 200, null);
            } catch (Exception e) {
                System.out.println("Error with image");
            }
            if (!checkWin() && items.size() == 4){
                g.setColor(Color.GRAY);
                g.fillRect(180, 330, 440, 140);
                g.setColor(Color.WHITE);
                g.setFont(Colours.small);
                g.drawString("Those are the incorrect items", 200, 370);
                g.drawString("press any key to try again", 200, 400);
            }
            g.setColor(Colours.darkerBlue);
            g.fillRect(0, getHeight()-20, getWidth(), 20);
        }
    }
}
