import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyChecker implements KeyListener {

    private boolean rightKey;
    private boolean leftKey;
    private boolean upKey;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            this.rightKey = true;
            System.out.println("moving right");
        }
        if (code == KeyEvent.VK_A) {
            this.leftKey = true;
            System.out.println("moving left");
        }
        if (code == KeyEvent.VK_W) {
            this.upKey = true;
            System.out.println("moving up");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            this.rightKey = false;
        }
        if (code == KeyEvent.VK_A) {
            this.leftKey = false;
        }
        if (code == KeyEvent.VK_W) {
            this.upKey = false;
        }

    }

    public char getMovement() {
        if (this.rightKey) {
            return 'd';
        } else if (this.leftKey) {
            return 'a';
        } else if (this.upKey) {
            return 'w';
        }
        return 'x';
    }
}