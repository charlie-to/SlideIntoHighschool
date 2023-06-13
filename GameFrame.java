import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 * GameFrame class of Slide Into Highschool, resets variables, takes input, and controls flow of game
 *
 * <h2>Course Info:</h2>
 * ICS4UP with Krasteva, V.
 * Date: June 5st, 2023
 * Time Spent: 10 hrs
 * @version 1
 * @author Charlie To, Milena Mofrad
 */
public class GameFrame extends JFrame implements KeyListener, MouseListener {

 
    /**
     * Constructor method
     *
     * @param title Sets title for frame
     */
    public GameFrame(String title) {
        super(title);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

     /**
     * resetMinigameVars method, resets all variables for minigames
     *
     */
    public static void resetMinigameVars() {
        // LOCK GAME
        Lock.degrees = 0;
        Lock.turns = new ArrayList<String>();
        Lock.curNum = 0;
        // MainMenu.setIsLock(false);
        // MAZE GAME
        // ClassMaze.curCharX = 634;
        // ClassMaze.curCharY = 144;
        // ClassMaze.curX = ClassMaze.startX;
        // ClassMaze.curY = ClassMaze.startY;
        // MEET THE PERSON
        // MeetThePerson.x = 0;
        // MeetThePerson.y = 0;
        // MeetThePerson.xPos = 0;
        // MeetThePerson.yPos = 0;
        // MeetThePerson.score = 0;
        // MeetThePerson.stage = 1;
        // MeetThePerson.hover1 = false;
        // MeetThePerson.hover2 = false;
        // MeetThePerson.isComplete = false;
        // MAP GAME
        Map.x = 0;
        Map.y = 0;
        Map.xPos = 0;
        Map.yPos = 0;
        Map.stage = 1;
        Map.selected = 0;
        Map.found = new boolean[] { false, false, false, false };
        Map.win = false;
        // HALLWAY GAME
        HallwayGame.items = new ArrayList<String>(4);
        // TAKE NOES
        TakeNotes.x = 0;
        TakeNotes.y = 0;
        TakeNotes.xPos = 0;
        TakeNotes.yPos = 0;
        TakeNotes.stage = 1;
        TakeNotes.score = 0;
        TakeNotes.isComplete = false;
        TakeNotes.win = false;
        // TALK TO TEACHER
        TalkToTeacher.x = 0;
        TalkToTeacher.y = 0;
        TalkToTeacher.xPos = 0;
        TalkToTeacher.yPos = 0;
        TalkToTeacher.stage = 1;
        TalkToTeacher.score = 0;
        TalkToTeacher.hover1 = false;
        TalkToTeacher.hover2 = false;
        TalkToTeacher.isComplete = false;
        // LIBRARY GAME
        LibraryGame.x = 0;
        LibraryGame.y = 0;
        LibraryGame.xPos = 0;
        LibraryGame.yPos = 0;
        LibraryGame.stage = 1;
        LibraryGame.score = 0;
        LibraryGame.x1 = 0;
        LibraryGame.x2 = 0;
        LibraryGame.y1 = 0;
        LibraryGame.y2 = 0;
        LibraryGame.books = new boolean[6];
        LibraryGame.isComplete = false;
        // MEET THE PERSON
        MeetThePerson.x=0;
        MeetThePerson.y = 0;
        MeetThePerson.xPos = 0;
        MeetThePerson.yPos =0;
        MeetThePerson.score = 0;
        MeetThePerson.stage =1;
        MeetThePerson.hover1 = false;
        MeetThePerson.hover2 = false;
        MeetThePerson.isComplete = false;
    }

   /**
     * resetLevelVars method, resets all variables for levels
     *
     */
    public static void resetLevelVars() {
        // ESCAPE MAP
        EscapeMap.text = "Exit";
        EscapeMap.isHallComplete = false;
        EscapeMap.isTakeNotesComplete = false;
        EscapeMap.isTalkToTeacherComplete = false;
        EscapeMap.isKickBallComplete = false;
        EscapeMap.isLibraryGameComplete = false;

        //MAZE
        ClassMaze.curX = ClassMaze.startX;
        ClassMaze.curY = ClassMaze.startY;
        ClassMaze.curCharX = 634;
        ClassMaze.curCharY = 144;
    }

   /**
     * keyTyped method, takes key input
     *
     * @param e Takes key input
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (MainMenu.getIsGoodbye()){
            System.exit(0);
        }
        if (MainMenu.getIsCongratsMenu()){
            MainMenu.setIsCongratsMenu(false);
            MainMenu.setIsLearningLevel(false);
            MainMenu m = new MainMenu(this);
            m.run();
        }
        if(MainMenu.getIsMazeIntro()){
            MainMenu.setIsMazeIntro(false);
            ClassMaze c = new ClassMaze(this);
            c.run();
        }
        if(MainMenu.getIsEscapeIntro()){
            MainMenu.setIsEscapeIntro(false);
            EscapeMap c = new EscapeMap(this);
            c.run();
        }
        if (Congrats.cur.equals("MeetThePerson")){
            resetMinigameVars();
            MainMenu.setIsCongrats(false);
            MainMenu.setIsMeetPerson(false);
            Congrats.cur = "";
            ClassMaze.move("left");
            ClassMaze m = new ClassMaze(this);
            m.run();
        }
        if (MainMenu.getIsCongrats() && EscapeMap.isHallComplete && EscapeMap.isTakeNotesComplete
                && EscapeMap.isTalkToTeacherComplete && EscapeMap.isKickBallComplete
                && EscapeMap.isLibraryGameComplete) {
            MainMenu.setIsTextScreen(false);
            resetLevelVars();
            MainMenu m = new MainMenu(this);
            m.run();
        } else if (EscapeMap.isHallComplete && EscapeMap.isTakeNotesComplete && EscapeMap.isTalkToTeacherComplete
                && EscapeMap.isKickBallComplete && EscapeMap.isLibraryGameComplete) {
            MainMenu.setIsEscapeMap(false);
            Congrats c = new Congrats(this, "You have completed the escape level", "Press any key to go to main menu");
            c.run();
        }
        // CONGRATS SCREEN
        else if (MainMenu.getIsCongrats()) {
            MainMenu.setIsCongrats(false);
            MainMenu m = new MainMenu(this);
            m.run();
        }
        // // INSTRUCTIONS
        // if (e.getKeyChar() == 'e' && MainMenu.getIsInstruction() && !MainMenu.getIsCongrats()) {
        //     resetMinigameVars();
        //     MainMenu ex = new MainMenu(this);
        //     ex.run();
        // }
        // LOCK GAME
        if (e.getKeyChar() == 'w' && MainMenu.getIsLock()&&!Lock.checkWinner()) {
            if (Lock.degrees == 360)
                Lock.degrees = 45;
            else
                Lock.degrees += 45;
            Lock.turns.add("up");
            Lock l = new Lock(this);
            l.run();
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsLock() && !Lock.checkWinner()) {
            if (Lock.degrees == 0)
                Lock.degrees = 315;
            else
                Lock.degrees -= 45;
            Lock.turns.add("down");
            Lock l = new Lock(this);
            l.run();
        }
        // MAZE
        if (e.getKeyChar() == 'w' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsCongrats()&& !MainMenu.getIsLock()
                && !MainMenu.getIsMap()&&!MainMenu.getIsMeetPerson()) {

            resetMinigameVars();
            ClassMaze.move("up");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen()&& !MainMenu.getIsCongrats() && !MainMenu.getIsLock()
                && !MainMenu.getIsMap()&&!MainMenu.getIsMeetPerson()) {
            resetMinigameVars();
            ClassMaze.move("down");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'a' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsCongrats()&& !MainMenu.getIsLock()
                && !MainMenu.getIsMap()&& !MainMenu.getIsMeetPerson()) {
            resetMinigameVars();
            ClassMaze.move("left");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'd' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsCongrats()&& !MainMenu.getIsLock()
                && !MainMenu.getIsMap()&&!MainMenu.getIsMeetPerson()) {
            resetMinigameVars();
            ClassMaze.move("right");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        
        if (ClassMaze.checkWinner() && MainMenu.getIsMazeGame()) {
            // MainMenu.setIsMazeGame(false);
            resetMinigameVars();
            Congrats c = new Congrats(this, "You have completed the Maze Level!", "Press any key to go to main menu");
            c.run();
        }
        if (MainMenu.getIsLock() && MainMenu.getIsMazeGame()) { // Run lock game and check if complete
            
            if (Lock.checkWinner()) {
                // MainMenu.setIsLock(false);
                Congrats c = new Congrats(this, "Yay! Lock Level has been completed.");
                c.run();
                if (e.getKeyChar() == ' ') {
                    MainMenu.setIsLock(false);
                    ClassMaze m = new ClassMaze(this);
                    try{
                        Robot r = new Robot();
                        r.keyPress(KeyEvent.VK_W);
                        r.keyRelease(KeyEvent.VK_W);
                    }catch (Exception d){System.out.println("robot problem");}
                    m.run();

                }
            }
            else{
                Lock l = new Lock(this);
                l.run();
            }
        } else if (ClassMaze.checkLockGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsLock()) {
                MainMenu.setIsTextScreen(false);
                Lock l = new Lock(this);
                l.run();
            } else {
                TextScreen.cur = "lock";
                TextScreen t = new TextScreen(this, "Obstacle #1: Unlock The Lock");
                t.run();
            }
        }

        if (MainMenu.getIsMap() && MainMenu.getIsMazeGame()) { // Run lock game and check if complete
            Map l = new Map(this);
            l.run();
            if (Map.checkWin()) {
                Congrats c = new Congrats(this, "Yay! Map Level has been completed.");
                c.run();
                if (e.getKeyChar() == ' ') {
                    MainMenu.setIsMap(false);
                    ClassMaze m = new ClassMaze(this);
                    m.run();
                    try {
                        Robot robot = new Robot();
                        // Simulate a key press
                        robot.keyPress(KeyEvent.VK_S);

                    } catch (AWTException f) {
                        f.printStackTrace();
                    }
                }
            }
        } else if (ClassMaze.checkMapGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsMap()) {
                MainMenu.setIsTextScreen(false);
                Map l = new Map(this);
                l.run();
            } else {
                TextScreen.cur = "map";
                TextScreen t = new TextScreen(this, "Obstacle #2: Map the school");
                t.run();
            }
        }
        else if (ClassMaze.checkMeetGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsMeetPerson()) {
                MainMenu.setIsTextScreen(false);
                MeetThePerson p = new MeetThePerson(this);
                p.run();
            } else {
                TextScreen.cur = "MeetThePerson";
                TextScreen t = new TextScreen(this, "Obstacle #3: Meet the Person");
                t.run();
            }
        }

        // ESCAPE MAP
        if (MainMenu.getIsEscapeMap() && !MainMenu.getIsHallwayGame() && !MainMenu.getIsKickBall()
                && !MainMenu.getIsTalkToTeacher() && !MainMenu.getIsTakeNotes() && !MainMenu.getIsLibraryGame()) {
            int moveAmt = 5;
            if (e.getKeyChar() == 's' && MainMenu.getIsEscapeMap()) {
                if (EscapeMap.xPos > 310 && EscapeMap.yPos < 355){
                EscapeMap.yPos += moveAmt;
                EscapeMap m = new EscapeMap(this);
                m.run();
                }
                if (EscapeMap.xPos < 310 && EscapeMap.yPos < 270){
                EscapeMap.yPos += moveAmt;
                EscapeMap m = new EscapeMap(this);
                m.run();
                }
            }
            if (e.getKeyChar() == 'w' && MainMenu.getIsEscapeMap() && EscapeMap.yPos > 60) {
                EscapeMap.yPos -= moveAmt;
                EscapeMap m = new EscapeMap(this);
                m.run();
            }
            if (e.getKeyChar() == 'a' && MainMenu.getIsEscapeMap()) {
                if (EscapeMap.yPos < 280 && EscapeMap.xPos > 93){
                    EscapeMap.xPos -= moveAmt;
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                }
                if (EscapeMap.yPos >280 && EscapeMap.xPos > 327){
                    EscapeMap.xPos -= moveAmt;
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                }
            }
            if (e.getKeyChar() == 'd' && MainMenu.getIsEscapeMap() && EscapeMap.xPos <= 650) {
                EscapeMap.xPos += moveAmt;
                EscapeMap m = new EscapeMap(this);
                m.run();
            }
        }
        // ESCAPE MAP IN LIBRARY
        if (MainMenu.getIsEscapeMap()
                && (EscapeMap.xPos > 511 && EscapeMap.xPos < 700 && !EscapeMap.isLibraryGameComplete)
                && (EscapeMap.yPos > 250 && EscapeMap.yPos < 413)) {
            EscapeMap.text = "Library Game";
        } else if (MainMenu.getIsEscapeMap() && (EscapeMap.xPos > 328 && EscapeMap.xPos < 510)
                && (EscapeMap.yPos > 201 && EscapeMap.yPos < 454) && !EscapeMap.isKickBallComplete) {
            EscapeMap.text = "Gym Game";
        } else if (MainMenu.getIsEscapeMap() && (EscapeMap.xPos > 126 && EscapeMap.xPos < 507)
                && (EscapeMap.yPos > 100 && EscapeMap.yPos < 200) && !EscapeMap.isHallComplete) {
            EscapeMap.text = "Hallway Game";
        } else if (MainMenu.getIsEscapeMap() && (EscapeMap.xPos > 314 && EscapeMap.xPos < 390)
                && (EscapeMap.yPos > 50 && EscapeMap.yPos < 186) && !EscapeMap.isTakeNotesComplete) {
            EscapeMap.text = "Take Notes Game";
        } else if (MainMenu.getIsEscapeMap() && (EscapeMap.xPos > 228 && EscapeMap.xPos < 290)
                && (EscapeMap.yPos > 200 && EscapeMap.yPos < 300) && !EscapeMap.isTalkToTeacherComplete) {
            EscapeMap.text = "Talk to Teacher Game";
        } else {
            EscapeMap.text = "Exit";
        }

        // HALLWAY GAME
        if (!HallwayGame.checkWin() && HallwayGame.items.size() == 4 && MainMenu.getIsHallwayGame()) {
            resetMinigameVars();
            HallwayGame h = new HallwayGame(this);
            h.run();
        }
    }

   /**
     * keyPressed method, takes key input
     *
     * @param e Function
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (ClassMaze.checkWinner() && MainMenu.getIsCongrats()) {
            MainMenu.setIsMazeGame(false);
            resetMinigameVars();
            resetLevelVars();
            MainMenu m = new MainMenu(this);
            m.run();
        }
        
    }

   /**
     * keyReleased method, takes key input
     *
     * @param e Takes key input
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

     
     /**
     * keyReleased method, takes key input
     *
     * @param e Takes key input
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, e.getComponent());
        double x = p.getX();
        double y = p.getY();
        // MAIN MENU
        if (MainMenu.getIsMainMenu()){
            MainMenu.setIsMainMenu(false);
            if ((x > 260 && x < 527) && (y > 160 && y < 200)){
                MainMenu.setIsMainMenu(false);
                LearningLevel h = new LearningLevel(this);
                h.run();
            }
            if ((x > 260 && x < 527) && (y > 230 && y < 280)){
                MainMenu.setIsMainMenu(false);
                MazeIntro l = new MazeIntro(this);
                l.run();
                // ClassMaze c = new ClassMaze(this);
                // c.run();
            }
            if ((x > 260 && x < 527) && (y > 300 && y < 350)){
                MainMenu.setIsMainMenu(false);
                EscapeIntro c = new EscapeIntro(this);
                c.run();
                // EscapeMap c = new EscapeMap(this);
                // c.run();
            }
            if ((x > 260 && x < 527) && (y > 370 && y < 420)){
                Goodbye g = new Goodbye(this);
                g.run();
            }
        }
        // LEARNING LEVELS
        if (MainMenu.getIsLearningLevel()){
            if (LearningLevel.cur == 1){
                if ((x > 170 && x < 215) && (y > 250 && y < 300)){
                    LearningLevel.text = "This is a lock.";
                    LearningLevel.text2 = "You use it to lock your locker and ensure your items are safe.";
                }
                else if ((x > 320 && x < 465) && (y > 61 && y < 100)){
                    LearningLevel.text = "This is a schedule.";
                    LearningLevel.text2 = "It tells you where all of your classes are, and who your teachers are.";
                }
                else if ((x > 315 && x < 405) && (y > 212 && y < 349)){
                    LearningLevel.text = "This is a student. This could be your classmate. ";
                    LearningLevel.text2 = "Become friends with a variety of people by being nice";
                }
                else if ((x > 458 && x < 564) && (y > 160 && y < 393)){
                    LearningLevel.text = "This is a locker. You can store all your belongings here";
                    LearningLevel.text2 = "grab things from it between classes";
                }
                else if ((x > 615 && x < 708) && (y > 130 && y < 214)){
                    LearningLevel.text = "This is a room number.";
                    LearningLevel.text2 = "Your schedule will tell you which room you should be in.";
                }
                
            }
            if (LearningLevel.cur == 2){
                if ((x > 51 && x < 169) && (y > 130 && y < 223)){
                    LearningLevel.text = "This is a teacher.";
                    LearningLevel.text2 = "Be polite and respectful towards the teachers, and follow their rules";
                }
                if ((x > 315 && x < 435) && (y > 73 && y < 213)){
                    LearningLevel.text = "This is a rule list.";
                    LearningLevel.text2 = "These are your teachers expectations for you. Follow the rules.";
                }
                if ((x > 277 && x < 373) && (y > 269 && y < 299)){
                    LearningLevel.text = "This is a notebook.";
                    LearningLevel.text2 = "You should use it to take notes for each class to help you memorize material.";
                }
                if ((x > 512 && x < 630) && (y > 285 && y < 399)){
                    LearningLevel.text = "This is a desk. You will sit here, during each class.";
                    LearningLevel.text2 = "Choose wisely, where you sit can determine how much you concentrate.";
                }
                if ((x > 643 && x < 723) && (y > 195 && y < 323)){
                    LearningLevel.text = "This is a student. This student is your classmate";
                    LearningLevel.text2 = " Befriend them so you can help each other in the class";
                }
            }
            if (LearningLevel.cur == 3){
                if ((x > 263 && x < 476) && (y > 71 && y < 173)){
                    LearningLevel.text = "This is where you sign up for clubs.";
                    LearningLevel.text2 = "You should try joining 1-2 clubs, it can help you make friends.";
                }
                if ((x > 13 && x < 175) && (y > 279 && y < 406)){
                    LearningLevel.text = "This is a table.";
                    LearningLevel.text2 = "You can sit at a table with your friends, or you can sit outside.";
                }
                if ((x > 263 && x < 357) && (y > 230 && y < 406)){
                    LearningLevel.text = "This is a friend";
                    LearningLevel.text2 = "You should try to make at least a couple of friends in high school.";
                }
                if ((x > 659 && x < 786) && (y > 145 && y < 411)){
                    LearningLevel.text = "This is where you buy food.";
                    LearningLevel.text2 = "You should try buying nutritional food so you can focus better in your classes.";
                }
            }
            if ((x > 573 && x < 752) && (y > 62 && y < 99)){
                LearningLevel.cur += 1;
                LearningLevel.text = "Click the circled items to learn about them.";
                LearningLevel.text2 = "Click the green button after you've learnt about all the items in the room";
            }

            if (LearningLevel.cur == 4){
                LearningLevel.resetVars();
                MainMenu.setIsLearningLevel(false);
                CongratsMenu c = new CongratsMenu(this,"You have finished the learning level!", "Press any key to go to back to main menu");
                c.run();
            }
            else if ((x > 38 && x < 148) && (y > 63 && y < 99)){
                LearningLevel.resetVars();
                MainMenu.setIsLearningLevel(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
            else{
                LearningLevel l = new LearningLevel(this);
                l.run();
            }
        }
        
        // MAZE MAP
        if (MainMenu.getIsMap()) {
            x = p.getX();
            y = p.getY() - 25;
            if (Map.stage == 1) {
                if (x > 650 && x < 700 && y > 100 && y < 200) {
                    Map.stage = 2;
                }
            } else {
                if (x > 650 && x < 700 && y > 100 && y < 150) {
                    Map.selected = 1;
                } else if (x > 650 && x < 700 && y > 180 && y < 230) {
                    Map.selected = 2;
                } else if (x > 650 && x < 700 && y > 260 && y < 310) {
                    Map.selected = 3;
                } else if (x > 650 && x < 700 && y > 340 && y < 390) {
                    Map.selected = 4;
                } else if (x > 110 && x < 190 && y > 110 && y < 190) {
                    if (Map.selected == 1)
                        Map.found[0] = true;
                } else if (x > 410 && x < 490 && y > 110 && y < 190) {
                    if (Map.selected == 2)
                        Map.found[1] = true;
                } else if (x > 310 && x < 390 && y > 310 && y < 390) {
                    if (Map.selected == 3)
                        Map.found[2] = true;
                } else if (x > 210 && x < 390 && y > 110 && y < 190) {
                    if (Map.selected == 4)
                        Map.found[3] = true;
                }
            }
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_S);
            } catch (Exception d) {
                System.out.println("robot error");
            }
            // Map l = new Map(this);
            // l.run();
        }

        // ESCAPE MAP
        if (MainMenu.getIsEscapeMap()) {
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isHallComplete
                    && EscapeMap.text.equals("Hallway Game")) {
                HallwayGame h = new HallwayGame(this);
                h.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isTakeNotesComplete
                    && EscapeMap.text.equals("Take Notes Game")) {
                TakeNotes n = new TakeNotes(this);
                n.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isTalkToTeacherComplete
                    && EscapeMap.text.equals("Talk to Teacher Game")) {
                TalkToTeacher n = new TalkToTeacher(this);
                n.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isKickBallComplete
                    && EscapeMap.text.equals("Gym Game")) {
                KickBall k = new KickBall(this);
                k.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isLibraryGameComplete
                    && EscapeMap.text.equals("Library Game")) {
                LibraryGame l = new LibraryGame(this);
                l.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && EscapeMap.text.equals("Exit")) {
                resetMinigameVars();
                resetLevelVars();
                MainMenu.setIsEscapeMap(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }

        // HALLWAY GAME
        x = p.getX();
        y = p.getY();
        if (MainMenu.getIsHallwayGame()) {
            if ((x > 56 && x < 155) && (y > 128 && y < 234) && !HallwayGame.items.contains("dog")) {
                HallwayGame.items.add("dog");
            }
            if ((x > 199 && x < 268) && (y > 127 && y < 237) && !HallwayGame.items.contains("notebook")) {
                HallwayGame.items.add("notebook");
            }
            if ((x > 313 && x < 367) && (y > 132 && y < 219) && !HallwayGame.items.contains("headphones")) {
                HallwayGame.items.add("headphones");
            }
            if ((x > 413 && x < 493) && (y > 148 && y < 214) && !HallwayGame.items.contains("textbooks")) {
                HallwayGame.items.add("textbooks");
            }
            if ((x > 545 && x < 646) && (y > 151 && y < 218) && !HallwayGame.items.contains("pencilCase")) {
                HallwayGame.items.add("pencilCase");
            }
            if ((x > 325 && x < 417) && (y > 262 && y < 329) && !HallwayGame.items.contains("videoGame")) {
                HallwayGame.items.add("videoGame");
            }
            if ((x > 502 && x < 543) && (y > 247 && y < 326) && !HallwayGame.items.contains("water")) {
                HallwayGame.items.add("water");
            }
            if (HallwayGame.checkWin() && HallwayGame.items.size() == 4) {
                MainMenu.setIsHallwayGame(false);
                EscapeMap.isHallComplete = true;
                EscapeMap m = new EscapeMap(this);
                m.run();
            } else {
                // System.out.println(HallwayGame.items);
                HallwayGame h = new HallwayGame(this);
                h.run();
            }
        }
    }

   /**
     * mousePressed method, takes mouse input
     *
     * @param e Takes mouse input
     */
    @Override
    public void mousePressed(MouseEvent e) {

        // Point q = MouseInfo.getPointerInfo().getLocation();
        // SwingUtilities.convertPointFromScreen(q, e.getComponent());
        // double xx = q.getX();
        // double yy = q.getY();
        // System.out.println("X: " + xx + "   Y: "+ yy);
        if (MainMenu.getIsMeetPerson()) {
            MainMenu.setIsMainMenu(false);
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;
            if (x > 350 && x < 500 && y > 350 && y < 425) {
                if (MeetThePerson.stage == 1 || MeetThePerson.stage == 2) {
                    MeetThePerson.score++;
                }
                MeetThePerson.stage++;
                MeetThePerson.hover1 = true;
            } else {
                MeetThePerson.hover1 = false;
            }

            if (x > 550 && x < 700 && y > 350 && y < 425) {
                // System.out.println("2 clicked");
                if (MeetThePerson.stage == 3) {
                    MeetThePerson.score++;
                    MainMenu.setIsMeetPerson(false);
                    MeetThePerson.isComplete = true;
                }
                MeetThePerson.stage++;
                MeetThePerson.hover2 = true;
            } else {
                MeetThePerson.hover2 = false;
            }
            if (MeetThePerson.stage == 4) {
                if (MeetThePerson.score == 3) {
                    // MainMenu.setIsMeetPerson(false);
                    MeetThePerson.isComplete = true;
                    Congrats.cur= "MeetThePerson";
                    Congrats c = new Congrats(this, "you have completed the meet the person game", "Press any key to continue");
                    c.run();
                }
                else if (MeetThePerson.score < 3) {
                    resetMinigameVars();
                    // System.out.println("hi");
                    TextScreen.cur = "Try again";
                    TextScreen t = new TextScreen(this, "Try again");
                    t.run();
                }
            }
            else{
                MeetThePerson d = new MeetThePerson(this);
                d.run();
            }
        }
        // TALK TO TEACHER GAME
        if (MainMenu.getIsTalkToTeacher()) {
            MainMenu.setIsEscapeMap(false);
            if (TalkToTeacher.isComplete) {
                if (TalkToTeacher.score == 3) {
                    EscapeMap.isTalkToTeacherComplete = true;
                    MainMenu.setIsTalkToTeacher(false);
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                } else {
                    resetMinigameVars();
                    TalkToTeacher t = new TalkToTeacher(this);
                    t.run();
                }
            }
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;
            if (x > 350 && x < 500 && y > 350 && y < 425) {
                TalkToTeacher.hover1 = true;
                if (TalkToTeacher.stage == 1) {
                    TalkToTeacher.score++;
                }
                TalkToTeacher.stage++;
            } else {
                TalkToTeacher.hover1 = false;
                // TalkToTeacher.stage ++;
            }

            if (x > 550 && x < 700 && y > 350 && y < 425) {
                TalkToTeacher.hover2 = true;
                if (TalkToTeacher.stage == 2 || TalkToTeacher.stage == 3) {
                    TalkToTeacher.score++;
                }
                TalkToTeacher.stage++;
            } else {
                TalkToTeacher.hover2 = false;
            }
            if (TalkToTeacher.stage == 5 && TalkToTeacher.score == 3) {
                TalkToTeacher.isComplete = true;
                EscapeMap.isTalkToTeacherComplete = true;
                MainMenu.setIsTalkToTeacher(false);
                EscapeMap m = new EscapeMap(this);
                m.run();
            }
            if (TalkToTeacher.stage == 5 && TalkToTeacher.score < 3) {
                resetMinigameVars();
                TalkToTeacher t = new TalkToTeacher(this);
                t.run();
            }
            if (MainMenu.getIsTalkToTeacher()) {
                TalkToTeacher t = new TalkToTeacher(this);
                t.run();
            }
        }
    }

   /**
     * mouseReleased method, takes mouse input
     *
     * @param e Takes mouse input
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // // DELETE
        if (MainMenu.getIsEscapeMap()) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY();
            // System.out.println("X: " + x + "        Y: " + y);
        }

        // TAKE NOTES
        if (MainMenu.getIsTakeNotes()) {
            MainMenu.setIsEscapeMap(false);

            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;

            if (MainMenu.getIsTakeNotes()) {
                // System.out.println("123");
                TakeNotes m = new TakeNotes(this);
                m.run();
            }
            if (TakeNotes.stage == 1 || TakeNotes.stage == 5) {
                if (x > 300 && x < 500 && y > 420 && y < 480) {
                    TakeNotes.stage++;
                }

            } else if (x > 100 && x < 700 && y > 100 && y < 200) {
                TakeNotes.stage++;
                TakeNotes.score++;
            } else if (x > 100 && x < 700 && y > 300 && y < 400) {
                TakeNotes.stage++;
            }
            if (TakeNotes.stage == 6) {
                // System.out.println("Take notes complete");
                MainMenu.setIsTakeNotes(false);
                if (TakeNotes.win) {
                    EscapeMap.isTakeNotesComplete = true;
                    MainMenu.setIsTakeNotes(false);
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                } else {
                    MainMenu.setIsTakeNotes(false);
                    resetMinigameVars();
                    TakeNotes n = new TakeNotes(this);
                    n.run();
                }
            }
        }

        // KICK BALL
        if (MainMenu.getIsKickBall()) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;

            if (KickBall.stage == 1) {
                if (x > 100 && x < 700 && y > 200 && y < 400) {
                    KickBall.score++;
                    KickBall.stage++;
                }

            } else if (KickBall.stage == 2) {
                if (x > 200 && x < 600 && y > 250 && y < 400) {
                    KickBall.score++;
                    KickBall.stage++;
                }

            } else if (KickBall.stage == 3) {
                if (x > 300 && x < 500 && y > 300 && y < 400) {
                    KickBall.score++;
                    KickBall.stage++;
                }

            } else if (KickBall.stage == 4) {
                EscapeMap.isKickBallComplete = true;
                MainMenu.setIsKickBall(false);
                EscapeMap m = new EscapeMap(this);
                m.run();
            } else if (x > 300 && x < 500 && y > 420 && y < 480) {
                KickBall.stage++;

            }
            if (MainMenu.getIsKickBall()) {
                KickBall m = new KickBall(this);
                m.run();
            }
        }

        // LIBRARY GAME
        if (MainMenu.getIsLibraryGame()) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;

            if (x > LibraryGame.x1 && x < LibraryGame.x2 && y > LibraryGame.y1 && y < LibraryGame.y2) {
                LibraryGame.score++;
                LibraryGame.stage++;
            }
            if (LibraryGame.stage == 7) {
                if (x > 300 && x < 500 && y > 300 && y < 400) {
                    LibraryGame.stage++;
                }
            }
            if (LibraryGame.isComplete) {
                EscapeMap.isLibraryGameComplete = true;
                MainMenu.setIsLibraryGame(false);
                EscapeMap l = new EscapeMap(this);
                l.run();
                // System.out.println("dfskhaf");
            } else {
                LibraryGame m = new LibraryGame(this);
                m.run();
            }
        }

    }
   
   /**
     * mouseEntered method, takes mouse input
     *
     * @param e Takes mouse input
     */
     
     
    @Override
    public void mouseEntered(MouseEvent e) {
    }

   /**
     * mouseEntered method, takes mouse input
     *
     * @param e Takes mouse input
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
}