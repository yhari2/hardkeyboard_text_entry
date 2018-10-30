import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainScreen implements Screen {
    // constants
    private final int NUM_OF_PHRASES_PER_STUDY = 10;

    // parameters
    private JFrame frame;
    private JPanel panel;
    private Main main;
    private String partipantID;

    // useful information
    private String phrase;
    private String[] phrases;
    private int phraseIndex;

    // Components
    private JPanel textPanel;
    private JLabel phraseLabel;
    private JTextField textField;

    MainScreen(JFrame frame, JPanel panel, Main main, String partipantID) {
        this.frame = frame;
        this.panel = panel;
        this.main = main;
        this.partipantID = partipantID;

        this.textPanel = new JPanel();
        this.phraseIndex = 0;
        this.phraseLabel = new JLabel();
        this.textField = new JTextField();
        this.phrases = getPhrases();
    }


    private String[] getPhrases() {
        List<String> result = new ArrayList<>();
        String file = "src/main/resources/".concat(this.partipantID).concat(".txt");
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            String line;

            while((line = reader.readLine()) != null){
                String[] records = line.split(",");
                result.add(records[records.length - 1]);
            }

        } catch(Exception e) {
            // print e for debugging
            e.printStackTrace();
        }

        return result.toArray(new String[0]);
    }

    @Override
    public void drawNextScreen() {
    }


    private String getText() {
        if (0 <= this.phraseIndex && this.phraseIndex < this.phrases.length) {
            String result = this.phrases[this.phraseIndex];
            this.phraseIndex = this.phraseIndex + 1;
            return result;
        } else {
            return null;
        }
    }

    @Override
    public void draw() {
        this.panel.removeAll();
        this.panel.setLayout(new BorderLayout());

        this.phrase = getText();

        this.textPanel = new JPanel();
        this.phraseLabel = new JLabel(this.phrase);
        this.textPanel.add(this.phraseLabel);
        this.textPanel.add(this.textField);

        this.panel.add(this.textPanel);
        this.frame.add(this.panel, BorderLayout.NORTH);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
}
