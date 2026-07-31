# BỘ BÀI TẬP THỰC HÀNH LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG (OOP) VỚI JAVA

Chào mừng bạn đến với bộ bài tập Lập trình Hướng đối tượng (Object-Oriented Programming - OOP). Bộ bài tập này được thiết kế dựa trên các bài toán thực tế trong phát triển phần mềm doanh nghiệp, nhằm giúp bạn hiểu sâu và áp dụng thành thạo **4 tính chất cốt lõi của OOP**:

1. **Tính Đóng gói (Encapsulation):** Bảo vệ dữ liệu, che giấu trạng thái bên trong của đối tượng và kiểm soát truy cập thông qua Getter/Setter/Validation logic.
2. **Tính Kế thừa (Inheritance):** Tái sử dụng cấu trúc và hành vi giữa các lớp có quan hệ cha - con.
3. **Tính Đa hình (Polymorphic Behavior):** Cho phép các đối tượng thuộc các lớp khác nhau phản ứng khác nhau với cùng một thông điệp (gọi phương thức).
4. **Tính Trừu tượng (Abstraction):** Tập trung vào "đối tượng làm gì" thay vì "đối tượng làm như thế nào" thông qua Abstract Class và Interface.

---

## MỤC LỤC
1. [Bài 1: Hệ thống Thanh toán Thương mại Điện tử (E-Commerce Payment Gateway)](#bài-1-hệ-thống-thanh-toán-thương-mại-điện-tử-e-commerce-payment-gateway)
2. [Bài 2: Hệ thống Tính Lương Nhân viên Tự động (HR Payroll System)](#bài-2-hệ-thống-tính-lương-nhân-viên-tự-động-hr-payroll-system)
3. [Bài 3: Hệ thống Thông báo Đa kênh (Notification Service)](#bài-3-hệ-thống-thông-báo-đa-kênh-notification-service)
4. [Bài 4: Hệ thống Điều khiển Thiết bị Nhà thông minh (Smart Home IoT)](#bài-4-hệ-thống-điều-khiển-thiết-bị-nhà-thông-minh-smart-home-iot)
5. [Bài 5: Hệ thống Quản lý Tài khoản Ngân hàng (Banking Account Management)](#bài-5-hệ-thống-quản-lý-tài-khoản-ngân-hàng-banking-account-management)

---

## Bài 1: Hệ thống Thanh toán Thương mại Điện tử (E-Commerce Payment Gateway)

### 1. Bối cảnh thực tiễn
Trong một nền tảng thương mại điện tử hiện đại, khách hàng có thể chọn nhiều hình thức thanh toán khác nhau tại bước Checkout: Thanh toán qua Thẻ tín dụng (Credit Card), Ví điện tử MoMo, hoặc Chuyển khoản ngân hàng (Bank Transfer). 

Bộ phận xử lý đơn hàng (`OrderProcessor`) chỉ cần gửi thông tin yêu cầu thanh toán tới cổng thanh toán chung. Hệ thống phải đảm bảo tính mở: khi tích hợp thêm cổng thanh toán mới (như Apple Pay hay ZaloPay), toàn bộ mã nguồn xử lý đơn hàng hiện tại không bị ảnh hưởng hay phải sửa đổi.

---

### 2. Mô tả yêu cầu hệ thống

#### 2.1. Lớp trừu tượng `PaymentMethod` (Abstract Class)
Lớp này đóng vai trò là khuôn mẫu chung cho mọi phương thức thanh toán.
* **Thuộc tính:**
  * `transactionId` (`String`, `private`): Mã giao dịch duy nhất.
* **Phương thức:**
  * Constructor nhận vào `transactionId`.
  * Getter cho `transactionId`.
  * Phương thức trừu tượng: `public abstract boolean processPayment(double amount)`: Xử lý trừ tiền hoặc xác thực giao dịch với số tiền `amount`.

#### 2.2. Lớp `CreditCardPayment` (Kế thừa `PaymentMethod`)
Đại diện cho hình thức thanh toán bằng thẻ tín dụng.
* **Thuộc tính riêng:**
  * `cardNumber` (`String`, `private`): Số thẻ tín dụng.
  * `cvv` (`String`, `private`): Mã bảo mật CVV.
* **Yêu cầu:**
  * Khởi tạo đầy đủ các thuộc tính (gọi constructor của lớp cha).
  * Ghi đè phương thức `processPayment(double amount)`: In ra thông báo xác thực CVV, thực hiện trừ tiền từ số thẻ và trả về `true` nếu hợp lệ.

#### 2.3. Lớp `MomoPayment` (Kế thừa `PaymentMethod`)
Đại diện cho hình thức thanh toán qua ví MoMo.
* **Thuộc tính riêng:**
  * `phoneNumber` (`String`, `private`): Số điện thoại đăng ký ví.
* **Yêu cầu:**
  * Khởi tạo đầy đủ các thuộc tính.
  * Ghi đè phương thức `processPayment(double amount)`: In ra thông báo gửi mã OTP đến số điện thoại và trả về `true`.

#### 2.4. Lớp `OrderProcessor` (Xử lý Đơn hàng)
* **Phương thức:**
  * `public void checkout(PaymentMethod payment, double totalAmount)`:
    * Nhận vào một đối tượng kiểu `PaymentMethod` (chấp nhận bất kỳ lớp con nào).
    * Gọi phương thức `processPayment(totalAmount)`.
    * In ra thông báo giao dịch thành công (kèm mã giao dịch) hoặc thất bại.

---

### 3. Thể hiện 4 tính chất OOP

| Tính chất | Biểu hiện trong bài |
| :--- | :--- |
| **Encapsulation** | Che giấu `transactionId`, `cardNumber`, `cvv`, `phoneNumber` dưới dạng `private`. Chỉ truy cập qua phương thức được phép. |
| **Inheritance** | `CreditCardPayment` và `MomoPayment` tái sử dụng cấu trúc và phương thức từ `PaymentMethod`. |
| **Polymorphism** | `OrderProcessor.checkout()` nhận tham số kiểu `PaymentMethod`, nhưng thực tế sẽ thực thi logic `processPayment()` riêng biệt tương ứng với từng loại thẻ/ví được truyền vào lúc runtime. |
| **Abstraction** | Lớp `PaymentMethod` ẩn đi chi tiết cài đặt cụ thể của từng phương thức thanh toán, chỉ định nghĩa giao diện chung `processPayment()`. |

---

### 4. Bài học rút ra & Kiến trúc Phần mềm
* **Nguyên lý Open/Closed (SOLID):** Bạn có thể mở rộng hệ thống bằng cách thêm lớp `ApplePayPayment` mới mà **không cần chỉnh sửa một dòng code nào** trong lớp `OrderProcessor`.
* **Loose Coupling (Độ phụ thuộc lỏng lẻo):** Lớp xử lý đơn hàng không phụ thuộc trực tiếp vào chi tiết kỹ thuật của từng ngân hàng hay ví điện tử.

---

## Bài 2: Hệ thống Tính Lương Nhân viên Tự động (HR Payroll System)

### 1. Bối cảnh thực tiễn
Phòng Nhân sự cần một hệ thống tự động hóa việc tính lương và xuất phiếu lương hàng tháng. Doanh nghiệp có nhiều nhóm nhân sự với hình thức đãi ngộ khác nhau:
* **Nhân viên chính thức (Full-time):** Có mức lương cơ bản cố định và tiền thưởng hiệu suất.
* **Nhân viên bán thời gian (Part-time):** Tính lương dựa trên số giờ làm việc thực tế và đơn giá theo giờ.
* **Thực tập sinh (Intern):** Nhận phụ cấp cố định.

Hệ thống phải quản lý danh sách toàn bộ nhân sự tập trung và xuất tổng chi phí lương của toàn công ty chỉ bằng một lượt duyệt.

---

### 2. Mô tả yêu cầu hệ thống

#### 2.1. Lớp trừu tượng `Employee` (Abstract Class)
* **Thuộc tính:**
  * `id` (`String`, `private`): Mã định danh nhân viên.
  * `name` (`String`, `private`): Họ và tên.
  * `baseSalary` (`double`, `private`): Lương cơ bản.
* **Phương thức:**
  * Constructor thiết lập các thuộc tính.
  * Getter/Setter với Validation: `setBaseSalary(double baseSalary)` phải kiểm tra nếu `baseSalary < 0` thì ném ra ngoại lệ (`IllegalArgumentException`) hoặc thông báo lỗi.
  * Phương thức trừu tượng: `public abstract double calculateSalary()`: Tính tổng thu nhập thực nhận trong tháng.

#### 2.2. Lớp `FullTimeEmployee` (Kế thừa `Employee`)
* **Thuộc tính riêng:**
  * `bonus` (`double`, `private`): Tiền thưởng.
* **Yêu cầu:**
  * Khởi tạo thông tin nhân viên và khoản thưởng.
  * Ghi đè `calculateSalary()`: `Tổng lương = Lương cơ bản + Thưởng`.

#### 2.3. Lớp `PartTimeEmployee` (Kế thừa `Employee`)
* **Thuộc tính riêng:**
  * `hoursWorked` (`int`, `private`): Số giờ làm việc trong tháng.
  * `hourlyRate` (`double`, `private`): Mức lương theo giờ.
* **Yêu cầu:**
  * Lương cơ bản ở lớp cha được gán bằng 0.
  * Ghi đè `calculateSalary()`: `Tổng lương = Số giờ làm * Đơn giá theo giờ`.

#### 2.4. Chương trình quản lý (Main Class)
* Tạo danh sách/mảng kiểu `Employee[]` hoặc `List<Employee>`.
* Thêm các nhân viên thuộc nhiều hình thức khác nhau vào danh sách.
* Duyệt qua danh sách, gọi `calculateSalary()` để in bảng lương chi tiết và tính tổng ngân sách chi trả lương của công ty.

---

### 3. Thể hiện 4 tính chất OOP

| Tính chất | Biểu hiện trong bài |
| :--- | :--- |
| **Encapsulation** | Bắt buộc kiểm tra ràng buộc dữ liệu (ví dụ: lương không âm) ngay trong Setter. Che giấu biến `baseSalary`. |
| **Inheritance** | Các lớp `FullTimeEmployee`, `PartTimeEmployee` thừa hưởng thông tin định danh `id`, `name` từ `Employee`. |
| **Polymorphism** | Mảng kiểu `Employee[]` chứa hỗn hợp các đối tượng `FullTimeEmployee` và `PartTimeEmployee`. Vòng lặp gọi `emp.calculateSalary()` sẽ tự động kích hoạt công thức tương ứng. |
| **Abstraction** | Lớp `Employee` thể hiện khái niệm chung về một nhân viên có năng lực "tính lương", bỏ qua chi tiết tính như thế nào ở cấp độ chung. |

---

### 4. Bài học rút ra & Kiến trúc Phần mềm
* **Quản lý danh sách đối tượng hỗn hợp (Heterogeneous Collections):** Nhờ Đa hình và Kế thừa, lập trình viên không cần viết các câu lệnh `if-else` hay `switch-case` phức tạp để kiểm tra loại nhân viên trước khi tính lương.
* **Bảo vệ toàn vẹn dữ liệu (Data Integrity):** Kiểm soát dữ liệu đầu vào qua Setter ngăn ngừa dữ liệu hỏng tràn vào hệ thống.

---

## Bài 3: Hệ thống Thông báo Đa kênh (Notification Service)

### 1. Bối cảnh thực tiễn
Trong một ứng dụng tài chính/ngân hàng, khi xảy ra sự kiện quan trọng (như biến động số dư, cảnh báo đăng nhập lạ), hệ thống cần gửi thông báo ngay lập tức cho người dùng. Kênh gửi thông báo có thể linh hoạt thay đổi: Email, SMS, hoặc App Push Notification tùy thuộc vào cài đặt của người dùng hoặc mức độ khẩn cấp.

---

### 2. Mô tả yêu cầu hệ thống

#### 2.1. Giao diện `NotificationService` (Interface)
Xác định hợp đồng (contract) chung cho tất cả các dịch vụ gửi thông báo.
* **Phương thức:**
  * `void sendNotification(String userId, String message)`

#### 2.2. Lớp `EmailNotification` (Triển khai `NotificationService`)
* **Thuộc tính riêng:**
  * `senderEmail` (`String`, `private`): Địa chỉ email gửi đi.
* **Yêu cầu:**
  * Triển khai phương thức `sendNotification`: Giả lập việc gửi email với định dạng `[EMAIL từ senderEmail] Gửi tới User userId: message`.

#### 2.3. Lớp `SMSNotification` (Triển khai `NotificationService`)
* **Thuộc tính riêng:**
  * `apiKey` (`String`, `private`): Khóa kết nối API cổng SMS Gateway.
* **Yêu cầu:**
  * Triển khai phương thức `sendNotification`: Giả lập gửi SMS qua Gateway với định dạng `[SMS via Gateway] Gửi tới User userId: message`.

#### 2.4. Lớp `AlertManager` (Điều phối thông báo)
* **Thuộc tính:**
  * `notificationService` (`NotificationService`, `private`): Khai báo dưới dạng Interface, không khai báo lớp cụ thể.
* **Phương thức:**
  * Constructor tiêm phụ thuộc (Dependency Injection): `public AlertManager(NotificationService notificationService)`.
  * `public void triggerSecurityAlert(String userId)`: Tạo nội dung cảnh báo an ninh và gọi `notificationService.sendNotification()`.

---

### 3. Thể hiện 4 tính chất OOP

| Tính chất | Biểu hiện trong bài |
| :--- | :--- |
| **Encapsulation** | Giấu thông tin nhạy cảm như `apiKey` hay `senderEmail` trong từng lớp triển khai cụ thể. |
| **Inheritance** | Các lớp thực thi tính kế thừa giao diện (Interface Realization) từ `NotificationService`. |
| **Polymorphism** | `AlertManager` có thể hoạt động với bất kỳ kênh thông báo nào (`EmailNotification`, `SMSNotification`) mà không cần thay đổi mã nguồn. |
| **Abstraction** | `NotificationService` là mức trừu tượng hóa tuyệt đối (Interface), chỉ định nghĩa các phương thức mà không giữ bất kỳ trạng thái hay logic cài đặt nào. |

---

### 4. Bài học rút ra & Kiến trúc Phần mềm
* **Interface vs Abstract Class:** Sử dụng `Interface` khi các lớp không có chung mã nguồn hay thuộc tính, mà chỉ muốn giao ước chung một tập các **hành vi**.
* **Dependency Inversion Principle (DIP):** Lớp cấp cao (`AlertManager`) không nên phụ thuộc vào các lớp cấp thấp cụ thể (`EmailNotification`), cả hai nên phụ thuộc vào sự trừu tượng (`NotificationService`).

---

## Bài 4: Hệ thống Điều khiển Thiết bị Nhà thông minh (Smart Home IoT)

### 1. Bối cảnh thực tiễn
Một trung tâm điều khiển nhà thông minh (Smart Home Hub) quản lý hàng loạt thiết bị IoT trong gia đình: Đèn thông minh (Smart Light), Điều hòa (Smart AC), Bình nóng lạnh,... 

Người dùng có nhu cầu nhấn một nút bấm duy nhất trên ứng dụng di động để chuyển toàn bộ căn nhà sang "Chế độ Tiết kiệm điện" (Power Saving Mode) khi ra khỏi nhà. Mỗi thiết bị có cơ chế tiết kiệm điện đặc thù: Đèn sẽ tự động giảm độ sáng xuống 30%, Điều hòa sẽ tự điều chỉnh nhiệt độ lên 26°C.

---

### 2. Mô tả yêu cầu hệ thống

#### 2.1. Lớp trừu tượng `SmartDevice` (Abstract Class)
* **Thuộc tính:**
  * `deviceName` (`String`, `private`): Tên thiết bị.
  * `isPowerOn` (`boolean`, `private`): Trạng thái bật/tắt (mặc định `false`).
* **Phương thức:**
  * Constructor nhận `deviceName`.
  * Getter cho `deviceName` và `isPowerOn`.
  * `public void turnOn()`: Chuyển `isPowerOn = true` và in thông báo.
  * `public void turnOff()`: Chuyển `isPowerOn = false` và in thông báo.
  * Phương thức trừu tượng: `public abstract void enablePowerSavingMode()`: Kích hoạt chế độ tiết kiệm điện.

#### 2.2. Lớp `SmartLight` (Kế thừa `SmartDevice`)
* **Thuộc tính riêng:**
  * `brightness` (`int`, `private`): Độ sáng hiện tại (0 - 100%).
* **Yêu cầu:**
  * Ghi đè `enablePowerSavingMode()`: Giảm `brightness` xuống 30% và in ra thông báo điều chỉnh độ sáng.

#### 2.3. Lớp `SmartAirConditioner` (Kế thừa `SmartDevice`)
* **Thuộc tính riêng:**
  * `temperature` (`int`, `private`): Nhiệt độ cài đặt (°C).
* **Yêu cầu:**
  * Ghi đè `enablePowerSavingMode()`: Tăng `temperature` lên 26°C và in ra thông báo điều chỉnh nhiệt độ.

#### 2.4. Lớp điều khiển Trung tâm `SmartHomeHub`
* Quản lý mảng hoặc danh sách các `SmartDevice`.
* Phương thức `public void activateGlobalPowerSaving()`: Duyệt qua tất cả thiết bị trong nhà và kích hoạt `enablePowerSavingMode()`.

---

### 3. Thể hiện 4 tính chất OOP

| Tính chất | Biểu hiện trong bài |
| :--- | :--- |
| **Encapsulation** | Trạng thái nguồn `isPowerOn` và tham số vận hành (`brightness`, `temperature`) được bảo vệ nghiêm ngặt. |
| **Inheritance** | Thừa hưởng trạng thái công tắc nguồn (`turnOn`, `turnOff`) và tên thiết bị từ `SmartDevice`. |
| **Polymorphism** | Lệnh `enablePowerSavingMode()` trên cùng một danh sách thiết bị sẽ tạo ra các phản ứng kỹ thuật khác nhau (giảm độ sáng đối với đèn, tăng nhiệt độ đối với điều hòa). |
| **Abstraction** | Mẫu thiết kế chung cho thiết bị IoT, ẩn đi các lệnh điều khiển phần cứng phức tạp bên dưới. |

---

### 4. Bài học rút ra & Kiến trúc Phần mềm
* **Tái sử dụng mã nguồn (DRY - Don't Repeat Yourself):** Tránh việc phải viết lại thuộc tính `deviceName` hay các hàm `turnOn()`, `turnOff()` ở từng lớp thiết bị riêng lẻ.
* **Khả năng mở rộng quy mô (Scalability):** Dễ dàng thêm các thiết bị mới như Rèm tự động, Tivi thông minh vào hệ thống mà không làm hỏng logic của trung tâm điều khiển.

---

## Bài 5: Hệ thống Quản lý Tài khoản Ngân hàng (Banking Account Management)

### 1. Bối cảnh thực tiễn
Ngân hàng quản lý các loại tài khoản giao dịch khác nhau cho khách hàng:
1. **Tài khoản Tiết kiệm (Savings Account):** Khách hàng hưởng lãi suất theo kỳ hạn, nhưng **không được phép rút tiền quá số dư hiện có**.
2. **Tài khoản Thanh toán (Checking Account):** Cho phép khách hàng **rút tiền vượt quá số dư hiện có** dựa trên một Hạn mức thấu chi (Overdraft Limit) được ngân hàng cấp phép.

Hệ thống cần đảm bảo tính bảo mật tuyệt đối cho số dư tài khoản và tính chính xác của các giao dịch rút tiền.

---

### 2. Mô tả yêu cầu hệ thống

#### 2.1. Lớp trừu tượng `BankAccount` (Abstract Class)
* **Thuộc tính:**
  * `accountNumber` (`String`, `private`): Số tài khoản.
  * `ownerName` (`String`, `private`): Tên chủ tài khoản.
  * `balance` (`double`, `private`): Số dư tài khoản.
* **Phương thức:**
  * Constructor khởi tạo thuộc tính với kiểm tra số dư ban đầu không được âm.
  * Getter cho `accountNumber`, `ownerName`, `balance`.
  * Phương thức `protected void setBalance(double balance)`: Chỉ cho phép các lớp con điều chỉnh số dư trực tiếp.
  * `public void deposit(double amount)`: Nạp tiền (kiểm tra `amount > 0`).
  * Phương thức trừu tượng: `public abstract boolean withdraw(double amount)`: Quy định giao dịch rút tiền.

#### 2.2. Lớp `SavingsAccount` (Kế thừa `BankAccount`)
* **Thuộc tính riêng:**
  * `interestRate` (`double`, `private`): Lãi suất (ví dụ `0.05` tương ứng 5%/năm).
* **Yêu cầu:**
  * Ghi đè `withdraw(double amount)`:
    * Điều kiện rút thành công: `amount > 0` và `amount <= balance`.
    * Trừ số dư và trả về `true` nếu hợp lệ. Trả về `false` nếu số dư không đủ.

#### 2.3. Lớp `CheckingAccount` (Kế thừa `BankAccount`)
* **Thuộc tính riêng:**
  * `overdraftLimit` (`double`, `private`): Hạn mức thấu chi tối đa (ví dụ 2,000,000 VNĐ).
* **Yêu cầu:**
  * Ghi đè `withdraw(double amount)`:
    * Điều kiện rút thành công: `amount > 0` và `amount <= (balance + overdraftLimit)`.
    * Trừ số dư (số dư có thể bị âm nhưng không vượt quá `-overdraftLimit`) và trả về `true`. Trả về `false` nếu vượt hạn mức.

---

### 3. Thể hiện 4 tính chất OOP

| Tính chất | Biểu hiện trong bài |
| :--- | :--- |
| **Encapsulation** | Thuộc tính `balance` ở dạng `private`. Việc thay đổi số dư chỉ được thực hiện thông qua các quy tắc kiểm tra nghiêm ngặt trong `deposit()` và `withdraw()`. |
| **Inheritance** | Kế thừa toàn bộ thông tin tài khoản và nghiệp vụ gửi tiền `deposit()`. |
| **Polymorphism** | Cùng một hành vi `withdraw(1,500,000 VNĐ)` nhưng `SavingsAccount` có thể từ chối (do thiếu số dư), trong khi `CheckingAccount` chấp nhận thực hiện (nhờ hạn mức thấu chi). |
| **Abstraction** | `BankAccount` đưa ra mô hình chung cho mọi loại tài khoản tài chính trong hệ thống ngân hàng. |

---

### 4. Bài học rút ra & Kiến trúc Phần mềm
* **Bảo vệ tài sản dữ liệu:** Tránh việc để thuộc tính `balance` ở dạng `public` hoặc cung cấp `setBalance` công khai mà không có kiểm soát. Một sơ suất nhỏ có thể dẫn tới hậu quả nghiêm trọng về mặt dữ liệu tài chính.
* **Tầm quan trọng của Phạm vi truy cập (`protected` vs `private`):** Sử dụng `protected` đúng lúc giúp lớp con có thẩm quyền mở rộng logic của lớp cha mà vẫn ngăn chặn được sự can thiệp từ các lớp bên ngoài hệ thống.

---

## TỔNG KẾT
Khi thực hành xong 5 bài tập trên, bạn sẽ nắm vững:
1. Cách thiết kế hệ thống **linh hoạt, dễ mở rộng (Extensible)**.
2. Cách áp dụng các nguyên lý thiết kế hướng đối tượng chuẩn mực trong thực tế.
3. Cách lựa chọn giữa **Abstract Class** và **Interface** dựa trên yêu cầu bài toán.
