import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Player extends JLabel {

    private GamePanel panel;

    private int x;
    private int y;
    private int width;
    private int height;

    private double xSpeed;
    private double ySpeed;

    private Rectangle hitBox;

    private KeyChecker kChecker;

    public Player(int x, int y, GamePanel panel) {
        this.panel = panel;
        this.x = x;
        this.y = y;

        this.width = 48;
        this.height = 96;
        this.hitBox = new Rectangle(x, y, width, height);
        this.kChecker = new KeyChecker(this);
    }

    public void setMovementRules() {
        // if (this.keyRight && this.keyLeft || !this.keyLeft && !this.keyRight) {
        // this.xSpeed *= 0.8;
        // }

        // osetrenie pohybu, nastavenie max rychlosti...
        if (xSpeed > 0 && xSpeed < 0.75)

        {
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

        ySpeed += 0.3; // gravitacia

        // horizontalna kolizia
        hitBox.x += xSpeed;
        for (Wall wall : panel.getWalls()) {
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
        for (Wall wall : panel.getWalls()) {
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

    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }

    public boolean jump() {
        hitBox.y++;

        for (Wall wall : panel.getWalls()) {
            if (wall.hitBox.intersects(hitBox)) // ak je hrac na zemi moze vyskocit
                ySpeed = -6;
        }

        hitBox.y--; // musim odcitat aby hitbox ostal nezmeneny
        this.y += ySpeed;
        this.hitBox.y = y; // vzdy ked pohnem hraca hitbox sa posunie s nim kvoli koliziam
        return true;

    }

    public boolean crouch() {
        return false;
    }

    public boolean goLeft() {
        this.xSpeed--;
        this.x += xSpeed;
        this.hitBox.x = x; // vzdy ked pohnem hraca hitbox sa posunie s nim kvoli koliziam
        return true;
    }

    public boolean goRight() {
        this.xSpeed++;
        this.x += xSpeed;
        this.hitBox.x = x;
        return true;
    }
}
