import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameFrame extends JFrame implements KeyListener
{
    public GameFrame(String title){
        super(title);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()== 'e' && MainMenu.getIsInstruction()){
            MainMenu ex = new MainMenu(this);
            ex.run();
        }
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
                MainMenu ex = new MainMenu(this);
                ex.run();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        

    }
}