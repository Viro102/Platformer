public class Game {
    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);

        gamePanel.startGameThread();

    }
}
