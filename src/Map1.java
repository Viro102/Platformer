import java.util.ArrayList;

public class Map1 {

    private static Map1 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Map1() {
    }

    public ArrayList<Wall> makeTerrain() {
        terrain = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            this.terrain.add(new Wall(0 + (GamePanel.tileSize * i), GamePanel.tileSize * 5));
        }

        this.terrain.add(new Wall(GamePanel.tileSize * 6, GamePanel.tileSize * 3));
        this.terrain.add(new Wall(GamePanel.tileSize * 6, GamePanel.tileSize * 4));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 3));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 4));
        this.terrain.add(new Wall(GamePanel.tileSize * 12, GamePanel.tileSize * 2));

        return this.terrain;
    }

    public ArrayList<Obstacle> makeObstacles() {
        obstacles = new ArrayList<>();
        // hranice mapy vlavo a vpravo
        for (int i = 0; i < 20; i++) {
            this.obstacles.add(new Obstacle(GamePanel.tileSize * -1, GamePanel.tileSize * i));
            this.obstacles.add(new Obstacle(GamePanel.tileSize * 30, GamePanel.tileSize * i));
        }
        // hranica mapy dole
        for (int i = 0; i < 30; i++) {
            this.obstacles.add(new Obstacle(GamePanel.tileSize * i, GamePanel.tileSize * 20));
        }

        this.obstacles.add(new Obstacle(GamePanel.tileSize * 7, GamePanel.tileSize * 4));
        this.obstacles.add(new Obstacle(GamePanel.tileSize * 8, GamePanel.tileSize * 4));
        this.obstacles.add(new Obstacle(GamePanel.tileSize * 9, GamePanel.tileSize * 4));
        this.obstacles.add(new Obstacle(GamePanel.tileSize * 10, GamePanel.tileSize * 4));
        this.obstacles.add(new Obstacle(GamePanel.tileSize * 11, GamePanel.tileSize * 4));

        return this.obstacles;
    }

    public static Map1 getInstance() {
        if (Map1.instance == null) {
            Map1.instance = new Map1();
        }
        return Map1.instance;
    }
}
