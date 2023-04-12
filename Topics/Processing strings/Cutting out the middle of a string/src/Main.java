import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        String input = scanner.next();
        int midIndex = input.length()/2;


        String firstPart;
        String secondPart = input.substring(midIndex+1);
        if (input.length() % 2 !=0 ){
            firstPart = input.substring(0, midIndex);
        } else {
            firstPart = input.substring(0, midIndex - 1);

        }
        System.out.println(firstPart+secondPart);


    }
}