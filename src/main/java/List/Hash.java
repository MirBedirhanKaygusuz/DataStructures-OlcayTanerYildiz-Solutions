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
        // First check for duplicates within each linked list
        for (int i = 0; i < N; i++) {
            LinkedList list = table[i];
            if (!list.isEmpty()) {
                Node current = list.getHead();
                while (current != null) {
                    // Check for duplicates in the same list
                    Node runner = current.next;
                    while (runner != null) {
                        if (current.data == runner.data) {
                            return false; // Found duplicate
                        }
                        runner = runner.next;
                    }
                    current = current.next;
                }
            }
        }

        // Then check across different linked lists for elements that should hash to the same bucket
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                LinkedList list1 = table[i];
                LinkedList list2 = table[j];

                if (!list1.isEmpty() && !list2.isEmpty()) {
                    Node current = list1.getHead();
                    while (current != null) {
                        Node other = list2.getHead();
                        while (other != null) {
                            // If two different elements hash to different buckets but have same value
                            if (current.data == other.data) {
                                return false; // Found duplicate
                            }
                            other = other.next;
                        }
                        current = current.next;
                    }
                }
            }
        }

        return true; // No duplicates found
    }

}
