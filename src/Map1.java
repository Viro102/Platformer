import java.util.ArrayList;

public class Map1 {

    private static Map1 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private Map1() {
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            this.terrain.add(new Wall(0 + (GamePanel.TILESIZE * i), GamePanel.TILESIZE * 5));
        }

        this.terrain.add(new Wall(GamePanel.TILESIZE * 6, GamePanel.TILESIZE * 3));
        this.terrain.add(new Wall(GamePanel.TILESIZE * 6, GamePanel.TILESIZE * 4));
        this.terrain.add(new Wall(GamePanel.TILESIZE * 12, GamePanel.TILESIZE * 3));
        this.terrain.add(new Wall(GamePanel.TILESIZE * 12, GamePanel.TILESIZE * 4));
        this.terrain.add(new Wall(GamePanel.TILESIZE * 12, GamePanel.TILESIZE * 2));

        return this.terrain;
    }

    public ArrayList<Obstacle> makeObstacles() {
        this.obstacles = new ArrayList<>();
        // hranice mapy vlavo a vpravo
        for (int i = 0; i < 20; i++) {
            this.obstacles.add(new Obstacle(GamePanel.TILESIZE * -1, GamePanel.TILESIZE * i));
            this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 30, GamePanel.TILESIZE * i));
        }
        // hranica mapy dole
        for (int i = 0; i < 30; i++) {
            this.obstacles.add(new Obstacle(GamePanel.TILESIZE * i, GamePanel.TILESIZE * 20));
        }

        this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 7, GamePanel.TILESIZE * 4));
        this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 8, GamePanel.TILESIZE * 4));
        this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 9, GamePanel.TILESIZE * 4));
        this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 10, GamePanel.TILESIZE * 4));
        this.obstacles.add(new Obstacle(GamePanel.TILESIZE * 11, GamePanel.TILESIZE * 4));

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(GamePanel.TILESIZE * 24, GamePanel.TILESIZE * 4);
        return this.finish;
    }

    public static Map1 getInstance() {
        if (Map1.instance == null) {
            Map1.instance = new Map1();
        }
        return Map1.instance;
    }
}
