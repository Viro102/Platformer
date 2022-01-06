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
            Player.instance = new Player(0, 0, 32, 64);
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
        // Hrac vyskoci len vtedy ak je na plosine
        this.hitbox.y++;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (this.hitbox.intersects(wall.getHitbox())) {
                this.ySpeed = -8.55;
            }
        }
        this.hitbox.y--;

    }

    public void moveLeft() {
        this.xSpeed--;
    }

    public void setMovementRules() {

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

        // Horizontalna kolizia
        this.hitbox.x += this.xSpeed;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (this.hitbox.intersects(wall.getHitbox())) {
                this.hitbox.x -= this.xSpeed;
                while (!this.hitbox.intersects(wall.getHitbox())) {
                    this.hitbox.x += Math.signum(this.xSpeed);
                }
                this.hitbox.x -= Math.signum(this.xSpeed);
                this.xSpeed = 0;
                this.x = this.hitbox.x;
            }
        }

        for (Obstacle obstacle : GamePanel.getInstance().getObstacles()) {
            if (this.hitbox.intersects(obstacle.getHitbox())) {
                hasCollided = true;
            }
        }

        if (this.hitbox.intersects(GamePanel.getInstance().getFinish().getHitbox())) {
            this.win = true;
        }

        // Vertikalna kolizia
        this.hitbox.y += this.ySpeed;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (this.hitbox.intersects(wall.getHitbox())) {
                this.hitbox.y -= this.ySpeed;
                while (!this.hitbox.intersects(wall.getHitbox())) {
                    this.hitbox.y += Math.signum(this.ySpeed);
                }
                this.hitbox.y -= Math.signum(this.ySpeed);
                this.ySpeed = 0;
                this.y = this.hitbox.y;
            }
        }

        for (Obstacle obstacle : GamePanel.getInstance().getObstacles()) {
            if (this.hitbox.intersects(obstacle.getHitbox())) {
                hasCollided = true;
            }
        }

        if (hasCollided) {
            GamePanel.getInstance().reset(GamePanel.getInstance().getMapNumber());
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
        return this.win;
    }

}