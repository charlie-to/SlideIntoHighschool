
import java.awt.*;
import javax.swing.*;

public class MazeIntro {

/**
 * MazeIntro class of Slide Into Highschool, shows intro message for maze level
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 5st, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    /** Holds the frame*/
    JFrame frame;
    public MazeIntro(JFrame frame, String text){
        MainMenu.setIsMazeIntro(true);
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
    }
    
    /**
     * Constructor method
     *
     * @param frame, text, text2, takes frames and texts to display
     * @return name Function
     */
    public MazeIntro(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsMazeIntro(true);
    }
    public void run(){
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
            // NUMBERS
            g.setColor(Color.WHITE);
            g.setFont(Colours.title);
            g.drawString("Welcome to the maze level", 100, 90);   
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Use 'W', 'A', 'S', 'D' to move yourself arround", 100, 170);
            g.drawString("Complete the maze by overcoming obstacles you ", 100, 170+40+10);
            g.drawString("see along the way", 100, 170+40+30+10);
            g.drawString("Press any key to start, Good luck!", 100, 170+80+50);
        }
    }
}