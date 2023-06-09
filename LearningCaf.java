import javax.swing.*;
import java.awt.*;

public class LearningCaf {

/**
 * LearningCaf class of Slide Into Highschool, creates graphics for cafeteria for learning stage
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 4st, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    JFrame frame;
    /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public LearningCaf(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLearningCaf(true);
    }
    public void run(){
        ImageIcon hall = new ImageIcon("images/LearningCaf.png", "image of caf");
        frame.add(new JLabel(hall));
        frame.setVisible(true);
    }
}
