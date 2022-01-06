import javax.swing.JOptionPane;

/**
 * @author Adam Virostek
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String info = "Hello and Welcome to my first Java Game, hope you enjoy! :D\n"
                + "Keybindings:\n"
                + "A = walk left, D = walk right, W = jump, R = reset back to start\n"
                + "The goal of this game is to reach the blue tile.\n"
                + "Beware of red tiles, also you will die if you go outside the map";
        String[] options = { "Start game", "Close game" };
        int n = JOptionPane.showOptionDialog(null,
                info,
                "Main menu",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

        if (n == 0) {
            MainFrame mainFrame = new MainFrame();
            GamePanel panel = GamePanel.getInstance();
            mainFrame.add(panel);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            panel.startGameThread();
        } else {
            System.exit(0);
        }
    }
}
