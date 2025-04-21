import Array.Hash;

public class HashTest {
    public static void main(String[] args) {
        Hash hash = new Hash(12);


        int[] array1 = new int[10];
        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++) {
            array1[i] = i;
            array2[i] = i;
        }

        // Burada union() fonksiyonu döndürdüğü sonucu bir değişkene atıyoruz:
        int[] result = hash.union(array1, array2);

        // Sonucu yazdır
        System.out.println("Union sonucu:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


}
