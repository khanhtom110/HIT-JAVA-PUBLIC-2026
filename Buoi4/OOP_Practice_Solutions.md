# ĐÁP ÁN MÃ NGUỒN CÁC BÀI TẬP LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG (OOP) JAVA

Tài liệu này chứa đáp án source code Java đầy đủ cho **5 bài tập OOP thực tiễn**, được thiết kế để minh họa rõ nét 4 tính chất cốt lõi: **Encapsulation (Đóng gói)**, **Inheritance (Kế thừa)**, **Polymorphism (Đa hình)**, và **Abstraction (Trừu tượng)**.

---

## MỤC LỤC
1. [Bài 1: Cổng Thanh toán Thương mại Điện tử (E-Commerce Payment Gateway)](#bài-1-cổng-thanh-toán-thương-mại-điện-tử)
2. [Bài 2: Hệ thống Tính Lương Nhân viên Tự động (HR Payroll System)](#bài-2-hệ-thống-tính-lương-nhân-viên-tự-động)
3. [Bài 3: Hệ thống Thông báo Đa kênh (Notification Service)](#bài-3-hệ-thống-thông-báo-đa-kênh)
4. [Bài 4: Điều khiển Thiết bị Nhà thông minh (Smart Home IoT)](#bài-4-điều-khiển-thiết-bị-nhà-thông-minh)
5. [Bài 5: Hệ thống Quản lý Tài khoản Ngân hàng (Banking Account Management)](#bài-5-hệ-thống-quản-lý-tài-khoản-ngân-hàng)

---

## Bài 1: Cổng Thanh toán Thương mại Điện tử

```java
package buoi4.payment;

// 1. ABSTRACTION: Định nghĩa khuôn mẫu phương thức thanh toán
public abstract class PaymentMethod {
    // ENCAPSULATION: Che giấu mã giao dịch bằng private
    private String transactionId;

    public PaymentMethod(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    // Phương thức trừu tượng - Ép các lớp con cài đặt logic xử lý riêng
    public abstract boolean processPayment(double amount);
}
```

```java
package buoi4.payment;

// 2. INHERITANCE: CreditCardPayment kế thừa từ PaymentMethod
public class CreditCardPayment extends PaymentMethod {
    private String cardNumber;
    private String cvv;

    public CreditCardPayment(String transactionId, String cardNumber, String cvv) {
        super(transactionId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    // 3. POLYMORPHISM: Ghi đè phương thức thanh toán cho Thẻ tín dụng
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền thanh toán không hợp lệ!");
            return false;
        }
        System.out.println("[CREDIT CARD] Đang xác thực CVV (" + cvv + ")...");
        System.out.println("[CREDIT CARD] Đã trừ " + String.format("%,.0f", amount) + " VNĐ từ thẻ " + maskCardNumber(cardNumber));
        return true;
    }

    private String maskCardNumber(String number) {
        if (number != null && number.length() >= 4) {
            return "****-****-****-" + number.substring(number.length() - 4);
        }
        return "****";
    }
}
```

```java
package buoi4.payment;

// INHERITANCE: MomoPayment kế thừa từ PaymentMethod
public class MomoPayment extends PaymentMethod {
    private String phoneNumber;

    public MomoPayment(String transactionId, String phoneNumber) {
        super(transactionId);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // POLYMORPHISM: Ghi đè phương thức thanh toán cho Ví MoMo
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền thanh toán không hợp lệ!");
            return false;
        }
        System.out.println("[MOMO] Đang gửi mã OTP xác nhận tới SĐT: " + phoneNumber);
        System.out.println("[MOMO] OTP hợp lệ. Đã trừ " + String.format("%,.0f", amount) + " VNĐ từ Ví MoMo.");
        return true;
    }
}
```

```java
package buoi4.payment;

// Lớp điều phối giao dịch sử dụng Tính Đa hình
public class OrderProcessor {
    public void checkout(PaymentMethod payment, double totalAmount) {
        System.out.println("------------------------------------------");
        System.out.println("Bắt đầu xử lý đơn hàng...");
        System.out.println("Mã giao dịch: " + payment.getTransactionId());
        
        // POLYMORPHISM: Gọi processPayment() tương ứng ở runtime
        boolean isSuccess = payment.processPayment(totalAmount);
        
        if (isSuccess) {
            System.out.println("=> KẾT QUẢ: Thanh toán đơn hàng THÀNH CÔNG!");
        } else {
            System.out.println("=> KẾT QUẢ: Thanh toán THẤT BẠI.");
        }
        System.out.println("------------------------------------------
");
    }
}
```

```java
package buoi4.payment;

public class Main1 {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        PaymentMethod card = new CreditCardPayment("TXN-001", "4111222233334444", "123");
        PaymentMethod momo = new MomoPayment("TXN-002", "0987654321");

        processor.checkout(card, 2500000);
        processor.checkout(momo, 450000);
    }
}
```

---

## Bài 2: Hệ thống Tính Lương Nhân viên Tự động

```java
package buoi4.payroll;

// 1. ABSTRACTION & ENCAPSULATION
public abstract class Employee {
    private String id;
    private String name;
    private double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        setBaseSalary(baseSalary);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    // ENCAPSULATION: Kiểm tra ràng buộc dữ liệu đầu vào
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Lương cơ bản không được âm!");
        }
        this.baseSalary = baseSalary;
    }

    // Phương thức trừu tượng tính lương thực nhận
    public abstract double calculateSalary();
}
```

```java
package buoi4.payroll;

// 2. INHERITANCE: Nhân viên chính thức
public class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }

    // 3. POLYMORPHISM: TÍnh lương = Lương cơ bản + Thưởng
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}
```

```java
package buoi4.payroll;

// INHERITANCE: Nhân viên bán thời gian
public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, int hoursWorked, double hourlyRate) {
        super(id, name, 0); // Lương cơ bản gán = 0
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // POLYMORPHISM: Tính lương = Giờ làm x Đơn giá
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}
```

```java
package buoi4.payroll;

public class Main2 {
    public static void main(String[] args) {
        // Quản lý mảng danh sách đối tượng hỗn hợp nhờ Đa hình
        Employee[] employees = new Employee[] {
            new FullTimeEmployee("FT-01", "Nguyễn Văn A", 15000000, 3000000),
            new PartTimeEmployee("PT-01", "Trần Thị B", 80, 50000),
            new FullTimeEmployee("FT-02", "Lê Văn C", 20000000, 5000000)
        };

        double totalPayroll = 0;
        System.out.println("=== BẢNG LƯƠNG NHÂN VIÊN ===");
        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            System.out.printf("Mã NV: %-6s | Tên: %-15s | Thực nhận: %,.0f VNĐ
", 
                              emp.getId(), emp.getName(), salary);
            totalPayroll += salary;
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("TỔNG NGÂN SÁCH LƯƠNG: %,.0f VNĐ
", totalPayroll);
    }
}
```

---

## Bài 3: Hệ thống Thông báo Đa kênh

```java
package buoi4.notification;

// 1. ABSTRACTION: Interface giao ước hành vi gửi thông báo
public interface NotificationService {
    void sendNotification(String userId, String message);
}
```

```java
package buoi4.notification;

// 2. INHERITANCE & POLYMORPHISM: Kênh Email
public class EmailNotification implements NotificationService {
    private String senderEmail;

    public EmailNotification(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("[EMAIL từ " + senderEmail + "] Gửi tới User <" + userId + ">: " + message);
    }
}
```

```java
package buoi4.notification;

// INHERITANCE & POLYMORPHISM: Kênh SMS
public class SMSNotification implements NotificationService {
    private String apiKey;

    public SMSNotification(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("[SMS Gateway Key: " + apiKey + "] Gửi tới User <" + userId + ">: " + message);
    }
}
```

```java
package buoi4.notification;

// Lớp quản lý điều phối - Dependency Inversion
public class AlertManager {
    private NotificationService notificationService;

    // Dependency Injection qua Constructor
    public AlertManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void triggerSecurityAlert(String userId) {
        String msg = "CẢNH BÁO: Phát hiện đăng nhập bất thường trên thiết bị mới!";
        notificationService.sendNotification(userId, msg);
    }
}
```

```java
package buoi4.notification;

public class Main3 {
    public static void main(String[] args) {
        // Gửi qua Email
        AlertManager emailAlert = new AlertManager(new EmailNotification("security@bank.com"));
        emailAlert.triggerSecurityAlert("USER_101");

        // Gửi qua SMS
        AlertManager smsAlert = new AlertManager(new SMSNotification("API_KEY_SMS_999"));
        smsAlert.triggerSecurityAlert("USER_102");
    }
}
```

---

## Bài 4: Điều khiển Thiết bị Nhà thông minh

```java
package buoi4.smarthome;

// 1. ABSTRACTION & ENCAPSULATION
public abstract class SmartDevice {
    private String deviceName;
    private boolean isPowerOn;

    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
        this.isPowerOn = false;
    }

    public String getDeviceName() { return deviceName; }
    public boolean isPowerOn() { return isPowerOn; }

    public void turnOn() {
        this.isPowerOn = true;
        System.out.println(deviceName + " -> ĐÃ BẬT.");
    }

    public void turnOff() {
        this.isPowerOn = false;
        System.out.println(deviceName + " -> ĐÃ TẮT.");
    }

    // Phương thức trừu tượng kích hoạt tiết kiệm điện
    public abstract void enablePowerSavingMode();
}
```

```java
package buoi4.smarthome;

// 2. INHERITANCE: Đèn thông minh
public class SmartLight extends SmartDevice {
    private int brightness; // 0 - 100%

    public SmartLight(String deviceName) {
        super(deviceName);
        this.brightness = 100;
    }

    // 3. POLYMORPHISM
    @Override
    public void enablePowerSavingMode() {
        this.brightness = 30;
        System.out.println("[TẮT/BỚT ĐÈN] " + getDeviceName() + ": Giảm độ sáng xuống " + brightness + "%.");
    }
}
```

```java
package buoi4.smarthome;

// INHERITANCE: Điều hòa thông minh
public class SmartAirConditioner extends SmartDevice {
    private int temperature;

    public SmartAirConditioner(String deviceName) {
        super(deviceName);
        this.temperature = 20;
    }

    // POLYMORPHISM
    @Override
    public void enablePowerSavingMode() {
        this.temperature = 26;
        System.out.println("[ĐIỀU HÒA] " + getDeviceName() + ": Tăng nhiệt độ lên " + temperature + "°C.");
    }
}
```

```java
package buoi4.smarthome;

public class SmartHomeHub {
    private SmartDevice[] devices;

    public SmartHomeHub(SmartDevice[] devices) {
        this.devices = devices;
    }

    public void activateGlobalPowerSaving() {
        System.out.println("=== KÍCH HOẠT CHẾ ĐỘ TIẾT KIỆM ĐIỆN TOÀN NHÀ ===");
        for (SmartDevice device : devices) {
            if (!device.isPowerOn()) {
                device.turnOn();
            }
            device.enablePowerSavingMode();
        }
        System.out.println("================================================");
    }
}
```

```java
package buoi4.smarthome;

public class Main4 {
    public static void main(String[] args) {
        SmartDevice[] homeDevices = new SmartDevice[] {
            new SmartLight("Đèn Đọc Sách Phòng Khách"),
            new SmartAirConditioner("Điều Hòa Phòng Ngủ")
        };

        SmartHomeHub hub = new SmartHomeHub(homeDevices);
        hub.activateGlobalPowerSaving();
    }
}
```

---

## Bài 5: Hệ thống Quản lý Tài khoản Ngân hàng

```java
package buoi4.bank;

// 1. ABSTRACTION & ENCAPSULATION
public abstract class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    // Đóng gói: Chỉ cho phép các lớp con điều chỉnh số dư trực tiếp
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("[" + accountNumber + "] Nạp tiền thành công: +" + String.format("%,.0f", amount) + " VNĐ");
        }
    }

    // Phương thức trừu tượng rút tiền
    public abstract boolean withdraw(double amount);
}
```

```java
package buoi4.bank;

// 2. INHERITANCE: Tài khoản Tiết kiệm
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    // 3. POLYMORPHISM: Rút tiền không được vượt quá số dư
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("[" + getAccountNumber() + "] Rút tiền thành công: -" + String.format("%,.0f", amount) + " VNĐ");
            return true;
        }
        System.out.println("[" + getAccountNumber() + "] RÚT TIỀN THẤT BẠI: Số dư không đủ!");
        return false;
    }
}
```

```java
package buoi4.bank;

// INHERITANCE: Tài khoản Thanh toán (Cho phép thấu chi)
public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double overdraftLimit) {
        super(accountNumber, ownerName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // POLYMORPHISM: Cho phép âm tiền tới hạn mức thấu chi
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            setBalance(getBalance() - amount);
            System.out.println("[" + getAccountNumber() + "] Rút/Thấu chi thành công: -" + String.format("%,.0f", amount) + " VNĐ");
            return true;
        }
        System.out.println("[" + getAccountNumber() + "] RÚT TIỀN THẤT BẠI: Vượt quá hạn mức thấu chi!");
        return false;
    }
}
```

```java
package buoi4.bank;

public class Main5 {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SA-101", "Nguyễn Văn A", 1000000, 0.05);
        BankAccount checking = new CheckingAccount("CA-202", "Trần Thị B", 500000, 2000000);

        System.out.println("--- THỬ NGHIỆM TÀI KHOẢN TIẾT KIỆM ---");
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", savings.getBalance()) + " VNĐ");
        savings.withdraw(1500000); // Thất bại

        System.out.println("
--- THỬ NGHIỆM TÀI KHOẢN THANH TOÁN (THẤU CHI) ---");
        System.out.println("Số dư hiện tại: " + String.format("%,.0f", checking.getBalance()) + " VNĐ");
        checking.withdraw(1500000); // Thành công
        System.out.println("Số dư sau khi thấu chi: " + String.format("%,.0f", checking.getBalance()) + " VNĐ");
    }
}
```
