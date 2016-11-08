import java.util.Iterator;

public class UserList {

	private UserComponent userList; //First item in the list
	private UserCollection listOfAllUsers;
	private UserGroupCollection listOfAllUserGroups;
	
	public UserList() {
		userList = new UserGroup("All");
		
		userList.add(new User("John"));
		userList.add(new User("Bob"));
		userList.add(new User("Steve"));
		
		UserComponent cs356 = new UserGroup ("CS 356");
		UserComponent cs356s01 = new UserGroup ("CS 356 Section 01");
		
		userList.add(cs356);
		cs356.add(new User("stu1"));
		cs356.add(new User("stu2"));
		cs356.add(new User("stu3"));
		
		cs356.add(cs356s01);
		
		cs356s01.add(new User("stu8"));
		cs356s01.add(new User("stu9"));
		cs356s01.add(new User("stu10"));
		
		cs356.add(new User("stu4"));
		userList.add(new User("oostu"));
		userList.add(new User("ppstu2"));
		createListOfAllUsers();
	}
	private  void createListOfAllUsers() {
		listOfAllUsers = new UserCollection();
		listOfAllUserGroups = new UserGroupCollection();
		
		UserComponent all = userList; //Get first Component of list
		
		iterate(all);
	}	
	private void iterate(UserComponent all) {
		Iterator<UserComponent> userIterator = all.getComponents().iterator();
		while(userIterator.hasNext()) {
			UserComponent component = (UserComponent) userIterator.next();
			
			if(component instanceof User) {
				listOfAllUsers.add((User) component);
			}
			else if(component instanceof UserGroup) {
				listOfAllUserGroups.add((UserGroup) component);
				iterate(component);
			}
		}	
	}
	
	public void add(User user) {
		userList.add(user);
		listOfAllUsers.add(user);
	}
	
	public void add(UserGroup user) {
		userList.add(user);
		listOfAllUserGroups.add(user);
	}
	
	public UserComponent getUserList() {
		return userList;
	}
	
	public User search(String id) {
		return listOfAllUsers.search(id);
	}
	
	public int getNumOfUsers() {
		return listOfAllUsers.getSize();
	}
	
	public int getNumOfGroupss() {
		return listOfAllUserGroups.getSize();
	}
	
	
}
