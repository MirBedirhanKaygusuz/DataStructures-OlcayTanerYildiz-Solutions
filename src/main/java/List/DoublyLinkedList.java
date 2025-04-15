package List;

public class DoublyLinkedList extends LinkedList{

    public void insertFirst(DoublyNode newNode) {
        if (tail == null) {
            tail = newNode;
        } else {
            ((DoublyNode) head).setPrevious(newNode);
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertMiddle(DoublyNode newNode, DoublyNode previous) {
        newNode.setNext(previous.getNext());
        newNode.setPrevious(previous);
        ((DoublyNode) previous.getNext()).setPrevious(newNode);
        previous.setNext(newNode);
    }

    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteFirst(){
        head = head.getNext();
        if (head == null){
            tail = null;
        } else {
            ((DoublyNode)head).setPrevious(null);
        }
    }

    public void deleteMiddle(DoublyNode node){
        ((DoublyNode) node.getNext()).setPrevious(node.getPrevious());
        node.getPrevious().setNext(node.getNext());
    }

    public void deleteLast(){
        tail = ((DoublyNode)tail).getPrevious();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    //Write the method
    //void reverse ()
    //for reversing a doubly linked list. Your method should have a time com-
    //plexity of O(N). You are not allowed to use any extra data structures.
    //You are not allowed to use any linked list methods, just attributes,
    //constructors, getters and setters.

    public void reverse(){
       DoublyNode current = (DoublyNode) head;
       DoublyNode tmp = null;
       while(current!= null){
           tmp = current.getPrevious();
           current.setPrevious((DoublyNode) current.getNext());
           current.setNext(tmp);
           current = current.getPrevious();
       }

       if(tmp != null){
           head = tmp.getPrevious();
       }
    }



}
