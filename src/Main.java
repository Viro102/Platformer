public class Main {
    private static MainFrame mainFrame;
    private static GamePanel panel;

    public static void main(String[] args) throws Exception {
        mainFrame = new MainFrame();
        panel = GamePanel.getInstance();
        mainFrame.add(panel);
        mainFrame.setVisible(true);
        mainFrame.pack();
        panel.startGameThread();
    }
}
