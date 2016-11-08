import java.util.ArrayList;

//Holds all Users
public class UserCollection implements Visitable{

	private ArrayList<User> allUsers;
	
	public UserCollection() {
		allUsers = new ArrayList<User>();
	}
	public void add(User u) {
		allUsers.add(u);
	}

	public int getSize() {
		return allUsers.size();
	}
	
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
	public User search(String id) {
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getID().equals(id)) {
				return allUsers.get(i);
			}
		}
		return null;
	}
	public void add(UserComponent user) {
		allUsers.add((User)user);
	}

}
