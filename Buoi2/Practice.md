# BÀI TẬP THỰC HÀNH: BUỔI 2 - NỀN TẢNG JAVA

Tập hợp 5 bài tập thực hành dưới đây được thiết kế nhằm củng cố toàn bộ kiến thức nền tảng trong bài học **Buổi 2** (Biến, kiểu dữ liệu, ép kiểu, nhập xuất dữ liệu, toán tử, điều kiện, vòng lặp, quy tắc đặt tên, mảng, hàm, hằng số, lớp `String` và `Math`).

> [!IMPORTANT]
> **Quy tắc chung khi làm bài:**
> 1. Chỉ sử dụng các thư viện và lớp đã học: `java.util.Scanner`, `java.lang.String`, và `java.lang.Math`. Không sử dụng các cấu trúc dữ liệu nâng cao như `ArrayList`, `List`, `Regex` phức tạp, v.v.
> 2. Đặt tên biến, tên hàm theo chuẩn **camelCase** (ví dụ: `studentAge`, `calculateSum`).
> 3. Đặt tên Class theo chuẩn **PascalCase** (ví dụ: `GeometryCalculator`).
> 4. Xử lý triệt để hiện tượng trôi dòng khi nhập dữ liệu bằng cách sử dụng `Integer.parseInt(scanner.nextLine())` hoặc `Double.parseDouble(scanner.nextLine())` thay vì `nextInt()`, `nextDouble()`.

---

## BÀI 1: TÍNH KHOẢNG CÁCH EUCLIDEAN (Tọa độ, Lớp Math, Ép kiểu, Định dạng đầu ra)

### 1. Mục tiêu
- Luyện tập nhập xuất dữ liệu từ bàn phím bằng `Scanner`.
- Sử dụng các phương thức `Math.pow()` và `Math.sqrt()`.
- Sử dụng phương thức xuất dữ liệu có định dạng `System.out.printf()`.

### 2. Mô tả bài toán
Viết chương trình nhập vào tọa độ của hai điểm $A(x_1, y_1)$ và $B(x_2, y_2)$ từ bàn phím (tất cả các tọa độ $x_1, y_1, x_2, y_2$ đều là số nguyên). Tính và in ra khoảng cách Euclidean giữa hai điểm này theo công thức:
$$d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}$$
Kết quả in ra màn hình phải được làm tròn chính xác đến **2 chữ số thập phân**.

### 3. Ví dụ minh họa
- **Đầu vào (Input):**
  ```text
  Nhập x1: 1
  Nhập y1: 2
  Nhập x2: 3
  Nhập y2: 4
  ```
- **Đầu ra (Output):**
  ```text
  Khoảng cách giữa hai điểm A và B là: 2.83
  ```

### 4. Gợi ý & Cảnh báo bẫy
- **Bẫy ép kiểu:** Kết quả của hiệu tọa độ sau khi bình phương cần đảm bảo được truyền vào hàm của `Math` dưới dạng số thực (`double`) để tránh lỗi mất mát dữ liệu hoặc lỗi kiểu dữ liệu.
- Định dạng xuất: Sử dụng định dạng `%.2f` và ký tự xuống dòng chuẩn `%n` trong `printf()`.

### 5. Khung mã nguồn gợi ý
```java
import java.util.Scanner;

public class PointDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập x1: ");
        int x1 = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập y1: ");
        int y1 = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập x2: ");
        int x2 = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập y2: ");
        int y2 = Integer.parseInt(scanner.nextLine());

        // Viết code tính toán khoảng cách ở đây
        // ...

        // In kết quả có định dạng
        // System.out.printf("...", ...);
    }
}
```

---

## BÀI 2: PHÂN LOẠI TAM GIÁC & TÍNH DIỆN TÍCH (Điều kiện, Toán tử logic, Ép kiểu)

### 1. Mục tiêu
- Sử dụng các toán tử logic (`&&`, `||`, `!`) và cấu trúc điều kiện `if - else if - else`.
- Áp dụng kỹ thuật ép kiểu và tránh bẫy chia số nguyên.

### 2. Mô tả bài toán
Viết chương trình nhập vào 3 số nguyên dương $a, b, c$ từ bàn phím đại diện cho độ dài 3 cạnh.
1. Kiểm tra xem 3 cạnh đó có tạo thành một tam giác hợp lệ hay không. (Điều kiện tam giác hợp lệ: Tổng độ dài của 2 cạnh bất kỳ luôn lớn hơn độ dài cạnh còn lại: $a+b > c$, $a+c > b$, và $b+c > a$).
2. Nếu hợp lệ:
   - Hãy cho biết đó là tam giác gì: **Tam giác đều** (3 cạnh bằng nhau), **Tam giác cân** (2 cạnh bằng nhau), hay **Tam giác thường** (các trường hợp còn lại).
   - Tính và in ra chu vi và diện tích của tam giác đó. Diện tích được tính theo công thức Heron: 
     $$S = \sqrt{p(p-a)(p-b)(p-c)}$$
     Trong đó $p$ là nửa chu vi: $p = \frac{a+b+c}{2}$. Kết quả diện tích được làm tròn đến 2 chữ số thập phân.
3. Nếu không hợp lệ: In ra thông báo: `"Ba cạnh đã nhập không tạo thành một tam giác hợp lệ."`

### 3. Ví dụ minh họa
- **Đầu vào (Input):**
  ```text
  Nhập cạnh a: 3
  Nhập cạnh b: 4
  Nhập cạnh c: 5
  ```
- **Đầu ra (Output):**
  ```text
  Đây là tam giác thường.
  Chu vi: 12
  Diện tích: 6.00
  ```

### 4. Gợi ý & Cảnh báo bẫy
- **Bẫy chia số nguyên:** Công thức tính nửa chu vi $p = (a+b+c)/2$ sẽ bị mất phần thập phân nếu $a+b+c$ là số lẻ (ví dụ: $3+4+6 = 13$, $13/2$ trong Java sẽ ra $6.0$ thay vì $6.5$). Hãy ép kiểu hoặc thực hiện chia số thực: `double p = (a + b + c) / 2.0;`.

### 5. Khung mã nguồn gợi ý
```java
import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập cạnh b: ");
        int b = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập cạnh c: ");
        int c = Integer.parseInt(scanner.nextLine());

        // Kiểm tra điều kiện và thực hiện logic phân loại, tính toán
        // ...
    }
}
```

---

## BÀI 3: KIỂM TRA MẬT KHẨU HỢP LỆ (Vòng lặp, Xử lý ký tự, Biến cờ hiệu)

### 1. Mục tiêu
- Sử dụng vòng lặp `for` kết hợp cấu trúc điều kiện `if`.
- Làm quen với việc thao tác trên chuỗi bằng phương thức `length()`, `trim()`, và `charAt()`.
- Sử dụng biến logic (`boolean`) làm cờ hiệu (flag).

### 2. Mô tả bài toán
Viết chương trình nhập vào một chuỗi làm mật khẩu đăng ký từ bàn phím. Chương trình cần kiểm tra xem mật khẩu đó có hợp lệ hay không dựa trên các quy tắc bảo mật sau:
1. Mật khẩu sau khi đã loại bỏ khoảng trắng ở hai đầu (sử dụng `trim()`) phải có độ dài **tối thiểu là 8 ký tự**.
2. Mật khẩu phải chứa **ít nhất 1 chữ số** (từ `'0'` đến `'9'`).
3. Mật khẩu phải chứa **ít nhất 1 chữ cái viết hoa** (từ `'A'` đến `'Z'`).

Hãy thông báo cụ thể mật khẩu có hợp lệ hay không. Nếu không hợp lệ, hãy chỉ ra các tiêu chuẩn mà mật khẩu chưa đạt được.

### 3. Ví dụ minh họa
- **Đầu vào (Input):**
  ```text
  Nhập mật khẩu:  Abc12   
  ```
- **Đầu ra (Output):**
  ```text
  Mật khẩu không hợp lệ!
  - Mật khẩu phải có độ dài tối thiểu là 8 ký tự (Độ dài hiện tại sau khi cắt khoảng trắng: 5).
  ```
- **Đầu vào (Input):**
  ```text
  Nhập mật khẩu: admin123
  ```
- **Đầu ra (Output):**
  ```text
  Mật khẩu không hợp lệ!
  - Mật khẩu phải chứa ít nhất 1 chữ cái viết hoa.
  ```

### 4. Gợi ý & Cảnh báo bẫy
- Sử dụng phương thức `charAt(i)` để lấy ký tự tại vị trí chỉ số `i` trong chuỗi.
- Ký tự kiểu `char` có thể so sánh trực tiếp bằng các toán tử so sánh thông thường: ví dụ `c >= '0' && c <= '9'` để kiểm tra ký tự số, và `c >= 'A' && c <= 'Z'` để kiểm tra ký tự viết hoa.
- Nhớ thực hiện `password = password.trim()` trước khi kiểm tra độ dài.

### 5. Khung mã nguồn gợi ý
```java
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        // 1. Cắt khoảng trắng thừa
        String cleanedPassword = password.trim();
        int length = cleanedPassword.length();

        // 2. Khai báo các biến cờ hiệu logic
        boolean hasDigit = false;
        boolean hasUpper = false;

        // 3. Sử dụng vòng lặp duyệt qua từng ký tự
        for (int i = 0; i < length; i++) {
            char c = cleanedPassword.charAt(i);
            if (c >= '0' && c <= '9') {
                hasDigit = true;
            }
            if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            }
        }

        // 4. Kiểm tra các điều kiện và in ra kết quả tương ứng
        // ...
    }
}
```

---

## BÀI 4: QUẢN LÝ ĐIỂM SỐ HỌC SINH (Mảng, Vòng lặp for-each, Hàm static)

### 1. Mục tiêu
- Sử dụng mảng để lưu trữ tập hợp dữ liệu.
- Áp dụng vòng lặp `for-each` để duyệt mảng hiệu quả.
- Rèn luyện kỹ năng viết và gọi hàm (`static method`) có tham số truyền vào là mảng và kiểu trả về phù hợp.

### 2. Mô tả bài toán
Viết chương trình thực hiện các công việc sau:
1. Nhập vào số lượng học sinh $N$ từ bàn phím ($N > 0$).
2. Khởi tạo một mảng số thực (`double[]`) có kích thước là $N$ để lưu trữ điểm số của các học sinh (điểm hợp lệ là số thực nằm trong khoảng từ `0.0` đến `10.0`). Hãy yêu cầu nhập điểm cho từng học sinh.
3. Viết và gọi các hàm (phương thức static) sau để xử lý dữ liệu mảng:
   - `public static double findMax(double[] arr)`: Tìm và trả về điểm số cao nhất trong mảng.
   - `public static double calculateAverage(double[] arr)`: Tính và trả về điểm số trung bình của cả lớp.
   - `public static int countFailedStudents(double[] arr)`: Đếm và trả về số lượng học sinh có điểm dưới trung bình (nhỏ hơn `5.0`). **Yêu cầu bắt buộc sử dụng vòng lặp for-each** trong hàm này.
4. In các thông tin kết quả (điểm cao nhất, điểm trung bình làm tròn 2 chữ số thập phân, số lượng học sinh dưới trung bình) ra màn hình.

### 3. Ví dụ minh họa
- **Đầu vào (Input):**
  ```text
  Nhập số lượng học sinh: 4
  Nhập điểm học sinh thứ 1: 8.5
  Nhập điểm học sinh thứ 2: 4.0
  Nhập điểm học sinh thứ 3: 9.0
  Nhập điểm học sinh thứ 4: 4.8
  ```
- **Đầu ra (Output):**
  ```text
  Điểm cao nhất: 9.0
  Điểm trung bình lớp: 6.58
  Số học sinh có điểm dưới trung bình (< 5.0): 2
  ```

### 4. Gợi ý & Cảnh báo bẫy
- **Lỗi chỉ số mảng:** Chỉ số của mảng chạy từ `0` đến `arr.length - 1`. Hãy cẩn thận khi duyệt vòng lặp để tránh lỗi `ArrayIndexOutOfBoundsException`.
- Khi tính trung bình, hãy cộng dồn toàn bộ điểm rồi chia cho `arr.length`. Nhớ kiểm tra trường hợp độ dài mảng bằng 0 để tránh phép chia cho 0.

### 5. Khung mã nguồn gợi ý
```java
import java.util.Scanner;

public class ScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng học sinh: ");
        int n = Integer.parseInt(scanner.nextLine());

        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm học sinh thứ " + (i + 1) + ": ");
            scores[i] = Double.parseDouble(scanner.nextLine());
        }

        // Gọi các hàm và in kết quả ra màn hình
        System.out.println("Điểm cao nhất: " + findMax(scores));
        System.out.printf("Điểm trung bình lớp: %.2f%n", calculateAverage(scores));
        System.out.println("Số học sinh dưới trung bình: " + countFailedStudents(scores));
    }

    public static double findMax(double[] arr) {
        double max = arr[0];
        // Viết code tìm giá trị lớn nhất ở đây
        // ...
        return max;
    }

    public static double calculateAverage(double[] arr) {
        double sum = 0;
        // Viết code tính tổng ở đây
        // ...
        return sum / arr.length;
    }

    public static int countFailedStudents(double[] arr) {
        int count = 0;
        // Bắt buộc dùng vòng lặp for-each để đếm số học sinh có điểm < 5.0
        // ...
        return count;
    }
}
```

---

## BÀI 5: PHÂN TÍCH & CHUẨN HÓA THÔNG TIN NHÂN VIÊN (String Manipulation)

### 1. Mục tiêu
- Sử dụng linh hoạt các phương thức của lớp `String`: `trim()`, `split()`, `substring()`, `toLowerCase()`, `toUpperCase()`, và `contains()`.
- Rèn luyện tư duy xử lý và chuẩn hóa chuỗi dữ liệu đầu vào.

### 2. Mô tả bài toán
Trong các hệ thống thực tế, dữ liệu nhập vào thường chưa được định dạng đẹp mắt. Viết chương trình nhập vào một chuỗi thông tin nhân viên có định dạng thô như sau:
`"  Mã_Số - Họ_Tên - Năm_Sinh - Phòng_Ban  "`
*(Ví dụ: `"  nv204 -   LÊ   hOÀNg   nHÂn - 2002 - Phòng kỹ thuật  "`)*

Hãy xử lý và chuẩn hóa chuỗi này theo các yêu cầu sau:
1. Loại bỏ các khoảng trắng thừa ở hai đầu của chuỗi gốc.
2. Tách chuỗi gốc thành 4 phần thông tin: Mã số, Họ tên, Năm sinh, Phòng ban dựa vào ký tự phân tách là dấu gạch ngang `-`. **Lưu ý loại bỏ khoảng trắng thừa của từng phần thông tin sau khi tách.**
3. **Chuẩn hóa Họ tên:** Viết hoa chữ cái đầu tiên của từng từ và viết thường các chữ cái còn lại trong từ đó. (Ví dụ: `LÊ   hOÀNg   nHÂn` -> `Lê Hoàng Nhân`). Các từ cách nhau đúng 1 khoảng trắng duy nhất.
4. **Kiểm tra phòng ban:** 
   - Nếu phòng ban chứa cụm từ `"kỹ thuật"` hoặc `"ky thuat"` (không phân biệt chữ hoa chữ thường), hãy in ra thông báo: `"Phân loại: Nhân viên kỹ thuật"`.
   - Ngược lại, in ra thông báo: `"Phân loại: Nhân viên nghiệp vụ"`.
5. **Đầu ra:** Tính tuổi của nhân viên (biết năm hiện tại là 2026, tuổi = $2026 - Năm\_Sinh$) và in ra thông tin nhân viên theo định dạng chuẩn hóa sau:
   `Mã nhân viên: NV204 | Họ và tên: Lê Hoàng Nhân | Tuổi: 24 | Bộ phận: Phòng kỹ thuật`

### 3. Ví dụ minh họa
- **Đầu vào (Input):**
  ```text
  Nhập thông tin nhân viên:   nv204 -   LÊ   hOÀNg   nHÂn - 2002 - Phòng kỹ thuật  
  ```
- **Đầu ra (Output):**
  ```text
  Phân loại: Nhân viên kỹ thuật
  Mã nhân viên: nv204 | Họ và tên: Lê Hoàng Nhân | Tuổi: 24 | Bộ phận: Phòng kỹ thuật
  ```

### 4. Gợi ý & Cảnh báo bẫy
- Sử dụng phương thức `split("-")` để tách chuỗi gốc thành một mảng gồm 4 phần tử.
- Nhớ gọi `.trim()` cho từng phần tử sau khi tách để loại bỏ khoảng trắng thừa bao quanh giá trị.
- Để chuẩn hóa họ tên: Tách chuỗi tên thô thành mảng các từ (ví dụ dùng `split("\\s+")` để tách theo một hoặc nhiều khoảng trắng). Lặp qua từng từ, chuyển từ đó về chữ thường (`toLowerCase()`), sau đó dùng `toUpperCase()` kết hợp `substring()` để viết hoa ký tự đầu tiên. Nối các từ lại với nhau bằng một dấu cách `" "`.
- Sử dụng `toLowerCase().contains("kỹ thuật")` để kiểm tra phòng ban không phân biệt chữ hoa chữ thường.

### 5. Khung mã nguồn gợi ý
```java
import java.util.Scanner;

public class EmployeeInfoStandardizer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập thông tin nhân viên: ");
        String rawInput = scanner.nextLine();

        // 1. Loại bỏ khoảng trắng 2 đầu và tách mảng theo dấu "-"
        String[] parts = rawInput.trim().split("-");

        if (parts.length < 4) {
            System.out.println("Thông tin nhập vào không đúng định dạng!");
            return;
        }

        // 2. Trích xuất và trim() các trường thông tin
        String code = parts[0].trim();
        String rawName = parts[1].trim();
        String rawYear = parts[2].trim();
        String department = parts[3].trim();

        // 3. Chuẩn hóa họ tên
        String formattedName = capitalizeName(rawName);

        // 4. Kiểm tra phòng ban
        if (department.toLowerCase().contains("kỹ thuật") || department.toLowerCase().contains("ky thuat")) {
            System.out.println("Phân loại: Nhân viên kỹ thuật");
        } else {
            System.out.println("Phân loại: Nhân viên nghiệp vụ");
        }

        // 5. Tính tuổi và in kết quả định dạng
        int birthYear = Integer.parseInt(rawYear);
        int age = 2026 - birthYear;

        System.out.println("Mã nhân viên: " + code + 
                           " | Họ và tên: " + formattedName + 
                           " | Tuổi: " + age + 
                           " | Bộ phận: " + department);
    }

    public static String capitalizeName(String name) {
        // Tách chuỗi tên thô thành các từ riêng biệt bằng một hoặc nhiều khoảng trắng
        String[] words = name.split("\\s+");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                // Viết hoa chữ đầu, viết thường các chữ sau
                String firstChar = word.substring(0, 1).toUpperCase();
                String remaining = word.substring(1).toLowerCase();
                
                result += firstChar + remaining;
                if (i < words.length - 1) {
                    result += " "; // Thêm khoảng trắng giữa các từ
                }
            }
        }
        return result.trim();
    }
}
```
