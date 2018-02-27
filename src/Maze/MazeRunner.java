package Maze;

import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MazeRunner {

    char[][] matrix = new char[2][3];

    int count = 0;

    public MazeRunner() {

        matrix[0][0] = 'a';
        matrix[0][1] = 'b';
        matrix[0][2] = 'j';
        matrix[1][0] = 'c';
        matrix[1][1] = 'd';
        matrix[1][2] = 'l';
//        matrix[2][0] = 'e';
//        matrix[2][1] = 'f';
//        matrix[2][2] = 'o';
    }


    public Node[][] getNodeMatrix(){

        Node[][] nodeMatrix = new Node[matrix.length][matrix[0].length];

        for(int i = 0;i<nodeMatrix.length;i++){
            for(int j = 0;j<nodeMatrix[0].length;j++){
                Node temp = new Node();
                temp.val = matrix[i][j];
                nodeMatrix[i][j] = temp;
            }
        }

        for(int i = 0;i<nodeMatrix.length;i++){
            for(int j = 0;j<nodeMatrix[0].length;j++){
                makeNode(i,j,nodeMatrix[i][j],nodeMatrix);
            }
        }

        return nodeMatrix;

    }


    public void makeNode(int i,int j,Node n,Node[][] nodeMatrix){

        int strCol =0;
        int endCol = nodeMatrix[0].length-1;
        int strRow =0;
        int endRow = nodeMatrix.length-1;

        if(i == strRow && j == endCol){
            n.friends.add(nodeMatrix[i][j-1]);
            n.friends.add(nodeMatrix[i+1][j]);
            return;
        }

        if(i == endRow && j == strCol){
            return;
        }

        if(i-1>=strRow){

            n.friends.add(nodeMatrix[i-1][j]);
        }

        if(i+1<=endRow){

            n.friends.add(nodeMatrix[i+1][j]);
        }

        if(j-1>=strCol){
            n.friends.add(nodeMatrix[i][j-1]);
        }

        if(j+1<=endCol){
            n.friends.add(nodeMatrix[i][j+1]);
        }
    }


    public void traverse(Node node,StringBuilder sb){

       Stack<Node> stack = new Stack<>();
       boolean str = true;
       if(node.friends.isEmpty()){
           System.out.println(sb.toString());
           sb.deleteCharAt(sb.length()-1);
           this.count++;
           return;
       }

       if(str== true){
         stack.addAll(node.friends);
         str = false;
       }

       while (!stack.isEmpty()){
           Node temp = stack.pop();
           sb.append(temp.val);
       //    System.out.println(sb.toString()+"-----");
           if(!checkSameChar(sb)){
               traverse(temp,sb);
           }else {
               sb.deleteCharAt(sb.length()-1);
           }
       }

        sb.deleteCharAt(sb.length()-1);
    }


    public boolean checkSameChar(StringBuilder sb){
        String s = sb.toString();

        Map<Character,Integer> map = new TreeMap<>();

        for(Character ch : s.toCharArray()){
            if(map.containsKey(ch)){
               return true;
            }else{
                map.put(ch,1);
            }
        }

     return false;
    }





}
