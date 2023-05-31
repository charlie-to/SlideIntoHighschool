import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame implements KeyListener
{
    public GameFrame(String title){
        super(title);
        setFocusable(true);
        addKeyListener(this);
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
        // INSTRUCTIONS
        if(e.getKeyChar()== 'e' && MainMenu.getIsInstruction()){
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
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
        if(ClassMaze.checkWinner() && MainMenu.getIsMazeGame()){
            MainMenu.setIsMazeGame(false);
            resetVars();
            MainMenu ex = new MainMenu(this);
            ex.run();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        

    }
}