import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    List<MenuItem> cart = new ArrayList<>();
    int count;

    void addCart(MenuItem item, int count){//장바구니에 추가
        this.cart.add(item);
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        this.count = count;
    }

    public List<MenuItem> getCart() {
        for (int i = 0; i <cart.size() ; i++) {
            System.out.println(cart.get(i).getName()+"\t| W "+cart.get(i).getPrice()+" | "+cart.get(i).getEx());
            System.out.println(count+"개");
        }
        return cart;
    }
}
