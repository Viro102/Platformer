import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private static GamePanel panelInstance = null;

    private final int tileSize = 48; // 48x48 dlazdica
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    private final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    private Thread gameThread;
    private KeyChecker keyChecker;

    private int FPS = 60;

    private Wall walls;

    private GamePanel() {
        this.walls = new Wall(0, 192);
        this.keyChecker = new KeyChecker();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.white);
        this.addKeyListener(keyChecker);
        this.setFocusable(true);
    }

    public static GamePanel getInstance() {
        if (panelInstance == null) {
            panelInstance = new GamePanel();
        }

        return panelInstance;
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
        if (keyChecker.getMovement() == 'd') {
            Player.getInstance().moveRight();
        } else if (keyChecker.getMovement() == 'a') {
            Player.getInstance().moveLeft();
        } else if (keyChecker.getMovement() == 'w') {
            Player.getInstance().moveUp();
        }

        Player.getInstance().set();

    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Player.getInstance().draw(g);
        walls.makeWalls(g);
        g.dispose();
    }
}
