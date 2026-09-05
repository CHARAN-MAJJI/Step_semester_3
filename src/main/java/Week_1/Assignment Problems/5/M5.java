public class M5 {

    static void classifyWordLengths(String review) {
        int shortWords = 0, mediumWords = 0, longWords = 0;

        String[] words = review.split(" ");

        for (String word : words) {
            int length = word.length();

            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }

    public static void main(String[] args) {
        classifyWordLengths(
            "This movie was absolutely fantastic and thrilling"
        );
    }
}