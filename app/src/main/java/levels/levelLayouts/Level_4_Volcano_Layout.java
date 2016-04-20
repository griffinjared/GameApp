package levels.levelLayouts;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by griff on 3/23/2016.
 */
public class Level_4_Volcano_Layout {
    private static final char EXIT_ROOM = 'X';
    private static final char EMPTY_ROOM = 'E';
    private static final char CHAMBER = 'C';
    private static final char LAVA_POOL = 'P';
    private static final char LAVA_RIVER = 'R';

    public static char[][] generateLevel() {
        ArrayList<Character> rooms = new ArrayList<>();
        rooms.add(EXIT_ROOM);

        char[][] layout = emptyLayout();

        generateBranch(layout, 5, 8, 5, 9, 0);

        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 11; x++) {
                if (y == 0 || y == 10 || x == 0 || x == 10) {
                    layout[y][x] = ' ';
                } else if (y == 9 && x == 5) {
                    layout[y][x] = 'S';
                }
            }
        }

        return layout;
    }

    private static char[][] emptyLayout() {
        char[][] empty = new char[11][11];
        for(int x = 0; x < empty.length; x++) {
            for(int y = 0; y < empty[x].length; y++) {
                empty[x][y] = ' ';
            }
        }
        return empty;
    }

    private static void generateBranch(char[][] layout, int curX, int curY, int lastX, int lastY, int roomCount) {
        Random rand = new Random();
        final int MAX_NUMBER_OF_ROOMS = 30;
        if(curX == 0 || curY == 0 || curX == layout.length - 1 || curY == layout.length - 1 || roomCount >= MAX_NUMBER_OF_ROOMS) {
            layout[curY][curX] = ' ';
            if(!isExitRoomGenerated(layout)) {
                layout[lastY][lastX] = EXIT_ROOM;
            }
            return;
        }
        else {
            int whichRoom = rand.nextInt(4);
            int nextDirection = rand.nextInt(3);
            int shouldCreateNewBranch = rand.nextInt(10);

            if(shouldCreateNewBranch < 1) {
                generateBranch(layout, curX, curY, lastX, lastY, roomCount);
            }
            System.out.println("next direction: " + nextDirection);
            switch(whichRoom) {
                case 0:
                    layout[curY][curX] = EMPTY_ROOM;
                    break;
                case 1:
                    layout[curY][curX] = CHAMBER;
                    break;
                case 2:
                    layout[curY][curX] = LAVA_POOL;
                    break;
                default:
                    layout[curY][curX] = LAVA_RIVER;
                    break;
            }

            switch(nextDirection) {
                case 0:
                    if(curX - 1 != lastX) {
                        generateBranch(layout, curX - 1, curY, curX, curY, roomCount + 1);
                        return;
                    }
                    else {
                        generateBranch(layout, curX, curY, lastX, lastY, roomCount);
                        return;
                    }
                case 1:
                    generateBranch(layout, curX, curY - 1, curX, curY, roomCount + 1);
                    return;
                default:
                    if(curX + 1 != lastX) {
                        generateBranch(layout, curX + 1, curY, curX, curY, roomCount + 1);
                        return;
                    }
                    else {
                        generateBranch(layout, curX, curY, lastX, lastY, roomCount);
                        return;
                    }
            }
        }
    }

    private static boolean isExitRoomGenerated(char[][] layout) {
        for(char[] rows : layout) {
            for(char room : rows) {
                if(room == EXIT_ROOM) {
                    return true;
                }
            }
        }
        return false;
    }
}

