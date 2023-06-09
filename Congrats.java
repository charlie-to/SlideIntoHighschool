
import java.awt.*;
import javax.swing.*;

public class Congrats {

/**
 * Congrats class of Slide Into Highschool, shows congratulations message for games
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
    /** Holds the text for congratulations screen*/
    String text;
    /** Holds the text for congratulations screen*/
    String text2 = "press space to continue";
    public Congrats(JFrame frame, String text){
        this.frame = frame;
        this.text = text;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsCongrats(true);
    }
    
    /**
     * Constructor method
     *
     * @param frame, text, text2, takes frames and texts to display
     * @return name Function
     */
    public Congrats(JFrame frame, String text, String text2){
        this.frame = frame;
        this.text = text;
        this.text2 = text2;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsCongrats(true);
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
            g.drawString("Congrats!", 100, 130);   
            g.drawString(text, 100, 170);
            g.drawString(text2, 100, 210);   
        }
    }
}