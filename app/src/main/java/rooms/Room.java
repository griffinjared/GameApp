package rooms;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

import assets.chests.Chest;
import mob.Enemy;
import mob.players.Player;

/** The Room class is essentially an array of Tiles
 *  Each Room will have an integer map of the assortment of Tiles, which are then switched out for actual Tiles
 *  The method getTiles() is called by the Screen class so that each Tile can be individually rendered
 */

public class Room {

    protected int[][] tileLayout = new int[12][12];
    protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    protected Player player;
    protected String name;

    /** Door Layouts
     *  0 - Four-way
     *  1 - 2 Vertical
     *  2 - 2 Horizontal
     *  3 - Corner South/East
     *  4 - Corner South/West
     *  5 - Corner North/East
     *  6 - Corner North/West
     *  7 - Single North
     *  8 - Single South
     *  9 - Single East
     *  10 - Single West
     */

    //Chests will typically be put in individually with specific coordinates instead of on the tileLayout grid
    protected ArrayList<Chest> treasure = new ArrayList<Chest>();

    protected Context context;

    public Room(Context context) {
        this.context = context;

        //map tileLayout formation here.
        /** Layout numbering key:
         *  0 = Wall (Usually surrounding border that prevents player from walking off-screen without a doorway)
         *
         *  1 = Floor, Type 1
         *  2 = Floor, Type 2
         *  3 = Floor, Type 3
         *  4 = Floor, Type 4
         *
         *  5 = Obstacle, Type 1 (Anything that isn't a wall that still blocks the player, like rocks or water in the environment)
         *  6 = Obstacle, Type 2
         *  7 = Obstacle, Type 3
         *  8 = Obstacle, Type 4
         *
         *  9 = Exit
         */
    }

    public void update() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update(this);
        }
    }

    public void draw(Canvas c, Paint p) {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(c, p);
        }
        for (int i = 0; i < treasure.size(); i++) {
            treasure.get(i).draw(c, p);
        }
    }

    public int[][] getTileLayout() {
        return tileLayout;
    }
    public ArrayList<Chest> getTreasures() {
        return treasure;
    }

    //DOORWAY LAYOUTS
    public void defineDoorLayout(int doorLayout) {
        switch(doorLayout) {
            case 0: fourWay(); break;

            case 1: twoWayVertical(); break;
            case 2: twoWayHorizontal(); break;

            case 3: cornerSE(); break;
            case 4: cornerSW(); break;
            case 5: cornerNE(); break;
            case 6: cornerNW(); break;

            case 7: north(); break;
            case 8: south(); break;
            case 9: east(); break;
            case 10: west(); break;

            case 11: three_NES(); break;
            case 12: three_ESW(); break;
            case 13: three_SWN(); break;
            case 14: three_WNE(); break;

            case 15: trap(); break;
        }
    }

    public void trap() {
        tileLayout[0][tileLayout.length/2] = 0; tileLayout[0][(tileLayout.length/2) - 1] = 0; //Top row
        tileLayout[tileLayout.length/2][0] = 0; tileLayout[(tileLayout.length/2) - 1][0] = 0; //Left wall
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 0; tileLayout[(tileLayout.length/2) - 0][tileLayout.length - 1] = 1; //Right wall
        tileLayout[tileLayout.length-1][5] = 0; tileLayout[tileLayout.length-1][6] = 0; //Bottom row
    }

    //Room with 4 exits (all four walls)
    public void fourWay() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Room with 2 vertical exits (top and bottom)
    public void twoWayHorizontal() {
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1;
    }

    //Room with 2 horizontal exits (top and bottom)
    public void twoWayVertical() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Corner - south and east (bottom and right)
    public void cornerSE() {
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Corner - south and west
    public void cornerSW() {
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Corner - north and east
    public void cornerNE() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
    }

    //Corner - north and west
    public void cornerNW() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
    }

    //One exit - North
    public void north() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
    }

    //One exit - South
    public void south() {
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //One exit - East
    public void east() {
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
    }

    //One exit - West
    public void west() {
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
    }

    //Three exits - North, East, South
    public void three_NES() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Three exits - East, South, West
    public void three_ESW() {
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Three exits - South, West, North
    public void three_SWN() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length-1][5] = 1; tileLayout[tileLayout.length-1][6] = 1; //Bottom row
    }

    //Three exits - West, North, East
    public void three_WNE() {
        tileLayout[0][tileLayout.length/2] = 1; tileLayout[0][(tileLayout.length/2) - 1] = 1; //Top row
        tileLayout[tileLayout.length/2][0] = 1; tileLayout[(tileLayout.length/2) - 1][0] = 1; //Left wall
        tileLayout[tileLayout.length/2][tileLayout.length - 1] = 1; tileLayout[(tileLayout.length/2) - 1][tileLayout.length - 1] = 1; //Right wall
    }

    public String getName() {
        return name;
    }
}
