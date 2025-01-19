public class UserCalculater {
    double result;

    public double calculater(UserSale userSale, double total) throws BadInputError {
        switch (userSale){
            case 국가유공자 -> result=total*(1.0-0.1);
            case 군인 -> result=total*(1.0-0.05);
            case 학생 -> result=total*(1.0-0.03);
            case 일반 -> result=total;
            default -> throw new BadInputError(userSale);
        }
        return result;
    }
}

/*
[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료
1 <- // 1을 입력

[ BURGERS MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
2 <- // 2를 입력
선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

// 2번을 누르면 나오는 메뉴입니다.
"SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
위 메뉴를 장바구니에 추가하시겠습니까?
1. 확인        2. 취소
1 <-

// 1번을 누르면 나오는 메뉴입니다.
SmokeShack 이 장바구니에 추가되었습니다.

// 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
// 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다.
// 미출력일 때 4,5 번을 누르면 예외를 던저줘야 합니다.
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료

[ ORDER MENU ]
4. Orders       | 장바구니를 확인 후 주문합니다.
5. Cancel       | 진행중인 주문을 취소합니다.
4 <- // 4를 입력

// 4번을 누르면 나오는 메뉴입니다.
아래와 같이 주문 하시겠습니까?

[ Orders ]
SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

[ Total ]
W 8.9

1. 주문      2. 메뉴판
1 <-

// 1번을 누르면 할인 정보를 제공해줍니다.
할인 정보를 입력해주세요.
1. 국가유공자 : 10%
2. 군인     :  5%
3. 학생     :  3%
4. 일반     :  0%
4 <-

// 4번을 누르면 나오는 메뉴입니다.
주문이 완료되었습니다. 금액은 W 8.9 입니다.*/