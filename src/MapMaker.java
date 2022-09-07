import java.util.Arrays;
import java.util.Random;

public class MapMaker {
    private String[][] map;
    private String[] mineCoordinates;
    private int mapSize;
    private int mineAmount;

    MapMaker(int mapSize, int mineAmount) {
        this.map = new String[mapSize][mapSize];
        this.mapSize = mapSize;
        this.mineAmount = mineAmount;
    }

    public void makeMap() {
        mineCoordinates = getMineCoordinates(coordinates());

        setMines();
    }

    private void setMines() {
        for (int i = 0; i < mineCoordinates.length; i += 1) {
            String[] coordinate = mineCoordinates[i].split("");

            int xCoordinate = Integer.parseInt(coordinate[0]);
            int yCoordinate = Integer.parseInt(coordinate[1]);

            map[xCoordinate][yCoordinate] = "X";
        }
    }

    private String[] coordinates() {
        String[] coordinates = new String[mapSize * mapSize];

        for (int i = 0; i < coordinates.length; i += 1) {
            if (i < 10) {
                coordinates[i] = "0" + i;

                continue;
            }

            coordinates[i] = Integer.toString(i);
        }

        return coordinates;
    }

    private String[] getMineCoordinates(String[] coordinates) {
        String[] mineCoordinates = coordinates;

        Random random = new Random();

        for (int i = 0; i < 100; i += 1) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);

            String temp = coordinates[x];
            coordinates[x] = coordinates[y];
            coordinates[y] = temp;
        }

        return Arrays.copyOf(mineCoordinates, mineAmount);
    }
}
