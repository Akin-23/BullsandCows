import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        int n = scanner.nextInt();

        if (n < s.length()){

           String nString = s.substring(0,n);
           String leftOver = s.substring(n);

            System.out.println(leftOver + nString);
        } else {
            System.out.println(s);
        }
    }
}