import javax.swing.*;

public class MainFrame {
    public MainFrame() {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setTitle("Moja prva hra");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // okno sa zobrazi v strede
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // program skonci ak zatvorim okno
    }
}
