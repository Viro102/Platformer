import javax.swing.*;
import java.awt.event.*;

public class KeyChecker {

    private Action upAction;
    private Action downAction;
    private Action leftAction;
    private Action rightAction;

    private Player player;

    public KeyChecker(Player player) {

        this.player = player;

        this.upAction = new UpAction();
        this.downAction = new DownAction();
        this.leftAction = new LeftAction();
        this.rightAction = new RightAction();

        this.player.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
        this.player.getActionMap().put("upAction", upAction);

        this.player.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
        this.player.getActionMap().put("downAction", downAction);

        this.player.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
        this.player.getActionMap().put("leftAction", leftAction);

        this.player.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
        this.player.getActionMap().put("rightAction", rightAction);
    }

    public class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.jump();
            System.out.println("moving up");

        }

    }

    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.crouch();
            System.out.println("moving down");

        }

    }

    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.goLeft();
            System.out.println("moving left");

        }

    }

    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.goRight();
            System.out.println("moving right");

        }

    }
}
