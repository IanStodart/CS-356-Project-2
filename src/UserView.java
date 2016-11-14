import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Label;

public class UserView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2422532481701741663L;
	private JPanel contentPane;
	private JTextField userID;
	private JTextField tweetBox;
	private static UserView instance;
	private ArrayList<UserView> otherViews;
	private String iD;
	private List newsFeed;
	private User myUser;
	
	public static UserView createInstance(UserList userList, User user, TweetCollection tweets, ArrayList<UserView> view){
		instance = new UserView(userList, user, tweets, view);
		return instance;
	}
	
	public void visible(){
		instance.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public UserView(UserList userList, User user, TweetCollection tweets, ArrayList<UserView> view) {
		
		otherViews = view;
		iD = user.getID();
		myUser = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label name = new Label(user.getID());
		name.setBounds(167, -3, 82, 27);
		contentPane.add(name);
		
		userID = new JTextField();
		userID.setBounds(15, 30, 166, 54);
		contentPane.add(userID);
		userID.setColumns(10);
		
		List following = new List();
		if(user.getFollowingSize() != 0)
		{
			for(int i = 0; i < user.getFollowing().size(); i++) {
				following.add(((User)user.getFollowing().get(i)).getID());
			}
		}
		following.setBounds(15, 94, 372, 87);
		contentPane.add(following);
		
		JButton followButton = new JButton("Follow");
		followButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.addFollowing(userList.search(userID.getText()));
				following.add(userID.getText());
				contentPane.add(following);
				userID.setText("");
			}
		});
		followButton.setBounds(246, 27, 141, 61);
		contentPane.add(followButton);
		
		tweetBox = new JTextField();
		tweetBox.setColumns(10);
		tweetBox.setBounds(15, 193, 166, 54);
		contentPane.add(tweetBox);
		
		newsFeed = new List();
		for(int i = 0; i < user.getNewsFeed().size(); i++) {
			newsFeed.add(user.getNewsFeed().get(i));
		}
		newsFeed.setBounds(15, 264, 372, 80);
		contentPane.add(newsFeed);	
		
		JButton tweetButton = new JButton("Tweet");
		tweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tweet = user.getID() + ": " + tweetBox.getText();
				user.getNewTweet(tweet);
				tweets.add(tweet);
				newsFeed.add(tweet);
				contentPane.add(newsFeed);
				tweetBox.setText("");
				updateUserViews(user);
			}
		});
		tweetButton.setBounds(246, 190, 141, 61);
		contentPane.add(tweetButton);
		
	}
	public String getID(){
		return iD;
	}
	
	private void updateUserViews(User u){
		for(int i = 0; i < u.getFollowers().size(); i++) {
			for(int j = 0; j < otherViews.size(); j ++){
				if(otherViews.get(j).getID().equals(u.getFollowers().get(i).getID())){ //UserView j is the window of one of u's followers
					otherViews.get(j).updateNewsFeed();
				}
			}
		}
	}

	private void updateNewsFeed() {
		for(int i = 0; i < myUser.getNewsFeed().size(); i++) {
			newsFeed.add(myUser.getNewsFeed().get(i));
		}
		newsFeed.setBounds(15, 264, 372, 80);
		contentPane.add(newsFeed);	
		
	}
}
