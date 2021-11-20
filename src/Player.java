import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {

    private GamePanel panel;

    private int x;
    private int y;
    private int width;
    private int height;

    private double xSpeed;
    private double ySpeed;

    private Rectangle hitBox;

    public boolean keyRight;
    public boolean keyLeft;
    public boolean keyUp;
    public boolean keyDown;

    public Player(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        this.width = 50;
        this.height = 100;
        this.hitBox = new Rectangle(x, y, width, height);
    }

    public void set() {
        if (this.keyRight && this.keyLeft || !this.keyLeft && !this.keyRight) {
            this.xSpeed *= 0.8;
        } else if (this.keyLeft && !this.keyRight) {
            this.xSpeed--;
        } else if (!this.keyLeft && this.keyRight) {
            this.xSpeed++;
        }

        // osetrenie pohybu, nastavenie max rychlosti...
        if (xSpeed > 0 && xSpeed < 0.75) {
            xSpeed = 0;
        }

        if (xSpeed < 0 && xSpeed > -0.75) {
            xSpeed = 0;
        }

        if (xSpeed > 7) {
            xSpeed = 7;
        }

        if (xSpeed < -7) {
            xSpeed = -7;
        }

        if (this.keyUp) {
            // kontrolujem ci sa hrac dotyka zeme
            ySpeed = -6;
        }

        ySpeed += 0.3;

        this.x += xSpeed;
        this.y += ySpeed;

        // vzdy ked pohnem hraca hitbox sa posunie s nim aby som mohol kontrolovat
        // kolizie
        this.hitBox.x = x;
        this.hitBox.y = y;

    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLACK);
        gtd.fillRect(x, y, width, height);
    }
}
