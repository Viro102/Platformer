import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    private Player player;

    private ArrayList<Wall> walls = new ArrayList<>();

    private Thread gameThread;

    public GamePanel() {
        JPanel panel = new JPanel();
        panel.setLocation(0, 0);
        panel.setBackground(Color.black);
        panel.setVisible(true);
        panel.setDoubleBuffered(true); // lepsi render

        this.player = new Player(400, 300, this);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    // Toto je hlavny game loop
    @Override
    public void run() {
        while (gameThread != null) {

            System.out.println("the game is running");

            update();

            repaint();
        }
    }

    // 1. aktualizuje hracovu poziciu
    public void update() {

    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // menim Graphics na Graphics2D aby som mal vacsiu kontorlu na geometriou,
        // farbou, transformaciou...
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(16, 16, 100, 100);

        g2.dispose();

    }

    public void paint(Graphics g) {
        // super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for (Wall wall : walls) {
            wall.draw(gtd);
        }

    }

    public void makeWalls() {
        for (int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 600, 50, 50));

        }
        walls.add(new Wall(50, 450, 50, 50));
        walls.add(new Wall(50, 500, 50, 50));
        walls.add(new Wall(50, 550, 50, 50));
        walls.add(new Wall(450, 550, 50, 50));
        walls.add(new Wall(600, 450, 50, 50));
        walls.add(new Wall(600, 500, 50, 50));
        walls.add(new Wall(600, 550, 50, 50));

    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }
}
