import javax.swing.*;
import java.awt.*;
public class LearningHall{
    JFrame frame;
    public LearningHall(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLearningHall(true);
    }
    public void run(){
        ImageIcon hall = new ImageIcon("images/LearningHallway.png", "image of hallway");
        frame.add(new JLabel(hall));
        frame.setVisible(true);
    }
}
