import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] options = { "Start hry", "Zavri hru" };
        int n = JOptionPane.showOptionDialog(null,
                "Ovladanie A - dolava, D - doprava, W - skok\nTvojou ulohou je sa dostat ku modremu policku\nVyhybaj sa cervenym objektom",
                "Uvodne info",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

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
