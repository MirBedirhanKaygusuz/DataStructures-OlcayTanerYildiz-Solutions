package List;


public class LinkedList {

    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public Node getHead(){
        return head;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }
    
    public void insertMiddle(Node newNode, Node previous) {
        newNode.setNext(previous.getNext());
        previous.setNext(newNode);
    }

    /**
     * @param value The value to be searched.
     * @return The node that has the data value. If no node exists, returns null.
     */
    public Node search(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (value == tmp.getData()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public Node getNodeI(int i) {
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (index == i){
                return tmp;
            }
            index++;
            tmp = tmp.getNext();
        }
        return null;
    }

    public int numberOfElements(){
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    public void deleteFirst(){
        head = head.getNext();
        if (isEmpty()){
            tail = null;
        }
    }

    public Node getPrevious(Node node){
        Node tmp = head;
        Node previous = null;
        while (tmp != node) {
            previous = tmp;
            tmp = tmp.getNext();
        }
        return previous;
    }

    public void deleteValue(int value){
        Node tmp = head;
        Node previous = null;
        while (tmp != null) {
            if (tmp.getData() == value){
                if (previous != null){
                    previous.setNext(tmp.next);
                    if (tmp.next == null){
                        tail = previous;
                    }
                } else {
                    head = tmp.next;
                    if (head == null){
                        tail = null;
                    }
                }
                break;
            }
            previous = tmp;
            tmp = tmp.getNext();
        }
    }

    public void deleteLast(){
        tail = getPrevious(tail);
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    public void deleteMiddle(Node node){
        Node previous;
        previous = getPrevious(node);
        previous.setNext(node.getNext());
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    //13
    //Write a function that will delete all prime nodes that is their data field
    //is prime such as 2, 3, 5, 7, etc.
    //void deletePrimes()
    public void deletePrimes(){
        Node current = head;
        Node previous = null;
        int data;

        while (current!=null){
            int dividedNumber = 0;
            data = current.getData();
            for(int i = 1; i <= data; i++){
                if (data%i==0){
                    dividedNumber++;
                }
            }

            if (dividedNumber == 2){
                if (current == head){
                    head = head.next;
                    current = head;
                } else if (current == tail) {
                    tail = previous;
                    previous.next = null;
                    current = null;

                } else{
                    current= current.next;
                    previous.next = current;
                }
            }
            else {
                previous = current;
                current = current.next;
            }
        }
    }

    //27
    public void removeKthBeforeLast(int K){
        Node current = head;
        int countListMembers = 0;
        while(current != null){
            countListMembers++;
            current = current.getNext();
        }
        current = head;

        for(int i = 1; i <=countListMembers-K; i++){
            if(i == countListMembers-K){
                if(K == 1){
                    current.setNext(null);
                    tail = current;
                }
                else if (K ==countListMembers) {
                    head = head.getNext();
                }
                else{
                    current.setNext(current.getNext().getNext());
                }
            }
            else {
                current = current.getNext();
            }
        }
    }


    public boolean isPalindrom() {
        if (head == null || head.getNext() == null) {
            return true; // Empty or single node list is always a palindrome
        }

        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextNode = current.getNext();
            current.setNext(prev);
            prev = current;
            current = nextNode;
        }

        // Step 3: Compare the first half with the reversed second half
        Node firstHalf = head;
        Node secondHalf = prev; // prev is the new head of the reversed second half
        while (secondHalf != null) {
            if (firstHalf.getData() != secondHalf.getData()) {
                return false;
            }
            firstHalf = firstHalf.getNext();
            secondHalf = secondHalf.getNext();
        }

        return true;
    }


    //Write a function that returns the Fibonacci numbers between A and B
    //as a linked list. Fibonacci numbers are:
    public static LinkedList fibonacci (int a, int b){
        LinkedList fibList = new LinkedList();
        int startingNumber = 0;
        int startingNumber2 = 1;
        int temp ;

        while(startingNumber2<=b){
            if(startingNumber>=a){
                fibList.insertLast(new Node(startingNumber));
            }
            temp = startingNumber2;
            startingNumber2 = startingNumber + startingNumber2;
            startingNumber = temp;
        }

        if(startingNumber<=b){
            fibList.insertLast(new Node(startingNumber));
        }

        return fibList;
    }

    //Write a method which returns true if the singly linked list only contains
    //duplicates, that is, every datum (number) occurs only twice. Impor-
    //tant warning, the duplicate elements may not be adjacent. You are not
    //allowed to use any singly linked list methods, just attributes, construc-
    //tors, getters and setters.

    public boolean containsOnlyDuplicates(){
        Node current = head;

        while(current != null){
            Node listItem = head;
            int isDuplicate = 0;

            while(isEmpty()){
                if(current.getData() == listItem.getData()){
                    isDuplicate++;
                }

            }
            if(isDuplicate != 2){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    //Write a method which returns true if the single linked list only contains
    //triplicates, that is, every datum (number) occurs only three times. Im-
    //portant warning, the triplicate elements may not be adjacent. Your
    //method should have a time complexity of O(N2). You are not allowed
    //to use any single linked list methods, just attributes, constructors, get-
    //ters and setters.
    //boolean containsOnlyTriplicates ()

    public boolean containsOnlyTriplicates(){
        Node checkingNode = head;
        while(checkingNode != null){
            int count = 3;
            Node checkerNode = head;
            while(checkerNode!=null){
                if(checkerNode.getData() == checkingNode.getData()){
                    count--;
                }
                checkerNode = checkerNode.getNext();
            }
            if(count != 0){
                return false;
            }
            checkingNode = checkingNode.getNext();
        }
        return true;
    }


}
