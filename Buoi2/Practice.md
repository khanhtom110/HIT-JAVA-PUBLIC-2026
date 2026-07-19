# BÀI TẬP THỰC HÀNH: BUỔI 2 - NỀN TẢNG JAVA

Tập hợp 5 bài tập thực hành dưới đây được thiết kế nhằm củng cố toàn bộ kiến thức nền tảng trong bài học **Buổi 2** (Biến, kiểu dữ liệu, ép kiểu, nhập xuất dữ liệu, toán tử, điều kiện, vòng lặp, quy tắc đặt tên, mảng, hàm, hằng số, lớp `String` và `Math`).

> [!IMPORTANT]
> **Quy tắc chung khi làm bài:**
> 1. Chỉ sử dụng các thư viện và lớp đã học: `java.util.Scanner`, `java.lang.String`, và `java.lang.Math`. Không sử dụng các cấu trúc dữ liệu nâng cao như `ArrayList`, `List`, `Regex` phức tạp, v.v.
> 2. Đặt tên biến, tên hàm theo chuẩn **camelCase** (ví dụ: `studentAge`, `calculateSum`).
> 3. Đặt tên Class theo chuẩn **PascalCase** (ví dụ: `GeometryCalculator`).
> 4. Xử lý triệt để hiện tượng trôi dòng khi nhập dữ liệu bằng cách sử dụng `Integer.parseInt(scanner.nextLine())` hoặc `Double.parseDouble(scanner.nextLine())` thay vì `nextInt()`, `nextDouble()`.

---

## BÀI 1: TÍNH KHOẢNG CÁCH EUCLIDEAN

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
---

## BÀI 2: PHÂN LOẠI TAM GIÁC & TÍNH DIỆN TÍCH

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

---

## BÀI 3: KIỂM TRA MẬT KHẨU HỢP LỆ

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

---

## BÀI 4: QUẢN LÝ ĐIỂM SỐ HỌC SINH

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

---

## BÀI 5: PHÂN TÍCH & CHUẨN HÓA THÔNG TIN NHÂN VIÊN

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

