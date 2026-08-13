# Bài tập buổi 6

## Bài 1: Quản lý đơn hàng

**Mô tả:** Xây dựng hệ thống quản lý đơn hàng sử dụng quan hệ HAS-A, trong đó một đơn hàng có một khách hàng và chứa một mảng sản phẩm. Cần khai báo mảng đúng cách, kiểm tra kích thước mảng trước khi thêm sản phẩm, tính toán tổng tiền đúng bằng cách dùng biến đếm thay vì độ dài mảng.

**Yêu cầu:**
- Class `Customer`
  - Thuộc tính: `String name`, `String phone`, `String address`
  - Phương thức:

- Class `Product`
  - Thuộc tính: `String id`, `String name`, `double price`, `int quantity`
  - Phương thức: `double getSubtotal()`

- Class `Order`
  - Thuộc tính: `String orderId`, `Customer customer`, `Product[] items`, `int count`
  - Phương thức: `Order(String orderId, Customer customer)`, `void addProduct(Product p)`, `double getTotal()`, `void printInvoice()`

**Đầu vào:** 1 khách "Nguyễn Văn A" - "0987654321" - "123 Lê Lợi, TPHCM", 3 sản phẩm.

**Đầu ra:** Hóa đơn in ra màn hình.

**Yêu cầu nâng cao:** Viết lại class `Order` bằng `ArrayList<Product>` thay vì mảng thuần và so sánh sự khác nhau.

---

## Bài 2: Hệ thống sản phẩm với kế thừa

**Mô tả:** Xây dựng hệ thống sản phẩm sử dụng kế thừa (IS-A), với lớp cha Product và ba lớp con (Book, Electronic, Food). Mỗi loại sản phẩm có cách tính giá discount khác nhau. Ghi đè phương thức để hiển thị thông tin chi tiết và tính giá cuối cùng phù hợp với loại sản phẩm. Sử dụng List để chứa các sản phẩm khác loại.

**Yêu cầu:**
- Class `Product`
  - Thuộc tính: `protected String id`, `protected String name`, `protected double price`
  - Phương thức: `Product(String id, String name, double price)`, `double getDiscountedPrice()`, `void showInfo()`, `String toString()`

- Class `Book extends Product`
  - Thuộc tính: `private String author`, `private int pages`
  - Phương thức: `Book(String id, String name, double price, String author, int pages)`, `double getDiscountedPrice()` (giảm 10%), `void showInfo()`, `String toString()`

- Class `Electronic extends Product`
  - Thuộc tính: `private int warrantyMonths`
  - Phương thức: `Electronic(String id, String name, double price, int warrantyMonths)`, `double getDiscountedPrice()` (cộng 5%), `void showInfo()`, `String toString()`

- Class `Food extends Product`
  - Thuộc tính: `private String expiryDate`
  - Phương thức: `Food(String id, String name, double price, String expiryDate)`, `double getDiscountedPrice()`, `void showInfo()`, `String toString()`

**Đầu vào:** `List<Product>` chứa 5 sản phẩm: 2 sách, 2 điện tử, 1 thực phẩm.

**Đầu ra:** Duyệt danh sách và in `showInfo()` + `toString()` của từng sản phẩm.

**Yêu cầu nâng cao:** Tính tổng giá trị kho hàng (giá gốc) và tổng giá trị nếu bán hết (có áp dụng discount).

---

## Bài 3: Hệ thống tài khoản khách hàng

**Mô tả:** Xây dựng hệ thống tài khoản khách hàng sử dụng kế thừa và quan hệ HAS-A, trong đó lớp Account có một địa chỉ và hai loại tài khoản con (NormalAccount, VipAccount) với mức giảm giá khác nhau. Ghi đè phương thức `getDiscount()` để tính discount dựa trên loại tài khoản và điểm tích lũy.

**Yêu cầu:**
- Class `Address`
  - Thuộc tính: `private String street`, `private String city`, `private String zipCode`
  - Phương thức: `Address(String street, String city, String zipCode)`, `String toString()`

- Class `Account`
  - Thuộc tính: `protected String username`, `protected String email`, `protected Address address`
  - Phương thức: `Account(String username, String email, Address address)`, `double getDiscount()`, `String toString()`

- Class `NormalAccount extends Account`
  - Thuộc tính: (kế thừa từ cha)
  - Phương thức: `NormalAccount(String username, String email, Address address)`, `double getDiscount()`, `String toString()`

- Class `VipAccount extends Account`
  - Thuộc tính: `private int points`
  - Phương thức: `VipAccount(String username, String email, Address address, int points)`, `double getDiscount()`, `String toString()`

**Đầu vào:** 3 tài khoản: 1 normal, 2 VIP (1 có points < 1000, 1 có points >= 1000). Đơn hàng 2.000.000 VNĐ.

**Đầu ra:** In thông tin tài khoản, mức giảm giá (%), tổng tiền phải trả sau giảm giá.

**Yêu cầu nâng cao:** Thêm phương thức `void addPoints(int point)` vào `VipAccount`, kiểm tra nếu points vượt 1000 thì in thông báo "nâng hạng".
