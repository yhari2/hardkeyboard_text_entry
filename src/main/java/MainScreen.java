import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
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
    private JLabel phraseLabel;
    private JTextField textField;
    private JButton button;

    public MainScreen(JFrame frame, JPanel panel, Main main, String partipantID) {
        this.frame = frame;
        this.panel = panel;
        this.main = main;
        this.partipantID = partipantID;


        this.phraseIndex = 0;
        this.phraseLabel = new JLabel();
        this.textField = new JTextField();
        this.button = new JButton("Next");
        this.phrases = getPhrases();

        System.out.println("success");
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

        } catch(Exception e){
            // print e for debugging
            e.printStackTrace();
        }

        return result.toArray(new String[0]);
    }

    @Override
    public void drawNextScreen() {

    }

    @Override
    public void draw() {

    }
}
