import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MainMenu{
    JFrame frame;
    private static boolean isInstruction;
    private static boolean isLock;
    private static boolean isMazeGame;
    private static boolean isLearningHall;
    private static boolean isLearningClassroom;
    private static boolean isLearningCaf;
    private static boolean isLearningText;
    private static boolean isCongrats;
    private static boolean isEscapeMap;
    private static boolean isMap;
    private static boolean isTextScreen;
    private static boolean isMeetPerson;

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
        JButton deficiencies = new JButton("Deficiencies (1)");
        JButton scores = new JButton("Scores");
        JButton exit = new JButton("Exit");
        JButton maze = new JButton("Maze (2)");
        JButton escape = new JButton("Escape (3)");
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
        deficiencies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("deficiencies clicked");
                LearningHall h = new LearningHall(frame);
                h.run();
            }
        });
        maze.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("maze clicked");
                ClassMaze c = new ClassMaze(frame);
                c.run();
            }
        });
        escape.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("escape clicked");
                EscapeMap m = new EscapeMap(frame);
                m.run();
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
    public static boolean getIsMazeGame(){
        return isMazeGame;
    }
    public static void setIsMazeGame(boolean onMazeGame){
        isMazeGame = onMazeGame;
    }
    public static boolean getIsMap(){
        return isMap;
    }
    public static void setIsMap(boolean onMap){
        isMap = onMap;
    }    
    public static boolean getIsLearningText(){
        return isLearningText;
    }
    public static void setIsLearningText(boolean onLearningText){
        isLearningText = onLearningText;
    }
    public static boolean getIsLearningHall(){
        return isLearningHall;
    }
    public static void setIsLearningHall(boolean onLearningHall){
        isLearningHall = onLearningHall;
    }
    public static boolean getIsLearningClassroom(){
        return isLearningClassroom;
    }
    public static void setIsLearningClassroom(boolean onLearningClassroom){
        isLearningClassroom = onLearningClassroom;
    }
    public static boolean getIsLearningCaf(){
        return isLearningCaf;
    }
    public static void setIsLearningCaf(boolean onLearningCaf){
        isLearningCaf = onLearningCaf;
    }    
    public static boolean getIsCongrats(){
        return isCongrats;
    }
    public static void setIsCongrats(boolean onCongrats){
        isCongrats = onCongrats;
    }
    public static boolean getIsEscapeMap(){
        return isEscapeMap;
    }
    public static void setIsEscapeMap(boolean onEscapeMap){
        isEscapeMap = onEscapeMap;
    }
    public static boolean getIsTextScreen(){
        return isTextScreen;
    }
    public static void setIsTextScreen(boolean onTextScreen){
        isTextScreen = onTextScreen;
    }
    public static boolean getIsMeetPerson(){
        return isMeetPerson;
    }
    public static void setIsMeetPerson(boolean onMeetPerson){
        isMeetPerson = onMeetPerson;
    }

}