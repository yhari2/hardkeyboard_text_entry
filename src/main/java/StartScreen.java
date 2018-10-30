import javax.swing.*;
import java.awt.*;

public class StartScreen implements Screen {
    private JFrame frame;
    private JPanel panel;
    private Main main;
    private JTextField participantNumber;
    private final String PARTICIPANT_ID = "Particpant_ID";

    private final int BUTTON_WIDTH = 50;
    private final int BUTTON_HEIGHT = 50;

    private final int NUM_PARTICIPANTS = 30;

    StartScreen(JFrame frame, JPanel panel, Main main) {
        this.frame = frame;
        this.panel = panel;
        this.main = main;
    }


    private boolean checkParticipants(String text) {
        int underscore = -1;
        for(int i = 1; i < text.length(); i++) {
            if(text.charAt(i) == '_') {
                underscore = i;
                break;
            }
        }

        int val = Integer.valueOf(text.substring(1, underscore));
        return 0 <= val && val < NUM_PARTICIPANTS;
    }


    /**
     * validating here saves effort down the road
     */
    @Override
    public void drawNextScreen() {
        String enteredText = this.participantNumber.getText();

        if(!enteredText.equals(this.PARTICIPANT_ID) && checkParticipants(enteredText)) {
            this.frame = new JFrame();
            main.drawMainScreen(enteredText);
        }
    }

    @Override
    public void draw() {
        // add text description
        // add button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JButton button = new JButton("Start Study");
        button.addActionListener(e -> drawNextScreen());

        this.participantNumber = new JTextField(this.PARTICIPANT_ID);
        buttonPanel.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        buttonPanel.add(this.participantNumber, BorderLayout.NORTH);
        buttonPanel.add(button, BorderLayout.SOUTH);

        this.panel.add(buttonPanel, BorderLayout.NORTH);

        // make it visible
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(this.panel);
        this.frame.setVisible(true);
    }
}
