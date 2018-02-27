package Maze;

public class App {

    public static void main(String[] args){

        MazeRunner mazeRunner = new MazeRunner();
        Node[][] nodes =   mazeRunner.getNodeMatrix();

        StringBuilder sb = new StringBuilder();
        sb.append(nodes[0][2].val);
        mazeRunner.traverse(nodes[0][2],sb);


        System.out.println(mazeRunner.count);


    }

    public static void add(String name){

    }
}
