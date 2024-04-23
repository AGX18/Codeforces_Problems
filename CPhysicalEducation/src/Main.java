import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int findK(int n, int x) { // n - x = m * (2 * k - 2) -> (k - 1) * 2 * m = n - x
        HashSet<Integer> possibleKs = new HashSet<>();
        for (int i = 1; i * i <= n - x; i++) {
            // i = 2 * k - 2
            if ((n - x) % i == 0) {
                if(i % 2 == 0 && (i/2 + 1) >= x) {
                    possibleKs.add(i/2 + 1);
                }
                if(((n - x) / i) % 2 == 0 && (((n - x) / i) / 2 + 1) >= x){
                    possibleKs.add(((n - x) / i) / 2 + 1);
                }
            }
        }


        return possibleKs.size();
    }

    public static HashSet<Integer> findPossiblities(int a) { // n - x = m * (2 * k - 2) -> (k - 1) * 2 * m = n - x
        HashSet<Integer> possibleKs = new HashSet<>();
        for (int i = 1; i * i <= a; i++) {
            // i = 2 * k - 2
            if (a % i == 0) {
                if(i % 2 == 0) {
                    possibleKs.add(i / 2 + 1);
                }
                if((a / i) % 2 == 0){
                    possibleKs.add(((a / i) / 2 + 1));
                }
            }
        }


        return possibleKs;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int cnt = 0;
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            HashSet<Integer> possibleKs = findPossiblities(n - x);
            possibleKs.addAll(findPossiblities(n + x - 2));
            for (int k : possibleKs) {
                if(k >= x) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
        scanner.close();
    }
}
