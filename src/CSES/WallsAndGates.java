package CSES;

import java.util.*;

public class WallsAndGates {


    public static void main(String[] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
       int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
       wallsAndGates.wallsAndGates(rooms);
    }
    public void wallsAndGates(int[][] rooms) {

        if (rooms == null || rooms.length == 0) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        for (int i = 0; i< rooms.length; i++) {
            for (int j = 0; j< rooms[0].length; j++) {
                if (rooms[i][j] == Integer.MAX_VALUE ) {
                    fillNearestGate(rooms, i,j,visited);
                }
            }
        }

        return;
    }


    public void fillNearestGate(int[][] rooms, int row, int col, Set<Node> visited ) {


        int up = Integer.MAX_VALUE;
        int down = up;
        int left = up;
        int right = up;

        Node temp =  new Node(row, col);
        visited.add(temp);

        if (row+1 < rooms.length && !visited.contains(new Node(row+1,col))) {
            if (rooms[row+1][col] == Integer.MAX_VALUE) {
                fillNearestGate(rooms,row+1,col,visited);
                down = rooms[row+1][col]+1;
            } else if (rooms[row+1][col] == 0) {
                down = 1;
            } else if (rooms[row+1][col] > 0) {
                down = rooms[row+1][col]+1;
            }
        }

        if (col+1 < rooms[0].length && !visited.contains(new Node(row,col+1))) {
            if (rooms[row][col+1]== Integer.MAX_VALUE) {
                fillNearestGate(rooms,row,col+1,visited);
                right = rooms[row][col+1]+1;
            } else if (rooms[row][col+1] == 0) {
                right = 1;
            } else if (rooms[row][col+1] > 0) {
                right = rooms[row][col+1]+1;
            }
        }

        if (row-1 >=0 && !visited.contains(new Node(row-1,col))) {
            if (rooms[row-1][col] == Integer.MAX_VALUE && !visited.contains(new Node(row-1,col))) {
                fillNearestGate(rooms,row-1,col,visited);
                up = rooms[row-1][col]+1;
            } else if (rooms[row-1][col] == 0) {
                up = 1;
            } else if (rooms[row-1][col] > 0) {
                up = rooms[row-1][col]+1;
            }
        }

        if (col - 1 >= 0 && !visited.contains(new Node(row,col-1))) {
            if (rooms[row][col-1] == Integer.MAX_VALUE) {
                fillNearestGate(rooms,row-1,col,visited);
                left = rooms[row][col-1]+1;
            } else if (rooms[row][col-1] == 0) {
                left = 1;
            } else if (rooms[row][col-1] > 0) {
                left = rooms[row][col-1]+1;
            }
        }

        rooms[row][col] = Math.min(left, Math.min(right, Math.min(up,down)));
        System.out.println(row + "--" + col + "=====================>"+ rooms[row][col]);
        visited.remove(temp);
        return;
    }
}

class Node {

    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        Node temp = (Node)o;
        return (r == temp.r && c== temp.c) ? true : false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r,c);
    }
}