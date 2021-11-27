import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(900, 600);
        frame.setTitle("2D Platformer");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // okno sa zobrazi v strede
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program skonci ak zatvorim okno
    }
}
