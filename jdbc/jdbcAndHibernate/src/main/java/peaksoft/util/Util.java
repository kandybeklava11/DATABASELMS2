package peaksoft.util;

public class Util {
    private static final String url = "jdbc:postgresql://localhost:5432/DATABASELMS2";
    private static final String username = "postgres";
    private static final String password = "1234";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Successfully");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
