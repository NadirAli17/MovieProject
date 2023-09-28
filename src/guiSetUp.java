import javax.swing.JFrame;
import javax.swing.*;
//GUI IS NOT FINISHED
public class guiSetUp extends JFrame {
    int width;
    int height;

    public guiSetUp(int w, int h){
        width = w;
        height = h;
    }
    public void setUpGui(){
        setSize(width, height);
        setTitle("Ticket Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Create a label for the question
        JLabel questionLabel = new JLabel("How many tickets?");
        panel.add(questionLabel);

        // Create a text field for user input
        JTextField inputField = new JTextField(10); // 10 columns wide
        panel.add(inputField);

        // Create a button for submission (optional)
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Add the panel to the frame
        getContentPane().add(panel);

        pack(); // Size the frame to fit its components
        setVisible(true);
    }
}