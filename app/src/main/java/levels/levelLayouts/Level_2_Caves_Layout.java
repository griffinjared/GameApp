
package levels.levelLayouts;

        import java.util.ArrayList;
        import java.util.Random;

/**
 * Created by griff on 3/2/2016.
 */
public class Level_2_Caves_Layout {
    private static final char EXIT_ROOM = 'X';
    private static final char LAVA_CAVE = 'L';
    private static final char SEA_CAVE = 'S';
    private static final char TALIS_CAVE = 'T';
    private static final char EMPTY_ROOM = 'E';
    private static final int TOTAL_ROOMS = 48; //total rooms is the total size of the 2d char array minus 1

    static Random r = new Random();

    public static char[][] generateLevel() {
        ArrayList<Character> rooms = new ArrayList<>();
        rooms.add(EXIT_ROOM);
        for(int i = rooms.size(); i < TOTAL_ROOMS; i++) {
            int whichRoom = r.nextInt(10);
            switch(whichRoom) {
                case 0:
                case 1:
                    rooms.add(LAVA_CAVE);
                    break;
                case 2:
                case 3:
                    rooms.add(SEA_CAVE);
                    break;
                case 4:
                    rooms.add(TALIS_CAVE);
                    break;
                default:
                    rooms.add(EMPTY_ROOM);
                    break;
            }
        }

        char[][] layout = new char[9][9];
//        for(int y = 6; y >= 0; y--) {
//            for(int x = 6; x >= 0; x--) {
//                if(y == 0 || y == 6 || x == 0 || x == 6) {
//                    layout[x][y] = ' ';
//                }
//                else if(y == 3 && x == 3) {
//                    layout[x][y] = 'S';
//                }
//                else {
//                    layout[x][y] = rooms.get(0);
//                    rooms.remove(0);
//                }
//            }
//        }
        for(int y = 0; y < 9; y++) {
            for(int x = 0; x < 9; x++) {
                if(y == 0 || y == 6 || x == 0 || x == 6) {
                    layout[x][y] = ' ';
                }
                else if(y == 5 && x == 5) {
                    layout[x][y] = 'S';
                }
            }
        }

        return layout;
    }
}

