package net.lliira.game.campaign.storage.db;

import org.apache.ibatis.io.Resources;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public abstract class DbTestBase {
  private static final String DB_SCHEMA_FILE = "schema/postgresql.sql";

  private static boolean initialized = false;

  @BeforeClass
  public static void classSetUp() throws SQLException, IOException, URISyntaxException {
    if (!initialized) {
      initializeTestDB();
      initialized = true;
    }
  }

  private static void initializeTestDB()
      throws IOException, URISyntaxException, SQLException {
    String schema_sql = Files.readString(Path.of(Resources.getResourceURL(DB_SCHEMA_FILE).toURI()));
    try (var session = DbStorage.DB_STORAGE.getSessionFactory().openSession()) {
      var connection = session.getConnection();
      connection.createStatement().execute(schema_sql);
      connection.commit();
    }
  }
}
