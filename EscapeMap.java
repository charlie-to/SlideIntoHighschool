import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * EscapeMap class of Slide Into Highschool, Map for Escape stage of game
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 6st, 2023
 * Time Spent: 2.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
public class EscapeMap {

    /** frame variable*/
    JFrame frame;
    /** text variable for exit button*/
    public static String text = "Exit";
    /** checks if the hall level is complete*/
    public static boolean isHallComplete = false;
    /** checks if the take notes level is complete*/
    public static boolean isTakeNotesComplete = false;
    /** checks if the talk to teacher level is complete*/
    public static boolean isTalkToTeacherComplete = false;
    /** checks if the kick the ball level is complete*/
    public static boolean isKickBallComplete = false;
    /** check is the library game is complete*/
    public static boolean isLibraryGameComplete = false;
    
    /**
     * Constructor method
     *
     * @param frame Takes frame from driver
     */
    public EscapeMap(JFrame frame) {
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsEscapeMap(true);
    }
    
    /**
     * run method
     *
     */
    public void run(){
        ImageIcon map = new ImageIcon("images/map.png", "image of map");
        frame.add(new JLabel(map));
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    
    /** holds the x position*/
    public static int xPos = 640;
    /** holds the y position */
    public static int yPos = 170;
    
    /**
     * Drawing class
     *
     */
    class Drawing extends JComponent {
    
     /**
     * paint method
     *
     * @param g Takes Graphics class
     */
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND MAP
            try{
                BufferedImage img = ImageIO.read(new File("images/map.png"));
                g.drawImage(img,  0, 0, null);
            } catch (Exception e){System.out.println("Error with image");}
            // BACKGROUND PERSON
            try{
                BufferedImage img = ImageIO.read(new File("images/person.png"));
                Image newImage = img.getScaledInstance(40, 70, Image.SCALE_DEFAULT);
                g.drawImage(newImage,  xPos, yPos, null);
            } catch (Exception e){System.out.println("Error with image");}
            g.setColor(Color.GREEN);
            g.fillRect(80, 360, 210, 70);
            g.setColor(Color.BLACK);
            g.setFont(new Font("roboto", Font.BOLD, 22));
            g.drawString(text, 80, 405);
            if(isHallComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  402, 170, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isTakeNotesComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  352, 107, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isTalkToTeacherComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  240, 280, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isKickBallComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  400, 340, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isLibraryGameComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  575, 370, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("roboto", Font.BOLD, 22));
            g.drawString("Move to the green rooms with 'w' 'a' 's' 'd' and play the games", 70, 470);
            g.setFont(new Font("roboto", Font.BOLD, 35));
            g.drawString("Escape Level: Survie a School Day", 90, 40);
        }
    }
}
