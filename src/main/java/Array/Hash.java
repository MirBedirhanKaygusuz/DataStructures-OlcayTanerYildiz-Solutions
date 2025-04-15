package Array;

import List.Node;

public class Hash {

    private Element[] table;

    private boolean[] deleted;

    private int N;

    public Hash(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value){
        return value % N;
    }

    public Element search(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null){
            if (!deleted[address] && table[address].getData() == value){
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address]){
            address = (address + 1) % N;
        }
        if (table[address] != null){
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }

    public void deleteValue(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null){
            if (!deleted[address] && table[address].getData() == value){
                break;
            }
            address = (address + 1) % N;
        }
        deleted[address] = true;
    }

    //2. Write function that finds the number of empty slots in an hash table
    //(For both array and linked list implementations).
    //int numberOfEmptySlots()
    public int numberOfEmptySlots() {
        int count = 0;
        for (int i = 0; i < N; i++) {

            if (table[i] == null) {
                count++;
            }
        }
        return count;
    }

    //7. Write the method
    //int numberOfClusters()
    //that finds the number of clusters in hash table. A cluster is a contiguous
    //group of non-null elements in the array.
    public int numberOfClusters() {
        int count =0;
        boolean isCluster = false;

        for(int i = 0; i < N; i++){
            if (table[i] != null) {
                if(!isCluster){
                    isCluster = true;
                    count++;
                }

            }
            else {
                isCluster = false;
            }
        }
        return count;
    }

    //12. Write the static method in Hash class
    //boolean sumOfTwoK(int[] array, int K)
    //that takes an array of integers as a parameter and returns true if the
    //sum of two elements in the array is K. Your method should run in
    //O(N) time. Do not use any external data structures or arrays except
    //the external hash table.
    public static boolean sumOfTwoK(int[] array, int K) {
        Hash h = new Hash(array.length);
        for(int i = 0; i<array.length; i++){
            h.insert(array[i]);
        }

        for(int i = 0; i<array.length; i++){
            int sum = K - array[i];
            if(h.search(sum) != null){
                return true;
            }
        }
        return false;
    }

    //14. Write the static method in Hash class
    //boolean sumOfFourK(int[] array, int K)
    //that takes an array of integers as a parameter and returns true if the
    //sum of four elements in the array is K. Your method should run in
    //O(N2) time. You are only allowed to use an external array and an
    //external hash table.
    public static boolean sumOfFourK(int[] array, int K) {
        int size = array.length;
        int hashSize = size*(size-1)/2;
        Hash h = new Hash(hashSize);
        for(int i = 0; i<size; i++){
            for(int j = i+1; j<size; j++){
                int sum = array[i] + array[j];
                h.insert(sum);
            }
        }

        for(int i = 0; i <hashSize; i++){
            int sum = K - h.table[i].getData();
            for(int j = i+1; j<hashSize; j++){
                if(h.table[j].getData() == sum){
                    return true;
                }
            }
        }
        return false;

    }

    //11. Write the static method
    //int[] intersection (int[] list1 , int[] list2 )
    //to find the intersection of the elements in two arrays and return a new
    //array. Your method should run in O(N) time, where N is the number
    //of elements in the arrays. Do not use any external data structures or
    //arrays except the resulting array and hash table. The intersection array
    //should contain only that many items not more not less. Hint: How can
    //you search an element from the first list in the second list in O(1)?
    public static int[] intersection(int[] list1, int[] list2) {
        // Create a hash table for list1
        Hash hash = new Hash(Math.max(list1.length, 1));
        for (int num : list1) {
            hash.insert(num);
        }

        // Create a hash to track which elements we've already found
        Hash found = new Hash(Math.max(list2.length, 1));

        // First pass: count elements in the intersection
        int count = 0;
        for (int num : list2) {
            if (hash.search(num) != null && found.search(num) == null) {
                count++;
                found.insert(num);
            }
        }

        // Create result array of exact size
        int[] result = new int[count];

        // Reset our tracking hash
        found = new Hash(Math.max(list2.length, 1));

        // Second pass: fill the result array
        int index = 0;
        for (int num : list2) {
            if (hash.search(num) != null && found.search(num) == null) {
                result[index++] = num;
                found.insert(num);
            }
        }

        return result;
    }


}
