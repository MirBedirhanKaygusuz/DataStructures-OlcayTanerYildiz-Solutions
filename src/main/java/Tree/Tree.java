package Tree;

public class Tree {

    final static int LEFT = 0;
    final static int RIGHT = 1;

    protected TreeNode root;

    public Tree(){
        root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }

    public TreeNode recursiveSearch(int value){
        if (root != null){
            return root.recursiveSearch(value);
        } else {
            return null;
        }
    }

    public TreeNode iterativeSearch(int value){
        TreeNode tmp = root;
        while (tmp != null){
            if (value < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                if (value > tmp.getData()){
                    tmp = tmp.getRight();
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    public TreeNode iterativeMinSearch(){
        TreeNode tmp = root;
        TreeNode parent = null;
        while (tmp != null) {
            parent = tmp;
            tmp = tmp.getLeft();
        }
        return parent;
    }

    public TreeNode iterativeMaxSearch(){
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.getRight() == null){
                return tmp;
            }
            tmp = tmp.getRight();
        }
        return null;
    }

    public TreeNode recursiveMinSearch(){
        if (root != null){
            return root.recursiveMinSearch();
        }
        return null;
    }

    public TreeNode recursiveMaxSearch(){
        if (root != null){
            return root.recursiveMaxSearch();
        }
        return null;
    }

    protected TreeNode getParent(TreeNode node){
        TreeNode x = root, parent = null;
        while (x != node){
            parent = x;
            if (x.data > node.data){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return parent;
    }

    public void delete(int value){
        TreeNode y, x = root, parent;
        while (x.data != value){
            if (x.data > value){
                x = x.left;
            } else {
                x = x.right;
            }
        }
        parent = getParent(x);
        while (true){
            if (x.left != null){
                y = x.left.recursiveMaxSearch();
                parent = getParent(y);
            } else {
                if (x.right != null){
                    y = x.right.recursiveMinSearch();
                    parent = getParent(y);
                } else {
                    if (parent == null){
                        root = null;
                    } else {
                        if (parent.left == x){
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    break;
                }
            }
            x.data = y.data;
            x = y;
        }
    }

    public void inorder(){
        if (root != null){
            root.inorder();
        }
    }

    public void preorder(){
        if (root != null){
            root.preorder();
        }
    }

    public void postorder(){
        if (root != null){
            root.postorder();
        }
    }

    protected void insertChild(TreeNode parent, TreeNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.data < parent.data) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNode node){
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void recursiveInsert(TreeNode node){
        if (root == null){
            root = node;
        } else {
            root.recursiveInsert(node);
        }
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }

    public int nodeCountWithStack(){
        TreeNode tmp;
        int count = 0;
        Stack c = new Stack(100);
        if (root != null){
            c.push(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.pop();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.push(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    public int nodeCountWithQueue(){
        TreeNode tmp;
        int count = 0;
        Queue c = new Queue(100);
        if (root != null){
            c.enqueue(new Element(root));
        }
        while (!c.isEmpty()){
            Element e = c.dequeue();
            count++;
            tmp = e.getData();
            if (tmp.getLeft() != null){
                c.enqueue(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                c.enqueue(new Element(tmp.getRight()));
            }
        }
        return count;
    }

    //--------------------------------------Questions and Solutions-----------------------------------------------------



    //18. Write a non-recursive method
    //double simulateSearch(int N)
    //in Tree class, which first finds the minimum (A) and maximum (B)
    //elements in the tree. The method will then randomly search a number
    //between [A, B] N times and returns the average number of nodes visited
    //in this search. You are not allowed to use any tree methods.





    //24. Write the non-recursive method
    //int product()
    //in Tree class that computes the products of all keys in a binary search
    //tree by using stack.
    public int product(){
        int count = this.nodeCountWithStack();
        Stack stack = new Stack(count);
        int product = 1;
        TreeNode tmp;

        if(root != null){
            stack.push(new Element(root));
        }

        while(!stack.isEmpty()){
            Element e = stack.pop();
            tmp = e.getData();
            product *= tmp.data;
            if(tmp.left != null){
                stack.push(new Element(tmp.getLeft()));
            }
            if (tmp.getRight() != null){
                stack.push(new Element(tmp.getRight()));
            }
        }

        return product;
    }






}
