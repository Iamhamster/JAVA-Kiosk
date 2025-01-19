import java.lang.constant.ConstantDescs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    int count=0;

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    void start() throws BadInputError {
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
            menuList.stream().forEach(menu -> System.out.println((menuList.indexOf(menu) + 1) + ". " + menu));//forEach 반복문
            /*스트림 for(int i=0;i<3;i++){
                System.out.println((i+1)+". "+menuList.get(i).getMenus());
            }*/
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

            if(num>5||num<0){//범위 초과 에러
                throw new BadInputError(num);
            }

            /*종료 조건*/
            if(num==0||num==5){
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
                System.out.println("W "+carts.totalMoney());
                System.out.println();
                System.out.println("1. 주문\t2.메뉴판");
                int answer = sc.nextInt();
                if(answer!=1&&answer!=2){//범위 초과 에러
                    throw new BadInputError(answer);
                }
                if(answer==1){
                    UserCalculater uc = new UserCalculater();
                    System.out.println("할인 정보를 입력해주세요.");
                    System.out.println("1. 국가유공자\t: 10%");
                    System.out.println("2. 군인\t: 5%");
                    System.out.println("3. 학생\t: 3%");
                    System.out.println("4. 일반\t: 0%");
                    int userNum=sc.nextInt();
                    UserSale userType=UserSale.getNum(userNum);
                    double usertotal =uc.calculater(userType, carts.totalMoney());
                    System.out.println();
                    System.out.printf("주문이 완료되었습니다. 금액은 W %.2f 입니다.",usertotal);
                    break;
                }
            }
            else{
                /*세부 메뉴판*/
                //[ BURGERS MENU ]
                //1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                //2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                //3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                //4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                //0. 뒤로가기
                Menu sMenu = menuList.stream().skip(num-1).findFirst().get();//skip 이 주소만큼 건너 뜀.   //findFirst 첫 값을 가져옴.   //get 그냥 가져옴.
                //스트림 Menu sMenu = menuList.get(num-1);
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
                    MenuItem ssMenu = sMenu.getItem().stream().skip(num2-1).findFirst().get();//skip 이 주소만큼 건너 뜀.   //findFirst 첫 값을 가져옴.   //get 그냥 가져옴.
                    //스트림 MenuItem ssMenu = sMenu.getItem().get(num2-1);
                    System.out.println("선택한 메뉴: "+ssMenu.getName()+"\t| W "+ssMenu.getPrice()+" | "+ssMenu.getEx());
                    System.out.println();

                    //위 메뉴를 장바구니에 추가하시겠습니까?
                    //1. 확인        2. 취소
                    System.out.println("\""+ssMenu.getName()+"\t| W "+ssMenu.getPrice()+" | "+ssMenu.getEx()+"\"");
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1.확인\t\t2.취소");
                    sw = sc.nextInt();//1 <-
                    if(sw!=1&&sw!=2){//범위 초과 에러
                        throw new BadInputError(sw);
                    }

                    /*SmokeShack 이 장바구니에 추가되었습니다.*/
                    if(sw==1){
                        System.out.println("원하시는 수량을 입력하세요.");
                        count=sc.nextInt();//원하는 수량
                        carts.addCount(count);
                        if(count<0){//범위 초과 에러
                            throw new BadInputError(count);
                        }
                        System.out.println();
                        System.out.println(ssMenu.getName()+" 이 장바구니에 추가되었습니다.");
                        System.out.println();
                        carts.addCart(ssMenu);
                        break;
                    }
                }
            }


        }


    }
}
