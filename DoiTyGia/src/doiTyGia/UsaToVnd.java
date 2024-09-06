package doiTyGia;
import java.util.Scanner;
public class UsaToVnd {
	public static final double TY_GIA = 23500;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số tiền USD: ");
        double usd = scanner.nextDouble();

        double vnd = usd * TY_GIA;

        System.out.printf("Số tiền tương ứng bằng VND là: %.2f%n", vnd);

        scanner.close();
    }
}
