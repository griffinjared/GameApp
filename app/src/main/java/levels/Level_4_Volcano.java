package levels;

import android.content.Context;
import android.graphics.Bitmap;

import levels.Level;
import levels.levelLayouts.Level_4_Volcano_Layout;
import mob.players.Player;
import rooms.Room;
import rooms.common_rooms.Empty_Room;
import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;
import rooms.stage4_volcano.Chamber;
import rooms.stage4_volcano.Lava_Pool;
import rooms.stage4_volcano.Lava_River;

public class Level_4_Volcano extends Level {
    private final int SPAWN_X = 5;
    private final int SPAWN_Y = 9;

    public Level_4_Volcano(Context context, Player player, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);

        levelLayout = Level_4_Volcano_Layout.generateLevel();
        levelName = "Volcano";
        for(char[] row : levelLayout) {
            for(char r : row) {
                if(r == ' ')
                    System.out.print('-');
                else {
                    System.out.print(r);
                }
            }
            System.out.println("");
        }

        for (int y = 0; y < levelLayout.length; y++) {
            for (int x = 0; x < levelLayout[y].length; x++) {
                switch(levelLayout[y][x]) {
                    case 'E': rooms.add(new Empty_Room(context, player, configureDoors(x, y))); break;
                    case 'S': rooms.add(new Spawn_Room(context, configureDoors(x, y))); break;
                    case 'X': rooms.add(new Exit_Room(context, player, configureDoors(x, y))); break;
                    case 'P': rooms.add(new Lava_Pool(context, configureDoors(x, y))); break;
                    case 'C': rooms.add(new Chamber(context, configureDoors(x, y))); break;
                    case 'R': rooms.add(new Lava_River(context, configureDoors(x, y))); break;
                    default: rooms.add(new Room(context)); break;
                }
            }
        }

        roomY = SPAWN_Y;
        roomX = SPAWN_X;
        currentRoom = rooms.get(roomX + (roomY * levelLayout[roomX].length));
    }

    public Room changeRoom(int roomX, int roomY) {
        return rooms.get(roomX + (roomY*levelLayout[roomX].length));
    }

    public int configureDoors(int roomX, int roomY) {
        boolean north = true, south = true, east = true, west = true;

        if (levelLayout[roomY-1][roomX] == ' ') north = false; //north
        if (levelLayout[roomY+1][roomX] == ' ') south = false; //south
        if (levelLayout[roomY][roomX-1] == ' ') west = false; //west
        if (levelLayout[roomY][roomX+1] == ' ') east = false; //east

        //Assignment
        if (north && south && east && west) return 0;

        else if (north && east && south) return 11;
        else if (east && south && west) return 12;
        else if (south && west && north) return 13;
        else if (west && north && east) return 14;

        else if (north && south) return 1;
        else if (east && west) return 2;

        else if (south && east) return 3;
        else if (south && west) return 4;
        else if (north && east) return 5;
        else if (north && west) return 6;

        else if (north) return 7;
        else if (south) return 8;
        else if (east) return 9;
        else if (west) return 10;

        else return 15;
    }
}
