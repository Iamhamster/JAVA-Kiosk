public class MenuItem {
    /*필드*/
    private String name;    //아이템 이름
    private double price;   //가격
    private String ex;      //아이템 설명

    /*생성자*/
    public MenuItem(String name, double price, String ex){
        this.name = name;
        this.price = price;
        this.ex = ex;
    }

    public String toString(){
        return name + " | W " + price + " | " + ex;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice() {
        return price;
    }
    public String getEx() {
        return ex;
    }
}
