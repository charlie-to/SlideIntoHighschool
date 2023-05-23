import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MainMenu{
    JFrame frame;
    public MainMenu(JFrame frame){
        this.frame = frame;

        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        frame.revalidate();
        frame.repaint();
    }
    public void styleBtn(JButton btn){
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
        btn.setBackground(Colours.backgroundBlue);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font(btn.getFont().getName(), Font.PLAIN, 18));
        btn.setFocusPainted(false);
    }
    public void run(){
        frame.setLayout(new BorderLayout());
        
        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 20, 20), false);
        JButton instructions = new JButton("Instructions");
        JButton deficiencies = new JButton("Deficiencies");
        JButton scores = new JButton("Scores");
        JButton exit = new JButton("Exit");
        JButton maze = new JButton("Maze");
        JButton escape = new JButton("Escape");
        menuPanel.setBorder(new EmptyBorder(120, 170, 100, 170));
        styleBtn(instructions);
        styleBtn(deficiencies);
        styleBtn(scores);
        styleBtn(maze);
        styleBtn(exit);
        styleBtn(escape);
        menuPanel.add(instructions);
        menuPanel.add(deficiencies);
        menuPanel.add(scores);
        menuPanel.add(maze);
        menuPanel.add(exit);
        menuPanel.add(escape);

        menuPanel.setBackground(Colours.backgroundBlue);        
        frame.add(menuPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        instructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("instructions clicked");
                Instructions i = new Instructions(frame);
                i.run();
            }
        });
    }
}