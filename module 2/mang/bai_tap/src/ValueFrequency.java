public class ValueFrequency {
    public static void main(String[] args) {
        String str = "Beep boop";
        char x = 'e';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==x) count++;
        }
        System.out.println(count);
    }
}
