
import java.awt.*;
import javax.swing.*;

public class Goodbye {

/**
 * Goodbye class of Slide Into Highschool, shows goodbye message
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 5st, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
   JFrame frame;
    
    /**
     * Constructor method
     *
     * @param frame
     * @return name Function
     */
    public Goodbye(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsGoodbye(true);
        
    }
    public void run(){
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            System.out.println("goodbye");
            g.setColor(Colours.darkerBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Colours.backgroundBlue);
            g.fillRect(20, 20, getWidth()-40, getHeight()-40);
            // NUMBERS
            g.setColor(Color.WHITE);
            g.setFont(Colours.title);
            g.drawString("Goodbye!", 300, 90);   
            g.setFont(new Font("Roboto", Font.PLAIN, 25));
            g.drawString("Thank you for playing our game", 100, 170);
            g.drawString("We hope to see you play again soon", 100, 250);
            g.drawString("Press any key to exit", 100, 350);
        }
    }
}