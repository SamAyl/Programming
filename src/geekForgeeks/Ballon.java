package geekForgeeks;

import java.util.*;

public class Ballon {


    public static void main(String[] args) {
        int[][] points = new int[4][2];
        points[0][0] = 10;
        points[0][1] = 16;

        points[1][0] = 2;
        points[1][1] = 8;

        points[2][0] = 1;
        points[2][1] = 6;

        points[3][0] = 7;
        points[3][1] = 12;

        Ballon ballon = new Ballon();
       int ans =  ballon.findMinArrowShots(points);
        System.out.println(ans);
    }


        public int findMinArrowShots(int[][] points) {

            Node[] nodes = getNodes(points);
            Arrays.sort(nodes);


            List<Node> mergedNodes = new ArrayList<>();
            mergedNodes.add(nodes[0]);

            int count = 1;
            while(count<nodes.length){
                if(mergedNodes.get(mergedNodes.size()-1).x2 >=nodes[count].x1){

                    Node temp = mergedNodes.get(mergedNodes.size()-1);

                    if(temp.x2 < nodes[count].x2){
                        temp.x2 = nodes[count].x2;
                    }



                } else {
                    mergedNodes.add(nodes[count]);

                }
                count++;
            }

            return mergedNodes.size();
        }

        class Node implements Comparable<Node>{
            public int x1;
            public int x2;

            public Node(int x1,int x2){
                this.x1 = x1;
                this.x2 = x2;
            }

            public int compareTo(Node o){
                if(x1 > o.x1){
                    return 1;
                } else if(x1 < o.x1){
                    return -1;
                }

                return 0;
            }
        }


        Node[] getNodes(int[][] points){
            Node[] nodes = new Node[points.length];
            for(int i = 0;i<points.length;i++){
                nodes[i] = new Node(points[i][0],points[i][1]);
            }

            return nodes;
        }
    }

