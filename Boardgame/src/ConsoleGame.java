
public class ConsoleGame extends Game{

	/**
	 * Represents a console game. Success at console games always depends on dexterity,
	 *  and may optionally depend on intelligence as well.
	 *
	 * @author james stefanik<jxs5062@gmail.com>
	 */
	
	private boolean usesBrains;
	/**
	 * Whether or not the game uses intelligence
	 */
	
	public ConsoleGame(String name,
            int np,
            boolean usesBrains){
		/**
		 * Constructor, takes three args to set the instance variables
		 *Parameters:
		 *name - Name of the game
		 *np - Number of players that can play the game at once
		 *usesBrains - Whether or not the game uses intelligence
		 */
		super(name,np);
		this.usesBrains = usesBrains;
	
	}
	public void play(){
		/**
		 * Plays the game and chooses a winner. Winner is chosen either as the player with
		 *  highest dexterity (if the game does not use intelligence)
		 *   or highest (dexterity + intelligence) otherwise.
		 */
		System.out.println("Playing " + name + "...");
		double bestval= 0;
		Player winner= null;
		if(usesBrains == true){
			for (Player player : players) {
	            double thisval = player.getDexterity();
	            if (thisval > bestval) {
	                bestval = thisval;
	                winner = player;
	            	}	
				}
			}else{
			for (Player player : players) {
				double thisval = player.getDexterity() + 
						player.getIntelligence();
				if (thisval > bestval) {
					bestval = thisval;
					winner = player;
            		}
            	}
			}
		System.out.println("Winner is " + winner.getName());
	        winner.youWin();
	}
}