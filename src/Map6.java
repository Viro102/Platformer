import java.util.ArrayList;

public class Map6 {

    private static Map6 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private int oneTile;

    private Map6() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();

        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 2));
        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 8));
        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 16));
        this.terrain.add(new Wall(this.oneTile * 13, this.oneTile * 10));
        this.terrain.add(new Wall(this.oneTile * 11, this.oneTile * 7));
        this.terrain.add(new Wall(this.oneTile * 4, this.oneTile * 6));
        this.terrain.add(new Wall(this.oneTile * 1, this.oneTile * 8));

        for (int i = 7; i < 9; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 4));
        }

        for (int i = 1; i < 4; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 2));
        }

        for (int i = 15; i < 23; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 17));
        }

        for (int i = 18; i < 20; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 14));
        }

        for (int i = 16; i < 18; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 12));
        }

        for (int i = 11; i < 13; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 17));
        }

        for (int i = 6; i < 9; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 17));
        }

        for (int i = 2; i < 5; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 15));
        }

        for (int i = 7; i < 9; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 12));
        }

        for (int i = 3; i < 5; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 10));
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

        for (int i = 0; i < 13; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * 23, this.oneTile * i));
        }

        for (int i = 0; i < 13; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * 29, this.oneTile * i));
        }

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 2, this.oneTile * 1);
        return this.finish;
    }

    public static Map6 getInstance() {
        if (Map6.instance == null) {
            Map6.instance = new Map6();
        }
        return Map6.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}