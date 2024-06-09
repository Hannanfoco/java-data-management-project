package homework4;

public class Friendship {
    private String friend1;
    private String friend2;
    private int friendshipStrength;


    public Friendship(String friend1, String friend2, int friendshipStrength) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.friendshipStrength = friendshipStrength;
    }


    public String getFriend1() {
        return friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public int getFriendshipStrength() {
        return friendshipStrength;
    }


    public void setFriend1(String friend1) {
        this.friend1 = friend1;
    }

    public void setFriend2(String friend2) {
        this.friend2 = friend2;
    }

    public void setFriendshipStrength(int friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }


    @Override
    public String toString() {
        return "Friendship{" +
                "friend1='" + friend1 + '\'' +
                ", friend2='" + friend2 + '\'' +
                ", friendshipStrength=" + friendshipStrength +
                '}';
    }
}


