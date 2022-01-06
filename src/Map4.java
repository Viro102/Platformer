import java.util.ArrayList;

/**
 * @author Adam Virostek
 * @version 1.0
 */
public class Map4 {

    private static Map4 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private int oneTile;

    private Map4() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 17));
        }

        this.terrain.add(new Wall(this.oneTile * 4, this.oneTile * 14));
        this.terrain.add(new Wall(this.oneTile * 3, this.oneTile * 10));
        this.terrain.add(new Wall(this.oneTile * 7, this.oneTile * 11));
        this.terrain.add(new Wall(this.oneTile * 9, this.oneTile * 13));
        this.terrain.add(new Wall(this.oneTile * 11, this.oneTile * 11));
        this.terrain.add(new Wall(this.oneTile * 14, this.oneTile * 12));
        this.terrain.add(new Wall(this.oneTile * 16, this.oneTile * 13));
        this.terrain.add(new Wall(this.oneTile * 17, this.oneTile * 9));
        this.terrain.add(new Wall(this.oneTile * 21, this.oneTile * 13));
        this.terrain.add(new Wall(this.oneTile * 24, this.oneTile * 11));
        this.terrain.add(new Wall(this.oneTile * 15, this.oneTile * 6));

        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 14));
        this.terrain.add(new Wall(this.oneTile * 27, this.oneTile * 14));

        this.terrain.add(new Wall(this.oneTile * 1, this.oneTile * 7));
        this.terrain.add(new Wall(this.oneTile * 2, this.oneTile * 7));
        this.terrain.add(new Wall(this.oneTile * 1, this.oneTile * 8));
        this.terrain.add(new Wall(this.oneTile * 2, this.oneTile * 8));

        for (int i = 6; i < 9; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 6));
        }

        for (int i = 10; i < 13; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 4));
        }

        for (int i = 4; i < 7; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 2));
        }

        for (int i = 21; i < 27; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 6));
        }

        for (int i = 19; i < 22; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 2));
        }

        for (int i = 25; i < 28; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 3));
        }

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

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 5, this.oneTile * 1);
        return this.finish;
    }

    public static Map4 getInstance() {
        if (Map4.instance == null) {
            Map4.instance = new Map4();
        }
        return Map4.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}
