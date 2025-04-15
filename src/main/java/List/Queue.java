package List;

import Array.Element;

public class Queue {

    protected Node first;
    protected Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
    }

    public Node dequeue(){
        Node result = first;
        if (!isEmpty()){
            first = first.getNext();
            if (isEmpty()){
                last = null;
            }
        }
        return result;
    }
    //1. Write a function that adds a new element after the K’th (K ≥ 0)
    //element of the queue. Write the function for both array and linked
    //list implementations. You can safely assume that, there are at least K
    //elements in the queue.
    // void insertAfterKth ()
    public void insertAfterKth(int k, Node newNode) {

        Node current = first;
        for (int i = 0; i < k && current != null; i++) {
            current = current.getNext();
        }
        if (current != null) {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                last = newNode;
            }
        } else {
            throw new IllegalArgumentException("K is out of bounds");
        }
    }

    //3. Write a method where the method returns the minimum number in a
    //queue. Write the function for both array and linked list implementa-
    //tions. Do not use any class or external methods except isEmpty().
    //int minimum()
    public int minimum() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int minimum = first.getData();
        Node current = first.getNext();
        while (current != null) {
            if (current.getData() < minimum) {
                minimum = current.getData();
            }
            current = current.getNext();
        }
        return minimum;
    }

    //4. Write a method which removes and returns the second item from the
    //queue. Write the function for both array and linked list implementa-
    //tions. Your methods should run in O(1) time. Do not use any class or
    //external methods except isEmpty().
    //Element dequeue2nd()
    //Node∗ dequeue2nd()
    public Node dequeue2nd(){
        Node second = first.getNext();
        if(second == last){
            last = first;
        }
        else{
            first.next = second.next;
            second.next = null;
        }
        return second;
    }

    //14. Write the method
    //void removeAll(Queue[] list )
    //which removes all elements in the queues in the list from the original
    //queue. You are not allowed to use enqueue, dequeue, isEmpty func-
    //tions. You should solve the question for list implementation.
    public void removeAll(Queue[] list) {
        Node current = first;
        Node prev = null;

        while (current != null) {
            boolean remove = false;
            // List parametresindeki her kuyruğu kontrol ediyoruz
            for (Queue queue : list) {
                Node queueCurrent = queue.first;
                while (queueCurrent != null) {
                    // Karşılaştırma: gerekli ise equals() de kullanılabilir.
                    if (current.getData() == queueCurrent.getData()) {
                        remove = true;
                        break;  // Inner döngüden çık
                    }
                    queueCurrent = queueCurrent.getNext();
                }
                if (remove) break;
            }

            if (remove) {
                // current silinecek:
                if (current == first) {
                    first = current.getNext();
                    // Eğer silinen düğüm ilk düğümse, prev bir güncelleme yapmadan current'i first yapabiliriz.
                    current = first;
                } else {
                    prev.setNext(current.getNext());
                    // Eğer current son düğüm ise, last'i prev yapıyoruz.
                    if (current == last) {
                        last = prev;
                    }
                    current = current.getNext();
                }
            } else {
                // Eğer silme yapılmadıysa, normal ilerleyelim.
                prev = current;
                current = current.getNext();
            }
        }
    }
}
