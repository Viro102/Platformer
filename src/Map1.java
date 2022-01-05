import java.util.ArrayList;

public class Map1 {

    private static Map1 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Enemy> enemies;

    private Map1() {
    }

    public ArrayList<Wall> makeTerrain() {
        terrain = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            this.terrain.add(new Wall(0 + (GamePanel.tileSize * i), GamePanel.tileSize * 5));
        }

        this.terrain.add(new Wall(GamePanel.tileSize * 6, GamePanel.tileSize * 3));
        this.terrain.add(new Wall(GamePanel.tileSize * 6, GamePanel.tileSize * 4));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 3));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 4));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 2));

        return this.terrain;
    }

    public ArrayList<Enemy> makeEnemies() {
        enemies = new ArrayList<>();
        this.enemies.add(new Enemy(GamePanel.tileSize * 18, GamePanel.tileSize * 14));
        return this.enemies;
    }

    public static Map1 getInstance() {
        if (Map1.instance == null) {
            Map1.instance = new Map1();
        }
        return Map1.instance;
    }
}
