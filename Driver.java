import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Driver {
    static JFrame frame;
    public static void main(String[]args){
        frame = new JFrame("Slide Into Highschool");
        frame.setSize(800, 500);
        MainMenu m = new MainMenu(frame);
        // Instructions i = new Instructions(frame);
        m.run();
        // i.run();
    }
}
