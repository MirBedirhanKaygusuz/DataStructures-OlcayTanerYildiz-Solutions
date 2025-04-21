package List;

public class Hash {

    private LinkedList[] table;

    private int N;

    public Hash(int N){
        table = new LinkedList[N];
        for (int i = 0; i < N; i++){
            table[i] = new LinkedList();
        }
        this.N = N;
    }

    public Node search(int value){
        int address;
        address = hashFunction(value);
        return table[address].search(value);
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        table[address].insertLast(new Node(value));
    }

    public void insert(Node node){
        int address;
        address = hashFunction(node.data);
        table[address].insertLast(node);
    }

    public void deleteValue(int value){
        int address;
        if (search(value) != null){
            address = hashFunction(value);
            table[address].deleteValue(value);
        }
    }

    private int hashFunction(int value){
        return value % N;
    }

    //2. Write function that finds the number of empty slots in an hash table
    //(For both array and linked list implementations).
    //int numberOfEmptySlots()
    public int numberOfEmptySlots() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (table[i].isEmpty()) {
                count++;
            }
        }

        return count;
    }

    //13. Write the method in Hash class linked list implementation
    //boolean isValid()
    //that checks if the hash table is valid or not. An hash table is invalid if
    //it contains the same number twice. Your method should run in O(N)
    //time. Do not use external data structures or hash tables.
    public boolean isValid() {
        for(int i = 0; i<N; i++){
            LinkedList list = table[i];
            Node current = list.getHead();
            while (current != null){
                Node search = search(current.data);
                if(search != null && search == current){
                    return false;
                }
                current = current.getNext();
            }
        }
        return true;

    }



}
