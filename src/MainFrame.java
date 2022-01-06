import javax.swing.JFrame;

/**
 * @author Adam Virostek
 * @version 1.0
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        new JFrame();
        this.setResizable(false);
        this.setTitle("2D Platformer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program ends when user clicks the "x" button
    }
}
