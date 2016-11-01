package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.*;

/**
 * A RandomAI is a Controller that always chooses a random blank cell to play.
 */
public class RandomAI extends Controller {

	private final Random random;
	
	public RandomAI(Player me) {
		super(me);
		this.random = new Random();
	}

	@Override
	protected Location nextMove(Game g) {
		//create a list of all available locations;
		List<Location> available = new ArrayList<Location>();
		
		// find available moves
		for (Location loc : Board.LOCATIONS)
			if (g.getBoard().get(loc) == null)
				available.add(loc);
		//create a list of the columns of 
		// wait a bit
		delay();

		// choose a random move
		if (!available.isEmpty())
			return available.get(random.nextInt(available.size()));

		return null;
	}

}
