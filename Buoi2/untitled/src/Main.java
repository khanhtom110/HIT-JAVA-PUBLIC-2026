import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        //Yeu cau nhap so x khong am
        do{
            System.out.print("x=");
            x = scanner.nextInt();
        }while (x < 0);

        System.out.println(x);
    }
    public class ATM {
        // Giấu dữ liệu quan trọng, không cho bên ngoài sửa trực tiếp (private)
        private double soDu = 5000000;

        // Phương thức kiểm tra và rút tiền (Getter/Setter dạng tùy biến)
        public void rutTien(double soTien, String maPIN) {
            if (!"1234".equals(maPIN)) {
                System.out.println("Mã PIN không đúng!");
                return;
            }
            if (soTien > soDu) {
                System.out.println("Số dư không đủ!");
                return;
            }

            soDu -= soTien;
            System.out.println("Rút thành công: " + soTien + " VNĐ. Số dư còn lại: " + soDu);
        }
    }

}