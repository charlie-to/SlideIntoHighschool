import javax.swing.*;
import java.awt.*;

public class LearningCaf {
    JFrame frame;
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
