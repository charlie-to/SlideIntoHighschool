import java.awt.*;
import javax.swing.*;

public class TextScreen {
    JFrame frame;
    String text;
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
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            // NUMBERS
            g.setColor(Color.WHITE);
            g.setFont(new Font("Roboto", Font.PLAIN, 30));
            g.drawString(text, 100, 170);
            g.drawString("Press 'n' when you are ready to start", 100, 210);
        }
    }
}