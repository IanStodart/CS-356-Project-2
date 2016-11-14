import java.util.ArrayList;

public class User extends UserComponent implements Subject, Observer{
	
	private String userID;
	private boolean groupStatus;
	private ArrayList<Observer> followers;
	private ArrayList<Observer> following;
	private ArrayList<String> newsFeed;
	private String newTweet;
	private final int size = 1;
	private int followingSize;
	
	public User(String name){
		userID = name;
		followers = new  ArrayList<Observer>();
		following = new  ArrayList<Observer>();
		newsFeed = new  ArrayList<String>();
		setGroupStatus(false);
		followingSize = 0;
	}

	public String getID() {
		return userID;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(boolean group) {
		groupStatus = group;
	}

	public ArrayList<Observer> getFollowers() {
		return followers;
	}

	public void addFollower(Observer o) {
		followers.add(o);
	}

	public ArrayList<Observer> getFollowing() {
		return following;
	}

	public void addFollowing(User follow) {
		register(follow);
	}
	public int getFollowingSize(){
		return followingSize;
	}

	public ArrayList<String> getNewsFeed() {
		return newsFeed;
	}

	public void addToNewsFeed(String newNews) {
		newsFeed.add(newNews);
	}

	public void register(Observer o) {
			following.add(o);
			o.addFollower(this);
			followingSize++;
	}
	
	public void getNewTweet(String tweet) {
		newTweet = tweet;
		this.notifyObserver();
	}
	
	public void notifyObserver() {
		for(int i = 0; i < followers.size(); i++) {
			followers.get(i).update(newTweet);
		}
	}

	public void update(String newTweet) {
		this.addToNewsFeed(newTweet);
	}
	public void print() {
		System.out.println(userID);
	}
	public String toString() {
		return userID;
	}

	
}
