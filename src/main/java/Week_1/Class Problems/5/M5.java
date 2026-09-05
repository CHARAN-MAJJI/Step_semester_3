public class M5 {

    static String reverseCustomerName(String customerName) {
        char[] a = customerName.toCharArray();

        for (int i = 0; i < a.length / 2; i++) {
            char temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return new String(a);
    }

    public static void main(String[] args) {

        String name = "Sunil";

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverseCustomerName(name));
    }
}