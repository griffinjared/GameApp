package levels.levelLayouts;

import java.util.ArrayList;
import java.util.Random;

import rooms.common_rooms.Spawn_Room;

/**
 * Created by griff on 3/2/2016.
 */
public class Level_1_Forest_Layout {
    private static final char EXIT_ROOM = 'X';
    private static final char RIVER_ROOM = 'R';
    private static final char DEFORESTED_ROOM = 'D';
    private static final char EMPTY_ROOM = 'E';
    private static final int TOTAL_ROOMS = 8; //total rooms is the total size of the 2d char array minus 1

    static Random r = new Random();

    public static char[][] generateLevel() {
        ArrayList<Character> rooms = new ArrayList<>();
        rooms.add(EXIT_ROOM);
        for(int i = rooms.size(); i < TOTAL_ROOMS; i++) {
            int whichRoom = r.nextInt() % 5;
            switch(whichRoom) {
                case 0:
                    rooms.add(RIVER_ROOM);
                    break;
                case 1:
                    rooms.add(DEFORESTED_ROOM);
                    break;
                default:
                    rooms.add(EMPTY_ROOM);
                    break;
            }
        }

        char[][] layout = new char[5][5];
        for(int y = 0; y < 5; y++) {
            for(int x = 0; x < 5; x++) {
                if(y == 0 || y == 4 || x == 0 || x == 4) {
                    layout[x][y] = ' ';
                }
                else if(y == 2 && x == 2) {
                    layout[x][y] = 'S';
                }
                else {
                    layout[x][y] = rooms.get(0);
                    rooms.remove(0);
                }
            }
        }

        return layout;
    }
}
