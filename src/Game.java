public class Game {
    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        GamePanel gamePanel = new GamePanel();
        Player player = new Player(400, 300, gamePanel);
        gamePanel.makeWalls();
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        gamePanel.startGameThread();

    }
}
