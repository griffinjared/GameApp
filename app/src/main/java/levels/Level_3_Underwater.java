package levels;

import android.content.Context;
import android.graphics.Bitmap;

import levels.levelLayouts.Level_3_Underwater_Layout;
import mob.players.Player;
import rooms.Room;
import rooms.common_rooms.Empty_Room;
import rooms.common_rooms.Exit_Room;
import rooms.common_rooms.Spawn_Room;
import rooms.stage3_underwater.Deep_Water;
import rooms.stage3_underwater.Toxic_Lake;
import rooms.stage3_underwater.Underwater_Cave;

/**
 * Created by griff on 3/23/2016.
 */
public class Level_3_Underwater extends Level {
    private final int SPAWN_X = 1;
    private final int SPAWN_Y = 4;

    public Level_3_Underwater(Context context, Player player, Bitmap spriteSheet) {
        super(context);
        changeTilesSprites(spriteSheet);

        levelLayout = Level_3_Underwater_Layout.generateLevel();
        levelName = "Underwater";
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
                    case 'E': rooms.add(new Empty_Room(context, player, configureDoors(x, y), levelName)); break;
                    case 'S': rooms.add(new Spawn_Room(context, configureDoors(x, y), levelName)); break;
                    case 'X': rooms.add(new Exit_Room(context, player, configureDoors(x, y), levelName)); break;
                    case 'D': rooms.add(new Deep_Water(context, configureDoors(x, y))); break;
                    case 'C': rooms.add(new Underwater_Cave(context, configureDoors(x, y))); break;
                    case 'T': rooms.add(new Toxic_Lake(context, configureDoors(x, y))); break;
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

