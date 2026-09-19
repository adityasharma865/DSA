import java.util.*;

class Twitter {

    private static int time = 0;

    // userId -> tweets posted by that user
    private Map<Integer, List<Tweet>> tweets;

    // userId -> users they follow
    private Map<Integer, Set<Integer>> following;

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Add tweets of followed users
        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    pq.addAll(tweets.get(followee));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int count = 0;

        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}