import javax.swing.*;
import java.awt.event.*;

public class KeyChecker {

    private Action upAction;
    private Action downAction;
    private Action leftAction;
    private Action rightAction;

    private Player player;

    public KeyChecker() {
        upAction = new UpAction();
        downAction = new DownAction();
        leftAction = new LeftAction();
        rightAction = new RightAction();

        player.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
        player.getActionMap().put("upAction", upAction);

        player.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
        player.getActionMap().put("downAction", downAction);

        player.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
        player.getActionMap().put("leftAction", leftAction);

        player.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
        player.getActionMap().put("rightAction", rightAction);
    }

    public class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.setKey('w');
            player.jump();

        }

    }

    public class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.setKey('s');
            player.crouch();

        }

    }

    public class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.setKey('a');
            player.goLeft();

        }

    }

    public class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            player.setKey('d');
            player.goRight();

        }

    }
}
