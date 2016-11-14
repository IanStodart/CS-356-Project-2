import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class AdminControlPanel extends JFrame {
	/**
	 * 
	 */
	private static AdminControlPanel instance = null;
	private static final long serialVersionUID = 1L;
	private JTextField newUserName;
	private JTextField newGroupName;
	private UserList listOfUsers;
	private TweetCollection allTweets = new TweetCollection();
	ArrayList<UserView> views = new ArrayList<UserView>();

	public static AdminControlPanel getInstance(UserList users){
		if(instance == null)
		{
			instance = new AdminControlPanel(users);
			instance.setSize(580,420);
		}
		return instance;
	}
	public void visible() {
		instance.setVisible(true);
	}
	private AdminControlPanel(UserList users) {
		listOfUsers = users;
		
		getContentPane().setLayout(null);
		
		MutableTreeNode root = createNodes();
		JTree tree = new JTree(root);
		DefaultTreeModel dTree = (DefaultTreeModel)tree.getModel();
		tree.setBounds(10, 11, 230, 344);
		getContentPane().add(tree);
		
		JButton buttonAddUser = new JButton("Add User");
		buttonAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = newUserName.getText();
				listOfUsers.add(new User(newName));
				createNodes();
				MutableTreeNode newNode = new DefaultMutableTreeNode(newName);
				dTree.insertNodeInto(newNode, root, root.getChildCount());
				newUserName.setText("");
			}
		});
		buttonAddUser.setBounds(427, 11, 121, 55);
		getContentPane().add(buttonAddUser);
		
		JButton buttonAddGroup = new JButton("Add Group");
		buttonAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = newGroupName.getText();
				listOfUsers.add(new UserGroup(newName));
				createNodes();
				MutableTreeNode newNode = new DefaultMutableTreeNode(newName);
				dTree.insertNodeInto(newNode, root, root.getChildCount());
				newGroupName.setText("");
			}
		});
		buttonAddGroup.setBounds(427, 79, 121, 55);
		getContentPane().add(buttonAddGroup);
		
		newUserName = new JTextField();
		newUserName.setColumns(10);
		newUserName.setBounds(275, 11, 121, 55);
		getContentPane().add(newUserName);
		
		newGroupName = new JTextField();
		newGroupName.setColumns(10);
		newGroupName.setBounds(275, 79, 121, 55);
		getContentPane().add(newGroupName);
		
		JButton buttonOpenUserView = new JButton("Open User View");
		buttonOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath path = tree.getSelectionPath();
				String id = path.getLastPathComponent().toString();
				User u = listOfUsers.search(id);
				UserView frame = UserView.createInstance(listOfUsers, u, allTweets,views);
				views.add(frame);
				frame.visible();
			}
		});
		buttonOpenUserView.setBounds(275, 145, 273, 23);
		getContentPane().add(buttonOpenUserView);
		
		JButton showUserTotal = new JButton();
		showUserTotal.setLayout(new BorderLayout());
		String text = "Show" + "<br>" + "User Total";
		JLabel label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		showUserTotal .add(BorderLayout.CENTER,label);
		showUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JFrame window = new JFrame("User Count");
		        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		        JLabel label = new JLabel("Number of Users: " + listOfUsers.getNumOfUsers());
		        window.getContentPane().add(label);

		        //Display the window.
		        window.pack();
		        window.setVisible(true);
			}
		});
		showUserTotal.setBounds(275, 242, 121, 55);
		getContentPane().add(showUserTotal);
		
		JButton showGroupTotal = new JButton();
		showGroupTotal.setLayout(new BorderLayout());
		text = "Show" + "<br>" + "Group Total";
		label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		showGroupTotal .add(BorderLayout.CENTER,label);
		showGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JFrame window = new JFrame("Group Count");
		        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		        JLabel label = new JLabel("Number of Groups: " + listOfUsers.getNumOfGroupss());
		        window.getContentPane().add(label);

		        //Display the window.
		        window.pack();
		        window.setVisible(true);
			}
		});
		showGroupTotal.setBounds(427, 242, 121, 55);
		getContentPane().add(showGroupTotal);
		
		JButton showMsgTotal = new JButton();
		showMsgTotal.setLayout(new BorderLayout());
		text = "Show" + "<br>" + "Message Total";
		label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		showMsgTotal .add(BorderLayout.CENTER,label);
		showMsgTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JFrame window = new JFrame("Tweet Count");
		        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		        JLabel label = new JLabel("Number of Tweets: " + allTweets.getSize());
		        window.getContentPane().add(label);

		        //Display the window.
		        window.pack();
		        window.setVisible(true);
			}
		});
		showMsgTotal.setBounds(275, 300, 121, 55);
		getContentPane().add(showMsgTotal);
		
		JButton showPosPerc = new JButton();
		showPosPerc.setLayout(new BorderLayout());
		text = "Show Positive" + "<br>" + "Percentage";
		label = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
		showPosPerc .add(BorderLayout.CENTER,label);
		showPosPerc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JFrame window = new JFrame("Positive Tweet Percent");
		        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		        JLabel label = new JLabel("Percentage of Positive Tweets: " + allTweets.getPosPerc());
		        window.getContentPane().add(label);

		        //Display the window.
		        window.pack();
		        window.setVisible(true);
			}
		});
		showPosPerc.setBounds(427, 300, 121, 55);
		getContentPane().add(showPosPerc);		
	}

	private DefaultMutableTreeNode createNodes() {
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("All");
		
		UserComponent all = listOfUsers.getUserList();
		
		helpCreateNodes(root, all);
		
		return root;
	}
	private void helpCreateNodes(DefaultMutableTreeNode root, UserComponent all) {
		Iterator<UserComponent> userIterator = all.getComponents().iterator();
		while(userIterator.hasNext()) {
			UserComponent component = (UserComponent) userIterator.next();
			
			if(component instanceof UserGroup)
			{
				DefaultMutableTreeNode userGroup = new DefaultMutableTreeNode(component.getID());
				root.add(userGroup);
				helpCreateNodes(userGroup, component);
			}
			else 
			{
				root.add(new DefaultMutableTreeNode(component.getID()));
			}
		}
	}
}
