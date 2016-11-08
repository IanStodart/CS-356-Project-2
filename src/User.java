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

	public void addFollowers(User follower) {
		followers.add(follower);
	}

	public ArrayList<Observer> getFollowing() {
		return following;
	}

	public void addFollowing(User follow) {
		following.add(follow);
		followingSize++;
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

	@Override
	public void register(Observer follower) {
		followers.add(follower);
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		
	}
	
	public void getNewTweet(String tweet) {
		newTweet = tweet;
		notifyObserver();
	}
	
	@Override
	public void notifyObserver() {
		for(int i = 0; i < followers.size(); i++) {
			followers.get(i).update(newTweet);
		}
		
	}

	@Override
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
