package controller;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Game;
import model.Location;
import model.NotImplementedException;
import model.Player;

/**
 * A DumbAI is a Controller that always chooses the blank space with the
 * smallest column number from the row with the smallest row number.
 */
public class DumbAI extends Controller {

	public DumbAI(Player me) {
		super(me);
		
	}
//	private List<Integer> mergeSort(List<Integer> list){
//		//If list is empty; no need to do anything
//        if (list.size() <= 1) {
//            return list;
//        }
//         
//        //Split the array in half in two parts
//        List<Integer> first = list.subList(0, list.size()/2);
//        List<Integer> second = list.subList(list.size()/2, list.size());
//        
//         
//        //Sort each half recursively
//        mergeSort(first);
//        mergeSort(second);
//         
//        //Merge both halves together, overwriting to original array
//        merge(first, second, list);
//        return list;
//	}
	protected @Override Location nextMove(Game g) {
		// Note: Calling delay here will make the CLUI work a little more
		// nicely when competing different AIs against each other.
		
		//create a list of available locations.
		List<Location> available = new ArrayList<Location>();
		// find available moves
				for (Location loc : Board.LOCATIONS)
					if (g.getBoard().get(loc) == null)
						available.add(loc);
				//create a list of the columns of 
				// wait a bit
				delay();
		//create a list of column numbers of all available spaces.
				List<Integer> availableColumns = new ArrayList<>();
		for(Location loc: available){
			availableColumns.add(loc.col);
		}
		//find minimum column of available space
		int minC=availableColumns.get(0);
		for(int col: availableColumns){
			if(col<=minC) minC=col;
		}
		//create a list of row numbers of available spaces with column min
		List<Integer> availableRows = new ArrayList<>();
		for(Location loc: available){
			if(loc.col==minC) availableRows.add(loc.row);
		}
		//find minimum row of available space with column min
				int minR=availableRows.get(0);
				for(int row: availableRows){
					if(row<=minR) minR=row;
				}
		Location play=new Location(minR, minC);
		System.out.println(play);
		return play;
		
		// find available moves
		
	}
}
