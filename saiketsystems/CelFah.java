import java.util.Scanner;

public class CelFah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a degree in Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheit = ((9.0 / 5) * celsius) + 32;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
    }
}
