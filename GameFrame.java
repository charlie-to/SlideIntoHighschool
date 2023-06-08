import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameFrame extends JFrame implements KeyListener, MouseListener {
    public GameFrame(String title) {
        super(title);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    public static void resetVars() {
        // LOCK GAME
        Lock.degrees = 0;
        Lock.turns = new ArrayList<String>();
        Lock.curNum = 0;
        MainMenu.setIsLock(false);
        // MAZE GAME
        ClassMaze.curCharX = 634;
        ClassMaze.curCharY = 144;
        ClassMaze.curX = ClassMaze.startX;
        ClassMaze.curY = ClassMaze.startY;
        // ESCAPE MAZE
        // EscapeMap.text = "Exit";
        // EscapeMap.isHallComplete = false;
        //HALLWAY GAME
        HallwayGame.items = new ArrayList<String>(4);
        // TAKE NOES
        TakeNotes.x=0;
        TakeNotes.y = 0;
        TakeNotes.xPos = 0;
        TakeNotes.yPos =0;
        TakeNotes.stage =1;
        TakeNotes.score =0;
        TakeNotes.isComplete = false;
        TakeNotes.win = false;
        // TALK TO TEACHER
        TalkToTeacher.x=0;
        TalkToTeacher.y = 0;
        TalkToTeacher.xPos = 0;
        TalkToTeacher.yPos =0;
        TalkToTeacher.stage =1;
        TalkToTeacher.score = 0;
        TalkToTeacher.hover1 = false;
        TalkToTeacher.hover2 = false;
        TalkToTeacher.isComplete = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // CONGRATS SCREEN
        if (MainMenu.getIsCongrats()) {
            MainMenu.setIsCongrats(false);
            MainMenu m = new MainMenu(this);
            m.run();
        }
        // INSTRUCTIONS
        if (e.getKeyChar() == 'e' && MainMenu.getIsInstruction()) {
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
        }
        // LEARNING LEVEL
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningHall()) {// && MainMenu.getIsLearningText()){
            LearningHall l = new LearningHall(this);
            MainMenu.setIsLearningText(false);
            l.run();
        }
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningClassroom()) {// && MainMenu.getIsLearningText()){
            LearningClassroom c = new LearningClassroom(this);
            MainMenu.setIsLearningText(false);
            c.run();
        }
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningCaf()) {// && MainMenu.getIsLearningText()){
            LearningCaf c = new LearningCaf(this);
            MainMenu.setIsLearningText(false);
            c.run();
        }

        // LOCK GAME
        if (e.getKeyChar() == 'w' && MainMenu.getIsLock()) {
            if (Lock.degrees == 360)
                Lock.degrees = 45;
            else
                Lock.degrees += 45;
            Lock.turns.add("up");
            Lock l = new Lock(this);
            l.run();
            // if (l.checkWinner()){
            // MainMenu.setIsLock(false);
            // resetVars();
            // MainMenu ex = new MainMenu(this);
            // ex.run();
            // }
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsLock()) {
            if (Lock.degrees == 0)
                Lock.degrees = 315;
            else
                Lock.degrees -= 45;
            Lock.turns.add("down");
            Lock l = new Lock(this);
            // System.out.println(Lock.degrees);
            l.run();
            if (l.checkWinner()) {
                MainMenu.setIsLock(false);
                resetVars();
                MainMenu ex = new MainMenu(this);
                ex.run();
            }
        }
        // MAZE
        if (e.getKeyChar() == 'w' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsMap()) {
            ClassMaze.move("up");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsMap()) {
            ClassMaze.move("down");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'a' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsMap()) {
            ClassMaze.move("left");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'd' && MainMenu.getIsMazeGame() && !MainMenu.getIsTextScreen() && !MainMenu.getIsMap()) {
            ClassMaze.move("right");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (ClassMaze.checkWinner() && MainMenu.getIsMazeGame()) {
            MainMenu.setIsMazeGame(false);
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
        }

        if (MainMenu.getIsLock() && MainMenu.getIsMazeGame()) { // Run lock game and check if complete
            Lock l = new Lock(this);
            l.run();
            if (Lock.checkWinner()) {
                // MainMenu.setIsLock(false);
                Congrats c = new Congrats(this, "Yay! Lock Level has been completed.");
                c.run();
                if (e.getKeyChar() == ' ') {
                    MainMenu.setIsLock(false);
                    ClassMaze m = new ClassMaze(this);
                    m.run();
                }
            }
        } else if (ClassMaze.checkLockGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsLock()) {
                MainMenu.setIsTextScreen(false);
                Lock l = new Lock(this);
                l.run();
            } else {
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
                }
            }
        } else if (ClassMaze.checkMapGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsMap()) {
                MainMenu.setIsTextScreen(false);
                Map l = new Map(this);
                l.run();
            } else {
                TextScreen t = new TextScreen(this, "Obstacle #1: Map the school");
                t.run();
            }
        }
        if (MainMenu.getIsMeetPerson() && MainMenu.getIsMazeGame()) { // Run lock game and check if complete
            System.out.println(MeetThePerson.isComplete);
            if (MeetThePerson.isComplete) {
                MainMenu.setIsMeetPerson(false);
                Congrats c = new Congrats(this, "Yay! Meet the Person has been completed.", "press any key to continue");
                c.run();
                if (e.getKeyChar() != 'm') {
                    System.out.println("hi");
                    ClassMaze m = new ClassMaze(this);
                    MainMenu.setIsMeetPerson(false);
                    m.run();
                }
            }
            else if (!MeetThePerson.isComplete){
                MeetThePerson p = new MeetThePerson(this);
                p.run();
            }
        } else if (ClassMaze.checkMeetGame() && MainMenu.getIsMazeGame()) {
            if (e.getKeyChar() == 'n' && !MainMenu.getIsMeetPerson()) {
                MainMenu.setIsTextScreen(false);
                MeetThePerson p = new MeetThePerson(this);
                p.run();
            } else {
                TextScreen t = new TextScreen(this, "Obstacle #3: Meet the Person");
                t.run();
            }
        }

        // ESCAPE MAP
        int moveAmt = 5;
        if (e.getKeyChar() == 's' && MainMenu.getIsEscapeMap()) {
            EscapeMap.yPos += moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'w' && MainMenu.getIsEscapeMap()) {
            EscapeMap.yPos -= moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'a' && MainMenu.getIsEscapeMap()) {
            EscapeMap.xPos -= moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'd' && MainMenu.getIsEscapeMap()) {
            EscapeMap.xPos += moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        //ESCAPE MAP IN LIBRARY
        if (MainMenu.getIsEscapeMap() && (EscapeMap.xPos > 511 && EscapeMap.xPos < 700) && (EscapeMap.yPos > 250 && EscapeMap.yPos < 413)){
            // System.ou  t.println("IN LIBRARY");
            EscapeMap.text = "Library Game";
        }
        else if (MainMenu.getIsEscapeMap()&& (EscapeMap.xPos > 328 && EscapeMap.xPos < 510) && (EscapeMap.yPos > 201 && EscapeMap.yPos < 454)){
            EscapeMap.text = "Gym Game";
        }
        else if (MainMenu.getIsEscapeMap()&& (EscapeMap.xPos > 126 && EscapeMap.xPos < 507) && (EscapeMap.yPos > 100 && EscapeMap.yPos < 200) && !EscapeMap.isHallComplete){
            EscapeMap.text = "Hallway Game";
        }
        else if (MainMenu.getIsEscapeMap()&& (EscapeMap.xPos > 314 && EscapeMap.xPos < 390) && (EscapeMap.yPos > 50 && EscapeMap.yPos < 186) && !EscapeMap.isTakeNotesComplete){
            EscapeMap.text = "Take Notes Game";
        }
        else if (MainMenu.getIsEscapeMap()&& (EscapeMap.xPos > 228 && EscapeMap.xPos < 290) && (EscapeMap.yPos > 200 && EscapeMap.yPos < 300) && !EscapeMap.isTalkToTeacherComplete){
            EscapeMap.text = "Talk to Teacher Game";
        }
        else{
            EscapeMap.text = "Exit";
        }

        //HALLWAY GAME
        if (!HallwayGame.checkWin() && HallwayGame.items.size() == 4){
            resetVars();
            HallwayGame h = new HallwayGame(this);
            h.run();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, e.getComponent());
        double x = p.getX();
        double y = p.getY();
        // LEARNING HALL
        if (MainMenu.getIsLearningHall() && !MainMenu.getIsLearningText()) {
            System.out.println("X: " + p.getX() + "     Y: " + p.getY());
            if ((x > 334 && x < 486) && (y > 37 && y < 100)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a schedule");
                t.run();
            }
            if ((x > 178 && x < 244) && (y > 248 && y < 310)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a lock");
                t.run();
            }
            if ((x > 330 && x < 430) && (y > 196 && y < 393)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a student");
                t.run();
            }
            if ((x > 474 && x < 578) && (y > 144 && y < 415)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a locker");
                t.run();
            }
            if ((x > 629 && x < 734) && (y > 111 && y < 220)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a room number");
                t.run();
            }
            if ((x > 589 && x < 767) && (y > 46 && y < 88)) {
                MainMenu.setIsLearningHall(false);
                LearningClassroom c = new LearningClassroom(this);
                c.run();
            }
            if ((x > 54 && x < 164) && (y > 49 && y < 87)) {
                MainMenu.setIsLearningHall(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }
        // LEARNING CLASSROOM
        else if (MainMenu.getIsLearningClassroom() && !MainMenu.getIsLearningText()) {
            // System.out.println("X: " + p.getX() + " Y: " + p.getY());
            if ((x > 23 && x < 139) && (y > 143 && y < 262)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a teacher");
                t.run();
            }
            if ((x > 196 && x < 298) && (y > 297 && y < 336)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a notebook");
                t.run();
            }
            if ((x > 278 && x < 410) && (y > 69 && y < 234)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a rule list");
                t.run();
            }
            if ((x > 413 && x < 529) && (y > 308 && y < 474)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a desk");
                t.run();
            }
            if ((x > 530 && x < 618) && (y > 215 && y < 369)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a student");
                t.run();
            }
            if ((x > 597 && x < 773) && (y > 45 && y < 84)) {
                MainMenu.setIsLearningClassroom(false);
                MainMenu.setIsLearningCaf(true);
                LearningCaf caf = new LearningCaf(this);
                caf.run();
            }
            if ((x > 55 && x < 163) && (y > 45 && y < 87)) {
                MainMenu.setIsLearningClassroom(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }
        // LEARNING CAFETERIA
        else if (MainMenu.getIsLearningCaf() && !MainMenu.getIsLearningText()) {
            // System.out.println("X: " + p.getX() + " Y: " + p.getY());
            if ((x > 15 && x < 172) && (y > 309 && y < 460)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a table");
                t.run();
            }
            if ((x > 269 && x < 360) && (y > 267 && y < 497)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a friend");
                t.run();
            }
            if ((x > 223 && x < 443) && (y > 112 && y < 217)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is where you sign up for clubs");
                t.run();
            }
            if ((x > 587 && x < 666) && (y > 247 && y < 471)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is friend #2");
                t.run();
            }
            if ((x > 712 && x < 800) && (y > 160 && y < 457)) {
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is where you buy food");
                t.run();
            }
            if ((x > 581 && x < 757) && (y > 47 && y < 87)) {
                MainMenu.setIsLearningCaf(false);
                Congrats c = new Congrats(this, "You have finished the learning level!!");
                c.run();
            }
            if ((x > 53 && x < 164) && (y > 48 && y < 88)) {
                MainMenu.setIsLearningCaf(false);
                MainMenu m = new MainMenu(this);
                m.run();
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
        if (MainMenu.getIsEscapeMap()){
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isHallComplete && EscapeMap.text.equals("Hallway Game")){
                HallwayGame h = new HallwayGame(this);
                h.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isTakeNotesComplete && EscapeMap.text.equals("Take Notes Game")){
                TakeNotes n = new TakeNotes(this);
                n.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && !EscapeMap.isTalkToTeacherComplete && EscapeMap.text.equals("Talk to Teacher Game")){
                TalkToTeacher n = new TalkToTeacher(this);
                n.run();
            }
            if ((x > 88 && x < 294) && (y > 392 && y < 460) && EscapeMap.text.equals("Exit")){
                resetVars();
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }

        // HALLWAY GAME
        x = p.getX();
        y = p.getY();
        if (MainMenu.getIsHallwayGame()){
            if ((x > 56 && x < 155) && (y > 128 && y < 234) && !HallwayGame.items.contains("dog")){
                HallwayGame.items.add("dog");
            }
            if ((x > 199 && x < 268) && (y > 127 && y < 237)&& !HallwayGame.items.contains("notebook")){
                HallwayGame.items.add("notebook");
            }
            if ((x > 313 && x < 367) && (y > 132 && y < 219)&& !HallwayGame.items.contains("headphones")){
                HallwayGame.items.add("headphones");
            }
            if ((x > 413 && x < 493) && (y > 148 && y < 214)&& !HallwayGame.items.contains("textbooks")){
                HallwayGame.items.add("textbooks");
            }
            if ((x > 545 && x < 646) && (y > 151 && y < 218)&& !HallwayGame.items.contains("pencilCase")){
                HallwayGame.items.add("pencilCase");
            }
            if ((x > 325 && x < 417) && (y > 262 && y < 329)&& !HallwayGame.items.contains("videoGame")){
                HallwayGame.items.add("videoGame");
            }
            if ((x > 502 && x < 543) && (y > 247 && y < 326)&& !HallwayGame.items.contains("water")){
                HallwayGame.items.add("water");
            }
            if (HallwayGame.checkWin() && HallwayGame.items.size() == 4){
                MainMenu.setIsHallwayGame(false);
                EscapeMap.isHallComplete = true;
                EscapeMap m = new EscapeMap(this);
                m.run();
            }
            else{
            System.out.println(HallwayGame.items);
            HallwayGame h = new HallwayGame(this);
            h.run();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (MainMenu.getIsMeetPerson()) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;
            if (x > 350 && x < 500 && y > 350 && y < 425) {
                MeetThePerson.hover1 = true;
            } else {
                MeetThePerson.hover1 = false;
            }

            if (x > 550 && x < 700 && y > 350 && y < 425) {
                MeetThePerson.hover2 = true;
            } else {
                MeetThePerson.hover2 = false;
            }
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_A);
            } catch (Exception d) {
                System.out.println("robot error");
            }
            // MeetThePerson m = new MeetThePerson(this);
            // m.run();
        }
        // TALK TO TEACHER GAME
        if (MainMenu.getIsTalkToTeacher()) {
            MainMenu.setIsEscapeMap(false);
            if(TalkToTeacher.isComplete){
                if(TalkToTeacher.score == 3){
                    EscapeMap.isTalkToTeacherComplete = true;
                    MainMenu.setIsTalkToTeacher(false);
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                }
                else{
                    resetVars();
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
                if (TalkToTeacher.stage == 1){
                    TalkToTeacher.score ++;
                }
                System.out.println(TalkToTeacher.stage);
                TalkToTeacher.stage ++;
            } else {
                TalkToTeacher.hover1 = false;
                // TalkToTeacher.stage ++;
            }

            if (x > 550 && x < 700 && y > 350 && y < 425) {
                TalkToTeacher.hover2 = true;
                if (TalkToTeacher.stage == 2 || TalkToTeacher.stage == 3){
                    TalkToTeacher.score ++;
                }
                TalkToTeacher.stage ++;
            } else {
                TalkToTeacher.hover2 = false;
            }
            if (MainMenu.getIsTalkToTeacher()){
                TalkToTeacher t = new TalkToTeacher(this);
                t.run();
            }
            // try {
            //     Robot robot = new Robot();
            //     robot.keyPress(KeyEvent.VK_A);
            // } catch (Exception d) {
            //     System.out.println("robot error");
            // }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // // DELETE
        // if (MainMenu.getIsEscapeMap()){
        //     Point p = MouseInfo.getPointerInfo().getLocation();
        //     SwingUtilities.convertPointFromScreen(p, e.getComponent());
        //     double x = p.getX();
        //     double y = p.getY();
        //     System.out.println("X: " + x + "        Y: " + y);
        // }
        // MEET THE PERSON
        if (MainMenu.getIsMeetPerson()) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;

            if (x > 350 && x < 500 && y > 350 && y < 425) {
                MeetThePerson.stage++;
            } else if (x > 550 && x < 700 && y > 350 && y < 425) {
                MeetThePerson.stage++;
            }
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_M);
            } catch (Exception d) {
                System.out.println("robot error");
            }
            // MeetThePerson m = new MeetThePerson(this);
            // m.run();
        }

        // TAKE NOTES
        if (MainMenu.getIsTakeNotes()) {
            MainMenu.setIsEscapeMap(false);

            Point p = MouseInfo.getPointerInfo().getLocation();
            SwingUtilities.convertPointFromScreen(p, e.getComponent());
            double x = p.getX();
            double y = p.getY() - 25;
            if (TakeNotes.isComplete){
                // System.out.println("sdfkjdf");
                MainMenu.setIsTakeNotes(false);
                if (TakeNotes.win){
                    EscapeMap.isTakeNotesComplete = true;
                    MainMenu.setIsTakeNotes(false);
                    EscapeMap m = new EscapeMap(this);
                    m.run();
                }
                else{
                    MainMenu.setIsTakeNotes(false);
                    resetVars();
                    TakeNotes n = new TakeNotes(this);
                    n.run();
                }
            }
            else if (MainMenu.getIsTakeNotes()){
                System.out.println("123");
                TakeNotes m = new TakeNotes(this);
                m.run();
            }
            if (TakeNotes.stage == 1 || TakeNotes.stage == 5) {
                if(x > 300 && x < 500 && y > 420 && y < 480){
                   TakeNotes.stage++;
                }
                
            } else if (x > 100 && x < 700 && y > 100 && y < 200) {
                TakeNotes.stage++;
                TakeNotes.score++;  
            } else if (x > 100 && x < 700 && y > 300 && y < 400) {
                TakeNotes.stage++;
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}