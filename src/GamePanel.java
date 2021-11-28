import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    private final int originalTileSize = 16; // 16x16 dlazdica
    private final int scale = 3;

    private final int tileSize = originalTileSize * scale; // 48x48 dlazdica
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    private final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    private ArrayList<Wall> walls = new ArrayList<>();

    private Thread gameThread;

    private Player player;

    private int FPS = 60;

    public GamePanel() {
        this.player = new Player(48, 96, this);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true); // lepsi render
        this.add(this.player);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    // Toto je hlavny game loop pouzivam delta sposob vykreslovania
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime); // timer pouzivam na FPS zobrazenie
            lastTime = currentTime;

            if (delta > 1) {
                update();
                repaint();
                delta--;
                drawCount++; // pocet snimkov za sekundu
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

            // System.out.println("the game has been running for: " + currentTime + " sec");
        }
    }

    // 1. aktualizuje hracovu poziciu
    public void update() {
        if (player.jump()) {
        }
        if (player.crouch()) {
        }
        if (player.goLeft()) {
        }
        if (player.goRight()) {
        } else {
            System.out.println("nepodarilo sa");
        }
    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // menim Graphics na Graphics2D aby som mal vacsiu kontorlu na geometriou,
        // farbou, transformaciou...
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        for (Wall walls : walls) {
            walls.draw(g2);
        }

        g2.dispose();

    }

    // public void reset() {
    // player.x = 200;
    // player.y = 150;

    // }

    public void makeWalls() {
        for (int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 300, 50, 50));

        }
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

    public Player getPlayer() {
        return this.player;
    }
}
