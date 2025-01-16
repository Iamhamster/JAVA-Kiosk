import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    private int count = 0;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    void start(){
        ShoppingCart carts = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        int sw = 0;
        while (true){

            /*카테코리 메뉴판*/
            //[ MAIN MENU ]
            //1. Burgers
            //2. Drinks
            //3. Desserts
            //0. 종료      | 종료
            System.out.println("[ MAIN MENU ]");
            for(int i=0;i<3;i++){
                System.out.println((i+1)+". "+menuList.get(i).getMenus());
            }
            System.out.println("0. 종료\t\t\t| 종료");

            //[ ORDER MENU ]
            //4. Orders       | 장바구니를 확인 후 주문합니다.
            //5. Cancel       | 진행중인 주문을 취소합니다.
            if(sw==1){
                System.out.println();
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders\t| 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel\t| 진행중인 주문을 취소합니다.");
            }



            /*주문*/
            //1 <- 1을 입력
            //4 <- // 4를 입력
            int num = sc.nextInt();
            System.out.println();

            /*종료 조건*/
            if(num==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if(num==4){
                System.out.println("아래와 같이 주문 하시겠습니까?");
                System.out.println();
                System.out.println("[ Orders ]");
                carts.getCart();

                System.out.println();
                System.out.println("[ Total ]");
                System.out.println("W "+carts.cart.stream().mapToDouble(i->Double.valueOf(i.getPrice()*getCount())).sum());
                System.out.println();
                System.out.println("1. 주문\t2.메뉴판");
            }
            else{
                /*세부 메뉴판*/
                //[ BURGERS MENU ]
                //1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                //2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                //3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                //4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                //0. 뒤로가기
                Menu sMenu = menuList.get(num-1);
                while (true){
                    System.out.println("[ "+sMenu.getMenus()+" MENU ]");
                    sMenu.showmenuitems();
                    System.out.println("0. 뒤로가기");

                    int num2 = sc.nextInt();//2 <- 2를 입력

                    if(num2==0){
                        System.out.println("뒤로 갑니다.");
                        break;
                    }

                    //선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                    MenuItem ssMenu = sMenu.getItem().get(num2-1);
                    System.out.println("선택한 메뉴: "+ssMenu.getName()+"\t| W "+ssMenu.getPrice()+" | "+ssMenu.getEx());
                    System.out.println();

                    //위 메뉴를 장바구니에 추가하시겠습니까?
                    //1. 확인        2. 취소
                    System.out.println("\""+ssMenu.getName()+"\t| W "+ssMenu.getPrice()+" | "+ssMenu.getEx()+"\"");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1.확인\t\t2.취소");
                    sw = sc.nextInt();//1 <-

                    /*SmokeShack 이 장바구니에 추가되었습니다.*/
                    if(sw==1){
                        System.out.println("원하시는 수량을 입력하세요.");
                        count=sc.nextInt();//원하는 수량
                        setCount(count);
                        System.out.println();
                        System.out.println(ssMenu.getName()+" 이 장바구니에 추가되었습니다.");
                        System.out.println();
                        carts.addCart(ssMenu, getCount());
                        break;
                    }
                }
            }


        }


    }
}
