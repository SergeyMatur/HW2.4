public class Main {
    public static void main(String[] args) {

        boolean result = Validator.validate("tst_1234", "D_1213_", "D_1213_d");
        if (result) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Логин и/или пароль не корректные");
        }

    }


}