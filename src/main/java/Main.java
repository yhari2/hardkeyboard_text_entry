import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int WINDOW_WIDTH = 1500;
    private static final int WINDOW_HEIGHT = 1000;

    private static JFrame frame;
    private static JPanel panel;

    // screens
    private static StartScreen startScreen;
    private static MainScreen mainScreen;


    void drawMainScreen(String particpantID) {
        mainScreen = new MainScreen(this.frame, this.panel, new Main(), particpantID);
        mainScreen.draw();
    }

    public static void main(String[] args) {
        // initialize variables
        frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        startScreen = new StartScreen(frame, panel, new Main());
        startScreen.draw();
    }
}
