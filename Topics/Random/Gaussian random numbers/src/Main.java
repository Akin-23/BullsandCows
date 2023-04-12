import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();
        double M = scanner.nextDouble();

        Random random = new Random();
        int seed = K;

        while (true){
            random.setSeed(seed);
            boolean allLessOrEqual = true;

            for (int i = 0; i < N; i++){
                double num = random.nextGaussian();

                if (num > M){
                    allLessOrEqual = false;
                    break;
                }
            }

            if (allLessOrEqual) {
                System.out.println(seed);
                break;
            }

            seed++;
        }
    }
}