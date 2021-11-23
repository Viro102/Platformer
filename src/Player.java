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
            hitBox.y++;
            for (Wall wall : panel.walls) {
                if (wall.hitBox.intersects(hitBox)) // ak je hrac na zemi moze vyskocit
                    ySpeed = -6;
            }
            hitBox.y--; // musim odcitat aby hitbox ostal nezmeneny
        }

        ySpeed += 0.3; // gravitacia

        // horizontalna kolizia
        hitBox.x += xSpeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.x -= xSpeed;
                while (!wall.hitBox.intersects(hitBox)) { // toto je kontrola len hitboxu, hrac stale je inde
                    hitBox.x += Math.signum(xSpeed); // signum preto lebo chceme aby kolizie fungovali na obidve strany
                    hitBox.x -= Math.signum(xSpeed);
                    xSpeed = 0;
                    x = hitBox.x;
                }
            }
        }

        // vertikalna kolizia
        hitBox.y += ySpeed;
        for (Wall wall : panel.walls) {
            if (hitBox.intersects(wall.hitBox)) {
                hitBox.y -= ySpeed;
                while (!wall.hitBox.intersects(hitBox)) {
                    hitBox.y += Math.signum(ySpeed);
                    hitBox.y -= Math.signum(ySpeed);
                    ySpeed = 0;
                    y = hitBox.y;
                }
            }
        }

        this.x += xSpeed;
        this.y += ySpeed;

        this.hitBox.x = x; // vzdy ked pohnem hraca hitbox sa posunie s nim kvoli koliziam
        this.hitBox.y = y;

    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLACK);
        gtd.fillRect(x, y, width, height);
    }
}
