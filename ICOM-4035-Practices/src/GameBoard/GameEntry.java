package GameBoard;

public class GameEntry implements Comparable<GameEntry>{
	private String name;
	private int score;
	
	public GameEntry(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore(int scoreDelta){
		this.score+=scoreDelta;
	}
	
	@Override
	public String toString(){
		return this.name + "   Score: " + this.score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			if(name==null)
				return false;
		if (getClass() != obj.getClass())
			return false;
		GameEntry other = (GameEntry) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} 
		else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GameEntry o) {
		if(this.name.equals(o.getName())){
			return 0;
		}
		return 1;
	}
	
	
}
 