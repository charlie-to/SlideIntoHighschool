import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Instructions {
    JFrame frame;
    public Instructions(JFrame frame){
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
    }
    public void run(){
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    class Drawing extends JComponent{
        public void paint(Graphics g) {
            super.paintComponent(g);
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0,0, getWidth(), getHeight());
        }

    }
}
