package Uber_1;

import java.util.*;

// Definition for a node.
class node {
    public int val;
    public List<node> children;

    public node() {}

    public node(int _val) {
        val = _val;
    }

    public node(int _val, List<node> _children) {
        val = _val;
        children = _children;
    }
};




class Codec {


    public static void main(String[] args) {
        Codec codec = new Codec();
        node n1 = new node(1);
        node n2 = new node(2);
        node n3 = new node(3);
        node n4 = new node(4);
        node n5 = new node(5);
        node n6 = new node(6);

        n1.children = new ArrayList<>();
        n2.children = new ArrayList<>();
        n3.children = new ArrayList<>();
        n4.children = new ArrayList<>();

        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);

        n3.children.add(n5);
        n3.children.add(n6);

        String s = codec.serialize(n1);
        System.out.println(s);
        node na = codec.deserialize(s);

    }
    // Encodes a tree to a single string.
    public String serialize(node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            node temp = queue.remove();


            if (temp.children != null && temp.children.size() != 0) {
                sb.append(temp.val);
                sb.append("=");
                for (node child : temp.children) {
                    sb.append(child.val);
                    sb.append(",");
                    queue.add(child);
                }

                sb.deleteCharAt(sb.length() - 1);
                sb.append("|");
            }



        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public node deserialize(String data) {
        if (data == "") {
            return null;
        }


        String[] levels = data.split("\\|");
        Map<Integer, List<Integer>> map = createMap(levels);


        node root = new node(Character.getNumericValue(data.charAt(0)));
        createNode(map, root);
        return root;
    }


    public void createNode(Map<Integer, List<Integer>> map, node root) {

        if (map.containsKey(root.val)) {
            root.children = new ArrayList<>();
            for (Integer child : map.get(root.val)) {
                node temp = new node(child);
                root.children.add(temp);
                createNode(map, temp);
            }
        }

    }


    public Map<Integer, List<Integer>> createMap(String[] levels) {


        Map<Integer, List<Integer>> map = new HashMap<>();
        for (String singleLevel : levels) {
            String[] splitSingleLevel = singleLevel.split("=");
            List<Integer> list = new ArrayList<>();

            String[] childrenNode = (splitSingleLevel[1]).split(",");
            for (String singleChildrenNode : childrenNode) {
                list.add(Integer.parseInt(singleChildrenNode));
            }


            map.put(Integer.parseInt(splitSingleLevel[0]), list);

        }


        return map;
    }


}