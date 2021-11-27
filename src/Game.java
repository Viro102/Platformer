public class Game {
    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        gamePanel.startGameThread();

        Player player = new Player(400, 300, gamePanel);

    }
}
