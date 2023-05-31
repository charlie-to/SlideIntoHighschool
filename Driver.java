import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Driver {
    static GameFrame frame;
    public static void main(String[]args){
        frame = new GameFrame("Slide Into Highschool");
        frame.setSize(800, 500);
        // MainMenu m = new MainMenu(frame);
        // m.run();
        ClassMaze m = new ClassMaze(frame);
        m.run();
    }
}
