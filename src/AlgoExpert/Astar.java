package AlgoExpert;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.*;

public class Astar {

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1,1,1},{1,0,0,0,1},{1,1,1,1,1},{1,1,1,1,0},{1,1,1,1,1}};
        int strX = 0;
        int strY = 1;

        int endX = 4;
        int endY = 1;



        PriorityQueue<MNode> pq = new PriorityQueue<MNode>();
        MNode temp = new MNode(strX,strY,null);
        temp.parent = temp;
        pq.add(temp);


        Set<MNode> visited = new HashSet<>();


        Map<Integer,MNode> nodeMap = new HashMap<>();
        nodeMap.put(temp.hashCode(),temp);


        List<List<Integer>> list = new ArrayList<>();
        while (true) {

            MNode curr = pq.remove();
            if (curr.x == endX && curr.y ==endY) {
                getPath(list,curr);
                break;
            }
            visited.add(curr);

           // System.out.println(curr.x + "   " + curr.y);
            MNode left = null;
            MNode right = null;
            MNode top = null;
            MNode bottom = null;

            if (curr.y - 1 >=0 && matrix[curr.x][curr.y-1] != 0) {
                MNode tempLeft = new MNode(curr.x, curr.y-1,curr);
                if (!visited.contains(tempLeft)) {
                    left = tempLeft;
                    left.strDistance = curr.strDistance+1;
                    setHdist(left,endX,endY);
                    updatePQ(left,pq,nodeMap);
                }
            }

            if (curr.y + 1 < matrix[0].length  && matrix[curr.x][curr.y+1] != 0) {
                MNode tempRight = new MNode(curr.x, curr.y+1,curr);
                if (!visited.contains(tempRight)) {
                    right = tempRight;
                    right.strDistance = curr.strDistance+1;
                    setHdist(right,endX,endY);
                    updatePQ(right,pq,nodeMap);
                }
            }


            if (curr.x - 1 >= 0 && matrix[curr.x-1][curr.y] != 0) {
                MNode tempTop = new MNode(curr.x-1,curr.y,curr);
                if (!visited.contains(tempTop)) {
                    top = tempTop;
                    top.strDistance = curr.strDistance + 1;
                    setHdist(top,endX,endY);
                    updatePQ(top,pq,nodeMap);
                }
            }

            if (curr.x + 1 < matrix.length && matrix[curr.x+1][curr.y] != 0) {
                MNode tempBottom = new MNode(curr.x+1,curr.y,curr);
                if (!visited.contains(tempBottom)) {
                    bottom = tempBottom;
                    bottom.strDistance = curr.strDistance + 1;
                    setHdist(bottom,endX,endY);
                    updatePQ(bottom,pq,nodeMap);
                }
            }




        }


        for (List<Integer> tempList : list) {
            System.out.println(tempList.get(0)+ ","+tempList.get(1));
        }
    }


    public static void setHdist(MNode node, int x, int y) {
        node.hDistance = Math.abs(x - node.x) + Math.abs(y - node.y);
        node.totDistance = node.strDistance + node.hDistance;
    }

    public static void updatePQ(MNode node, PriorityQueue<MNode> pq, Map<Integer,MNode> nodesPresentInPQ) {
       if (nodesPresentInPQ.containsKey(node.hashCode())) {
           MNode nodeInPQ = nodesPresentInPQ.get(node.hashCode());
           if (node.compareTo(nodeInPQ) < 0) {
               nodesPresentInPQ.put(node.hashCode(),node);
               pq.remove(nodeInPQ);
               pq.add(node);
           }
       } else {
           pq.add(node);
           nodesPresentInPQ.put(node.hashCode(),node);
       }
    }

    public static void getPath(List<List<Integer>> list, MNode curr) {
        if (curr.parent == curr) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(curr.x);
            list1.add(curr.y);

            list.add(list1);
            return;
        }

        List<Integer> list12 = new ArrayList<>();
        list12.add(curr.x);
        list12.add(curr.y);
        list.add(list12);
        getPath(list,curr.parent);
    }
}

class MNode implements Comparable<MNode> {

    int x;
    int y;
    int totDistance;
    int hDistance;
    int strDistance;

    MNode parent;

    public MNode(int x, int y , MNode parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    @Override
    public int compareTo(MNode o) {
        int totDistCompare = totDistance - o.totDistance;
        if (totDistCompare != 0) {
            return totDistCompare;
        }

//        int strDistCompare = strDistance - o.strDistance;
//
//        if (strDistCompare != 0) {
//            return strDistCompare;
//        }

        int hDistCompare = hDistance - o.hDistance;

        if (hDistCompare != 0) {
            return hDistCompare;
        }

        int strDistCompare = strDistance - o.strDistance;

        if (strDistCompare != 0) {
            return strDistCompare;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MNode) {
            MNode mNode = (MNode)o;
            if (mNode.x == this.x  && mNode.y == this.y){
                return true;
            }else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }
}
