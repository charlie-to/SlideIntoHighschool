import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EscapeMap {
    JFrame frame;
    public static String text = "Exit";
    public static boolean isHallComplete = false;
    public static boolean isTakeNotesComplete = false;
    public static boolean isTalkToTeacherComplete = false;
    public EscapeMap(JFrame frame) {
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsEscapeMap(true);
    }
    public void run(){
        ImageIcon map = new ImageIcon("images/map.png", "image of map");
        frame.add(new JLabel(map));
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    public static int xPos = 640;
    public static int yPos = 170;
    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND MAP
            try{
                BufferedImage img = ImageIO.read(new File("images/map.png"));
                g.drawImage(img,  0, 0, null);
            } catch (Exception e){System.out.println("Error with image");}
            // BACKGROUND PERSON
            try{
                BufferedImage img = ImageIO.read(new File("images/person.png"));
                Image newImage = img.getScaledInstance(40, 70, Image.SCALE_DEFAULT);
                g.drawImage(newImage,  xPos, yPos, null);
            } catch (Exception e){System.out.println("Error with image");}
            g.setColor(Color.GREEN);
            g.fillRect(80, 360, 210, 70);
            g.setColor(Color.BLACK);
            g.setFont(Colours.mediumSerifFont);
            g.drawString(text, 80, 405);
            if(isHallComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  402, 170, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isTakeNotesComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  352, 107, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
            if(isTalkToTeacherComplete){
                try{
                    BufferedImage img = ImageIO.read(new File("images/check.png"));
                    Image newImage = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g.drawImage(newImage,  240, 280, null);
                } catch (Exception e){System.out.println("Error with image");}
            }
        }
    }
}
