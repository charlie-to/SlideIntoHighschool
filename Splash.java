import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Splash {
    JFrame frame;
    public Splash(JFrame fr) {
      this.frame = fr;
      this.frame.revalidate();
      this.frame.repaint();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
                frame.add(new MyPane());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public class MyPane extends JPanel {

        private int x = 0;
        private int y = 0;
        Timer timer;

        /* I learned how to use a timer using GeeksForGeeks.org
        
         https://www.geeksforgeeks.org/java-util-timer-class-java/
         
        */
         
        public MyPane() {
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    move();
                    repaint();
                }
            });
            timer.start();
        }

        protected void move() {
            x++;
            y--;
            if(x>300){
               timer.stop();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Colours.backgroundBlue);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(Colours.largeSerifFont);
            g.drawString("Slide Into", 0+x,200);
            g.drawString("High School", 580+y,300);
            g.setColor(new Color(230,190,30));//yellow
            g.fillRect(0,400,800,100);
            g.setColor(new Color(100,50,0));//dark brown
            g.fillRect(90,-100+x,20,200);
            g.setColor(new Color(150,70,0));//light brown
            g.fillRect(50,40+x,100,60);
            g.setColor(new Color(50,200,100));//green
            g.fillOval(50,-250+x,100,100);
            g.fillOval(50,-170+x,100,100);
            g.fillOval(50,-90+x,100,100);
            
            g.setColor(new Color(100,50,0));//dark brown
            g.fillRect(690,-100+x,20,200);
            g.setColor(new Color(150,70,0));//light brown
            g.fillRect(650,40+x,100,60);
            g.setColor(new Color(50,200,100));//green
            g.fillOval(650,-250+x,100,100);
            g.fillOval(650,-170+x,100,100);
            g.fillOval(650,-90+x,100,100);
            g.dispose();
        }

    }

}