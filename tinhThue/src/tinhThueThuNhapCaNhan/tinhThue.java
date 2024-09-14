package tinhThueThuNhapCaNhan;
import java.util.Scanner;

public class tinhThue {

	 // Hàm tính thu nhập chịu thuế
    public static double tinhThuNhapChiuThue(double tongThuNhap, int soNguoiPhuThuoc) {
        double mienGiamBanThan = 4;  // 4 triệu
        double mienGiamNguoiPhuThuoc = soNguoiPhuThuoc * 1.6;  // 1.6 triệu cho mỗi người phụ thuộc
        double thuNhapChiuThue = tongThuNhap - mienGiamBanThan - mienGiamNguoiPhuThuoc;
        return Math.max(thuNhapChiuThue, 0);  // Không thể có thu nhập chịu thuế âm
    }

    // Hàm tính thuế thu nhập cá nhân
    public static double tinhThue(double thuNhapChiuThue) {
        double thue = 0;
        double[] mucThue = {60, 120, 210, 384, 624, 960};  // Mức thu nhập (triệu VND)
        double[] thueSuat = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};  // Thuế suất tương ứng

        if (thuNhapChiuThue <= mucThue[0]) {
            thue = thuNhapChiuThue * thueSuat[0];
        } else if (thuNhapChiuThue <= mucThue[1]) {
            thue = mucThue[0] * thueSuat[0] + (thuNhapChiuThue - mucThue[0]) * thueSuat[1];
        } else if (thuNhapChiuThue <= mucThue[2]) {
            thue = mucThue[0] * thueSuat[0] + (mucThue[1] - mucThue[0]) * thueSuat[1]
                    + (thuNhapChiuThue - mucThue[1]) * thueSuat[2];
        } else if (thuNhapChiuThue <= mucThue[3]) {
            thue = mucThue[0] * thueSuat[0] + (mucThue[1] - mucThue[0]) * thueSuat[1]
                    + (mucThue[2] - mucThue[1]) * thueSuat[2] + (thuNhapChiuThue - mucThue[2]) * thueSuat[3];
        } else if (thuNhapChiuThue <= mucThue[4]) {
            thue = mucThue[0] * thueSuat[0] + (mucThue[1] - mucThue[0]) * thueSuat[1]
                    + (mucThue[2] - mucThue[1]) * thueSuat[2] + (mucThue[3] - mucThue[2]) * thueSuat[3]
                    + (thuNhapChiuThue - mucThue[3]) * thueSuat[4];
        } else if (thuNhapChiuThue <= mucThue[5]) {
            thue = mucThue[0] * thueSuat[0] + (mucThue[1] - mucThue[0]) * thueSuat[1]
                    + (mucThue[2] - mucThue[1]) * thueSuat[2] + (mucThue[3] - mucThue[2]) * thueSuat[3]
                    + (mucThue[4] - mucThue[3]) * thueSuat[4] + (thuNhapChiuThue - mucThue[4]) * thueSuat[5];
        } else {
            thue = mucThue[0] * thueSuat[0] + (mucThue[1] - mucThue[0]) * thueSuat[1]
                    + (mucThue[2] - mucThue[1]) * thueSuat[2] + (mucThue[3] - mucThue[2]) * thueSuat[3]
                    + (mucThue[4] - mucThue[3]) * thueSuat[4] + (mucThue[5] - mucThue[4]) * thueSuat[5]
                    + (thuNhapChiuThue - mucThue[5]) * thueSuat[6];
        }

        return thue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin từ người dùng
        System.out.print("Nhập tên người nộp thuế: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập tổng thu nhập trong năm (triệu đồng): ");
        double tongThuNhap = scanner.nextDouble();

        System.out.print("Nhập vào số người phụ thuộc: ");
        int soNguoiPhuThuoc = scanner.nextInt();

        // Tính thu nhập chịu thuế
        double thuNhapChiuThue = tinhThuNhapChiuThue(tongThuNhap, soNguoiPhuThuoc);

        // Tính thuế thu nhập cá nhân
        double thuePhaiDong = tinhThue(thuNhapChiuThue);

        // In ra kết quả với nhiều chữ số thập phân hơn
        System.out.printf("Thu nhập chịu thuế: %.8f triệu VND\n", thuNhapChiuThue);
        System.out.printf("Số thuế %s phải nộp là: %.8f triệu đồng\n", hoTen, thuePhaiDong);
    }
}