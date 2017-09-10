package GameBoard;

import java.util.Arrays;
import java.util.Comparator;

public class ScoreBoard {
	private int numOfEntries;
	private GameEntry[] gameEntries;
	
    private Comparator<GameEntry> comparatorByVal = new Comparator<GameEntry>() {
        @Override
        public int compare(GameEntry o1, GameEntry o2) {
            if (o1 == null && o2 == null) return 0; 
            else if (o1 == null) return 1;  
            else if (o2 == null) return -1;
            if(o1.getScore() == o2.getScore()){
    			return 0;
    		}
    		else if(o1.getScore() >= o2.getScore()){
    			return -1;
    		}
    		return 1;
    }};
    
	public ScoreBoard(int maxEntries){
		this.gameEntries = new GameEntry[maxEntries];
		this.numOfEntries=0;
	}
	
	/**
	 * Method used for adding a GameEntry
	 * @param ge is the GameEntry to be added 
	 * @throws Exception if the ScoreBoard is full
	 */
	public void addGameEntry(GameEntry ge) throws Exception{
		int index = lookUpEntry(ge.getName());
		if(index != -1){
			 this.gameEntries[index].setScore(ge.getScore());
		}
		else{
			if(this.numOfEntries<this.gameEntries.length){
				this.gameEntries[numOfEntries] = ge;
				this.numOfEntries++;
				Arrays.parallelSort(this.gameEntries,comparatorByVal);
			}
			else{
				throw new Exception("Limit of ScoreBoard entries reached");
			}
		}
	}
	
	/**
	 * Method used for removing a GameEntry
	 * @param name string of GameEntry to remove
	 * @throws Exception if there's no such player in ScoreBoard
	 */
	public void removeGameEntry(String name)throws Exception{
		int index = lookUpEntry(name);
		if(index!=-1){
			this.gameEntries[index] = null;
			Arrays.sort(this.gameEntries,comparatorByVal);
			this.numOfEntries--;
		}
		else{
			throw new Exception("Invalid player. No such player in ScoreBoard.");
		}
	}
	
	/**
	 * Method for incrementing the score of a player.
	 * @param name string of GameEntry to modify
	 * @param score amount to add to current score of the GameEntry
	 * @throws Exception if there's no such player in ScoreBoard
	 */
	public void incrementGameEntryScore(String name, int score) throws Exception{
		int index = lookUpEntry(name);
		if(index!=-1){
			this.gameEntries[index].incrementScore(score);;
			Arrays.sort(this.gameEntries,comparatorByVal);
		}
		else{
			throw new Exception("Invalid player. No such player in ScoreBoard.");
		}
	}
	
	/**
	 * Method for checking if a GameEntry with the name exists 
	 * @param s is the name of the GameEntry to check
	 * @return index location of the GameEntry object or-1 if it doesn't exist
	 */
	public int lookUpEntry(String s){
		for(int i=0; i<this.numOfEntries; i++){
			if(this.gameEntries[i].getName().equals(s)){
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param rank of player in the ScoreBoard to look for
	 * @return the GameEntry in that rank
	 * @throws Exception if there's not GameEntry in given rank 
	 */
	public GameEntry getRunnerInRank(int rank)throws Exception{
		if(rank > this.numOfEntries || rank<=0){
			throw new Exception("Invalid rank. ScoreBoard doesn't contain that rank.");
		}
		return gameEntries[rank-1];
	}
	
	/**
	 * Method is used for finding out the rank of a player.
	 * @param runner string name of player to look for
	 * @return rank of player in the ScoreBoard
	 * @throws Exception if there's no such player in ScoreBoard
	 */
	public int getRankOfRunner(String runner)throws Exception{
		int rank = lookUpEntry(runner);
		if(rank==-1){
			throw new Exception("Invalid player. No such player in ScoreBoard.");
		}
		return rank+1;
	}
	
	/**
	 * @return all the GameEntries in the ScoreBoard
	 */
	public GameEntry[] getScoreBoardEntries(){
		if(this.numOfEntries==0){
			return null;
		}
		return this.gameEntries;
	}
	
}
