import Array.Hash;

public class HashTest {
    public static void main(String[] args) {
        Hash hash = new Hash(10);
        hash.insert(1);
        hash.insert(2);
        hash.insert(3);
        hash.insert(4);
        hash.insert(5);
        hash.insert(6);
        hash.insert(7);
        hash.insert(8);
        hash.insert(9);
        hash.insert(10);

        int[] array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = i;
        }

        System.out.println(array.length);
    }


}
