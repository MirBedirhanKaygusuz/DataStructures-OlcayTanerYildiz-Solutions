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

        while(currentIndex != last){
            if (array[currentIndex].getData()<minimum){
                minimum = array[currentIndex].getData();
            }
            currentIndex = (currentIndex+1)%N;
        }

        return minimum;
    }


}
