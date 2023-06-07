import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * @author Charlie To
 * Date: June 1st, 2023
 * Time Spent: 1 hr
 * Version #: 1
 */
public class ClassMaze {
    JFrame frame;
    Color lightRed = new Color(244, 204, 204);
    Color green = new Color(106, 168, 79);
    static boolean[][] maze = {{false, true, true,true,true,false,true,true,true,true,false, false, false, false},
                        {false, true, false, false, true, false, true, false, false, true,true,true,true,true},
                        {false, true,true,true,true,false, true, false, false, false, true, false, false, false},
                        {false, false, false, false, true,true,true,false,true,false,true,false, false, false},
                        {true,true,false, false, false, false, true,false, true,true,true,true,true,true,},
                        {false, true, false, false,true,true,true,false,true,false,true,false,false,true},
                        {false, true, false, false,true,false,false,false,true,false,true,false,false,true,},
                        {false,true,true,true,true,false,false,false,true,false,true,true,true,true}};
    public static int startX = 13;
    public static int startY = 1;
    public static int endX=0;
    public static int endY=4;
    public static int curX = startX;
    public static int curY = startY;

    public static int lockX=9;
    public static int lockY=1;

    public static int mapX=6;
    public static int mapY=4;

    public static int meetX = 2;
    public static int meetY = 7;

    public ClassMaze(JFrame frame) {
        this.frame = frame;
        // Clear the frame
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        this.frame.revalidate();
        this.frame.repaint();
        MainMenu.setIsMazeGame(true);
    }
    /**
     * Checks if the maze is complete
     * @return true if complete
     */
    public static boolean checkWinner(){
        if (curX == endX && curY == endY){
            return true;
        }
        return false;
    }
    /**
     * check if character is on the lock game square
     * @return true if it's on the square
     */
    public static boolean checkLockGame(){
        if (curX == lockX && curY == lockY){
            return true;
        }
        return false;
    }
    /**
     * check if character is on map game square
     * @return true if character is on square
     */
    public static boolean checkMapGame(){
        if (curX == mapX && curY == mapY){
            return true;
        }
        return false;
    }
    /**
     * checks if character is on meet game square
     * @return true if character is on square
     */
    public static boolean checkMeetGame(){
        if (curX == meetX && curY == meetY){
            return true;
        }
        return false;
    }
    /**
     * Moves the character
     * @param direction direction to be moved in
     * @return true
     */
    public static boolean move(String direction){
        if (direction.equals("up") && curY-1 >=0 && maze[curY-1][curX]){
            curY -= 1;
            curCharY -= height;
        }
        if (direction.equals("down") && curY+1 < maze.length && maze[curY+1][curX]){
            curY += 1;
            curCharY +=height;
        }
        if (direction.equals("left") && curX -1 >= 0 && maze[curY][curX-1]){
            curX -= 1;
            curCharX -= width;
        }
        if (direction.equals("right")&& curX +1 < maze[curY].length && maze[curY][curX+1]){
            curX += 1;
            curCharX += width;
        }
        return true;
    }
    /**
     * displays the screen
     */
    public void run() {
        frame.getContentPane().add(new Drawing());
        frame.setVisible(true);
    }
    //MAZE VARIABLES
    int mazeStartX = 110;
    int mazeStartY = 60;
    static int width = 40;
    static int height = 40;
    int borderW = 5;
    int borderH = 5;
    //CHARACTER VARIABLES
    static int charSize = 30;  // width and height of character circle
    public static int curCharX = 634;
    public static int curCharY = 144;
    class Drawing extends JComponent {
        public void paint(Graphics g) {
            super.paintComponent(g);
            // BACKGROUND
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            // DRAW MAZE
            int x = mazeStartX;
            int y = mazeStartY;
            for (int i = 0; i < maze.length; i ++){
                y +=height;
                x = mazeStartX;
                for (int b = 0; b < maze[0].length; b++){
                    g.setColor(Color.BLACK);
                    g.fillRect(x,y, width, height);
                    if (maze[i][b])
                        g.setColor(lightRed);
                    else
                        g.setColor(Color.WHITE);
                    g.fillRect(x + borderW/2 , y + borderH/2, width-borderW, height-borderH);
                    x += width;
                }
            }
            try{
                BufferedImage img = ImageIO.read(new File("images/items/lock.png"));
                Image newImage = img.getScaledInstance(25, 35, Image.SCALE_DEFAULT);
                g.drawImage(newImage,  475, 145, null);
            } catch (Exception e){System.out.println("Error with image");}
            try{
                BufferedImage img = ImageIO.read(new File("images/items/mapIcon.png"));
                Image newImage = img.getScaledInstance(25, 35, Image.SCALE_DEFAULT);
                g.drawImage(newImage,  355, 263, null);
            } catch (Exception e){System.out.println("Error with image");}
            try{
                BufferedImage img = ImageIO.read(new File("images/person.png"));
                Image newImage = img.getScaledInstance(25, 35, Image.SCALE_DEFAULT);
                g.drawImage(newImage,  198, 382, null);
            } catch (Exception e){System.out.println("Error with image");}
            // CHARACTER
            g.setColor(green);
            g.fillOval(curCharX,curCharY, charSize, charSize);
        }
    }
}
