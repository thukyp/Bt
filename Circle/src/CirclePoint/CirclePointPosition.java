package CirclePoint;

import java.util.Scanner;

public class CirclePointPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tọa độ x của tâm đường tròn: ");
        double xC = scanner.nextDouble();
        System.out.print("Nhập tọa độ y của tâm đường tròn: ");
        double yC = scanner.nextDouble();
        System.out.print("Nhập bán kính đường tròn: ");
        double r = scanner.nextDouble();

        System.out.print("Nhập tọa độ x của điểm M: ");
        double xM = scanner.nextDouble();
        System.out.print("Nhập tọa độ y của điểm M: ");
        double yM = scanner.nextDouble();

        double distance = Math.sqrt(Math.pow(xM - xC, 2) + Math.pow(yM - yC, 2));

        if (distance < r) {
            System.out.println("Điểm M nằm bên trong đường tròn.");
        } else if (distance == r) {
            System.out.println("Điểm M nằm trên đường tròn.");
        } else {
            System.out.println("Điểm M nằm ngoài đường tròn.");
        }

        scanner.close();
    }
}

