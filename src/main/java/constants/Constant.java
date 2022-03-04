package constants;

public class Constant {
    public static class TimeoutVariables {
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls{
        public static final String LOGIN_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    }

    public static class LoginTestData {
        public static final String LOGIN = "fominaelena";
        public static final String PASSWORD = "1P73BP4Z";
        public static final String AVATAR_NAME = "Фомина Елена Сергеевна";
        public static final String NOT_VALID_LOGIN = "FominaelenA";
        public static final String NOT_VALID_PASSWORD = "1p73BP4z";
    }

    public static class WarnMessage {
        public static final String TEXT_ALERT = "Неверные данные для авторизации.";
        public static final String TEXT_ALERT_UPPERCASE = "Неверные данные для авторизации";

    }
}
