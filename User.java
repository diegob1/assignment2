import java.util.Random;

public class User {
   private String userID;
   private String name;
   private long creationTime;
   private long updateTime;
   private String[] followersID;
   private String[] followingID;
   private String[] twitterMsgs;
   private UserGroup userGroup;
   private int totalFollowers;
   private int totalFollowing;

   private int totalTwits;

   public User() {
      Random rand = new Random();
      creationTime = System.currentTimeMillis();
      userID = "" + rand.nextInt();
      followersID = new String[10];

      followingID = new String[10];

      twitterMsgs = new String[10];
      totalFollowers = 0;
      totalFollowing = 0;
      totalTwits = 0;

   }

   public long getUpdateTime() {
      return updateTime;
   }

   public long updateTime() {
      updateTime = System.currentTimeMillis();
      return updateTime;
   }

   public long getCreationTime() {
      return creationTime;
   }

   public int getTotalFollowing() {
      return totalFollowing;
   }

   public int getTotalTweets() {
      return totalTwits;
   }

   public void addTwit(String msg) {
      twitterMsgs[totalTwits] = msg;
      totalTwits++;
   }

   public int getAmountOfTotalFollowers() {
      return totalFollowers;
   }

   public void addFollowing(String following) {
      followingID[totalFollowing] = following;
      totalFollowing++;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getUserID() {
      return userID;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public String[] getFollowersID() {
      return followersID;
   }

   public void setFollowersID(String[] followersID) {
      this.followersID = followersID;
   }

   public String[] getFollowingID() {
      return followingID;
   }

   public void setFollowingID(String[] followingID) {
      this.followingID = followingID;
   }

   public String[] getTwitterMsgs() {
      return twitterMsgs;
   }

   public void setTwitterMsgs(String[] twitterMsgs) {
      this.twitterMsgs = twitterMsgs;
   }

   public UserGroup getUserGroup() {
      return userGroup;
   }

   public void setUserGroup(UserGroup userGroup) {
      this.userGroup = userGroup;
   }

}
