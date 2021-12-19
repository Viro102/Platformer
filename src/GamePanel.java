import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private static GamePanel panelInstance = null;

    private final int tileSize = 48; // 48x48 dlazdica
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = this.tileSize * this.maxScreenCol; // 768 pixels
    private final int screenHeight = this.tileSize * this.maxScreenRow; // 576 pixels

    private Thread gameThread;
    private KeyChecker keyChecker;

    private int fps = 60;

    private Wall walls;

    private GamePanel() {
        this.walls = new Wall(0, 192);
        this.keyChecker = new KeyChecker();
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.white);
        this.addKeyListener(this.keyChecker);
        this.setFocusable(true);
    }

    public static GamePanel getInstance() {
        if (GamePanel.panelInstance == null) {
            GamePanel.panelInstance = new GamePanel();
        }

        return GamePanel.panelInstance;
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();

    }

    // Toto je hlavny game loop pouzivam delta sposob vykreslovania
    @Override
    public void run() {
        double drawInterval = 1000000000 / this.fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (this.gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime); // timer pouzivam na FPS zobrazenie
            lastTime = currentTime;

            if (delta > 1) {
                this.update();
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
        if (this.keyChecker.getMovement() == 'd') {
            Player.getInstance().moveRight();
        } else if (this.keyChecker.getMovement() == 'a') {
            Player.getInstance().moveLeft();
        } else if (this.keyChecker.getMovement() == 'w') {
            Player.getInstance().moveUp();
        }

        Player.getInstance().set();

    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Player.getInstance().draw(g);
        this.walls.makeWalls(g);
        g.dispose();
    }
}
