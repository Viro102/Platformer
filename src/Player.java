import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {
    private static Player instance = null;

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

        if (this.xSpeed > 0 && this.xSpeed < 0.75) {
            this.xSpeed = 0;
        }

        if (this.xSpeed < 0 && this.xSpeed > -0.75) { // osetrenie "klzania hraca"
            this.xSpeed = 0;
        }

        if (this.xSpeed > 7) { // nastavenie max rychlosti
            this.xSpeed = 7;
        }

        if (this.xSpeed < -7) { // nastavenie max rychlosti na opacnu stranu
            this.xSpeed = -7;
        }

        this.xSpeed *= 0.9;

        // ySpeed += 0.4; // gravitacia

        this.x += this.xSpeed;
        this.y += this.ySpeed;

        this.hitbox.x = this.x;
        this.hitbox.y = this.y;
    }

    // TODO Kolizie
}