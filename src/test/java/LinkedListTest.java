import List.DoublyLinkedList;
import List.DoublyNode;
import List.LinkedList;
import List.Node;
import org.junit.Test;
import org.junit.Assert;

import static List.LinkedList.fibonacci;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LinkedListTest {

    @Test
    public void testDeletePrimes() {
        // Create linked list
        LinkedList list = new LinkedList();

        // Insert test values (including prime and non-prime numbers)
        list.insertLast(new Node(2));  // Prime
        list.insertLast(new Node(3));  // Prime
        list.insertLast(new Node(4));  // Not Prime
        list.insertLast(new Node(5));  // Prime
        list.insertLast(new Node(6));  // Not Prime
        list.insertLast(new Node(7));  // Prime
        list.insertLast(new Node(7));  // Not Prime

        // Before deletion
        System.out.println("Before deletePrimes: " + list);

        // Call deletePrimes()
        list.deletePrimes();

        // After deletion
        System.out.println("After deletePrimes: " + list);

        // Expected values in the list after removing primes: [4, 6, 8]

    }



    @Test
    public void testRemoveKthBeforeLast() {
        // Create a new doubly linked list
        DoublyLinkedList list2 = new DoublyLinkedList();

        // Insert test values
        list2.insertLast(new DoublyNode(1));
        list2.insertLast(new DoublyNode(2));
        list2.insertLast(new DoublyNode(3));
        list2.insertLast(new DoublyNode(4));
        list2.insertLast(new DoublyNode(5));

        System.out.println("Before removal: " + list2);
        // Remove the 3rd node from the end (should remove node "3")
        list2.removeKthBeforeLast(3);
        System.out.println("After removing 3rd from last: " + list2);
    }

    @Test
    public void isPolindromTest(){
        LinkedList list = new LinkedList();
        list.insertLast(new Node(1));
        list.insertLast(new Node(2));
        list.insertLast(new Node(3));
        list.insertLast(new Node(2));
        list.insertLast(new Node(1));

        System.out.println(list.isPalindrom());  // Output: true

        list.insertLast(new Node(4));
        System.out.println(list.isPalindrom());  // Output: false
    }

    @Test
    public void fibTest(){
        System.out.println(fibonacci(20,90));
    }

    @Test
    public void containsOnlyTriplicatesTest(){
        LinkedList list = new LinkedList();
        list.insertLast(new Node(1));
        list.insertLast(new Node(2));
        list.insertLast(new Node(3));
        list.insertLast(new Node(1));
        list.insertLast(new Node(2));
        list.insertLast(new Node(3));
        list.insertLast(new Node(1));
        list.insertLast(new Node(2));
        list.insertLast(new Node(3));
        System.out.println(list.containsOnlyTriplicates()); // true
    }

    @Test
    public void reverseTest(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertLast(new DoublyNode(1));
        list.insertLast(new DoublyNode(2));
        list.insertLast(new DoublyNode(3));

        System.out.println(list);

        list.reverse();

        System.out.println(list);

    }


}