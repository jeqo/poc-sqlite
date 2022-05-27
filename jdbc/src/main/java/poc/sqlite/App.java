package poc.sqlite;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

  public static void main(String[] args) {
//    var db = ":memory:";
    var db = "test.db";
    try (var conn = DriverManager.getConnection("jdbc:sqlite:" + db)) {
      var statement = conn.createStatement();
      statement.setQueryTimeout(30); // set timeout to 30 sec.

      statement.executeUpdate("pragma journal_mode = WAL");

      statement.executeUpdate("drop table if exists person");
      statement.executeUpdate("create table person (id integer, name string)");
      statement.executeUpdate("insert into person values(1, 'leo')");
      statement.executeUpdate("insert into person values(2, 'yui')");

      var rs = statement.executeQuery("select * from person");
      while (rs.next()) {
        // read the result set
        System.out.println("name = " + rs.getString("name"));
        System.out.println("id = " + rs.getInt("id"));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
