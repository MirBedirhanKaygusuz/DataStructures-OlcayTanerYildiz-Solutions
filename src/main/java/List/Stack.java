package List;

import Array.Element;

public class Stack{
    private Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public Node peek(){
        return top;
    }

    public void push(Node node){
        node.setNext(top);
        top = node;
    }

    public Node pop(){
        Node topNode = top;
        top = top.next;
        return topNode;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    //1. Write a function using stacks that determines if a parenthesis sequence
    //is balanced or not. For example the parenthesis sequence ( ( ) ( ) ) is
    //balanced, whereas the parenthesis sequence ( ( ( ) ( is not. You can
    //assume that the character sequence contains just ’(’ and ’)’ characters.
    //boolean isBalanced(String s)
    public static boolean isBalanced(String s) {
        Stack stack = new Stack();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch =='('){
                stack.push(new Node(ch));
            } else if (ch == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();

            }
        }

        return stack.isEmpty();
    }

    //Write a function using stacks that determines if a parenthesis sequence
    //is balanced or not. For example the parenthesis sequence ( { ( ) [ { }
    //] } ( ) ) is balanced, whereas the parenthesis sequence ( } ] ) ( is not.
    //You can assume that the character sequence contains just (, {, [, ), },
    //] characters.
    //boolean isBalanced(String s)
    public static boolean isBalancedExpended(String s) {
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(new Node(ch));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Node topNode = stack.pop();
                char top = (char) topNode.getData();


                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    //. Write a function that determines if a character sequence is palindrome,
    //that is, it is equal its reverse. (Hint: Use a stack to reverse the character
    //sequence)
    //boolean palindrom(String s)
    public static boolean palindrom(String string){
        Stack s = new Stack();

        for(int i = 0; i<string.length(); i++){
            s.push(new Node(string.charAt(i)));
        }

        int j = 0;
        while(!s.isEmpty()){
            if((char)s.pop().getData() != string.charAt(j)){
                return false;
            }
            j++;
        }

        return true;
    }

    public void removeOddIndexes(){
        Stack tmp = new Stack();
        int indexCount = 1;

        while(!isEmpty()){
            if(indexCount %2 == 0){
                tmp.push(pop());
            }else {
                pop();
            }
            indexCount++;
        }

        while(!tmp.isEmpty()){
            push(tmp.pop());
        }
    }


}
