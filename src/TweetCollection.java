import java.util.ArrayList;

//Holds all tweets
public class TweetCollection implements Visitable{

	private ArrayList<String> allTweets;
	private String[] positive = {"good", "excellent","great","fantastic","wonderful","happy"};
	
	public TweetCollection() {
		allTweets = new ArrayList<String>();
	}
	public void add(String tweet) {
		allTweets.add(tweet);
	}

	public int getSize() {
		return allTweets.size();
	}
	
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
	public double getPosPerc() {
		int pos = 0;
		for(int i = 0; i < this.getSize(); i++) {
			for(int j = 0; j < positive.length; j++) {
				if(allTweets.get(i).contains(positive[j])) {
					pos++;
				}
			}
		}
		double perc = (Integer)(pos/(this.getSize())*100);
		return perc/100;
	}

}
