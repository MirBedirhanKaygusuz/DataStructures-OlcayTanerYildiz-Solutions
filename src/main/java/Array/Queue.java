package Array;

public class Queue {

    private Element array[];

    private int first;

    private int last;

    private int N;

    public Queue(int N){
        this.N = N;
        array = new Element[N];
        first = 0;
        last = 0;
    }

    boolean isFull(){
        return (last + 1) % N == first;
    }

    public boolean isEmpty(){
        return first == last;
    }

    public void enqueue(Element element){
        if (!isFull()){
            array[last] = element;
            last = (last + 1) % N;
        }
    }

    public Element dequeue(){
        if (!isEmpty()){
            Element tmp = array[first];
            first = (first + 1) % N;
            return tmp;
        }
        return null;
    }

    public String printQueueArray(){
        StringBuilder sb = new StringBuilder();
        int i = first;
        while (i != last) {
            if (array[i] != null) {
                sb.append(array[i].getData()).append(" ");
            }
            i = (i + 1) % N;
        }
        return sb.toString();
    }

    //--------------------------------------Questions and Solutions-----------------------------------------------------


    //1. Write a function that adds a new element after the K’th (K ≥ 0)
    //element of the queue. Write the function for both array and linked
    //list implementations. You can safely assume that, there are at least K
    //elements in the queue.
    // void insertAfterKth ()
    public void insertAfterKth(int k, Element newElement) {
        int currentIndex = first;
        for (int i = 0; i < k; i++) {
            currentIndex = (currentIndex + 1) % N;
        }

        int insertionIndex = (currentIndex + 1) % N;

        int i = (last-1+N)%N;
        while (i != (insertionIndex-1)%N){
            array[(i + 1) % N] = array[i];
            i = (i - 1 + N) % N;
        }

        array[insertionIndex] = newElement;
        last = (last + 1) % N;
    }

    //2. Write a function that deletes the element in the K’th (K ≥ 0) position
    //of the queue. Write the function for array implementation.
    //void deleteKth(int K)
    public void deleteKth(int K){
        int currentIndex = first;
        while(currentIndex!= K){
            currentIndex = (currentIndex+1)%N;
        }

        int lastElement = (last-1+N)%N;

        while(currentIndex != lastElement){
            array[currentIndex] = array[(currentIndex+1)%N];
            currentIndex = (currentIndex+1)%N;
        }

        array[(last-1+N)%N] = null;
        last = (last-1)%N;
    }

    //3. Write a method where the method returns the minimum number in a
    //queue. Write the function for both array and linked list implementa-
    //tions. Do not use any class or external methods except isEmpty().
    //int minimum()
    public int minimum(){
        int minimum = array[first].getData() ;
        int currentIndex = first;

        while(array[currentIndex] != null){
            if (array[currentIndex].getData()<minimum){
                minimum = array[currentIndex].getData();
            }
            currentIndex = (currentIndex+1)%N;
        }

        return minimum;
    }

    //4. Write a method which removes and returns the second item from the
    //queue. Write the function for both array and linked list implementa-
    //tions. Your methods should run in O(1) time. Do not use any class or
    //external methods except isEmpty().
    //Element dequeue2nd()
    //Node∗ dequeue2nd()
    public Element dequeue2nd(){
        int secondItemIndex = (first +1)%N ;
        Element result = array[secondItemIndex];
        array[secondItemIndex] = null;
        return result;

    }

    //5. Write a function that inserts a new element after the largest element
    //of the queue. Write the function for array implementation. You are
    //not allowed to use any queue methods, just attributes, constructors,
    //getters and setters.
    //void insertAfterLargest (int data)
    public void insertAfterLargest (int data){
        int max = array[first].getData();
        int current = first;
        int largestIndex = first;

        while (array[current] != null){
            if(array[current].getData()>max){
                max= array[current].getData();
                largestIndex = current;
            }
            current = (current + 1)%N;
        }

        while (current != largestIndex){
            array[(current +1)%N] = array[current];
            current = (current - 1 + N)%N;
        }

        int insertionIndex =  (largestIndex+1)%N;
        array[insertionIndex] = new Element(data);
    }

    //11. Write the method for array implementation
    //void cutPaste(Queue dest, int p, int q)
    //which cuts all the elements between indexes p and q from the original
    //queue and inserts at the end to the dest queue. You are not allowed to
    //use enqueue, dequeue, isEmpty functions. You can assume the desti-
    //nation queue has enough space for insertion. Your method should run
    //in O(N) time.
    public void cutPaste(Queue dest, int p, int q){
        int startIndex = (first + p)%N;
        int endIndex = (first + q)%N;

        int currentındex = startIndex;
        int count = 0;

        while(currentındex != endIndex){
            if(dest.isEmpty()){
                dest.array[last] = new Element(array[currentındex].getData());
                dest.last = (dest.last+1)%dest.N;
                count++;
            }
        }
        int shiftIndex = endIndex;
        int targetındex = startIndex;

        while(shiftIndex != last){
            array[targetındex] = array[shiftIndex];
            array[shiftIndex] = null;
            shiftIndex = (shiftIndex +1)%N;
            targetındex = (targetındex +1)%N;
        }

        last = (last-count+N)%N;

    }

    //13. Write another constructor method
    //void Queue(Queue[] list )
    //which constructs a new array based queue by adding the elements in
    //the list of queues one by one. So, the first k elements of the original
    //queue will be constructed with the first elements of the k queues in
    //the list; the second k elements of the original queue will be constructed
    //with the second elements of the k queues in the list etc. The elements
    //from queues should be recreated (not copied from the queues). You are
    //not allowed to use enqueue, dequeue, isEmpty functions. You should
    //solve the question for array implementation.
    public void Queue(Queue[] list) {
        int totalCapacity = 0;
        for (Queue q : list) {
            totalCapacity += (q.last - q.first) % q.N;
        }

        this.array = new Element[totalCapacity + 1];
        this.first = 0;
        this.last = 0;
        this.N = totalCapacity + 1;

        boolean hasElements = true;
        int index = 0;
        while (hasElements) {
            hasElements = false;
            for (Queue q : list) {
                if (index < (q.last - q.first) % q.N) {
                    Element element = q.array[(q.first + index) % q.N];
                    this.array[this.last] = new Element(element.getData());
                    this.last++;
                    hasElements = true;
                }
            }
            index++;
        }
    }



}
