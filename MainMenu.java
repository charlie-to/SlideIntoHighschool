import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MainMenu{
    JFrame frame;
    private static boolean isInstruction;
    private static boolean isLock;

    public MainMenu(JFrame frame){
        this.frame = frame;
        isInstruction = false;

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
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("exit clicked");
                Lock l = new Lock(frame);
                l.run();
            }
        });
    }

    public static boolean getIsInstruction(){
        return isInstruction;
    }
    public static void setIsInstruction(boolean onInstruction)
    {
        isInstruction = onInstruction;
    }
    public static boolean getIsLock(){
        return isLock;
    }
    public static void setIsLock(boolean onLock){
        isLock = onLock;
    }
}