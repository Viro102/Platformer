import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Adam Virostek
 * @version 1.0
 */
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

    /**
     * Allows the player to jump only if touching goound
     */
    public void moveUp() {
        this.hitbox.y++;
        for (Wall wall : GamePanel.getInstance().getWalls()) {
            if (this.hitbox.intersects(wall.getHitbox())) {
                this.ySpeed = -8.55; // Jump height, this value feels adequate
            }
        }
        this.hitbox.y--;

    }

    public void moveLeft() {
        this.xSpeed--;
    }

    /**
     * Correctly sets all movement rules and physics
     */
    public void setMovementRules() {

        // Fix for player "sliding" if not holding move key
        if ((this.xSpeed < 0 && this.xSpeed > -0.75) || (this.xSpeed > 0 && this.xSpeed < 0.75)) {
            this.xSpeed = 0;
        }

        // Sets the max speed
        if (this.xSpeed > 7) {
            this.xSpeed = 7;
        }

        // Sets the max speed the other way
        if (this.xSpeed < -7) {
            this.xSpeed = -7;
        }

        // Acceleration
        this.xSpeed *= 0.9;

        // Gravity
        this.ySpeed += 0.4;

        boolean hasCollided = false;

        // Checks for horizontal collisions
        // inspired by RedFlyer Coding at youtube.com
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

        // Checks for vertical collisions
        // inspired by RedFlyer Coding at youtube.com
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