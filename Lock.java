import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
// COMBO = 10, 35, 30
public class Lock {

/**
 * Lock class of Slide Into Highschool, creates the lock game for the maze stage of the game
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 4st, 2023
 * Time Spent: 2 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
    JFrame frame;
    public static int degrees = 0;
    public static ArrayList<String> turns = new ArrayList<String>();
    public static int curNum;


      /**
     * checkWinner method, checks for a win
     *
     * @return boolean Whether the game is won or not
     */
    public static boolean checkWinner(){
        String[] winCombo = { "up", "up", "up", "up", "up", "up", "up", "down", "down", "down", "down", "down", "down", "down", "down", "down","down","down"};
        if (curNum == 30 && turns.size() > 18+1){
            for (int x = turns.size()-1, i = 0; i < winCombo.length ;x--, i ++){
                if (turns.get(x) == winCombo[i]){
                    continue;
                }
                else{
                    // System.out.println("no win");
                    return false;
                }
            }
            // System.out.println("win");
            return true;
        }
        return false;
    }
     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public Lock(JFrame frame) {
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsLock(true);
    }

    public void run() {
        frame.getContentPane().add(new Drawing());
        curNum = (degrees/45)*5;
        // System.out.println(curNum);
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
            g.setColor(Color.WHITE);
            // INSTRUCTION TEXT
            g.setFont(Colours.title);
            g.drawString("Unlock the Lock", 250, 65);
            g.setFont(new Font("Roboto", Font.BOLD, 25));
            // g.drawString("Use 'S' and 'W' to rotate lock", 10, 100);
            g.drawString("COMBO: 10, 35, 30", 280, 430);
            // LOCK
            g.setColor(Color.BLACK);
            g.fillOval(240, 80, 320, 320);
            g.setColor(Color.GRAY);
            g.fillOval(250, 90, 300, 300);
            g.setColor(Color.WHITE);
            g.fillOval(365, 200, 70, 70);
            // NUMBERS
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 30));
            g.drawString("0", 395, 130);
            g.drawString("5", 480, 170);
            g.drawString("10", 505, 250);
            g.drawString("15", 470, 340);
            g.drawString("20", 385, 375);
            g.drawString("25", 295, 340);
            g.drawString("30", 260, 250);
            g.drawString("35", 290, 170);


            // ROTATING THING
            Graphics2D g2d = (Graphics2D) g;
            Rectangle rect2 = new Rectangle(385, 140, 30, 90);

            g2d.rotate(Math.toRadians(degrees),385+15, 140+100);
            g2d.draw(rect2);
            g2d.fill(rect2);
        }
    }

}
