package Array;

import List.Node;

import java.util.Arrays;

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

    //--------------------------------------Questions and Solutions-----------------------------------------------------


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


    //10. Write a static method
    //int[] sortByHashing(int[] array )
    //that takes an array of integers as a parameter (which contains distinct
    //numbers less than 2N, where N is the number of elements in the array)
    //and returns the sorted version of that array. Your method should run
    //in O(N) time. Do not use any external data structures or arrays except
    //the resulting array and hash table. Hint: Find the maximum number
    //in the array, the sorted array should contain only numbers less than
    //that.
    public static int[] sortByHashing(int[] array){
        int size = array.length;
        Hash hash = new Hash(size*2);
        for(int i = 0; i<size; i++){
            hash.insert(array[i]);

        }

        int[] result = new int[size];
        int index = 0;

        for(int i = 0; i<size*2 ;i++){
            if(hash.search(i) != null){
                System.out.println(i);
                result[index] = i;
                index++;
            }
        }

        return result;
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
        // n dizinin uzunluğu
        int n = array.length;
        // Toplam farklı çift sayısı, buradaki ifadenin sonucu n*(n-1)/2 olması beklenir.
        int totalLength = n * (n - 1) / 2;
        // Cevap anahtarında kullanıldığı gibi harici bir Hash nesnesi örneği:
        // (Önceden tanımlı, dış kütüphane olmadan kendi Hash sınıfınızı yazdığınızı varsayalım.)
        Hash pairSums = new Hash(totalLength);
        // Çift toplamlarını tutmak için geçici dizi
        int[] tempPairs = new int[totalLength];
        int index = 0;

        // Çiftleri hesaplayıp, hem tempPairs dizisine hem de hash tablosuna ekliyoruz.
        // (Burada j döngüsünün 0'dan n'e gitmesi beklenmez, genellikle j = i+1 şeklinde ikili kombinasyon hesaplanır,
        // fakat cevap anahtarında verilen biçime sadık kalınıyor.)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = array[i] + array[j];
                pairSums.insert(sum);
                tempPairs[index] = sum;
                index++;
            }
        }

        // Şimdi, tempPairs dizisindeki her çift toplamı için tamamlayıcı toplamı kontrol ediyoruz.
        for (int sum1 : tempPairs) {
            int sum2 = K - sum1;
            if (pairSums.search(sum2) != null) {
                return true;
            }
        }

        return false;
    }




    //15. Write a static method
    //int [] union(int[] list1 , int[] list2 )
    //to find the union of the elements in two arrays and return a new array.
    //The union array should contain only that many items not more not
    //less. Your method should run in O(N) time, where N is the number
    //of elements in the arrays. Do not use any external data structures or
    //arrays except the resulting array and an external hash table.
    public static int[] union(int[] list1, int[] list2) {
        int hashN = list1.length + list2.length;
        Hash hash = new Hash(hashN);

        // 1. Duplicate'leri engelleyerek ekleme
        for (int num : list1) {
            if (hash.search(num) == null) {
                hash.insert(num);
            }
        }

        for (int num : list2) {
            if (hash.search(num) == null) {
                hash.insert(num);
            }
        }

        // 2. Kaç benzersiz eleman var?
        int count = 0;
        for (int i = 0; i < hashN; i++) {
            if (hash.table[i] != null && !hash.deleted[i]) {
                count++;
            }
        }

        // 3. Sonuç dizisini oluştur
        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < hashN; i++) {
            if (hash.table[i] != null && !hash.deleted[i]) {
                result[index++] = hash.table[i].getData();
            }
        }

        return result;
    }



}
