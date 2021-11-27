import javax.swing.*;

public class MainFrame {

    public MainFrame() {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setTitle("2D Platformer");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // okno sa zobrazi v strede
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program skonci ak zatvorim okno
    }
}
