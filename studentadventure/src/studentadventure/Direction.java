package studentadventure;

public class Direction {
	private String word;
	private String direction;
	
	public Direction(String w,String d) {
		this.word=w;
		this.direction=d;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
