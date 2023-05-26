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
        if(e.getKeyChar() == 'h' && MainMenu.getIsInstruction()){
            System.out.println("x");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        

    }
}