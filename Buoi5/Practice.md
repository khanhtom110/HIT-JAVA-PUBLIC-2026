# BÀI TẬP VỀ NHÀ BUỔI 5 - LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG (OOP)
**Chủ đề:** Hệ thống Quản lý Cửa hàng Điện thoại

---

### Bài 1: Class `Smartphone`
- **Mục tiêu:** Đóng gói dữ liệu chặt chẽ và hiểu cách biến static hoạt động độc lập với từng đối tượng (instance).
- **Yêu cầu:** Tạo class `Smartphone` để lưu trữ thông tin sản phẩm.
- Khai báo thuộc tính:
  - `private static int totalPhones = 0;` (Biến tĩnh: Đếm tổng số lượng điện thoại đã được tạo ra trong hệ thống).
  - `private String id;` (Mã sản phẩm).
  - `private String name;`
  - `private double price;`
  - `private int stock;` (Số lượng tồn kho).
- Constructor chỉ nhận `name`, `price`, `stock`.
  - Mỗi lần khởi tạo 1 đối tượng, `totalPhones` phải tự động tăng thêm 1.
  - Mã `id` được sinh tự động theo quy tắc: `"SP" + totalPhones` (VD: tạo cái đầu tiên là `SP1`, cái thứ hai là `SP2`). Không viết hàm `setId()` để tránh mã này bị đổi từ bên ngoài.
- Viết các hàm `getter/setter` cho `name`, `price`, `stock`.
  - Cài đặt điều kiện: Nếu `price < 0` hoặc `stock < 0` thì in ra lỗi và gán bằng `0`.
- **Hàm `Main` (Kiểm tra Bài 1):**
  - Tạo 3 chiếc `Smartphone`. In ra ID của từng chiếc để thấy ID tự động tăng.
  - Thử in `Smartphone.getTotalPhones()` (nhớ viết hàm static getter cho nó) để thấy tổng số đếm.

### Bài 2: Class `Customer`
- **Mục tiêu:** Quản lý danh sách đối tượng bằng `ArrayList` và học cách chống rò rỉ dữ liệu (bảo vệ reference type).
- **Yêu cầu:** Tạo class `Customer` đại diện cho khách hàng.
- Thuộc tính:
  - `private String customerName;`
  - `private ArrayList<Smartphone> cart;` (Giỏ hàng của khách).
- Khởi tạo: Constructor nhận `customerName`. Khởi tạo `cart` là một `ArrayList` rỗng.
- **Đa hình (Polymorphism - Overloading):**
  - Viết 2 hàm xóa sản phẩm khỏi giỏ hàng cùng tên:
    - `public void removePhone(String id)`: Duyệt giỏ hàng, xóa điện thoại có id tương ứng.
    - `public void removePhone(int index)`: Xóa điện thoại theo vị trí index trong giỏ hàng (nhớ kiểm tra index hợp lệ để không bị lỗi `IndexOutOfBoundsException`).
- **Bảo mật dữ liệu (Khó):**
  - Viết hàm `public ArrayList<Smartphone> getCart()`.
  - **Quy tắc cốt lõi:** Tuyệt đối KHÔNG `return cart;`. (Bởi vì nếu làm vậy, bên ngoài có thể gọi `khachHang.getCart().clear()` và xóa sạch giỏ hàng dù không dùng hàm của `Customer`).
  - **Cách giải quyết:** Hãy return một bản sao của `ArrayList` (Tạo một `ArrayList` mới, bỏ các phần tử hiện tại vào và return cái mới đó).
- **Hàm `Main` (Kiểm tra Bài 2):**
  - Tạo 1 `Customer` và add 2 `Smartphone` (từ bài 1) vào `cart`.
  - Lấy giỏ hàng ra bằng `getCart()` và gọi lệnh `.clear()`.
  - Sau đó in lại số lượng sản phẩm trong giỏ của `Customer`. Nếu số lượng vẫn là 2, bạn đã đóng gói `ArrayList` thành công!

### Bài 3: Class `Store`
- **Mục tiêu:** Làm quen với việc thao tác dữ liệu phức tạp trên `ArrayList` bằng Đa hình (Overloading).
- **Yêu cầu:** Tạo class `Store` (Cửa hàng).
- Thuộc tính:
  - `private ArrayList<Smartphone> inventory;` (Kho hàng của cửa hàng).
- Khởi tạo & Thêm sửa:
  - Khởi tạo danh sách rỗng trong Constructor.
  - Viết hàm `public void addPhoneToStore(Smartphone phone)`.
- Cửa hàng cung cấp 3 cách tìm kiếm sản phẩm cho khách, hãy viết 3 hàm cùng tên `search`:
  - `public Smartphone search(String id)`: Trả về đúng 1 chiếc điện thoại có ID trùng khớp. Trả về `null` nếu không thấy.
  - `public ArrayList<Smartphone> search(double minPrice, double maxPrice)`: Lọc kho hàng, trả về một danh sách mới chứa các điện thoại có giá nằm trong khoảng `minPrice` đến `maxPrice`.
  - `public ArrayList<Smartphone> searchName(String keyword)`: Hãy overload tiếp bằng hàm `search(String keyword)` -> Lưu ý: Bạn không thể overload 2 hàm cùng nhận 1 tham số `String` (ID và Keyword). Hãy tìm cách gộp chúng hoặc thêm tham số `boolean isSearchByName` để lách luật quá tải hàm. (Ví dụ: `public ArrayList<Smartphone> search(String keyword, boolean isName)`).
- **Hàm `Main` (Kiểm tra Bài 3):**
  - Tạo `Store`, nạp vào 4-5 cái `Smartphone` khác nhau.
  - Test thử việc gọi hàm `search` với các kiểu tham số khác nhau, hệ thống sẽ tự động điều hướng đến đúng luồng xử lý.

### Bài 4: Giao dịch giữa `Store` và `Customer` (bổ sung)
- **Mục tiêu:** Yêu cầu sinh viên hiểu sâu sắc việc các đối tượng trong Java trỏ chung vùng nhớ.
- **Yêu cầu:**
  - Trong class `Store`, viết hàm: `public void sellPhone(Customer customer, String phoneId)`
  - **Logic bán hàng:**
    - Gọi hàm `search(String id)` để tìm điện thoại trong kho.
    - Nếu tìm thấy và `stock > 0`:
      - Giảm `stock` của chiếc điện thoại đó đi 1.
      - Add chiếc điện thoại đó vào giỏ hàng của `customer`.
- **Hàm `Main` (Kiểm tra sự thấu hiểu - Thực hiện đúng các bước sau):**
  - **Bước 1:** Tạo Cửa hàng, Tạo 1 Khách hàng. Nhập vào kho 1 chiếc "iPhone 15, giá 20 triệu".
  - **Bước 2:** Cửa hàng bán (`sellPhone`) chiếc iPhone 15 đó cho Khách hàng.
  - **Bước 3:** Cửa hàng quyết định TĂNG GIÁ chiếc iPhone 15 trong kho (`inventory`) lên 25 triệu.
  - **Bước 4:** In ra giá chiếc iPhone 15 đang nằm trong giỏ hàng (`cart`) của Khách hàng.
  - **Câu hỏi cho bạn:** Tại sao giá trong giỏ hàng của khách cũng bị biến thành 25 triệu dù khách đã mua từ trước? *(Gợi ý: Cửa hàng và Khách hàng đang lưu trữ 2 ArrayList khác nhau, nhưng cả 2 mảng này lại đang chứa cùng 1 địa chỉ bộ nhớ trỏ đến đúng 1 object Smartphone đó. Sửa 1 nơi, nơi kia tự đổi).*

### Bài 5: Chính sách thuế toàn cục
- **Mục tiêu:** Ứng dụng biến static vào việc thay đổi hàng loạt dữ liệu của hệ thống chỉ với một dòng code.
- **Yêu cầu:**
  - Nâng cấp class `Smartphone`:
    - Thêm `private static double vatTax = 0.10;` (Thuế VAT chung của toàn hệ thống là 10%).
    - Viết hàm `public static void setVatTax(double tax)` để nhà nước có thể cập nhật thuế.
    - Viết hàm `public double getFinalPrice()`: Tính giá sau thuế = `price + (price * vatTax)`.
  - Nâng cấp class `Customer`:
    - Viết hàm `public double calculateTotalBill()`: Duyệt qua toàn bộ giỏ hàng, dùng hàm `getFinalPrice()` cộng dồn và trả về tổng tiền khách phải trả.
  - Nâng cấp class `Store`:
    - Viết hàm `public double calculateInventoryValue()`: Duyệt kho hàng, tính tổng tiền (Dựa vào `getFinalPrice() * stock`).
- **Hàm `Main` (Trải nghiệm quyền năng của Static):**
  - Đưa vài sản phẩm vào `Store`, thực hiện vài giao dịch cho `Customer`.
  - In ra `calculateTotalBill()` của Khách và `calculateInventoryValue()` của Kho.
  - Đột nhiên nhà nước ban hành luật mới: Giảm thuế VAT xuống còn 8% (Gọi `Smartphone.setVatTax(0.08)`).
  - Gọi lại 2 hàm tính tiền ở trên và in ra màn hình.