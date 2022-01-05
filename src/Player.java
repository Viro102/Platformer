import java.awt.Color;
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
    private boolean win;

    private Rectangle hitbox;

    private Player(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hitbox = new Rectangle(x, y, width, height);
    }

    public static Player getInstance() {
        if (Player.instance == null) {
            Player.instance = new Player(32, 96, 32, 64);
        }

        return Player.instance;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void moveRight() {
        this.xSpeed++;
    }

    public void moveUp() {
        // odrazi sa len vtedy ak je hrac na plosine
        hitbox.y++;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (hitbox.intersects(wall.getHitbox())) {
                this.ySpeed = -8;
            }
        }
        hitbox.y--;

    }

    public void moveLeft() {
        this.xSpeed--;
    }

    public void set() {

        // osetrenie "klzania hraca"
        if ((this.xSpeed < 0 && this.xSpeed > -0.75) || (this.xSpeed > 0 && this.xSpeed < 0.75)) {
            this.xSpeed = 0;
        }

        // nastavenie max rychlosti
        if (this.xSpeed > 7) {
            this.xSpeed = 7;
        }

        // nastavenie max rychlosti na opacnu stranu
        if (this.xSpeed < -7) {
            this.xSpeed = -7;
        }

        this.xSpeed *= 0.9;

        // gravitacia
        this.ySpeed += 0.4;

        boolean hasCollided = false;

        // Horizontalna kolizia pre steny
        hitbox.x += xSpeed;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (hitbox.intersects(wall.getHitbox())) {
                hitbox.x -= xSpeed;
                while (!wall.getHitbox().intersects(hitbox)) {
                    hitbox.x += Math.signum(xSpeed);
                }
                hitbox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitbox.x;
            }
        }

        for (Obstacle obstacle : GamePanel.getInstance().getObstacles()) {
            if (hitbox.intersects(obstacle.getHitbox())) {
                hasCollided = true;
            }
        }

        if (hitbox.intersects(GamePanel.getInstance().getFinish().getHitbox())) {
            this.win = true;
        }

        // Vertikalna kolizia pre steny
        hitbox.y += ySpeed;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (hitbox.intersects(wall.getHitbox())) {
                hitbox.y -= ySpeed;
                while (!wall.getHitbox().intersects(hitbox)) {
                    hitbox.y += Math.signum(ySpeed);
                }
                hitbox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitbox.y;
            }
        }

        for (Obstacle obstacle : GamePanel.getInstance().getObstacles()) {
            if (hitbox.intersects(obstacle.getHitbox())) {
                hasCollided = true;
            }
        }

        if (hasCollided) {
            GamePanel.getInstance().reset();
        }

        this.x += this.xSpeed;
        this.y += this.ySpeed;

        this.hitbox.x = this.x;
        this.hitbox.y = this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXSpeed(double x) {
        this.xSpeed = x;
    }

    public void setYSpeed(double y) {
        this.ySpeed = y;
    }

    public boolean hasWon() {
        if (this.win) {
            return true;
        } else {
            return false;
        }
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}