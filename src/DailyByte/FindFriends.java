package DailyByte;

public class FindFriends {

    public static void main(String[] args) {
        int[][] friends = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(getDistinctFriends(friends));

    }

    public static int getDistinctFriends(int[][] friend){
        int[] parent = new int[friend.length];

        for(int i = 0; i< parent.length; i++) {
            parent[i] = i;
        }


        for(int singleFriend = 0; singleFriend < friend.length; singleFriend++) {
            for (int childFriend = 0; childFriend < friend[0].length; childFriend++) {
                if (friend[singleFriend][childFriend] == 1) {
                    if (parent[childFriend] == childFriend) {
                        parent[childFriend] = parent[singleFriend];
                    } else {
                        int parentFriend = getParent(parent, childFriend);
                        parent[singleFriend] = parentFriend;
                    }
                }
            }
        }


        return getDistinctParent(parent);
    }


    public static int getParent(int[] parent, int child) {
        if (parent[child] == child) {
            return child;
        }

        return getParent(parent,parent[child]);

    }


    public static int getDistinctParent(int[] parent) {
        int count = 0;

        for(int i = 0; i< parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        return count;
    }
}
