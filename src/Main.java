import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] options = { "Start game", "Close game" };
        int n = JOptionPane.showOptionDialog(null,
                "Keybindings:\n A = walk left, D = walk right, W = jump\nThe goal of this game is to reach the blue tile.\nBeware of red tiles!",
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
