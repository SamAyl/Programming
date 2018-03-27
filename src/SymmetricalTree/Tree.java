package SymmetricalTree;

import java.util.ArrayDeque;

public class Tree {

    public void insert(int value,Node root){
        if(root.value == Integer.MIN_VALUE){
            root.value = value;
            return;
        }

        if(root.value<=value) {
            if (root.right == null) {
                root.right = new Node(value);
                return;
            } else {
                insert(value, root.right);
            }


        }

        if(root.value>value){
            if(root.left == null){
                root.left = new Node(value);
            }else {
                insert(value,root.left);
            }
        }
    }


    public void inOrderLeft(Node root, ArrayDeque<Node> arrayDeque){
        if(root.left!=null){
            inOrderLeft(root.left,arrayDeque);
        }

        arrayDeque.add(root);

        if(root.right!=null){
            inOrderLeft(root.right,arrayDeque);
        }

    }


    public boolean inOrderRight(Node root,ArrayDeque<Node> arrayDeque){
        boolean b1 = true;
        boolean b2 = true;

        if(root.left!=null){
          b1 =  inOrderRight(root.left,arrayDeque);
        }

        if(b1 && !arrayDeque.isEmpty()){
          Node element =  arrayDeque.removeLast();
          if(element.value != root.value){
              return false;
          }
        }else if(arrayDeque.isEmpty()){
            return false;
        }

        if(root.right!=null){
            b2 = inOrderRight(root.right,arrayDeque);
        }

        return b1&&b2;
    }


    public boolean findSymmetry(Node root1,Node root2){
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        inOrderLeft(root1,arrayDeque);
        boolean temp = inOrderRight(root2,arrayDeque);

        if(temp==false){
            return temp;
        }else {
            if(arrayDeque.isEmpty()){
                return true;
            }else {
                return false;
            }
        }
    }


    public void dfs(Node root){

    }
}
