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
    private static boolean isMainMenu;
    private static boolean isLearningLevel;
    private static boolean isLock;
    private static boolean isMazeGame;
    private static boolean isCongrats;
    private static boolean isCongratsMenu;
    private static boolean isEscapeMap;
    private static boolean isMap;
    private static boolean isTextScreen;
    private static boolean isMeetPerson;
    private static boolean isLibraryGame;
    private static boolean isHallwayGame;
    private static boolean isTakeNotes;
    private static boolean isTalkToTeacher;
    private static boolean isKickBall;

    private static boolean isMazeIntro;
    private static boolean isEscapeIntro;
    
    private static boolean isGoodbye;    
    
   /**
     * Constructor method
     *
     * @param frame Takes JGrasp frame
     */
    public MainMenu(JFrame frame){
        this.frame = frame;
        isInstruction = false;

        // Clear the frame
        MainMenu.setIsMainMenu(true);
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        frame.revalidate();
        frame.repaint();
    }

    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            g.setColor(Colours.darkerBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Colours.backgroundBlue);
            g.fillRect(20, 20, getWidth()-40, getHeight()-40);
            g.setFont(Colours.title);
            g.setColor(Color.WHITE);
            g.drawString("Main Menu",285 ,90);
            g.setColor(Colours.darkerBlue);
            g.fillRoundRect(250, 130, 270, 50, 20, 20);
            g.fillRoundRect(250, 130+70, 270, 50, 20, 20);
            g.fillRoundRect(250, 130+70+70, 270, 50, 20, 20);
            g.fillRoundRect(250, 130+70+70+70, 270, 50, 20, 20);
            g.setColor(Color.WHITE);
            g.setFont(new Font ("Roboto", Font.PLAIN, 22));
            g.drawString("Level 1: LEARNING", 290, 163);
            g.drawString("Level 2: MAZE", 290, 163+70);
            g.drawString("Level 3: ESCAPE", 290, 163+70+70);
            g.drawString("EXIT", 355, 163+70+70+70);
            
        }
    }
    public void run(){           
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    /**
     * getIsMainMenu method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsMainMenu(){
        return isMainMenu;
    }
    
    /**
     * setIsInstruction method, function
     *
     * @param onMainMenu Sets if game is running corresponding class currently
     */
    public static void setIsMainMenu(boolean onMainMenu)
    {
        isMainMenu = onMainMenu;
    }

    /**
     * getIsMainMenu method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsLearningLevel(){
        return isLearningLevel;
    }
    
    /**
     * setIsInstruction method, function
     *
     * @param onMainMenu Sets if game is running corresponding class currently
     */
    public static void setIsLearningLevel(boolean onLearningLevel)
    {
        isLearningLevel = onLearningLevel;
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
    /**
     * getIsCongratsMenu method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsCongratsMenu(){
        return isCongratsMenu;
    }
    
    /**
     * setIsCongratesMenu method, function
     *
     * @param onCongratsMenu Sets if game is running corresponding class currently
     */
    public static void setIsCongratsMenu(boolean onCongratsMenu){
        isCongratsMenu = onCongratsMenu;
    }

    /**
     * getIsMazeIntro method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsMazeIntro(){
        return isMazeIntro;
    }
    
    /**
     * getIsMazeIntro method, function
     *
     * @param onMazeIntro Sets if game is running corresponding class currently
     */
    public static void setIsMazeIntro(boolean onMazeIntro){
        isMazeIntro = onMazeIntro;
    }

    /**
     * getIsMazeIntro method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsEscapeIntro(){
        return isEscapeIntro;
    }
    /**
     * getIsMazeIntro method, function
     *
     * @param onMazeIntro Sets if game is running corresponding class currently
     */
    public static void setIsEscapeIntro(boolean onEscapeIntro){
        isEscapeIntro = onEscapeIntro;
    }

    /**
     * getIsGoodbye method, function
     *
     * @return boolean, whether the game is running corresponding class currently
     */
    public static boolean getIsGoodbye(){
        return isGoodbye;
    }
    
    /**
     * setIsGoodbye method, function
     *
     * @param onGoodbye Sets if game is running corresponding class currently
     */
    public static void setIsGoodbye(boolean onGoodbye)
    {
        isGoodbye = onGoodbye;
    }
}