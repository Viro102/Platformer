public class Game {
    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        GamePanel gamePanel = new GamePanel();
        gamePanel.makeWalls();
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        gamePanel.startGameThread();

    }
}
