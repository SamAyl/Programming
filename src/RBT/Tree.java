package RBT;

public class Tree {

    Node root;

    public void insertCheck(Node node,Node root){
        insert(node, root);
        check(node);

        this.root.color = 'b';
    }

    public  void insert(Node node,Node root){
        if(this.root == null){
            this.root = new Node(node.value,'b');
            this.root.left = Node.getNil();
            this.root.right = Node.getNil();
            root = this.root;
            return;
        }

        if(root.value<node.value){
            if(root.right == null || root.right.value == -1) {
                root.right = node;
                node.parent = root;
                node.left = Node.getNil();
                node.right = Node.getNil();
                return;
            }else{
                insert(node,root.right);
                return;
            }
        }

        if(root.value >= node.value) {
            if (root.left == null || root.left.value == -1) {
                root.left = node;
                node.parent = root;
                node.left = Node.getNil();
                node.right = Node.getNil();
                return;
            } else {
                insert(node, root.left);
                return;
            }
        }
    }


    public void check(Node node){
        if(node == null || node.parent == null){
            return;
        }

        if(node.color == 'r' && node.parent.color == 'r'){

            int type = getType(node);
            Node node1 = node.parent.parent;
            Node temp = null;

            switch(type){
                case 1:
                    if(node1.left.color == 'b'){
                        temp =  caseRotate1(node,'r');
                    }else if(node1.left.color == 'r'){
                        temp =  caseRotate2(node,'r');
                    }

                    break;

                case 2:
                    if(node1.left.color == 'b'){
                        temp =    caseRotate1(node,'l');
                    }else if(node1.left.color == 'r'){
                        temp =   caseRotate2(node,'l');
                    }

                    break;

                case 3:
                    if(node1.left.color == 'b'){
                       temp= caseRotate3(node,'r');
                    }else if(node1.left.color == 'r'){
                        temp = caseRotate4(node,'r');
                    }

                    break;

                case 4:
                    if(node1.left.color == 'b'){
                      temp =  caseRotate3(node,'l');
                    }else if(node1.left.color == 'r'){
                        temp = caseRotate4(node,'l');
                    }

                    break;

                case 5:
                    if(node1.right.color == 'b'){
                      temp =   caseRotate1Mirror(node,'r');
                    }else if(node1.right.color == 'r'){
                       temp =  caseRotate2Mirror(node,'r');
                    }

                    break;

                case 6:
                    if(node1.right.color == 'b'){
                       temp =  caseRotate1Mirror(node,'l');
                    }else if(node1.right.color=='r'){
                       temp =  caseRotate2Mirror(node,'l');
                    }

                    break;

                case 7:
                    if(node1.right.color == 'b'){
                      temp =   caseRotate3Mirror(node,'r');
                    }else if(node1.right.color == 'r'){
                      temp =   caseRotate4Mirror(node,'r');
                    }

                    break;


                case 8:
                    if(node1.right.color == 'b'){
                      temp =   caseRotate3Mirror(node,'l');
                    }else if(node1.right.color == 'r'){
                       temp =  caseRotate4Mirror(node,'r');
                    }

                    break;

            }


            check(temp);

        }


    }


    public int getType(Node node){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node uncle;
        Node greatGrandParent = grandParent.parent;

        if(parent.right == node && grandParent.right == parent){
            uncle = grandParent.left;

            if(greatGrandParent==null ||greatGrandParent.right == grandParent){
                return 1;
            }else if(greatGrandParent.left== grandParent){
                return 2;
            }
        }


        if(parent.left == node && grandParent.right == parent){
            uncle = grandParent.left;
            if(greatGrandParent==null||greatGrandParent.right == grandParent){
                return  3;
            }else if(greatGrandParent.left == grandParent){
                return  4;
            }

        }



        if(parent.left  == node && grandParent.left == parent){
            uncle = grandParent.right;

            if(greatGrandParent==null||greatGrandParent.right == grandParent){
                return 5;
            }else if(greatGrandParent.left == grandParent){
                return 6;
            }


        }

        if(parent.right == node && grandParent.left == parent){
            uncle = grandParent.right;

            if(greatGrandParent==null||greatGrandParent.right == grandParent){
                return 7;
            }else if(greatGrandParent.left == grandParent){

                return  8;
            }

        }

        return 0;

    }

    public Node caseRotate1(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node greatGrandParent = grandParent.parent;

        /*structure change */
        Node tempLeft = parent.left;
        parent.left = grandParent;
        grandParent.right = tempLeft;

        grandParent.parent = parent;
        parent.parent = greatGrandParent;

        /*color changing */
        grandParent.color = 'r';
        parent.color = 'b';


        /*greatGrandParent change*/
        if(greatGrandParent!=null && ggp == 'l'){
            greatGrandParent.left = parent;
        }else if(greatGrandParent!=null && ggp == 'r'){
            greatGrandParent.right = parent;
        }


        return parent;

    }


    public Node caseRotate2(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node uncle = grandParent.left;


        /*color changing*/
        uncle.color='b';
        parent.color = 'b';
        grandParent.color = 'r';





        return grandParent;
    }


    public Node caseRotate3(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node tempRight = node.right;

        /*restructuring the node */
        node.right = parent;
        parent.left = tempRight;

        parent.parent = node;
        node.parent = grandParent;
        grandParent.right = node;

        return caseRotate1(parent,ggp);



    }

    public Node caseRotate4(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node tempRight = node.right;

        /*restructuring the node */
        node.right = parent;
        parent.left = tempRight;

        parent.parent = node;
        node.parent = grandParent;
        grandParent.right = node;

        return caseRotate2(parent,ggp);

    }


    public Node caseRotate1Mirror(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node greatGrandParent = grandParent.parent;

        Node tempRight = parent.right;

        /*restructuring the code */

        parent.right = grandParent;
        grandParent.left = tempRight;
        grandParent.parent = parent;
        parent.parent = greatGrandParent;


        /*recoloring the nodes*/

        parent.color = 'b';
        grandParent.color = 'r';

        if(greatGrandParent!=null && ggp == 'r'){
            greatGrandParent.right = parent;
        }else if(greatGrandParent!=null && ggp == 'l'){
            greatGrandParent.left = parent;
        }


        return  parent;



    }

    public Node caseRotate2Mirror(Node node,char ggp){

        Node parent = node.parent;
        Node grandParent = parent.parent;
        Node uncle = grandParent.right;

        parent.color = 'b';
        uncle.color = 'b';
        grandParent.color = 'r';

        return grandParent;
    }

    public Node caseRotate3Mirror(Node node, char ggp){
        Node parent = node.parent;
        Node grandParent  = parent.parent;
        Node tempLeft  = node.left;

       /*restructuring the code */

        grandParent.left = node;
        node.left = parent;
        parent.right = tempLeft;

        node.parent = grandParent;
        parent.parent = node;

        return   caseRotate1Mirror(parent,ggp);

    }

    public Node caseRotate4Mirror(Node node, char ggp){

        Node parent = node.parent;
        Node grandParent  = parent.parent;
        Node tempLeft  = node.left;

       /*restructuring the code */

        grandParent.left = node;
        node.left = parent;
        parent.right = tempLeft;

        node.parent = grandParent;
        parent.parent = node;


        return caseRotate2Mirror(parent,ggp);
    }


    public void print(Node node){

        if(node.left!=null){
            print(node.left);
        }
        if(node.value!=-1) {
            System.out.println(node.value);
        }

        if(node.right!=null){
            print(node.right);
        }
    }

}
