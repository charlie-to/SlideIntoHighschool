import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame implements KeyListener, MouseListener 
{
    public GameFrame(String title){
        super(title);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }
    public static void resetVars(){
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // CONGRATS SCREEN
        if(MainMenu.getIsCongrats()){
            MainMenu.setIsCongrats(false);
            MainMenu m = new MainMenu(this);
            m.run();
        }
        // INSTRUCTIONS
        if(e.getKeyChar()== 'e' && MainMenu.getIsInstruction()){
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
        }
        // LEARNING LEVEL
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningHall()){// && MainMenu.getIsLearningText()){
            LearningHall l = new LearningHall(this);
            MainMenu.setIsLearningText(false);
            l.run();
        }
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningClassroom()){// && MainMenu.getIsLearningText()){
            LearningClassroom c = new LearningClassroom(this);
            MainMenu.setIsLearningText(false);
            c.run();
        }
        if (e.getKeyChar() == 'e' && MainMenu.getIsLearningCaf()){// && MainMenu.getIsLearningText()){
            LearningCaf c = new LearningCaf(this);
            MainMenu.setIsLearningText(false);
            c.run();
        }
        
        // LOCK GAME
        if (e.getKeyChar() == 'w' && MainMenu.getIsLock()){
            if (Lock.degrees == 360)
                Lock.degrees = 45;
            else
                Lock.degrees += 45;
            Lock.turns.add("up");
            Lock l = new Lock(this);
            l.run();
            if (l.checkWinner()){
                MainMenu.setIsLock(false);
                resetVars();
                MainMenu ex = new MainMenu(this);
                ex.run();
            }
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsLock()){
            if (Lock.degrees == 0)
                Lock.degrees = 315;
            else
                Lock.degrees -= 45;
            Lock.turns.add("down");
            Lock l = new Lock(this);
            // System.out.println(Lock.degrees);
            l.run();
            if (l.checkWinner()){
                MainMenu.setIsLock(false);
                resetVars();
                MainMenu ex = new MainMenu(this);
                ex.run();
            }
        }
        // MAZE
        if (e.getKeyChar() == 'w' && MainMenu.getIsMazeGame()){
            ClassMaze.move("up");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 's' && MainMenu.getIsMazeGame()){
            ClassMaze.move("down");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'a' && MainMenu.getIsMazeGame()){
            ClassMaze.move("left");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (e.getKeyChar() == 'd' && MainMenu.getIsMazeGame()){
            ClassMaze.move("right");
            ClassMaze cm = new ClassMaze(this);
            cm.run();
        }
        if (ClassMaze.checkWinner() && MainMenu.getIsMazeGame()){
            MainMenu.setIsMazeGame(false);
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
        }  
        
        //ESCAPE MAP
        int moveAmt = 5;
        if (e.getKeyChar() == 's' && MainMenu.getIsEscapeMap()){
            EscapeMap.yPos += moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'w' && MainMenu.getIsEscapeMap()){
            EscapeMap.yPos -= moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'a' && MainMenu.getIsEscapeMap()){
            EscapeMap.xPos -= moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
        if (e.getKeyChar() == 'd' && MainMenu.getIsEscapeMap()){
            EscapeMap.xPos += moveAmt;
            EscapeMap m = new EscapeMap(this);
            m.run();
        }
    }
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}


    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, e.getComponent());
        double x = p.getX();
        double y = p.getY();
        // LEARNING HALL
        if(MainMenu.getIsLearningHall() && !MainMenu.getIsLearningText()){
            System.out.println("X: " + p.getX() + "     Y: " + p.getY());
            if ((x > 334 && x <486) &&(y> 37&& y < 100)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a schedule");
                t.run();
            }
            if ((x > 178 && x <244) &&(y> 248 && y < 310)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a lock");
                t.run();
            }
            if ((x > 330 && x <430) &&(y> 196 && y < 393)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a student");
                t.run();
            }
            if ((x > 474 && x <578) &&(y> 144 && y < 415)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a locker");
                t.run();
            }
            if ((x > 629 && x <734) &&(y> 111 && y < 220)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a room number");
                t.run();
            }
            if ((x > 589 && x <767) &&(y> 46 && y < 88)){
                MainMenu.setIsLearningHall(false);
                LearningClassroom c = new LearningClassroom(this);
                c.run();
            }
            if ((x > 54 && x <164) &&(y> 49 && y < 87)){
                MainMenu.setIsLearningHall(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }
        // LEARNING CLASSROOM
        else if (MainMenu.getIsLearningClassroom() && !MainMenu.getIsLearningText()){
            // System.out.println("X: " + p.getX() + "     Y: " + p.getY());
            if ((x > 23 && x <139) &&(y> 143 && y < 262)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a teacher");
                t.run();
            }
            if ((x > 196 && x <298) &&(y> 297 && y < 336)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a notebook");
                t.run();
            }
            if ((x > 278 && x <410) &&(y> 69 && y < 234)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a rule list");
                t.run();
            }
            if ((x > 413 && x <529) &&(y> 308 && y < 474)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a desk");
                t.run();
            }
            if ((x > 530 && x <618) &&(y> 215 && y < 369)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a student");
                t.run();
            }
            if ((x > 597 && x <773) &&(y> 45 && y < 84)){
                MainMenu.setIsLearningClassroom(false);
                MainMenu.setIsLearningCaf(true);
                LearningCaf caf = new LearningCaf(this);
                caf.run();
            }
            if ((x > 55 && x <163) &&(y> 45 && y < 87)){
                MainMenu.setIsLearningClassroom(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }
        // LEARNING CAFETERIA
        else if (MainMenu.getIsLearningCaf() && !MainMenu.getIsLearningText()){
            // System.out.println("X: " + p.getX() + "     Y: " + p.getY());
            if ((x > 15 && x <172) &&(y> 309 && y < 460)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a table");
                t.run();
            }
            if ((x > 269 && x <360) &&(y> 267 && y < 497)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is a friend");
                t.run();
            }
            if ((x > 223 && x <443) &&(y> 112 && y < 217)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is where you sign up for clubs");
                t.run();
            }
            if ((x > 587 && x <666) &&(y> 247 && y < 471)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is friend #2");
                t.run();
            }
            if ((x > 712 && x <800) &&(y> 160 && y < 457)){
                MainMenu.setIsLearningText(true);
                LearningText t = new LearningText(this, "This is where you buy food");
                t.run();
            }
            if ((x > 581 && x <757) &&(y> 47 && y < 87)){
                MainMenu.setIsLearningCaf(false);
                Congrats c = new Congrats(this, "You have finished the learning level!!");
                c.run();
            }
            if ((x > 53 && x <164) &&(y> 48 && y < 88)){
                MainMenu.setIsLearningCaf(false);
                MainMenu m = new MainMenu(this);
                m.run();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}