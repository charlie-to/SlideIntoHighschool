
import java.awt.*;
import javax.swing.*;

public class TextScreen {
/**
 * TextScreen class of Slide Into Highschool, creates the text screens for learning stage
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 6th, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
    JFrame frame;
    String text;
    public static String cur;    

   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public TextScreen(JFrame frame, String text){
        this.frame = frame;
        this.text = text;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsTextScreen(true);
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
            g.setFont(new Font("Roboto", Font.BOLD, 30));
            g.drawString(text, 100, 70);
            // g.setFont(new Font("Roboto", Font.PLAIN, 20));
            int a = 120;
            int l = 40;
            if (cur.equals("lock")){
                g.setFont(new Font("Roboto", Font.PLAIN, 24));
                g.drawString("Rotate the lock using 'W' and 'S'", 100, a);
                g.setFont(new Font("Roboto", Font.BOLD, 20));
                g.drawString("How to unlock a lock:", 100, a+l);
                g.setFont(new Font("Roboto", Font.PLAIN, 20));
                g.drawString("1. Rotate it 1 rotation clockwise to reset it", 100, a+l*2);
                g.drawString("2. Rotate it clockwise and stop at the first number", 100, a+l*3);
                g.drawString("3. Rotate it counter-clockwise a full rotation, stop at the first number", 100, a+l*4);
                g.drawString("4. Rotate it counter-clockwise to the second number", 100, a+l*5);
                g.drawString("5. Rotate it clockwise to the last number", 100, a+l*6);
                g.drawString("Press 'n' when you are ready to start", 230, 10+a+l*7);
            }
            if (cur.equals("map")){
                g.setFont(new Font("Roboto", Font.PLAIN, 24));
                g.drawString("You will be given a map to memorize", 100, a);
                g.setFont(new Font("Roboto", Font.PLAIN, 20));
                g.drawString("1. Memorize the room locations on the map then click next", 100, a+l);
                g.drawString("2. Place the missing rooms in their correct location", 100, a+l*2);
                g.drawString("Press 'n' when you are ready to start", 230, 10+a+l*7);
            }
            if (cur.equals("MeetThePerson")){
                g.setFont(new Font("Roboto", Font.PLAIN, 24));
                g.drawString("You will have be given common conversation questions", 100, 20+a);
                g.drawString("Choose the answer that will help you make friends", 100, 20+a+l);
                g.setFont(new Font("Roboto", Font.PLAIN, 20));
                g.drawString("Press 'n' when you are ready to start", 230, 10+a+l*7);
            }
            if (cur.equals("Try again")){
                g.setFont(new Font("Roboto", Font.PLAIN, 24));
                g.drawString("Some of your answers were incorrect", 100, 20+a);
                g.drawString("Press any key when you are ready to try again", 100, 20+a+l);
            }
        }
    }
}