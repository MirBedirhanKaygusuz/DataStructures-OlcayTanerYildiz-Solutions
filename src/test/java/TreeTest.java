import Tree.Tree;
import Tree.TreeNode;
import org.junit.Test;


public class TreeTest {

    @Test
    public void TestTree(){
        Tree tree = new Tree();
        tree.iterativeInsert(new TreeNode(7));
        tree.iterativeInsert(new TreeNode(4));
        tree.iterativeInsert(new TreeNode(10));
        tree.iterativeInsert(new TreeNode(2));
        tree.iterativeInsert(new TreeNode(6));
        tree.getRoot().prettyPrint(0);
        int[] result = tree.getRoot().collectNodes();

        System.out.print("Sıralı sonuç: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println(tree.getRoot().numberOfMeanNodes());
        System.out.println(tree.getRoot().leftistOrRightist());
        System.out.println(tree.nodeCountWithStack());
        System.out.println(tree.product());

        Tree tree1 = new Tree();
        TreeNode root = new TreeNode(6);
        tree1.iterativeInsert(root);
        tree1.iterativeInsert(new TreeNode(4));
        tree1.iterativeInsert(new TreeNode(8));
        tree1.iterativeInsert(new TreeNode(1));
        tree1.iterativeInsert(new TreeNode(11));
        tree1.iterativeInsert(new TreeNode(5));
        tree1.iterativeInsert(new TreeNode(7));

        Tree tree2 = new Tree();
        TreeNode root2 = new TreeNode(3);
        tree2.iterativeInsert(root2);
        tree2.iterativeInsert(new TreeNode(2));
        tree2.iterativeInsert(new TreeNode(4));
        tree2.iterativeInsert(new TreeNode(1));
        tree2.iterativeInsert(new TreeNode(3));
        tree2.iterativeInsert(new TreeNode(3));
        tree2.iterativeInsert(new TreeNode(5));

        System.out.println(root.sumOfNodesBetween(5,10));
        System.out.println(root2.averages());

        System.out.println(root.isIdentical(tree.getRoot(), tree1.getRoot()));
    }

}
