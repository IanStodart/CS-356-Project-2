interface Visitor {
	
	//Use the correct code based on object sent
	//Thanks to method overloading
	
	public String visit(TweetCollection allTweets);
	
	public String visit(UserCollection allUsers);
	
	public String visit(UserGroupCollection allGroups);
	
}