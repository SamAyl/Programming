package AlgoExpert;

import java.util.*;

class Program1 {

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"abcd"};

        List<String> ans = boggleBoard(board,words);
        System.out.println(ans.size());
    }
    public static List<String> boggleBoard(char[][] board, String[] words) {
        Map<Character, List<int[]>> map = getCharMap(board);
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (map.containsKey(word.charAt(0))) {
                for (int[] str : map.get(word.charAt(0))) {
                    boolean present = check(word,0,str[0],str[1],board,new HashSet<Node>());
                    if (present) {
                        ans.add(word);
                        break;
                    }
                }
            } else {
                continue;
            }

        }
        return ans;
    }

    public static boolean check(String word,int idx, int x, int y, char[][] board, Set<Node> visited) {
        if (idx == word.length()) {
            return true;
        }


        if (board[x][y] == word.charAt(idx)) {
            visited.add(new Node(x,y));


            boolean bool1 = false;
            if (x+1 < board.length) {
                Node nextNode = new Node(x+1,y);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x+1,y,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }

            if (x-1 >= 0) {
                Node nextNode = new Node(x-1,y);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x-1,y,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }

            if (y+1 < board[0].length) {
                Node nextNode = new Node(x,y+1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x,y+1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }

            if (y-1 >=0 ) {
                Node nextNode = new Node(x,y-1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x,y-1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }

            if (x+1 < board.length && y-1 >=0 ) {
                Node nextNode = new Node(x+1,y-1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x+1,y-1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }

            if (x+1 < board.length && y+1 < board[0].length ) {
                Node nextNode = new Node(x+1,y+1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x+1,y+1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }


            if (x-1 >= 0 && y+1< board[0].length ) {
                Node nextNode = new Node(x-1,y+1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x-1,y+1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }


            if (x-1 >= 0 && y-1 >= 0 ) {
                Node nextNode = new Node(x-1,y-1);
                if (!visited.contains(nextNode)) {
                    bool1 = check(word,idx+1,x-1,y-1,board,visited);
                    if (bool1) {
                        return bool1;
                    }
                }
            }


        }

        visited.remove(new Node(x,y));
        return false;

    }


    public static Map<Character, List<int[]>> getCharMap(char[][] board) {
        Map<Character, List<int[]>> map = new HashMap<>();

        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (map.containsKey(board[i][j])) {

                    List<int[]> list = map.get(board[i][j]);
                    int[] xy  = new int[2];
                    xy[0] = i;
                    xy[1] = j;
                    list.add(xy);
                } else {
                    List<int[]> list1 = new ArrayList<>();
                    int[] xy1 = new int[2];
                    xy1[0] = i;
                    xy1[1] = j;

                    list1.add(xy1);

                    map.put(board[i][j], list1);
                }
            }


        }

        return map;
    }

}

class Node{

    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
