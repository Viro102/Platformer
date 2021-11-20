import java.awt.*;

public class Wall {
    private int x;
    private int y;
    private int width;
    private int height;

    Rectangle hitBox;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        hitBox = new Rectangle(x, y, width, height);

    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(Color.BLACK);
        gtd.drawRect(x, y, width, height);
        gtd.setColor(Color.WHITE);
        gtd.fillRect(x + 1, y + 1, width - 2, height - 2);

    }
}
