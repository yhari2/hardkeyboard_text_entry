import javax.swing.*;
import java.awt.*;

public class StartScreen implements Screen {
    private JFrame frame;
    private JPanel panel;
    private Main main;
    private JTextField participantNumber;
    private final String PARTICIPANT_ID = "Particpant_ID";

    StartScreen(JFrame frame, JPanel panel, Main main) {
        this.frame = frame;
        this.panel = panel;
        this.main = main;
    }


    /**
     * TODO: validate participant ID here
     * saves effort down the road
     */
    @Override
    public void drawNextScreen() {
        String enteredText = this.participantNumber.getText();

        if(!enteredText.equals(this.PARTICIPANT_ID)) {
            this.frame.removeAll();
            main.drawMainScreen(enteredText);
        }
    }

    @Override
    public void draw() {
        // add layout
        this.frame.setLayout(new BorderLayout());

        // add text description
        // add button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JButton button = new JButton("Start Study");
        button.addActionListener(e -> drawNextScreen());

        this.participantNumber = new JTextField(this.PARTICIPANT_ID);
        buttonPanel.add(this.participantNumber, BorderLayout.WEST);
        buttonPanel.add(button, BorderLayout.EAST);

        this.panel.add(buttonPanel, BorderLayout.SOUTH);

        // make it visible
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}
