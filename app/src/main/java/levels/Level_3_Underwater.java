package levels;

import android.content.Context;
import android.graphics.Bitmap;

import levels.levelLayouts.Level_2_Caves_Layout;
import levels.levelLayouts.Level_3_Underwater_Layout;
import rooms.Room;
import rooms.common_rooms.Empty_Room;
import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;
import rooms.stage2_caves.Lava_Cave;
import rooms.stage2_caves.Sea_Cave;
import rooms.stage2_caves.Talis_Cave;
import rooms.stage3_underwater.Deep_Water;
import rooms.stage3_underwater.Toxic_Lake;
import rooms.stage3_underwater.Underwater_Cave;

/**
 * Created by griff on 3/23/2016.
 */
public class Level_3_Underwater extends Level {
    private final int SPAWN_X = 1;
    private final int SPAWN_Y = 4;

    public Level_3_Underwater(Context context, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);

        levelLayout = Level_3_Underwater_Layout.generateLevel();

        for (int y = 0; y < levelLayout.length; y++) {
            for (int x = 0; x < levelLayout[y].length; x++) {
                switch(levelLayout[y][x]) {
                    case 'E': rooms.add(new Empty_Room(context, configureDoors(x, y))); break;
                    case 'S': rooms.add(new Spawn_Room(context, configureDoors(x, y))); break;
                    case 'X': rooms.add(new Exit_Room(context, configureDoors(x, y))); break;
                    case 'D': rooms.add(new Deep_Water(context, configureDoors(x, y))); break;
                    case 'T': rooms.add(new Toxic_Lake(context, configureDoors(x, y))); break;
                    case 'C': rooms.add(new Underwater_Cave(context, configureDoors(x, y))); break;
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
        boolean north = false, south = false, east = false, west = false;

        if (levelLayout[roomY-1][roomX] != ' ') north = true; //north
        if (levelLayout[roomY+1][roomX] != ' ') south = true; //south
        if (levelLayout[roomY][roomX-1] != ' ') west = true; //west
        if (levelLayout[roomY][roomX+1] != ' ') east = true; //east

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

