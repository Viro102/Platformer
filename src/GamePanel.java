import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel implements ActionListener {

    private Player player;
    ArrayList<Wall> walls = new ArrayList<>();
    // private Timer gameTimer;

    public GamePanel() {
        JPanel panel = new JPanel(); // na vykreslovanie pouzivam JPanel lebo nema flickering ako JFrame
        panel.setLocation(0, 0);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setVisible(true);

        this.player = new Player(400, 300, this);
    }

    public void paint(Graphics g) {
        // super.paint(g);

        Graphics2D gtd = (Graphics2D) g;

        player.draw(gtd);
        for (Wall wall : walls) {
            wall.draw(gtd);
        }

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
        case 'a':
            player.keyLeft = true;
            break;
        case 'd':
            player.keyRight = true;
            break;
        case 'w':
            player.keyUp = true;
            break;
        case 's':
            player.keyDown = true;
            break;
        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
        case 'a':
            player.keyLeft = false;
            break;
        case 'd':
            player.keyRight = false;
            break;
        case 'w':
            player.keyUp = false;
            break;
        case 's':
            player.keyDown = false;
            break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public void makeWalls() {
        for (int i = 50; i < 650; i += 50) {
            walls.add(new Wall(i, 600, 50, 50));

        }
        walls.add(new Wall(50, 450, 50, 50));
        walls.add(new Wall(50, 500, 50, 50));
        walls.add(new Wall(50, 550, 50, 50));
        walls.add(new Wall(450, 550, 50, 50));
        walls.add(new Wall(600, 450, 50, 50));
        walls.add(new Wall(600, 500, 50, 50));
        walls.add(new Wall(600, 550, 50, 50));

    }
}
