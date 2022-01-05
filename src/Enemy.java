import java.awt.Graphics;
import java.awt.Color;

public class Enemy {

    private int x;
    private int y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, 16, 16);
    }
}
