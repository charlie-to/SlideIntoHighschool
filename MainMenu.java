import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MainMenu{

/**
 * MainMenu class of Slide Into Highschool, allows user to choose what stage they do, or to exit
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 2nd, 2023
 * Time Spent: 0.5 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
 
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
    private static boolean isLibraryGame;
    private static boolean isHallwayGame;
    private static boolean isTakeNotes;
    private static boolean isTalkToTeacher;
    private static boolean isKickBall;
    
    
    
     
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public MainMenu(JFrame frame){
        this.frame = frame;
        isInstruction = false;

        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        frame.revalidate();
        frame.repaint();
    }
    
    /**
     * styleBtn method, creates button
     *
     */
    public void styleBtn(JButton btn){
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5, true));
        btn.setBackground(Colours.backgroundBlue);
        btn.setForeground(Color.BLACK);
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
        styleBtn(escape);
        styleBtn(exit);
        // menuPanel.add(instructions);
        menuPanel.add(deficiencies);
        // menuPanel.add(scores);
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
                System.exit(0);
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

   /**
     * getIsInstructions method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsInstruction(){
        return isInstruction;
    }
    
    /**
     * setIsInstruction method, function
     *
     * @param onInstruction Sets if game is running corresponding class currently
     */
    public static void setIsInstruction(boolean onInstruction)
    {
        isInstruction = onInstruction;
    }
    
    /**
     * getIsLock method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLock(){
        return isLock;
    }
    
    /**
     * setIsLock method, function
     *
     * @param onLock Sets if game is running corresponding class currently
     */
    public static void setIsLock(boolean onLock){
        isLock = onLock;
    }
    
    /**
     * getIsMazeGame method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsMazeGame(){
        return isMazeGame;
    }
    
    /**
     * setIsMazeGame method, function
     *
     * @param onMazeGame Sets if game is running corresponding class currently
     */
    public static void setIsMazeGame(boolean onMazeGame){
        isMazeGame = onMazeGame;
    }
    
    /**
     * getIsMap method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsMap(){
        return isMap;
    }
    
    /**
     * setIsMap method, function
     *
     * @param onMap Sets if game is running corresponding class currently
     */
    public static void setIsMap(boolean onMap){
        isMap = onMap;
    }   
    
    /**
     * getIsLearningText method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */ 
    public static boolean getIsLearningText(){
        return isLearningText;
    }
    
    /**
     * setIsLearningText method, function
     *
     * @param onLearningText Sets if game is running corresponding class currently
     */
    public static void setIsLearningText(boolean onLearningText){
        isLearningText = onLearningText;
    }
    
    /**
     * getIsLearningHall method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLearningHall(){
        return isLearningHall;
    }
    
    /**
     * setIsLearningHall method, function
     *
     * @param onLearningHall Sets if game is running corresponding class currently
     */
    public static void setIsLearningHall(boolean onLearningHall){
        isLearningHall = onLearningHall;
    }
    
    /**
     * getIsLearningClassroom method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLearningClassroom(){
        return isLearningClassroom;
    }
    
    /**
     * setIsLearningClassroom method, function
     *
     * @param onLearningClassroom Sets if game is running corresponding class currently
     */
    public static void setIsLearningClassroom(boolean onLearningClassroom){
        isLearningClassroom = onLearningClassroom;
    }
    
    /**
     * getIsLearningCaf method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLearningCaf(){
        return isLearningCaf;
    }
    
    /**
     * setIsLearningCaf method, function
     *
     * @param onLearningCaf Sets if game is running corresponding class currently
     */
    public static void setIsLearningCaf(boolean onLearningCaf){
        isLearningCaf = onLearningCaf;
    } 
    
    /**
     * getIsCongrats method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */   
    public static boolean getIsCongrats(){
        return isCongrats;
    }
    
    /**
     * setIsCongrats method, function
     *
     * @param onCongrats Sets if game is running corresponding class currently
     */
    public static void setIsCongrats(boolean onCongrats){
        isCongrats = onCongrats;
    }
    
    /**
     * getIsEscapeMap method, function
     *
     * @return isEscapeMap, whether the game is running corresponding class currently
     */
    public static boolean getIsEscapeMap(){
        return isEscapeMap;
    }
    
    /**
     * setIsEscapeMap method, function
     *
     * @param onEscapeMap Sets if game is running corresponding class currently
     */
    public static void setIsEscapeMap(boolean onEscapeMap){
        isEscapeMap = onEscapeMap;
    }
    
    /**
     * getIsTextScreen method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsTextScreen(){
        return isTextScreen;
    }
    
    /**
     * setIsTextScreen method, function
     *
     * @param onTextScreen Sets if game is running corresponding class currently
     */
    public static void setIsTextScreen(boolean onTextScreen){
        isTextScreen = onTextScreen;
    }
    
    /**
     * getIsMeetPerson method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsMeetPerson(){
        return isMeetPerson;
    }
    
    /**
     * setIsMeetPerson method, function
     *
     * @param onMeetPerson Sets if game is running corresponding class currently
     */
    public static void setIsMeetPerson(boolean onMeetPerson){
        isMeetPerson = onMeetPerson;
    }
    
    /**
     * getIsLibraryGame method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLibraryGame(){
        return isLibraryGame;
    }
    
    /**
     * setIsLibraryGame method, function
     *
     * @param onLibraryGame Sets if game is running corresponding class currently
     */
    public static void setIsLibraryGame(boolean onLibraryGame){
        isLibraryGame = onLibraryGame;
    }
    
    /**
     * getIsHallwayGame method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsHallwayGame(){
        return isHallwayGame;
    }
    
    /**
     * setIsHallwayGame method, function
     *
     * @param onHallwayGame Sets if game is running corresponding class currently
     */
    public static void setIsHallwayGame(boolean onHallwayGame){
        isHallwayGame = onHallwayGame;
    }
    
    /**
     * getIsTakeNotes method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsTakeNotes(){
        return isTakeNotes;
    }
    
    /**
     * setIsTakeNotes method, function
     *
     * @param onTakeNotes Sets if game is running corresponding class currently
     */
    public static void setIsTakeNotes(boolean onTakeNotes){
        isTakeNotes = onTakeNotes;
    }
    
    /**
     * getIsTalkToTeacher method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsTalkToTeacher(){
        return isTalkToTeacher;
    }
    
    /**
     * setIsTalkToTeacher method, function
     *
     * @param onTalkToTeacher Sets if game is running corresponding class currently
     */
    public static void setIsTalkToTeacher(boolean onTalkToTeacher){
        isTalkToTeacher = onTalkToTeacher;
    }
    
    /**
     * getIsKickBall method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsKickBall(){
        return isKickBall;
    }
    
    /**
     * setIsKickBall method, function
     *
     * @param onKickBall Sets if game is running corresponding class currently
     */
    public static void setIsKickBall(boolean onKickBall){
        isKickBall = onKickBall;
    }
}