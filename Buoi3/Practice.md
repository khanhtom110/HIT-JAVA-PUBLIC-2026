# Bài 1:

Viết chương trình tính chu vi, diện tích của hình tròn. Bán kính r là một số thực được nhập từ bàn phím

**Input**

- Một số thực là bán kính r

**Giới hạn:**

- 0 < r < 1000
- Làm tròn giá trị π = 3.14

**Output**

Lần lượt là chu vi và diện tích hình tròn cách nhau bởi 1 dấu cách. Kết quả làm tròn tới chữ số thập phân thứ 3

**Sample**

```text
0.5
```

**Output #1**

```text
3.140 0.785
```

---

# Bài 2: Kiểm tra chuỗi đối xứng

- Nhập chuỗi từ bàn phím.
- Nếu chuỗi đối xứng (Palindrome):
  - In chuỗi **in hoa toàn bộ và thông báo chuỗi này đối xứng**.
- Nếu không:
  - In chuỗi **in thường toàn bộ và thông báo chuỗi này không đối xứng**.

**Sample 1**

**Input**

```text
madam
```

**Output**

```text
MADAM chuỗi này đối xứng
```

**Sample 2**

**Input**

```text
hello
```

**Output**

```text
hello chuỗi này không đối xứng
```

---

# Bài 3: Trắc nghiệm phép cộng ngẫu nhiên

- Tạo ba số ngẫu nhiên:
  - a, b: trong [0, 100]
  - c: trong [0, 200]
- Hiển thị phép toán: a + b = c
- Người dùng nhập vào “phép tính đúng” hoặc “phép tính sai” -> in ra thông báo “Bạn đã trả lời đúng“ nếu đúng, ngược lại thì thông báo “Bạn đã trả lời sai“

**Sample 1**

_Hiển thị trên màn hình:_

```text
45 + 55 = 100
```

**Input**

```text
phép tính đúng
```

**Output**

```text
Bạn đã trả lời đúng
```

**Sample 2**

_Hiển thị trên màn hình:_

```text
45 + 55 = 110
```

**Input**

```text
phép tính đúng
```

**Output**

```text
Bạn đã trả lời sai
```

---

## Bài 4: Toán tử 3 ngôi

**Mô tả:**
Viết chương trình nhập vào 3 số nguyên $A, B, C$ phân biệt. Hãy tìm và in ra **số trung vị** (Median - tức là số có giá trị nằm giữa số lớn nhất và số nhỏ nhất).

**Yêu cầu đặc biệt:**
Bắt buộc chỉ được dùng toán tử 3 ngôi (`? :`) lồng nhau để giải quyết trên **ĐÚNG MỘT DÒNG LỆNH**.

**Input:** Ba số nguyên $A, B, C$.
**Output:** Giá trị của số trung vị.

**Sample 1**
**Input**

```text
5 2 8
```

**Output**

```text
5
```

**Sample 2**
**Input**

```text
10 15 7
```

**Output**

```text
10
```

---

## Bài 5: Hành Trình Mù Của Kẻ Leo Núi (Vòng lặp For-each)

**Mô tả:**
Cho một "dãy núi" được biểu diễn bằng một mảng số nguyên (chứa độ cao của các điểm). Bạn cần đếm xem có bao nhiêu "đỉnh núi" trong dãy này.
Một điểm được gọi là đỉnh núi nếu độ cao của nó **lớn hơn hẳn** cả điểm liền trước và điểm liền sau nó (Không xét điểm đầu tiên và điểm cuối cùng của dãy).

**Yêu cầu đặc biệt:**
Chỉ sử dụng vòng lặp For-each (cú pháp `for (int x : arr)`).

**Input:**

- Dòng 1: Số nguyên dương $N$ ($N \ge 3$).
- Dòng 2: $N$ số nguyên, cách nhau một khoảng trắng.

**Output:**
Số lượng "đỉnh núi" tìm thấy.

**Sample 1**
**Input**

```text
7
1 5 3 7 2 8 4
```

**Output**

```text
3
```

_(Giải thích: Các đỉnh núi là 5, 7, và 8)_

**Sample 2**
**Input**

```text
5
1 2 3 4 5
```

**Output**

```text
0
```
