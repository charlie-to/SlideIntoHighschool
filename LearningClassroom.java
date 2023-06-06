import javax.swing.*;
import java.awt.*;

public class LearningClassroom {
    JFrame frame;
    public LearningClassroom(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLearningClassroom(true);
    }
    public void run(){
        ImageIcon hall = new ImageIcon("images/LearningClassroom.png", "image of classroom");
        frame.add(new JLabel(hall));
        frame.setVisible(true);
    }
}