import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class LearningLevel {

/**
 * LearningClassroom class of Slide Into Highschool, creates learning classroom graphics for learning stage
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 4st, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    JFrame frame;
    public static int cur = 1;
    public static String text = "Welcome to the learning level! Click the circled items to learn about them.";
    public static String text2 = "Click 'Next Room' after you've learnt about all the different items in the room";
    /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public LearningLevel(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLearningLevel(true);
    }
    public static void resetVars(){
        cur = 1;
        text = "Welcome to the learning level! Click the circled items to learn about them.";
        text2 = "Click 'Next Room' after you've learnt about all the different items in the room";
    }
    public void run(){
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            if (cur == 1){
                try{
                    BufferedImage img = ImageIO.read(new File("images/learning/NewLearningHallway.png"));
                    // Image newImage = img.getScaledInstance(img.getWidth(), img., Image.SCALE_DEFAULT);
                    g.drawImage(img,  0, 0, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if (cur == 2){
                try{
                    BufferedImage img = ImageIO.read(new File("images/learning/NewLearningClassroom.png"));
                    // Image newImage = img.getScaledInstance(img.getWidth(), img., Image.SCALE_DEFAULT);
                    g.drawImage(img,  0, 0, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if (cur == 3){
                try{
                    BufferedImage img = ImageIO.read(new File("images/learning/NewLearningCaf.png"));
                    // Image newImage = img.getScaledInstance(img.getWidth(), img., Image.SCALE_DEFAULT);
                    g.drawImage(img,  0, 0, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            g.setColor(Colours.darkerBlue);
            g.fillRoundRect(100-10, 400-10, 580+20, 100+20, 20, 20);
            g.setColor(Color.WHITE);
            g.fillRoundRect(100-3, 400-3, 580+6, 100+6, 20, 20);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Roboto", Font.PLAIN, 17));
            g.drawString(text,100+10, 400+25);
            g.drawString(text2,100+10, 400+30+20);
        }
    }
}