import javax.swing.*;

public class MainFrame {
    private GamePanel panel;

    public MainFrame() {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setResizable(false);
        frame.setTitle("Moja prva hra");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // okno sa zobrazi v strede
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program skonci ak zatvorim okno

        // panel
        // panel.setSize(this.getSize());
        // this.add(panel);
    }
}
