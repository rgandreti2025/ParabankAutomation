package utilities;

public class TestDataUtil {
    public static String getUsername() {
        return JsonReader.getValue("validUser", "username");
    }

    public static String getPassword() {
        return JsonReader.getValue("validUser", "password");
    }

    public static String getTransactionId() {
        return JsonReader.getValue("transaction", "transactionId");
    }

    public static String getAccountId() {
        return JsonReader.getValue("transaction", "accountId");
    }
}

