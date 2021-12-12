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
            rightKey = true;
            System.out.println("moving right");
        }
        if (code == KeyEvent.VK_A) {
            leftKey = true;
            System.out.println("moving left");
        }
        if (code == KeyEvent.VK_W) {
            upKey = true;
            System.out.println("moving up");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            rightKey = false;
        }
        if (code == KeyEvent.VK_A) {
            leftKey = false;
        }
        if (code == KeyEvent.VK_W) {
            upKey = false;
        }

    }

    public char getMovement() {
        if (rightKey) {
            return 'd';
        } else if (leftKey) {
            return 'a';
        } else if (upKey) {
            return 'w';
        }
        return 'x';
    }
}