import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        double p = (a+b+c)/2;
        double d = p*(p-a)*(p-b)*(p-c);


        double s = Math.sqrt(d);

        System.out.println(s);
    }
}