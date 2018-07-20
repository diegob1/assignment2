
public class UserGroup {
   private String groupID;
   private String groupName;

   private User[] numberOfUsers;
   private String[] allGroupNames;
   private int numberOfCurrentUsers;
   private int numberOfCurrentGroups;
   private int indent; //

   public UserGroup() {
      numberOfUsers = new User[10];
      groupID = "0005";
      allGroupNames = new String[10];
      numberOfCurrentUsers = 0;
      numberOfCurrentGroups = 0;
      indent = 0;
   }

   public int getNumberOfCurrentGroups() {
      return numberOfCurrentGroups;
   }

   public int getNumberOfCurrentUsers() {
      return numberOfCurrentUsers;
   }

   public String getGroupName() {
      return groupName;
   }

   public void setGroupName(String groupName) {
      this.groupName = groupName;
   }

   public String getGroupID() {
      return groupID;
   }

   public void setGroupID(String groupID) {
      this.groupID = groupID;
   }

   public User[] getNumberOfUsers() {
      return numberOfUsers;
   }

   public void setNumberOfUsers(User[] numberOfUsers) {
      this.numberOfUsers = numberOfUsers;
   }

   public void addUser(User user) {
      numberOfUsers[numberOfCurrentUsers] = user;
      numberOfCurrentUsers++;
   }

   public void addGroup(String usergroup) {
      allGroupNames[numberOfCurrentGroups] = usergroup;
      numberOfCurrentGroups++;
   }

   public String[] getNumberOfGroups() {
      return allGroupNames;
   }

   public void setNumberOfGroups(String[] numberOfGroups) {
      this.allGroupNames = numberOfGroups;
   }

   public String setIndent(String usergroup) {
      String s = "";
      for (int i = 0; i < numberOfCurrentGroups; i++) {
         if (this.allGroupNames[i].equals(usergroup)) {
            indent = i;
         }
      }
      for (int i = 0; i <= indent; i++) {
         s += "  ";
      }
      return ("\n" + s);

   }
}
