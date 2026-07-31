# BÀI TẬP VỀ NHÀ BUỔI 4 - LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG (OOP)
**Chủ đề:** Quản lý Sản phẩm Cửa hàng Đồ chơi 

## Mô tả bài toán
Bạn cần xây dựng một chương trình quản lý các sản phẩm trong một cửa hàng đồ chơi. Chương trình yêu cầu áp dụng đủ 4 nguyên lý của OOP: 
1. **Trừu tượng (Abstraction):** Mô hình hóa đối tượng đồ chơi trong thực tế thành class với các thuộc tính cần thiết, ẩn đi các chi tiết không quan trọng.
2. **Đóng gói (Encapsulation):** Bảo vệ dữ liệu bằng `private` và kiểm soát qua `getter/setter`.
3. **Kế thừa (Inheritance):** Tái sử dụng code cho các loại đồ chơi cụ thể.
4. **Đa hình (Polymorphism):** Cùng một lệnh gọi hàm nhưng đối tượng con tự biết cách xử lý theo cách của nó.

---

### Yêu cầu 1: Tạo class cha Toy
- Tạo package `model`. Trong package `model`, tạo class `Toy`.
- Khai báo các thuộc tính `private` sau:
  - `id` (String): Mã đồ chơi.
  - `name` (String): Tên đồ chơi.
  - `price` (double): Giá bán.
  - `quantity` (int): Số lượng tồn kho.
- Viết Constructor đầy đủ tham số (Lưu ý: Gọi các hàm `setter` ở trong constructor này để tận dụng kiểm tra dữ liệu).
- Viết các phương thức `getter` và `setter` đầy đủ. Áp dụng validation:
  - `setPrice(double price)`: Nếu `price <= 0`, in ra thông báo lỗi *"Giá bán không hợp lệ!"* và không gán giá trị.
  - `setQuantity(int quantity)`: Nếu `quantity < 0`, in ra thông báo lỗi *"Số lượng không hợp lệ!"* và không gán giá trị.
- Viết phương thức `public double calculateDiscount()`: 
  *(Mặc định đối với đồ chơi thường, hàm này `return 0;` - tức là không có chính sách giảm giá).*
- Viết phương thức `public void printInfo()` in ra màn hình các thông tin cơ bản: Mã, Tên, Giá, Số lượng.

### Yêu cầu 2: Tạo class con ElectronicToy(Đồ chơi Điện tử)
- Tạo class `ElectronicToy` kế thừa từ class `Toy`.
- Bổ sung thuộc tính `private int warranty` (Thời gian bảo hành, tính bằng tháng).
- Viết constructor gọi `super(...)` để khởi tạo các thuộc tính của lớp cha, và gán giá trị cho `warranty`.
- Viết các hàm `getter/setter` cho `warranty`.
- **Ghi đè (Override)** phương thức `calculateDiscount()`: 
  Đồ chơi điện tử được giảm 5% giá bán nếu giá (`price`) lớn hơn `500.0`, ngược lại không giảm (trả về `0`). 
  *(Gợi ý: Dùng `getPrice()` kế thừa từ lớp cha để lấy giá trị kiểm tra).*
- **Ghi đè (Override)** phương thức `printInfo()`: Gọi `super.printInfo()` để in thông tin cơ bản, sau đó in bổ sung thêm thời gian bảo hành và số tiền được giảm giá (`calculateDiscount()`).

### Yêu cầu 3:Tạo class con PlushToy(Đồ chơi Nhồi bông)
- Tạo class `PlushToy` kế thừa từ class `Toy`.
- Bổ sung thuộc tính `private String material` (Chất liệu, ví dụ: "Bông gòn", "Nỉ").
- Viết constructor gọi `super(...)` để khởi tạo các thuộc tính của lớp cha, và gán giá trị cho `material`.
- Viết các hàm `getter/setter` cho `material`.
- **Ghi đè (Override)** phương thức `calculateDiscount()`: 
  Đồ chơi nhồi bông luôn được giảm giá 10% (trả về `getPrice() * 0.1`).
- **Ghi đè (Override)** phương thức `printInfo()`: Gọi `super.printInfo()` để in thông tin cơ bản, sau đó in bổ sung thêm chất liệu và số tiền được giảm giá.

### Yêu cầu 4: 
- Tạo package `app` (ngang hàng với package `model`). Trong package `app`, tạo class `Main` chứa phương thức `public static void main(String[] args)`.
- Khởi tạo một mảng (Array) kiểu `Toy` chứa 3 phần tử:
  - 1 đối tượng `Toy` cơ bản (Ví dụ: Bộ xếp hình).
  - 1 đối tượng `ElectronicToy` (Ví dụ: Robot thông minh, bảo hành 12 tháng).
  - 1 đối tượng `PlushToy` (Ví dụ: Gấu bông Teddy, chất liệu Bông gòn).
-  Sử dụng một vòng lặp `for` để duyệt qua mảng `Toy` vừa tạo và gọi phương thức `printInfo()` của từng đối tượng. 
  *( Lưu ý quan sát: Dù biến thuộc kiểu `Toy` và cùng gọi một hàm `printInfo()`, nhưng Java sẽ tự động thực thi đúng phương thức đã được override của từng lớp con tương ứng).*