import java.util.ArrayList;

public class Map5 {

    private static Map5 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private int oneTile;

    private Map5() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 4));
        }

        for (int i = 2; i < 5; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 8));
        }

        for (int i = 0; i < 3; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 12));
        }

        for (int i = 18; i < 22; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 3));
        }

        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 3));
        this.terrain.add(new Wall(this.oneTile * 23, this.oneTile * 6));
        this.terrain.add(new Wall(this.oneTile * 26, this.oneTile * 8));

        for (int i = 23; i < 27; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 11));
        }

        for (int i = 20; i < 23; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 13));
        }

        for (int i = 15; i < 19; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 15));
        }

        for (int i = 4; i < 10; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 15));
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

        for (int i = 5; i < 18; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 0));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 1));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 2));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 3));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 4));
        }

        for (int i = 5; i < 7; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 5));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 6));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 7));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 8));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 9));
        }

        for (int i = 28; i < 30; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 0));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 1));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 2));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 3));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 4));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 5));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 6));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 7));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 8));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 9));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 10));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 11));
        }

        for (int i = 11; i < 14; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 14));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 15));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 16));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 17));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 18));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 19));
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 20));
        }

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 19, this.oneTile * 2);
        return this.finish;
    }

    public static Map5 getInstance() {
        if (Map5.instance == null) {
            Map5.instance = new Map5();
        }
        return Map5.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}