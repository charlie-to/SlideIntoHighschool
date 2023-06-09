

    /**
     * Driver class of Slide Into Highschool, holds main method of game
     *
     * <h2>Course Info:</h2>
     * ICS4UP with Krasteva, V.
     * Date: June 5st, 2023
     * Time Spent: 15 min
     * @version 1
     * @author Charlie To, Milena Mofrad
     */
public class Driver {
     
       /** Holds the game frame*/
        static GameFrame frame;
       
        /**
         * main method, runs program
         *
         */
        public static void main(String[] args) {
            frame = new GameFrame("Slide Into Highschool");
            frame.setSize(800, 500);
            new Splash(frame);
            try {
                Thread.sleep(6000);
            } catch (Exception e) {
            }
            MainMenu m = new MainMenu(frame);
            m.run();
            // LibraryGame l = new LibraryGame(frame);
            // l.run();
            // KickBall k = new KickBall(frame);
            // k.run();
            // TalkToTeacher t = new TalkToTeacher(frame);
            // t.run();
            // LibraryGame l = new LibraryGame(frame);
            // l.run();
        }
    }
    