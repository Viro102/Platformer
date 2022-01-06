import java.util.ArrayList;

public class Map1 {

    private static Map1 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private int oneTile;

    private Map1() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 16));
        }

        for (int i = 23; i < 30; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 6));
        }
        for (int i = 22; i < 30; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 7));
        }

        for (int i = 7; i < 10; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 13));
        }

        for (int i = 13; i < 16; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 13));
        }

        for (int i = 18; i < 21; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 10));
        }

        this.terrain.add(new Wall(this.oneTile * 24, this.oneTile * 5));
        this.terrain.add(new Wall(this.oneTile * 24, this.oneTile * 4));

        this.terrain.add(new Wall(this.oneTile * 28, this.oneTile * 5));
        this.terrain.add(new Wall(this.oneTile * 28, this.oneTile * 4));
        this.terrain.add(new Wall(this.oneTile * 28, this.oneTile * 3));

        this.terrain.add(new Wall(this.oneTile * 29, this.oneTile * 5));
        this.terrain.add(new Wall(this.oneTile * 29, this.oneTile * 4));
        this.terrain.add(new Wall(this.oneTile * 29, this.oneTile * 3));

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

        this.obstacles.add(new Obstacle(this.oneTile * 26, this.oneTile * 5));
        this.obstacles.add(new Obstacle(this.oneTile * 27, this.oneTile * 5));
        this.obstacles.add(new Obstacle(this.oneTile * 25, this.oneTile * 5));

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 29, this.oneTile * 2);
        return this.finish;
    }

    public static Map1 getInstance() {
        if (Map1.instance == null) {
            Map1.instance = new Map1();
        }
        return Map1.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}
