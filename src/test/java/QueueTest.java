import Array.Element;
import Array.Queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        Element element1 = new Element(1);
        Element element2 = new Element(2);
        Element element3 = new Element(3);
        Element element4 = new Element(0);

        queue.enqueue(element1);
        queue.enqueue(element2);
        queue.enqueue(element3);
        queue.enqueue(element4);

        System.out.println(queue.printQueueArray());


        queue.insertAfterKth(2, new Element(6));
        queue.deleteKth(3);
        System.out.println(queue.printQueueArray());
        System.out.println(queue.minimum());



    }
}
