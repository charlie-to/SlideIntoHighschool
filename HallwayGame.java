import javax.swing.*;
import java.awt.*;
public class HallwayGame {
    JFrame frame;
    public HallwayGame(JFrame frame){
        this.frame = frame;
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsHallwayGame(true);
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
            g.setColor(Color.WHITE);
            g.setFont(Colours.mediumSerifFont);
            g.drawString("Get items you'll need for class", 100,50);
        }
    }
}
