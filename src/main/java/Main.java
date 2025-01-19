import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws BadInputError {

        Menu bugers = new Menu("Bugers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        bugers.addMenuItems(new MenuItem("ShackBurger", 6.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugers.addMenuItems(new MenuItem("SmokeShack", 8.9,"비프패티를 기반으로 야채가 들어간 기본버거"));
        bugers.addMenuItems(new MenuItem("Cheeseburger", 6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugers.addMenuItems(new MenuItem("Hamburger", 5.4,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));

        Kiosk k = new Kiosk(Arrays.asList(bugers,drinks,desserts));
        k.start();
    }
}
