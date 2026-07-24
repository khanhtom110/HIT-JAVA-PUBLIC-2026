package Test;

import ProductManagement.Product;

public class DienThoai {


    public static void main(String[] args) {

        Product dienThoai = new Product();

        Product iPhone = new Product("SanPham1","Iphone 17 promax 1TB",32000000,100);


        System.out.println(iPhone.getId());
    }
}
