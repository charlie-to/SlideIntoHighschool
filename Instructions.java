import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Instructions {
    JFrame frame;

    public Instructions(JFrame frame) {
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();

        MainMenu.setIsInstruction(true);
    }

    public void run() {
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(new Drawing());
        JButton exit = new JButton("exit");
        frame.add(exit, BorderLayout.SOUTH);
        frame.setVisible(true);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenu.setIsInstruction(false);
                System.out.println("exit clicked");
                MainMenu ex = new MainMenu(frame);
                ex.run();
            }
        });
    }

    
    

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 40));
            g.drawString("Instructions", 300, 75);
        }
    }
    

}
