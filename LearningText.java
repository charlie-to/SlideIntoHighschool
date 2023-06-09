import java.awt.*;
import javax.swing.*;

public class LearningText {

/**
 * LearningText class of Slide Into Highschool, creates all the text for the learning stage
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 5st, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    JFrame frame;
    String text, text2, text3;
    
     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public LearningText(JFrame frame, String text, String text2, String text3){
        this.frame = frame;
        this.text = text;
        this.text2 = text2;
        this.text3 = text3;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLearningText(true);
    }
    public void run(){
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            // NUMBERS
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 30));
            g.drawString(text, 100, 130); 
             g.drawString(text2, 100, 200); 
             g.drawString(text3, 100, 270);  
            g.drawString("Press e when you're done learning", 100, 380);   
        }
    }
}