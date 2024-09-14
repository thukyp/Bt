package tinhDiem;
import java.util.Scanner;

public class tinhDiemCong {

    // Hàm tính điểm ưu tiên theo khu vực
    public static double diemUuTienKhuVuc(String khuVuc) {
        switch (khuVuc) {
            case "A":
                return 2;
            case "B":
                return 1;
            case "C":
                return 0.5;
            default:
                return 0;
        }
    }

    // Hàm tính điểm ưu tiên theo đối tượng
    public static double diemUuTienDoiTuong(int doiTuong) {
        switch (doiTuong) {
            case 1:
                return 2.5;
            case 2:
                return 1.5;
            case 3:
                return 1;
            default:
                return 0;
        }
    }

    // Hàm kiểm tra kết quả thi
    public static String ketQuaTrungTuyen(double diemChuan, double diemMon1, double diemMon2, double diemMon3, String khuVuc, int doiTuong) {
        // Kiểm tra xem có môn nào bị điểm 0 hay không
        if (diemMon1 == 0 || diemMon2 == 0 || diemMon3 == 0) {
            return "Rớt";
        }

        // Tính tổng điểm ưu tiên
        double diemUuTien = diemUuTienKhuVuc(khuVuc) + diemUuTienDoiTuong(doiTuong);

        // Tính tổng điểm
        double tongDiem = diemMon1 + diemMon2 + diemMon3 + diemUuTien;

        // So sánh với điểm chuẩn
        if (tongDiem >= diemChuan) {
            return "Đậu với số điểm: " + tongDiem;
        } else {
            return "Rớt với số điểm: " + tongDiem;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập dữ liệu
        System.out.print("Mời bạn nhập điểm môn thứ nhất: ");
        double diemMon1 = scanner.nextDouble();

        System.out.print("Mời bạn nhập điểm môn thứ hai: ");
        double diemMon2 = scanner.nextDouble();

        System.out.print("Mời bạn nhập điểm môn thứ ba: ");
        double diemMon3 = scanner.nextDouble();

        System.out.println("Nhập khu vực của thí sinh:");
        System.out.println("A. Khu Vực A");
        System.out.println("B. Khu Vực B");
        System.out.println("C. Khu Vực C");
        System.out.println("X. Không có khu vực");
        String khuVuc = scanner.next().toUpperCase();

        System.out.println("Nhập đối tượng của thí sinh:");
        System.out.println("1. Đối tượng 1");
        System.out.println("2. Đối tượng 2");
        System.out.println("3. Đối tượng 3");
        System.out.println("0. Không có đối tượng");
        int doiTuong = scanner.nextInt();

        System.out.print("Mời bạn nhập điểm chuẩn: ");
        double diemChuan = scanner.nextDouble();

        // Tính kết quả
        String ketQua = ketQuaTrungTuyen(diemChuan, diemMon1, diemMon2, diemMon3, khuVuc, doiTuong);

        // Xuất kết quả
        System.out.println("Kết quả: " + ketQua);

        // Đóng Scanner
        scanner.close();
    }
}
