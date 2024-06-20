package socialnetwork;

import java.util.*;

public class SocialNetwork {
    private Map<String, List<Friendship>> adjacencyList;


    public SocialNetwork() {
        this.adjacencyList = new HashMap<>();
    }


    public SocialNetwork(Scanner in) {
        this();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty() || line.startsWith("friend1")) {
                continue;
            }
            String[] parts = line.split(";");
            if (parts.length == 3) {
                String friend1 = parts[0];
                String friend2 = parts[1];
                int strength = Integer.parseInt(parts[2]);
                addFriendship(new Friendship(friend1, friend2, strength));
            }
        }
    }


    public void addUser(String user) {
        if (!adjacencyList.containsKey(user)) {
            adjacencyList.put(user, new ArrayList<>());
        }
    }


    public void addFriendship(Friendship f) {
        addUser(f.getFriend1());
        addUser(f.getFriend2());
        adjacencyList.get(f.getFriend1()).add(f);
        adjacencyList.get(f.getFriend2()).add(new Friendship(f.getFriend2(), f.getFriend1(), f.getFriendshipStrength()));
    }


    public List<Friendship> getFriends(String user) {
        return adjacencyList.getOrDefault(user, Collections.emptyList());
    }


    public int getNumberOfUsers() {
        return adjacencyList.size();
    }

    public int getNumberOfFriendships() {
        int count = 0;
        for (List<Friendship> friendships : adjacencyList.values()) {
            count += friendships.size();
        }
        return count / 2;
    }


    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        Map<String, Integer> recommendationStrengthMap = new HashMap<>();


        for (Friendship friendship : getFriends(user)) {
            String friend = friendship.getFriend2();
            int userToFriendStrength = friendship.getFriendshipStrength();


            for (Friendship friendsFriendship : getFriends(friend)) {
                String friendsFriend = friendsFriendship.getFriend2();
                int friendToFriendsFriendStrength = friendsFriendship.getFriendshipStrength();


                if (friendsFriend.equals(user) || adjacencyList.get(user).stream().anyMatch(f -> f.getFriend2().equals(friendsFriend))) {
                    continue;
                }


                int strength = Math.min(userToFriendStrength, friendToFriendsFriendStrength);
                recommendationStrengthMap.put(friendsFriend, recommendationStrengthMap.getOrDefault(friendsFriend, 0) + strength);
            }
        }


        ArrayList<FriendshipRecommendation> recommendations = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : recommendationStrengthMap.entrySet()) {
            recommendations.add(new FriendshipRecommendation(entry.getKey(), entry.getValue()));
        }
        Collections.sort(recommendations);

        return recommendations;
    }
}

