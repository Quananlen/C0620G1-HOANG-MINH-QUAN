public class First20PrimeNum {
    public static void main(String[] args) {
        int count = 0;
        String result = "";
        int num = 2;
        boolean isPrime = true;
        while (count < 21) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                result += num + " ";
                count++;
            }
            num++;
            isPrime = true;
        }
        System.out.println(result);
    }
}
