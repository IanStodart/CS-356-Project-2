//The Observers update method is called when the Subject changes

public interface Observer {
	
	public void update(String newTweet);
	public void addFollower(Observer o);
	public String getID();
	
}
