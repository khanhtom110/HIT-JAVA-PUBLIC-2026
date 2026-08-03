# Tài liệu Java cơ bản cho lớp HIT-JAVA-PUBLIC-2026

## 1. List và ArrayList trong Java

### 1.1. Khái niệm

`List` là một interface trong Java, nằm trong package `java.util`, dùng để lưu trữ các phần tử theo thứ tự.

- Cho phép lưu nhiều phần tử
- Duy trì thứ tự chèn
- Có thể truy cập theo index
- Có thể chứa phần tử trùng lặp

`ArrayList` là một lớp cụ thể triển khai `List`.

### 1.2. Cấu trúc cơ bản

```java
import java.util.ArrayList;
import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("An");
        names.add("Binh");
        names.add("Cuong");

        System.out.println(names); // [An, Binh, Cuong]
        System.out.println(names.get(1)); // Binh

        names.set(1, "Duy");
        System.out.println(names); // [An, Duy, Cuong]

        names.remove(0);
        System.out.println(names); // [Duy, Cuong]
    }
}
```

### 1.3. Một số phương thức thường dùng

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.size());      // 3
System.out.println(numbers.contains(20)); // true
System.out.println(numbers.indexOf(30));  // 2
System.out.println(numbers.isEmpty());     // false
```

### 1.4. So sánh với mảng

- Mảng có kích thước cố định
- `ArrayList` có thể tăng/giảm kích thước linh hoạt
- `ArrayList` hỗ trợ nhiều phương thức tiện ích

### 1.5. Chú ý

- Khi khai báo `List`, nên dùng kiểu `List` thay vì `ArrayList` để dễ thay đổi triển khai sau này.
- `ArrayList` không phải kiểu dữ liệu nguyên thủy, nên phải dùng kiểu wrapper như `Integer`, `Double`...
- Khi duyệt `List`, có thể dùng vòng lặp for-each hoặc for index.

### 1.6. Bài tập luyện tập

#### Bài 1
Viết chương trình nhập tên 5 sinh viên, lưu vào `List<String>`, sau đó in ra từng tên theo thứ tự.

#### Bài 2
Viết chương trình `List<Integer>` chứa 10 số nguyên, in ra tổng và trung bình cộng của các phần tử.

#### Bài 3
Viết chương trình thêm, sửa, xóa một phần tử trong `ArrayList` và in ra kết quả sau từng thao tác.

---

## 2. Static trong Java

### 2.1. Khái niệm

Từ khóa `static` dùng để khai báo thành viên thuộc về class, không thuộc về đối tượng cụ thể.

Có 3 dạng chính:
- `static variable` (biến tĩnh)
- `static method` (phương thức tĩnh)
- `static block` (khối tĩnh)

### 2.2. Biến static

```java
class SinhVien {
    String ten;
    static String truong = "HIT";

    public void inThongTin() {
        System.out.println("Ten: " + ten + ", Truong: " + truong);
    }
}

public class DemoStaticVariable {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien();
        sv1.ten = "An";

        SinhVien sv2 = new SinhVien();
        sv2.ten = "Binh";

        System.out.println(sv1.truong); // HIT
        System.out.println(sv2.truong); // HIT

        SinhVien.truong = "HIT University";
        System.out.println(sv1.truong); // HIT University
    }
}
```

### 2.3. Phương thức static

```java
class MathUtil {
    public static int tinhTong(int a, int b) {
        return a + b;
    }
}

public class DemoStaticMethod {
    public static void main(String[] args) {
        int ketQua = MathUtil.tinhTong(10, 20);
        System.out.println(ketQua); // 30
    }
}
```

### 2.4. Khối static

```java
class DemoStaticBlock {
    static int x;

    static {
        x = 100;
        System.out.println("Khối static được chạy");
    }

    public static void main(String[] args) {
        System.out.println("x = " + x);
    }
}
```

### 2.5. Chú ý

- Phương thức static chỉ có thể truy cập biến static hoặc gọi phương thức static.
- `this` và `super` không thể dùng trong phương thức static.
- Biến static được chia sẻ cho tất cả đối tượng của class.
- Static method gọi trực tiếp bằng tên class, ví dụ: `ClassName.method()`.

### 2.6. Bài tập luyện tập

#### Bài 1
Viết class `SanPham` với:
- thuộc tính `ten`, `gia`
- biến static `soLuongSanPham`
- phương thức static `tangSoLuong()`

#### Bài 2
Viết chương trình tính diện tích hình chữ nhật bằng phương thức static.

#### Bài 3
Tạo class `SinhVien` có biến static `truongHoc`; in ra giá trị này trước và sau khi thay đổi.

---

## 3. Từ khóa this trong Java

### 3.1. Khái niệm

`this` là tham chiếu tới đối tượng hiện tại đang được thực thi trong class.

### 3.2. Dùng `this` để phân biệt biến instance và tham số

```java
class SinhVien {
    String ten;

    SinhVien(String ten) {
        this.ten = ten;
    }

    void inThongTin() {
        System.out.println("Ten: " + this.ten);
    }
}

public class DemoThis {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien("Lan");
        sv.inThongTin(); // Ten: Lan
    }
}
```

### 3.3. Dùng `this` để gọi constructor

```java
class HinhChuNhat {
    int chieuDai;
    int chieuRong;

    HinhChuNhat() {
        this(10, 20);
    }

    HinhChuNhat(int chieuDai, int chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    void inKichThuoc() {
        System.out.println(this.chieuDai + " x " + this.chieuRong);
    }
}

public class DemoThisConstructor {
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat();
        hcn.inKichThuoc(); // 10 x 20
    }
}
```

### 3.4. Chú ý

- `this` không thể dùng trong phương thức static.
- `this` thường dùng khi tên tham số và thuộc tính cùng tên.
- `this()` chỉ được dùng trong constructor để gọi constructor khác trong cùng class.

### 3.5. Bài tập luyện tập

#### Bài 1
Viết class `NhanVien` với thuộc tính `maNhanVien`, `tenNhanVien`, constructor nhận dữ liệu và dùng `this` để gán giá trị.

#### Bài 2
Viết class `Xe` với hai constructor: constructor rỗng và constructor có 2 tham số. Dùng `this()` để gọi constructor khác.

#### Bài 3
Viết class `HocSinh` có phương thức `xetDiem(int diem)` và dùng `this` để in ra thông tin của đối tượng hiện tại.

---

## 4. Nạp chồng phương thức (Method Overloading)

### 4.1. Khái niệm

Nạp chồng phương thức là việc định nghĩa nhiều phương thức cùng tên nhưng khác nhau về số lượng, kiểu dữ liệu của tham số.

### 4.2. Ví dụ

```java
class TinhToan {
    int cong(int a, int b) {
        return a + b;
    }

    double cong(double a, double b) {
        return a + b;
    }

    int cong(int a, int b, int c) {
        return a + b + c;
    }
}

public class DemoOverloading {
    public static void main(String[] args) {
        TinhToan tt = new TinhToan();

        System.out.println(tt.cong(2, 3));       // 5
        System.out.println(tt.cong(2.5, 3.5));   // 6.0
        System.out.println(tt.cong(1, 2, 3));    // 6
    }
}
```

### 4.3. Điều kiện nạp chồng

Các phương thức được coi là nạp chồng khi:
- cùng tên
- khác số lượng tham số, hoặc
- khác kiểu dữ liệu tham số

Không được chỉ dựa vào kiểu trả về để phân biệt phương thức.

### 4.4. Ví dụ sai thường gặp

```java
class Demo {
    int tong(int a, int b) {
        return a + b;
    }

    double tong(int a, int b) {
        return a + b;
    }
}
```

Đây là lỗi vì chỉ khác kiểu trả về, không khác tham số.

### 4.5. Chú ý

- Nạp chồng giúp code rõ ràng và dễ dùng hơn.
- Java sẽ chọn phương thức phù hợp dựa trên danh sách tham số gọi.
- Không nên nhầm lẫn với override (ghi đè) phương thức của lớp cha.

### 4.6. Bài tập luyện tập

#### Bài 1
Viết class `Calculator` với các phương thức `add()` nạp chồng theo kiểu:
- `add(int, int)`
- `add(double, double)`
- `add(int, int, int)`

#### Bài 2
Viết class `InThongTin` có các phương thức `display()`:
- `display(String)`
- `display(String, int)`
- `display(int, String)`

#### Bài 3
Viết chương trình nạp chồng `tinhDienTich()` cho hình chữ nhật và hình tròn với tham số khác nhau.

---

## 5. Bài tập tổng hợp

### Bài tập 1: Quản lý sinh viên
Viết chương trình:
- Khai báo class `SinhVien` có `ten`, `tuoi`, `lop`
- Sử dụng `List<SinhVien>` để lưu danh sách
- Thêm 3 sinh viên
- In ra danh sách
- Tìm sinh viên theo tên

### Bài tập 2: Tính toán với static
Viết class `TinhToan` với các phương thức static:
- `tong(int a, int b)`
- `hieu(int a, int b)`
- `tich(int a, int b)`

Sử dụng tên class để gọi và in kết quả.

### Bài tập 3: Nạp chồng và this
Viết class `XeMay` gồm:
- thuộc tính `hang`, `mauSac`, `soKhung`
- constructor mặc định và constructor có tham số
- phương thức `thongTin()` nạp chồng theo các dạng:
  - `thongTin()`
  - `thongTin(String hang)`
  - `thongTin(String hang, String mauSac)`

### Bài tập 4: Bài tập nâng cao
Cho một `List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));`
- In phần tử đầu và phần tử cuối
- Tính tổng các số chẵn
- Xóa phần tử ở vị trí 2
- In danh sách cuối cùng

---

## 6. Mẹo học hiệu quả

- Học theo từng ví dụ và tự sửa lại code.
- Nên viết từng đoạn code nhỏ thay vì copy nguyên một file lớn.
- Sau mỗi bài, hãy thử thay đổi tham số và quan sát kết quả.
- Khi chưa hiểu, hãy vẽ sơ đồ đối tượng và biến trong đầu.

---

## 7. Tổng kết

Các kiến thức quan trọng trong bài:
- `List` là giao diện chứa dữ liệu theo thứ tự.
- `ArrayList` là triển khai phổ biến của `List`.
- `static` dùng cho thành viên thuộc về class.
- `this` tham chiếu tới đối tượng hiện tại.
- Nạp chồng phương thức giúp tạo nhiều phiên bản khác nhau của cùng một tên phương thức.

Nếu bạn luyện tập đều các ví dụ và bài tập trên, bạn sẽ nắm vững nền tảng Java cơ bản rất tốt.

---

## 8. Gợi ý bài tập tự làm thêm

1. Viết chương trình quản lý danh sách học sinh dùng `ArrayList`.
2. Viết class `SanPham` có biến static đếm tổng số sản phẩm.
3. Viết class `Nguoi` với constructor sử dụng `this`.
4. Viết 3 phương thức nạp chồng `tinhLuong()` với tham số khác nhau.
5. Tạo chương trình nhập số lượng phần tử, lưu vào `List`, rồi sắp xếp và in ra.

Nếu bạn muốn, tôi có thể tiếp tục giúp bạn làm tiếp một trong các phần sau:
- soạn file `.java` cho từng bài tập
- tạo một bộ đề kiểm tra ngắn
- làm slide hoặc ghi chú dạng dễ học hơn cho sinh viên
