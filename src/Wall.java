import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall {

    private int x;
    private int y;

    private Rectangle hitBox;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
        this.hitBox = new Rectangle(this.x, this.y, 32, 32);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, 32, 32);
    }

    public Rectangle getHitbox() {
        return this.hitBox;
    }
}