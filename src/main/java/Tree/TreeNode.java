package Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;

public class TreeNode {

    protected TreeNode left;
    protected TreeNode right;
    protected int data;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public int getData(){
        return data;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public TreeNode recursiveSearch(int value){
        if (data == value){
            return this;
        }
        if (value < data){
            if (left != null){
                return left.recursiveSearch(value);
            } else {
                return null;
            }
        } else {
            if (right != null){
                return right.recursiveSearch(value);
            } else {
                return null;
            }
        }
    }

    public TreeNode recursiveMinSearch(){
        if (left == null){
            return this;
        }
        return left.recursiveMinSearch();
    }

    public TreeNode recursiveMaxSearch(){
        if (right == null){
            return this;
        }
        return right.recursiveMaxSearch();
    }

    public void preorder(){
        System.out.println(data);
        if (left != null){
            left.preorder();
        }
        if (right != null){
            right.preorder();
        }
    }

    public void inorder(){
        if (left != null){
            left.inorder();
        }
        System.out.println(data);
        if (right != null){
            right.inorder();
        }
    }

    public void postorder(){
        if (left != null){
            left.postorder();
        }
        if (right != null){
            right.postorder();
        }
        System.out.println(data);
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }

    public void recursiveInsert(TreeNode node){
        if (node.getData() < data){
            if (left != null){
                left.recursiveInsert(node);
            } else {
                left = node;
            }
        } else {
            if (right != null){
                right.recursiveInsert(node);
            } else {
                right = node;
            }
        }
    }

    //--------------------------------------Questions and Solutions-----------------------------------------------------
    //1. Write a function that finds the diﬀerence between the number of leftist
    //nodes and rightist nodes in a binary search tree. A node is leftist
    //(rightist) if it has only left (right) child.
    //int leftistOrRightist ()
    public int leftistOrRightist(){
        int diff =0;
        if(left!= null && right == null){
            diff++;
        }
        if(left == null && right != null){
            diff--;
        }
        if (left != null){
            diff += left.leftistOrRightist();
        }
        if (right != null){
            diff += right.leftistOrRightist();
        }

        return diff;
    }

    //2. Write a function which returns the number of mean nodes. A node is a
    //mean node if its value is the mean of its left and right children’s values.
    //int number of mean nodes(Treeptr a), int numberOfMeanNodes()
    public int numberOfMeanNodes(){
        int numOfNodes = 0;

        if(left != null && right != null){
            if(data == (left.data+right.data)/2){
                numOfNodes +=1;
            }
        }

        if (left != null){
            numOfNodes += left.numberOfMeanNodes();
        }
        if (right!= null){
            numOfNodes += right.numberOfMeanNodes();
        }

        return numOfNodes;
    }

    //15. Write the recursive method
    //int averages()
    //in TreeNode class which returns the number of nodes in the tree that
    //satisfy the following property: The node’s key is the average of its
    //children (left and right children).
    public int averages() {
        int numOfNodes = 0;

        if (left != null && right != null) {
            if (data == (left.data + right.data) / 2) {
                numOfNodes += 1;
            }
        }

        if (left != null) {
            numOfNodes += left.averages();
        }
        if (right != null) {
            numOfNodes += right.averages();
        }

        return numOfNodes;
    }

    //17. Write the recursive method
    //void accumulateLeafNodes(Queue queue)
    //in TreeNode class which accumulates the contents (integer as data field)
    //of all leaf nodes in queue. For queue, you are only allowed to use
    //enqueue function. You should use array implementation for the queue
    //in this question.
    public void accumulateLeafNodes(Queue queue) {

        if(left == null && right == null){
            Element element = new Element(this);
            queue.enqueue(element);
        }

        if(left != null){
            left.accumulateLeafNodes(queue);
        }

        if(right != null){
            right.accumulateLeafNodes(queue);
        }

    }


        //20. Write the recursive method
    //int sumOfNodesBetween(int p, int q)
    //in TreeNode class which returns the sum of the keys between p and q
    //in the tree. Your algorithm should run in O(log N + K), where K is
    //the number of nodes which have value larger than p and less than q in
    //the tree.
    public int sumOfNodesBetween(int p, int q) {
        int sum = 0;

        if (data > p && data < q) {
            sum += data;
        }

        if (left != null && data > p) {
            sum += left.sumOfNodesBetween(p, q);
        }

        if (right != null && data < q) {
            sum += right.sumOfNodesBetween(p, q);
        }

        return sum;
    }

    //21. Write the recursive method
    //int[] collectNodes()
    //in TreeNode class, which collects all values in all nodes in the tree in a
    //sorted manner. You are not allowed to use any tree methods.
    public int[] collectNodes(){
        int[] leftArr;
        if (left != null) {
            leftArr = left.collectNodes();
        } else {
            leftArr = new int[0];
        }

        int[] rightArr;
        if (right != null) {
            rightArr = right.collectNodes();
        } else {
            rightArr = new int[0];
        }

        int[] merged = new int[leftArr.length + 1 + rightArr.length];

        // Solu kopyala
        for (int i = 0; i < leftArr.length; i++) {
            merged[i] = leftArr[i];
        }

        // Ortaya kendi data'yı ekle
        merged[leftArr.length] = data;

        // Sağı kopyala (!! dikkat: j değil i kullanalım)
        for (int i = 0; i < rightArr.length; i++) {
            merged[leftArr.length + 1 + i] = rightArr[i];
        }

        // BST değilse sıralama yapmamız gerekiyor
        for (int i = 0; i < merged.length - 1; i++) {
            for (int j = 0; j < merged.length - 1 - i; j++) {
                if (merged[j] > merged[j + 1]) {
                    int temp = merged[j];
                    merged[j] = merged[j + 1];
                    merged[j + 1] = temp;
                }
            }
        }

        return merged;

    }




    //23. T1 and T2 are two binary trees. Write the recursive method
    //boolean isIdentical (TreeNode T1, TreeNode T2)
    //in Tree or TreeNode class to determine if T1 is identical to T2.
    public boolean isIdentical(TreeNode T1, TreeNode T2) {

        if (T1 == null && T2 == null) {
            return true; // Both trees are empty
        }

        if (T1 == null || T2 == null) {
            return false; // One tree is empty, one is not
        }

        if (T1.getData() != T2.getData()) {
            return false; // Data doesn't match
        }

        // Recursively check left and right subtrees
        return isIdentical(T1.getLeft(), T2.getLeft()) && isIdentical(T1.getRight(), T2.getRight());
    }

    //25. Given a binary tree (not necessarily search tree), implement method
    //bool isMirror (TreeNode∗ left , TreeNode∗ right)
    //in TreeNode class to check whether an input binary tree is a mirror of
    //itself (symmetric). You may not use any additional data structure or
    //array. Below is an example of a symmetric tree.
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true; // ikisi de boşsa simetrik
        }

        if (left == null || right == null) {
            return false; // biri boş, biri değilse simetrik değil
        }

        if (left.data != right.data) {
            return false; // veri eşleşmiyor
        }

        // çapraz kontroller
        return isMirror(left.left, right.right) &&
                isMirror(left.right, right.left);
    }


}
