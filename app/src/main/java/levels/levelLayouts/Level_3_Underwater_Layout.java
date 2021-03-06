package levels.levelLayouts;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by griff on 3/23/2016.
 */
public class Level_3_Underwater_Layout {
    private static final char EXIT_ROOM = 'X';
    private static final char EMPTY_ROOM = 'E';
    private static final char DEEP_WATER = 'D';
    private static final char TOXIC_WATER = 'T';
    private static final char UNDERWATER_CAVE = 'C';

    public static char[][] generateLevel() {
        ArrayList<Character> rooms = new ArrayList<>();
        rooms.add(EXIT_ROOM);

        char[][] layout = emptyLayout();

        generateBranch(layout, 2, 4, 1, 4, 0);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (y == 0 || y == 8 || x == 0 || x == 8) {
                    layout[y][x] = ' ';
                } else if (y == 4 && x == 1) {
                    layout[y][x] = 'S';
                }
            }
        }

        return layout;
    }

    private static char[][] emptyLayout() {
        char[][] empty = new char[9][9];
        for(int x = 0; x < empty.length; x++) {
            for(int y = 0; y < empty[x].length; y++) {
                empty[x][y] = ' ';
            }
        }
        return empty;
    }

    private static void generateBranch(char[][] layout, int curX, int curY, int lastX, int lastY, int roomCount) {
        Random rand = new Random();
        final int MAX_NUMBER_OF_ROOMS = 20;
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
                    layout[curY][curX] = DEEP_WATER;
                    break;
                case 2:
                    layout[curY][curX] = TOXIC_WATER;
                    break;
                default:
                    layout[curY][curX] = UNDERWATER_CAVE;
                    break;
            }

            switch(nextDirection) {
                case 0:
                    if(curY - 1 != lastY) {
                        generateBranch(layout, curX, curY - 1, curX, curY, roomCount + 1);
                        return;
                    }
                    else {
                        generateBranch(layout, curX, curY, lastX, lastY, roomCount);
                        return;
                    }
                case 1:
                    generateBranch(layout, curX + 1, curY, curX, curY, roomCount + 1);
                    return;
                default:
                    if(curY + 1 != lastY) {
                        generateBranch(layout, curX, curY + 1, curX, curY, roomCount + 1);
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
