import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    List<MenuItem> cart = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();
    private double result;

    void addCart(MenuItem item){//장바구니에 추가
        this.cart.add(item);
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
    }

    public List<MenuItem> getCart() {
        for (int i = 0; i <cart.size() ; i++) {
            System.out.println(cart.get(i).getName()+"\t| W "+cart.get(i).getPrice()+" | "+cart.get(i).getEx());
        }
        return cart;
    }

    public double totalMoney(){
        this.result =0;
        for (int i = 0; i <count.size() ; i++) {
            this.result += cart.get(i).getPrice()*count.get(i);
        }
        return this.result;
    }

    public void addCount(int count){
        this.count.add(count);
    }
}