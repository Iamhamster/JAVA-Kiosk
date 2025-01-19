public enum UserSale {
    국가유공자(1),
    군인(2),
    학생(3),
    일반(4);

    private int num;

    UserSale(int num) {
        this.num = num;
    }

    public static UserSale getNum(int num) throws BadInputError {
        switch (num){
            case 1: return UserSale.국가유공자;
            case 2: return UserSale.군인;
            case 3: return UserSale.학생;
            case 4: return UserSale.일반;
            default:
                throw new BadInputError(num);
        }
    }
}
