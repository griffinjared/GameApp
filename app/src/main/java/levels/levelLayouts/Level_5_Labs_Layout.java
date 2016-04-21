package levels.levelLayouts;

import java.util.Random;

/**
 * Created by griff on 4/21/2016.
 */
public class Level_5_Labs_Layout {
    private static char EXIT_ROOM = 'X';
    private static char SPAWN_ROOM = 'S';
    private static char EMPTY_ROOM = 'E';
    private static char LAB_ROOM = 'L';
    private static char EXPERIEMENT_ROOM = 'P';
    private static char MESSY_ROOM = 'M';
    private static char BORDER_ROOM = ' ';

    public static char[][] generateLevel() {
        char[][] layout = new char[11][11];
        for(int y = 0; y < 11; y++) {
            for(int x = 0; x < 11; x++) {
                if(x == 0 || x == 10 || y == 0 || y == 10 ) {
                    layout[y][x] = BORDER_ROOM;
                }
                else if(x == 5 && x == y) {
                    layout[y][x] = SPAWN_ROOM;
                }
                else {
                    layout[y][x] = randomRoom();
                }
            }
        }
        return generateExit(layout);
    }

    private static char[][] generateExit(char[][] layout) {
        Random r = new Random();
        int where = r.nextInt(4);
        switch(where) {
            case 0:
                layout[1][r.nextInt(9) + 1] = EXIT_ROOM;
                break;
            case 1:
                layout[10][r.nextInt(9) + 1] = EXIT_ROOM;
                break;
            case 2:
                layout[r.nextInt(9) + 1][1] = EXIT_ROOM;
                break;
            case 3:
                layout[r.nextInt(9) + 1][10] = EXIT_ROOM;
                break;
            default:
                return null;

        }
        return layout;
    }

    private static char randomRoom() {
        Random r = new Random();
        int whichRoom = r.nextInt(4);
        switch(whichRoom) {
            case 0:
                return EMPTY_ROOM;
            case 1:
                return LAB_ROOM;
            case 2:
                return EXPERIEMENT_ROOM;
            case 3:
                return MESSY_ROOM;
            default:
                return randomRoom();
        }
    }

}
