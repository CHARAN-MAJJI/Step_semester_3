public class M4 {

    static void analyzeInventory(int[] a, int[] b) {
        int sumA = 0, sumB = 0;
        int max = a[0];
        String section = "Section A";
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if (a[i] > max) {
                max = a[i];
                section = "Section A";
                index = i;
            }

            if (b[i] > max) {
                max = b[i];
                section = "Section B";
                index = i;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + sumA);
        System.out.println("Section B Total: " + sumB);
        System.out.println("Status: " + status);
        System.out.println("Highest Quantity: " + max +
                " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}