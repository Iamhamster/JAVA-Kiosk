public class BadInputError extends Exception {
    //RuntimeException
    public BadInputError(int num) {
        super(num+"는 없는 번호입니다. 재시도 하시길 바랍니다.");
    }
    public BadInputError(UserSale str) {
        super(str+"는 없는 문자입니다. 재시도 하시길 바랍니다.");
    }
}

