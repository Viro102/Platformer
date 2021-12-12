import java.awt.Graphics;

public class Wall {

    private int x;
    private int y;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void makeWalls(Graphics g) {
        for (int i = 0; i < 16; i++) {
            g.drawRect(x + (48 * i), y, 48, 48);
        }
    }

    // TODO Kolizie, nahodne generovane plosiny
}