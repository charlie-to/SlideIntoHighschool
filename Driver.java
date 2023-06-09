public class Driver {
    static GameFrame frame;
    public static void main(String[]args){
        frame = new GameFrame("Slide Into Highschool");
        frame.setSize(800, 500);
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
