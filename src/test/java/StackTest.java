import Array.Element;
import List.Stack;
import List.Node;
import org.junit.Test;
import org.junit.Assert;

import static List.Stack.*;

public class StackTest {

    @Test
    public void isBalancedTest(){
        String test1 = "(()())"; // Balanced
        String test2 = "((()(";  // Not balanced

        System.out.println(Stack.isBalanced(test1)); // true
        System.out.println(Stack.isBalanced(test2)); // false
    }

    @Test
    public void isBalancedExpendedTest(){
        String test1 = "{(())[{}]}()"; // Balanced
        String test2 = "({)}";        // Not balanced

        System.out.println(isBalancedExpended(test1)); // true
        System.out.println(isBalancedExpended(test2)); // false
    }

    @Test
    public void enlargeTest(){
        Array.Stack stack = new Array.Stack(2);
        stack.push(new Element(2));
        stack.push(new Element(1));

        stack.enlarge();

        stack.push(new Element(3));
        stack.push(new Element(4));

        stack.printArrayStack();
    }

    @Test
    public void palindromeTest(){
        System.out.println(palindrom("racecar")); // ✅ true
        System.out.println(palindrom("madam"));   // ✅ true
        System.out.println(palindrom("hello"));   // ❌ false
        System.out.println(palindrom("a"));       // ✅ true
        System.out.println(palindrom("ab"));      // ❌ false
    }

    @Test
    public void testBottom() {
        Array.Stack stack = new Array.Stack(5); // Initial capacity = 5

        // Push elements into the stack
        stack.push(new Element(10));  // Bottom element
        stack.push(new Element(20));
        stack.push(new Element(30));
        stack.push(new Element(40));  // Top element

        // Call bottom() method
        Element bottomElement = stack.bottom();

        // ✅ Check if the bottom element is correct
        Assert.assertEquals(10, bottomElement.getData());
    }

    @Test
    public void testInsertAfterLargest(){
        Array.Stack stack = new Array.Stack(5);
        stack.push(new Element(10));
        stack.push(new Element(40));
        stack.push(new Element(30));
        stack.push(new Element(20));

        stack.printArrayStack();

        stack.insertAfterLargest(25);

        stack.printArrayStack();
    }

    @Test
    public void removeOddIndexedTest(){
        Stack stack = new Stack();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.push(new Node(4));
        stack.push(new Node(5));
        stack.push(new Node(6));
        stack.removeOddIndexes();
        stack.printStack();


    }


}
