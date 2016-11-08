import java.util.ArrayList;

//Holds all UserGroupGroups
public class UserGroupCollection implements Visitable{

	private ArrayList<UserGroup> allUserGroupGroups;
	
	public UserGroupCollection() {
		allUserGroupGroups = new ArrayList<UserGroup>();
	}
	public void add(UserGroup u) {
		allUserGroupGroups.add(u);
	}

	public int getSize() {
		return allUserGroupGroups.size();
	}
	
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
