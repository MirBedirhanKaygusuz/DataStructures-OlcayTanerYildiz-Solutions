package Array;

public class Stack {
    private Element[] array;
    private int top;
    private int N;

    public Stack(int N){
        this.N = N;
        array = new Element[N];
        top = -1;
    }

    boolean isFull(){
        return top == N - 1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    Element peek(){
        return array[top];
    }

    public void push(Element element){
        if (!isFull()){
            top++;
            array[top] = element;
        }
    }

    Element pop(){
        if (!isEmpty()){
            top--;
            return array[top + 1];
        }
        return null;
    }

    public void printArrayStack() {

        for(int i =0; i<=top;i++){
            System.out.println(array[i].getData());
        }
    }


    //    For array representation, write a function that enlarges the stack when
    //    it is full. The new stack will hold two times more than the original
    //    stack.
    //    void enlarge ()

    public void enlarge(){
        N*= 2;
        Element[] newArray = new Element[N];

        for(int i = 0; i<= top; i++){
            newArray[i] = array[i];
        }

        array = newArray;
        System.out.println("capacity is: " + newArray.length);
    }


    // Write a function that returns the bottom element of a stack. You are
    //only allowed to use pop, push, isEmpty functions.
    //Element bottom()
    public Element bottom(){
        Stack s = new Stack(N);
        while (!isEmpty()){
            s.push(pop());
        }

        Element result = s.pop();
        push(result);

        while(!s.isEmpty()){
            push(s.pop());
        }

        System.out.println(result.getData());
        return result;

    }

    //21. Write a function that inserts a new integer after the largest element of
    //the stack. Write the function for array implementation. You are not
    //allowed to use any stack methods, just attributes, constructors, getters
    //and setters.
    //void insertAfterLargest (int s)
    public void insertAfterLargest(int s) {
        int maxIndex= 0;
        for(int i=0; i<top; i++){
            if(array[i].getData()>array[maxIndex].getData()){
                maxIndex =i;
            }
        }

        for(int i = top; i>maxIndex;i--){
            array[i+1] = array[i];
        }
        array[maxIndex+1] = new Element(s);
        top++;
    }

}
