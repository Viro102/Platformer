import java.util.ArrayList;

public class Map2 {

    private static Map2 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private int oneTile;

    private Finish finish;

    private Map2() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 14));
        }
        this.terrain.add(new Wall(this.oneTile * 6, this.oneTile * 13));
        this.terrain.add(new Wall(this.oneTile * 7, this.oneTile * 13));
        this.terrain.add(new Wall(this.oneTile * 7, this.oneTile * 12));
        for (int i = 13; i > 10; i--) {
            this.terrain.add(new Wall(this.oneTile * 17, this.oneTile * i));
        }
        this.terrain.add(new Wall(this.oneTile * 9, this.oneTile * 9));
        this.terrain.add(new Wall(this.oneTile * 10, this.oneTile * 9));
        this.terrain.add(new Wall(this.oneTile * 11, this.oneTile * 9));

        this.terrain.add(new Wall(this.oneTile * 15, this.oneTile * 8));
        this.terrain.add(new Wall(this.oneTile * 16, this.oneTile * 8));
        this.terrain.add(new Wall(this.oneTile * 17, this.oneTile * 8));

        this.terrain.add(new Wall(this.oneTile * 24, this.oneTile * 14));
        this.terrain.add(new Wall(this.oneTile * 25, this.oneTile * 14));
        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 14));

        this.terrain.add(new Wall(this.oneTile * 24, this.oneTile * 5));
        this.terrain.add(new Wall(this.oneTile * 25, this.oneTile * 5));
        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 5));

        return this.terrain;
    }

    public ArrayList<Obstacle> makeObstacles() {
        this.obstacles = new ArrayList<>();
        // hranice mapy vlavo a vpravo
        for (int i = 0; i < 20; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * -1, this.oneTile * i));
            this.obstacles.add(new Obstacle(this.oneTile * 30, this.oneTile * i));
        }
        // hranica mapy dole
        for (int i = 0; i < 30; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 20));
        }

        for (int i = 8; i < 17; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 13));
        }
        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 25, this.oneTile * 13);
        return this.finish;
    }

    public static Map2 getInstance() {
        if (Map2.instance == null) {
            Map2.instance = new Map2();
        }
        return Map2.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}
