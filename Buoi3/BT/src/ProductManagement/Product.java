package ProductManagement;

public class Product {
    //Thuoc tinh
    private String id;
    private String name;
    private double price;
    private int quantity;

    //Constructor (Ham khoi tao)
    public Product(String id, String name, double price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(){}

    //Getter, Setter
    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name=name;
    }
}
