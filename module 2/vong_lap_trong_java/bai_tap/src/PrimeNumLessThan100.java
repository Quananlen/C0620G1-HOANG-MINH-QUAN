public class PrimeNumLessThan100 {
    public static void main(String[] args) {
        String result = "";
        int num = 2;
        boolean isPrime = true;
        while (num < 100) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result += num + " ";
            }
            num++;
            isPrime = true;
        }
        System.out.println(result);
    }
}
