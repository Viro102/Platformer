import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
    private static Player instance = null;

    private KeyChecker keyChecker;

    private int x;
    private int y;
    private int width;
    private int height;
    private double xSpeed;
    private double ySpeed;

    private Rectangle hitbox;

    private Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.keyChecker = new KeyChecker();
        this.hitbox = new Rectangle();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player(48, 96, 48, 96);
        }

        return instance;
    }

    public void draw(Graphics g) {
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void moveRight() {
        this.xSpeed++;
    }

    public void moveUp() {
        this.ySpeed--;
    }

    public void moveLeft() {
        this.xSpeed--;
    }

    public void set() {

        if (xSpeed > 0 && xSpeed < 0.75) {
            xSpeed = 0;
        }

        if (xSpeed < 0 && xSpeed > -0.75) { // osetrenie "klzania hraca"
            xSpeed = 0;
        }

        if (xSpeed > 7) { // nastavenie max rychlosti
            xSpeed = 7;
        }

        if (xSpeed < -7) { // nastavenie max rychlosti na opacnu stranu
            xSpeed = -7;
        }

        xSpeed *= 0.9;

        // ySpeed += 0.4; // gravitacia

        x += xSpeed;
        y += ySpeed;

        this.hitbox.x = x;
        this.hitbox.y = y;
    }

    // TODO Kolizie
}