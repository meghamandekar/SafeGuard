import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    JFrame frame;
    JLabel image = new JLabel(new ImageIcon("img/icon.png"));
    JLabel text = new JLabel("SECURE GUARD", SwingConstants.CENTER);
    JLabel text2 = new JLabel("For better Security", SwingConstants.CENTER);
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel("", SwingConstants.CENTER); // Creating a JLabel for displaying the message

    SplashScreen() {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        addTitle();
        runningPBar();
    }

    public void createGUI() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setVisible(true);
    }

    public void addImage() {
        image.setSize(600, 200);
        frame.add(image);
    }

    public void addText() {
        text.setFont(new Font("arial", Font.BOLD, 30));
        text.setBounds(0, 200, 600, 60); // Centering the text horizontally
        text.setForeground(Color.WHITE);
        frame.add(text);
    }

    public void addTitle() {
        text2.setFont(new Font("arial", Font.BOLD, 17));
        text2.setBounds(0, 370, 600, 20); // Centering the text horizontally
        text2.setForeground(Color.GREEN);
        frame.add(text2);
    }

    public void addMessage() {
        message.setBounds(0, 320, 600, 40); // Centering the message horizontally
        message.setForeground(Color.BLACK);
        message.setFont(new Font("arial", Font.BOLD, 15));
        frame.add(message);
    }

    public void addProgressBar() {
        progressBar.setBounds(100, 280, 400, 30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.BLACK);
        progressBar.setForeground(Color.YELLOW);
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    public void runningPBar() {
        int i = 0;

        while (i <= 100) {
            try {
                Thread.sleep(40); // Pausing execution for 40 milliseconds
                progressBar.setValue(i); // Setting value of Progress Bar
                message.setText("LOADING....(" + i + "%)"); // Setting text of the message JLabel
                i++;
                if (i == 100) {
                    frame.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SplashScreen::new);
    }
}
