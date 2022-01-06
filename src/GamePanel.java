import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Random;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

    private static GamePanel panelInstance = null;

    public static final int TILESIZE = 32; // 32x32 dlazdica

    private final int maxScreenCol = 30;
    private final int maxScreenRow = 20;
    private final int screenWidth = GamePanel.TILESIZE * this.maxScreenCol; // 960 pixels
    private final int screenHeight = GamePanel.TILESIZE * this.maxScreenRow; // 640 pixels

    private Thread gameThread;
    private KeyChecker keyChecker;
    private Finish finish;
    // private Random generator;
    private BufferedImage backgroundPicture;

    private int mapNumber;

    private int fps = 60;

    private ArrayList<Wall> walls;
    private ArrayList<Obstacle> obstacles;

    private GamePanel() {
        this.walls = Map3.getInstance().makeTerrain();
        this.obstacles = Map3.getInstance().makeObstacles();
        this.keyChecker = new KeyChecker();
        // this.generator = new Random();
        try {
            this.backgroundPicture = ImageIO.read(new File("gfx/bg.png"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't find the specified image", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        // this.mapNumber = generator.nextInt(6 - 1) + 1;
        this.mapNumber = 1;
        this.reset(this.mapNumber);
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

    public void reset(int mapNumber) {
        Player.getInstance().setXSpeed(0);
        Player.getInstance().setYSpeed(0);
        this.walls.clear();
        this.obstacles.clear();
        switch (mapNumber) {
            case 1: {
                Player.getInstance().setX(TILESIZE);
                Player.getInstance().setY(TILESIZE * 13);
                this.walls = Map1.getInstance().makeTerrain();
                this.obstacles = Map1.getInstance().makeObstacles();
                this.finish = Map1.getInstance().makeFinish();
                break;
            }
            case 2: {
                Player.getInstance().setX(TILESIZE * 2);
                Player.getInstance().setY(TILESIZE * 11);
                this.walls = Map2.getInstance().makeTerrain();
                this.obstacles = Map2.getInstance().makeObstacles();
                this.finish = Map2.getInstance().makeFinish();
                break;

            }
            case 3: {
                Player.getInstance().setX(TILESIZE);
                Player.getInstance().setY(TILESIZE * 3);
                this.walls = Map3.getInstance().makeTerrain();
                this.obstacles = Map3.getInstance().makeObstacles();
                this.finish = Map3.getInstance().makeFinish();
                break;
            }
            case 4: {
                Player.getInstance().setX(TILESIZE * 11);
                Player.getInstance().setY(TILESIZE * 15);
                this.walls = Map4.getInstance().makeTerrain();
                this.obstacles = Map4.getInstance().makeObstacles();
                this.finish = Map4.getInstance().makeFinish();
                break;
            }
            case 5: {
                Player.getInstance().setX(TILESIZE * 1);
                Player.getInstance().setY(TILESIZE * 2);
                this.walls = Map5.getInstance().makeTerrain();
                this.obstacles = Map5.getInstance().makeObstacles();
                this.finish = Map5.getInstance().makeFinish();
                break;
            }
            case 6: {
                Player.getInstance().setX(TILESIZE * 26);
                Player.getInstance().setY(TILESIZE * 0);
                this.walls = Map6.getInstance().makeTerrain();
                this.obstacles = Map6.getInstance().makeObstacles();
                this.finish = Map6.getInstance().makeFinish();
                break;
            }
        }

        System.out.println("resetting to start...");
    }

    public void hasWon() {
        JOptionPane.showMessageDialog(null, "Congratulations!\nOnto the next level...");
        reset(this.mapNumber++);
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

    public ArrayList<Obstacle> getObstacles() {
        return this.obstacles;
    }

    public Finish getFinish() {
        return this.finish;
    }

    public int getMapNumber() {
        return this.mapNumber;
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
        if (this.keyChecker.getInput() == 'd') {
            Player.getInstance().moveRight();
        }

        if (this.keyChecker.getInput() == 'a') {
            Player.getInstance().moveLeft();
        }

        if (this.keyChecker.getInput() == 'w') {
            Player.getInstance().moveUp();
        }

        if (this.keyChecker.getInput() == 'r') {
            this.reset(this.mapNumber);
        }

        Player.getInstance().setMovementRules();

        if (Player.getInstance().hasWon()) {
            this.hasWon();
        }
    }

    // 2. vykresluje prostredie (renderuje)
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundPicture, 0, 0, null);
        Player.getInstance().draw(g);
        for (Wall wall : this.walls) {
            wall.draw(g);
        }
        for (Obstacle obstacle : this.obstacles) {
            obstacle.draw(g);
        }
        this.finish.draw(g);
        g.dispose();
    }
}
