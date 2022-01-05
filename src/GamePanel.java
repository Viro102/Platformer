import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private static GamePanel panelInstance = null;

    public static final int tileSize = 32; // 32x32 dlazdica

    private final int maxScreenCol = 30;
    private final int maxScreenRow = 20;
    private final int screenWidth = GamePanel.tileSize * this.maxScreenCol;
    private final int screenHeight = GamePanel.tileSize * this.maxScreenRow;

    private Thread gameThread;
    private KeyChecker keyChecker;
    private Finish finish;

    private int fps = 60;

    private ArrayList<Wall> walls;
    private ArrayList<Obstacle> obstacles;

    private GamePanel() {
        this.walls = Map1.getInstance().makeTerrain();
        this.obstacles = Map1.getInstance().makeObstacles();
        this.keyChecker = new KeyChecker();
        reset();
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.WHITE);
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

    public void reset() {
        Player.getInstance().setX(0);
        Player.getInstance().setY(0);
        Player.getInstance().setXSpeed(0);
        Player.getInstance().setYSpeed(0);
        this.walls.clear();
        this.obstacles.clear();
        this.walls = Map1.getInstance().makeTerrain();
        this.obstacles = Map1.getInstance().makeObstacles();
        this.finish = Map1.getInstance().makeFinish();
        System.out.println("resetting to start...");
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

    public ArrayList<Obstacle> getObstacles() {
        return this.obstacles;
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

        if (this.keyChecker.getInput() == 'r') {
            reset();
        }

        Player.getInstance().set();

    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Player.getInstance().draw(g);
        for (Wall wall : walls) {
            wall.draw(g);
        }
        for (Obstacle obstacle : obstacles) {
            obstacle.draw(g);
        }
        this.finish.draw(g);
        g.dispose();
    }
}
