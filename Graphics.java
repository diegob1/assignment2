import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Graphics extends JFrame {
   private int numberOfUsers;
   private int numberOfGroups;
   private User user = new User();
   private UserGroup usergroup = new UserGroup();

   public Graphics() {
      numberOfUsers = 0;
      numberOfGroups = 0;
      String[] posMsgs = { "nice", "good", "great", "excellent", "cool", "omg", "lol", "xD", "Kappa" };
      UserGroup rootGroup = new UserGroup();
      rootGroup.setGroupName("ROOT");
      usergroup.addGroup(rootGroup.getGroupName());
      setSize(620, 450);
      setTitle("ADMIN UI");
      JButton buttonAddUser = new JButton("Add User");
      JButton buttonAddGroup = new JButton("Add Group");
      JButton openUserViewButton = new JButton("Open User View");
      JButton showAllUsersButton = new JButton("Show User Total");
      JButton showGroupTotalButton = new JButton("Show Group Total");
      JButton showAllMsgButton = new JButton("Show Messages Total");
      JButton showPositivePercentageButton = new JButton("Show Positive Percentage");
      JButton verifyButton = new JButton("Validate IDs");
      JButton findLastUpdatedButton = new JButton("Find Last Updated User");

      JTextArea chooseUserToView = new JTextArea("Name of user to view.", 5, 20);
      JTextArea userID = new JTextArea(5, 20);
      JTextArea groupID = new JTextArea(5, 20);
      JTextPane informationPane = new JTextPane();
      informationPane.setText(rootGroup.getGroupName());
      informationPane.setBackground(Color.LIGHT_GRAY);
      informationPane.setEditable(false);
      JPanel panel = new JPanel();
      panel.setLayout(null);

      buttonAddUser.setBounds(300, 0, 300, 50);
      buttonAddGroup.setBounds(300, 50, 300, 50);
      showAllUsersButton.setBounds(300, 200, 150, 50);
      showGroupTotalButton.setBounds(450, 200, 150, 50);
      showAllMsgButton.setBounds(300, 250, 150, 50);
      showPositivePercentageButton.setBounds(450, 250, 150, 50);
      openUserViewButton.setBounds(300, 150, 200, 50);
      verifyButton.setBounds(300, 325, 150, 50);
      findLastUpdatedButton.setBounds(450, 325, 150, 50);
      userID.setBounds(300, 0, 100, 50);
      groupID.setBounds(300, 100, 100, 50);
      chooseUserToView.setBounds(300, 100, 200, 50);
      informationPane.setBounds(0, 0, 300, 500);
      panel.add(findLastUpdatedButton);
      panel.add(informationPane);
      panel.add(buttonAddGroup);
      panel.add(buttonAddUser);
      panel.add(showAllUsersButton);
      panel.add(showGroupTotalButton);
      panel.add(showAllMsgButton);
      panel.add(showPositivePercentageButton);
      panel.add(openUserViewButton);
      panel.add(chooseUserToView);
      panel.add(verifyButton);
      this.getContentPane().add(panel);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      // -------------
      buttonAddUser.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JFrame newPanel = new JFrame();
            newPanel.setLayout(null);
            JTextArea nameArea = new JTextArea("Name of user to add");
            JTextArea groupArea = new JTextArea("Group for user to be in");
            JButton addButton = new JButton("Add");
            addButton.setBounds(0, 50, 100, 25);
            nameArea.setBounds(0, 0, 200, 20);
            groupArea.setBounds(0, 25, 200, 20);
            newPanel.setSize(250, 150);
            newPanel.setName("D");
            newPanel.add(nameArea);
            newPanel.add(groupArea);
            newPanel.add(addButton);

            newPanel.setVisible(true);
            newPanel.setDefaultCloseOperation(HIDE_ON_CLOSE);
            addButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  User newUser = new User();
                  String g = groupArea.getText();
                  String s = nameArea.getText();
                  for (int i = 0; i < usergroup.getNumberOfCurrentGroups(); i++) {
                     if (usergroup.getNumberOfGroups()[i].equals(g)) {
                        newUser.setName(s);
                        usergroup.addUser(newUser);
                        informationPane.setText(informationPane.getText() + usergroup.setIndent(g) + "-[USER]" + s);
                        newPanel.setVisible(false);
                        break;
                     } else if ((i == usergroup.getNumberOfCurrentGroups() - 1)
                           && (usergroup.getNumberOfGroups()[i] != g)) // if we hit the end of the loop and we still
                                                                       // cant find the group then we cant add the group
                                                                       // to the group
                     {
                        System.out.println(g + " doesnt exist.");
                     }
                  }

               }
            });
         }
      });
      // -------------
      buttonAddGroup.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JFrame newPanel = new JFrame();
            newPanel.setLayout(null);
            JTextArea nameArea = new JTextArea("Name of group");
            JTextArea groupArea = new JTextArea("Group to add group too");
            JButton addButton = new JButton("Add");
            addButton.setBounds(0, 50, 100, 25);
            nameArea.setBounds(0, 0, 200, 20);
            groupArea.setBounds(0, 25, 200, 20);
            newPanel.setSize(250, 150);
            newPanel.setName("D");
            newPanel.add(nameArea);
            newPanel.add(groupArea);
            newPanel.add(addButton);

            newPanel.setVisible(true);
            newPanel.setDefaultCloseOperation(HIDE_ON_CLOSE);
            addButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  // User newUser = new User();
                  UserGroup newGroup = new UserGroup();
                  String g = groupArea.getText();
                  String s = nameArea.getText();
                  System.out.println("Number of current G " + usergroup.getNumberOfCurrentGroups());
                  for (int i = 0; i < usergroup.getNumberOfCurrentGroups(); i++) {
                     System.out.println("i is " + i + " " + usergroup.getNumberOfGroups()[i]);
                     // System.out.println(usergroup.getNumberOfCurrentGroups());
                     if (usergroup.getNumberOfGroups()[i].equals(g)) {
                        newGroup.setGroupName(s);
                        usergroup.addGroup(s);
                        System.out.println("usergroup" + "[" + i + "]" + usergroup.getNumberOfGroups()[i]);
                        informationPane.setText(informationPane.getText() + usergroup.setIndent(g) + "-[FOLDER] " + s);
                        newPanel.setVisible(false);
                        break;
                     } else if ((i == usergroup.getNumberOfCurrentGroups() - 1)
                           && (usergroup.getNumberOfGroups()[i] != g)) // if we hit the end of the loop and we still
                                                                       // cant find the group then we cant add the group
                                                                       // to the group
                     {
                        System.out.println(g + " doesnt exist.");
                     }
                  }

               }
            });
         }
      }); // end BUTTON ADD GROUP
      showAllUsersButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel, "There are " + usergroup.getNumberOfCurrentUsers() + " total users.");
         }
      });
      showPositivePercentageButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int totalPosTweets = 0;
            for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
               for (int j = 0; j < usergroup.getNumberOfUsers()[i].getTotalTweets(); j++) {
                  for (int z = 0; z < posMsgs.length; z++) {
                     if (usergroup.getNumberOfUsers()[i].getTwitterMsgs()[j].contains(posMsgs[z]))
                        totalPosTweets += 1;
                  }
               }

            }
            JOptionPane.showMessageDialog(panel, "There are " + totalPosTweets + " total positive words.");
         }
      });
      showAllMsgButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int totalTweets = 0;
            for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
               totalTweets += usergroup.getNumberOfUsers()[i].getTotalTweets();
            }
            JOptionPane.showMessageDialog(panel, "There are " + totalTweets + " total tweets.");
         }
      });
      showGroupTotalButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(panel,
                  "There are " + usergroup.getNumberOfCurrentGroups() + " total groups.");
         }
      });
      findLastUpdatedButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            long baseTime = usergroup.getNumberOfUsers()[0].getUpdateTime();
            int theUserLoc = 0;
            for (int i = 1; i < usergroup.getNumberOfCurrentUsers(); i++) {
               if (baseTime < usergroup.getNumberOfUsers()[i].getUpdateTime()) {
                  baseTime = usergroup.getNumberOfUsers()[i].getUpdateTime();
                  theUserLoc = i;
               }
            }
            JOptionPane.showMessageDialog(panel,
                  "The last updated user is " + usergroup.getNumberOfUsers()[theUserLoc].getName());
         }
      });
      verifyButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int numberOfErrors = 0;
            for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
               for (int j = i + 1; j < usergroup.getNumberOfCurrentUsers(); j++) {
                  if (usergroup.getNumberOfUsers()[j].getName().equals(usergroup.getNumberOfUsers()[i].getName()))
                     numberOfErrors++;
               }
            }
            for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
               if (usergroup.getNumberOfUsers()[i].getName().contains(" "))
                  numberOfErrors++;
            }

            JOptionPane.showMessageDialog(panel, "There are " + numberOfErrors + " name errors.");
         }
      });
      openUserViewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JFrame userViewPane = new JFrame();
            User ourUser = new User();
            String username = chooseUserToView.getText();
            for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
               if (usergroup.getNumberOfUsers()[i].getName().equals(username)) {
                  user = usergroup.getNumberOfUsers()[i];
                  break;
               } else if (i == usergroup.getNumberOfCurrentUsers() - 1) {
                  JOptionPane.showMessageDialog(panel, "User does not exist, close window and input proper name.");
               }
            }
            userViewPane.setLayout(null);
            userViewPane.setSize(400, 750);
            userViewPane.setTitle(username);
            JTextArea userIDArea = new JTextArea();
            JButton followUserButton = new JButton("Follow User");
            JTextPane currentFollowing = new JTextPane();
            JTextArea tweetMessageArea = new JTextArea();
            JButton postTweetButton = new JButton("Post Tweet");
            JTextPane newsFeed = new JTextPane();
            JLabel updateTimeLabel = new JLabel(Long.toString(user.updateTime()));
            JLabel creationTimeLabel = new JLabel(Long.toString(user.getCreationTime()));
            updateTimeLabel.setBounds(0, 650, 100, 50);
            creationTimeLabel.setBounds(0, 600, 100, 50);
            userIDArea.setBounds(0, 0, 200, 50);
            followUserButton.setBounds(250, 0, 150, 50);
            currentFollowing.setBounds(0, 75, 400, 200);
            tweetMessageArea.setBounds(0, 300, 200, 50);
            postTweetButton.setBounds(250, 300, 150, 50);
            newsFeed.setBounds(0, 375, 400, 200);

            currentFollowing.setText("List View (Current Following)");
            newsFeed.setText("List View (News Feed)");
            currentFollowing.setEditable(false);
            newsFeed.setEditable(false);
            for (int j = 0; j < user.getTotalFollowing(); j++) {
               currentFollowing.setText(currentFollowing.getText() + "\n-" + user.getFollowingID()[j]); // add current
                                                                                                        // following to
                                                                                                        // area
            }
            for (int j = 0; j < user.getTotalTweets(); j++) {
               newsFeed.setText(newsFeed.getText() + "\n-" + user.getName() + ": " + user.getTwitterMsgs()[j]); // add
                                                                                                                // current
                                                                                                                // tweets
                                                                                                                // to
                                                                                                                // area
            }
            for (int j = 0; j < user.getTotalFollowing(); j++) { // get following messages;
               if (usergroup.getNumberOfUsers()[j].getName().equals(user.getFollowingID()[j]))
                  newsFeed.setText(newsFeed.getText() + "\n-" + usergroup.getNumberOfUsers()[j].getName() + ": "
                        + usergroup.getNumberOfUsers()[j].getTwitterMsgs()[j]);
            }
            userViewPane.add(updateTimeLabel);
            userViewPane.add(creationTimeLabel);
            userViewPane.add(userIDArea);
            userViewPane.add(followUserButton);
            userViewPane.add(currentFollowing);
            userViewPane.add(tweetMessageArea);
            userViewPane.add(postTweetButton);
            userViewPane.add(newsFeed);
            userViewPane.setVisible(true);
            userViewPane.setDefaultCloseOperation(HIDE_ON_CLOSE);

            followUserButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  for (int i = 0; i < usergroup.getNumberOfCurrentUsers(); i++) {
                     if (usergroup.getNumberOfUsers()[i].getName().equals(userIDArea.getText())
                           && !usergroup.getNumberOfUsers()[i].getName().equals(username)) {
                        user.addFollowing(userIDArea.getText());
                        currentFollowing.setText(currentFollowing.getText() + "\n-" + userIDArea.getText());
                        for (int j = 0; j < user.getTotalFollowing(); j++) { // get following messages;
                           if (usergroup.getNumberOfUsers()[j].getName().equals(user.getFollowingID()[j]))
                              newsFeed.setText(newsFeed.getText() + "\n-" + usergroup.getNumberOfUsers()[j].getName()
                                    + ": " + usergroup.getNumberOfUsers()[j].getTwitterMsgs()[j]);
                        }
                        break;
                     } else if (i == usergroup.getNumberOfCurrentUsers() - 1) {
                        JOptionPane.showMessageDialog(panel, "User does not exist");
                     }
                  }

               }
            });// end followerUserButton

            postTweetButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  user.addTwit(tweetMessageArea.getText());
                  newsFeed.setText(newsFeed.getText() + "\n-" + user.getName() + ": " + tweetMessageArea.getText());
                  user.updateTime();
                  updateTimeLabel.setText(Long.toString(user.getUpdateTime()));

               }
            });// end postTweetButton

         }
      }); // end openUserViewButton

   }

   public static void main(String[] args) {
      Graphics graphics = new Graphics();
   }

}
