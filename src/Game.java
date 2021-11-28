public class Game {
    public static void main(String[] args) throws Exception {
        MainFrame frame = new MainFrame();
        GamePanel gamePanel = new GamePanel();

        gamePanel.getPlayer().setMovementRules();

        gamePanel.makeWalls();
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        gamePanel.startGameThread();

    }
}
