public class Validator {

    private static final String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Validator() {

    }

    public static boolean validate(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            checkUsingLoop(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    private static void checkUsingLoop(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
        }
        if (password == null || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля должна быть меньше или равна 20");
        }

        checkCharacters(login, "Логин");
        checkCharacters(password, "Пароль");

    }

    private static void checkCharacters(String s, String what) throws WrongPasswordException, WrongLoginException{
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                throw new WrongLoginException(String.format("%s содержит неверный символ %с!", what, s.charAt(i)));
            }
        }
    }
}
