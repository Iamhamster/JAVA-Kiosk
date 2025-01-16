import java.util.ArrayList;
import java.util.List;

public class Menu {
    // MenuItem 클래스를 List로 관리
    private List<MenuItem> Item = new ArrayList<>();
    private String menus;

    Menu(String menus){
        this.menus = menus;
        this.Item = new ArrayList<MenuItem>();
    }

    public String toString(){
        return menus;
    }

    public String getMenus() {//메뉴
        return menus;
    }
    public List<MenuItem> getItem() {//메뉴의 아이템
        return Item;
    }

    public void addMenuItems(MenuItem menuItem){
        Item.add(menuItem);
    }

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showmenuitems(){
        for (int i = 0; i < this.Item.size(); i++) {
            System.out.println((i+1)+". "+Item.get(i)); // get 조회
        }
    }

    // List를 리턴하는 함수

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
}
