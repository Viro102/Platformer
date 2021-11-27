import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setResizable(false);
        this.setTitle("2D Platformer");
        this.setLocationRelativeTo(null); // okno sa zobrazi v strede
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // program skonci ak zatvorim okno
    }
}
