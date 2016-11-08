public class CollectionVisitor implements Visitor {

	public CollectionVisitor() {
		
	}
	
	@Override

	// Calculates total number 
	// as a TweetCollection Object
		
	public String visit(TweetCollection allTweets) {
		return "Number of Tweets: " + allTweets.getSize();
	}

	// Calculates total number 
	// as a UserCollection Object
	
	public String visit(UserCollection allUsers) {
		return "Number of Tweets: " + allUsers.getSize();
	}

	// Calculates total number 
	// as a UserGroupCollection Object
	
	public String visit(UserGroupCollection allUserGroups) {
		return "Number of UserGroups: " + allUserGroups.getSize();
	}

}
