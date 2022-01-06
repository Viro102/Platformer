import java.util.ArrayList;

public class Map3 {

    private static Map3 instance = null;

    private ArrayList<Wall> terrain;
    private ArrayList<Obstacle> obstacles;

    private Finish finish;

    private int oneTile;

    private Map3() {
        this.oneTile = GamePanel.TILESIZE;
    }

    public ArrayList<Wall> makeTerrain() {
        this.terrain = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 5));
        }

        for (int i = 5; i < 8; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 10));
        }
        // stlp
        for (int i = 11; i < 20; i++) {
            this.terrain.add(new Wall(this.oneTile * 6, this.oneTile * i));
        }

        for (int i = 12; i < 15; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 10));
        }
        // stlp
        for (int i = 11; i < 20; i++) {
            this.terrain.add(new Wall(this.oneTile * 13, this.oneTile * i));
        }

        for (int i = 18; i < 21; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 9));
        }
        // stlp
        for (int i = 10; i < 20; i++) {
            this.terrain.add(new Wall(this.oneTile * 19, this.oneTile * i));
        }

        for (int i = 23; i < 25; i++) {
            this.terrain.add(new Wall(this.oneTile * i, this.oneTile * 7));
        }

        for (int i = 12; i < 20; i++) {
            this.terrain.add(new Wall(this.oneTile * 27, this.oneTile * i));
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

        for (int i = 0; i < 30; i++) {
            this.obstacles.add(new Obstacle(this.oneTile * i, this.oneTile * 1));
        }

        return this.obstacles;
    }

    public Finish makeFinish() {
        this.finish = new Finish(this.oneTile * 27, this.oneTile * 11);
        return this.finish;
    }

    public static Map3 getInstance() {
        if (Map3.instance == null) {
            Map3.instance = new Map3();
        }
        return Map3.instance;
    }

    // TODO nahodny vyber medzi nimi, dokumentacia
}
