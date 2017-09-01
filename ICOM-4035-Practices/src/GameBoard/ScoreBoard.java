package GameBoard;
import java.util.Arrays;
import java.util.Collections;
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
	
	public void removeGameEntry(String name)throws Exception{
		int index = lookUpEntry(name);
		if(index!=-1){
			this.gameEntries[index] = null;
			Arrays.sort(this.gameEntries,comparatorByVal);
		}
		else{
			throw new Exception("Invalid runner. No such runner in ScoreBoard.");
		}
	}
	
	private int lookUpEntry(String s){
		for(int i=0; i<this.numOfEntries; i++){
			if(this.gameEntries[i].getName().equals(s)){
				return i;
			}
		}
		return -1;
	}

	public GameEntry getRunnerInRank(int rank)throws Exception{
		if(rank >= this.gameEntries.length){
			throw new Exception("Invalid rank. ScoreBoard doesn't contain that rank.");
		}
		if(gameEntries[rank] == null){
			throw new Exception("Invalid rank. No runner in specified rank.");
		}
		return gameEntries[rank];
	}
	public int getRankOfRunner(String runner)throws Exception{
		int rank = lookUpEntry(runner);
		if(rank==-1){
			throw new Exception("Invalid runner. No such runner in ScoreBoard.");
		}
		return rank;
	}
	
	public GameEntry[] getScoreBoardEntries(){
		if(this.numOfEntries==0){
			return null;
		}
		return this.gameEntries;
	}
	
}
