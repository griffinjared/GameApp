
package levels.levelLayouts;

        import java.util.ArrayList;
        import java.util.Random;

/**
 * Created by griff on 3/2/2016.
 */
public class Level_2_Caves_Layout {
    private static final char EXIT_ROOM = 'X';
    private static final char LAVA_CAVE = 'L';
    private static final char SEA_CAVE = 'O';
    private static final char TALIS_CAVE = 'T';
    private static final char EMPTY_ROOM = 'E';

    static Random r = new Random();

    public static char[][] generateLevel() {
        ArrayList<Character> rooms = new ArrayList<>();
        rooms.add(EXIT_ROOM);

        char[][] layout = new char[9][9];

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (y == 0 || y == 6 || x == 0 || x == 6) {
                    layout[x][y] = ' ';
                } else if (y == 5 && x == 5) {
                    layout[x][y] = 'S';
                }
            }
        }

        generateCaves(5, 5, 4, 5, layout, 0);
        generateCaves(5, 5, 6, 5, layout, 0);
        generateCaves(5, 5, 5, 4, layout, 0);
        generateCaves(5, 5, 5, 6, layout, 0);

        return layout;
    }

    private static boolean generateCaves(int lastX, int lastY, int curX, int curY, char[][] layout, int numberOfRooms) {
        Random rand = new Random();
        int count = numberOfRooms;
        int newRoom = rand.nextInt(6);
        int direction = rand.nextInt(4);

        switch (newRoom) {
            case 0:
            case 1:
                layout[curX][curY] = LAVA_CAVE;
                break;
            case 2:
            case 3:
                layout[curX][curY] = SEA_CAVE;
                break;
            case 4:
                layout[curX][curY] = TALIS_CAVE;
                break;
            default:
                layout[curX][curY] = EMPTY_ROOM;
                break;
        }
        count++;

        if (curX == 0 || curX == 8 || curY == 0 || curY == 8) {
            if (!isBossRoomGenerated(layout)) {
                layout[lastX][lastY] = 'X';
            }
            return true;
        }

        if(count == 20) {
            return false;
        }

        //0 = up, 1 = right, 2 = down, 3 = left
        switch (direction) {
            case 0:
                if (curY - 1 != lastY) {
                    return generateCaves(curX, curY, curX, curY - 1, layout, count);
                } else {
                    return generateCaves(lastX, lastY, curX, curY, layout, count - 1);
                }
            case 1:
                if (curX + 1 != lastX) {
                    return generateCaves(curX, curY, curX + 1, curY, layout, count);
                } else {
                    return generateCaves(lastX, lastY, curX, curY, layout, count - 1);
                }
            case 2:
                if (curY + 1 != lastY) {
                    return generateCaves(curX, curY, curX, curY + 1, layout, count);
                } else {
                    return generateCaves(lastX, lastY, curX, curY, layout, count - 1);
                }
            default:
                if (curX - 1 != lastX) {
                    return generateCaves(curX, curY, curX - 1, curY, layout, count);
                } else {
                    return generateCaves(lastX, lastY, curX, curY, layout, count - 1);
                }
        }
    }

    private static boolean isBossRoomGenerated(char[][] layout) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (layout[i][j] == 'X') {
                    return true;
                }
            }
        }
        return false;

    }
}
