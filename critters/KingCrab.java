import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;


public class KingCrab extends CrabCritter {



    public KingCrab(){
        setColor(Color.RED);
    }


    public void processActors(ArrayList<Actor> actors) {
        Location loc = getLocation();
        int row = loc.getRow();
        int col = loc.getCol();
        for (Actor a : actors){
            boolean remove = true;
            ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());
            for(Location l:locs){
                if ( ((a.getLocation().getRow() > row && l.getRow() > row + 1) && (a.getLocation().getCol() > col && l.getCol() > col + 1)) ||
		     ((a.getLocation().getRow() > row && l.getRow() > row + 1) && (a.getLocation().getCol() < col && l.getCol() < col - 1)) ||
		     ((a.getLocation().getRow() < row && l.getRow() < row - 1) && (a.getLocation().getCol() > col && l.getCol() > col + 1)) ||
		     ((a.getLocation().getRow() < row && l.getRow() < row - 1) && (a.getLocation().getCol() < col && l.getCol() < col - 1)) ) {

                    a.moveTo(l);
                    remove = false;
                }
	    }
	    if (remove) {
		a.removeSelfFromGrid();
	    }
            
        }
    }
}
