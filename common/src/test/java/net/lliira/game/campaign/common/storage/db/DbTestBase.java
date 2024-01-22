package net.lliira.game.campaign.common.storage.db;

import net.lliira.game.campaign.common.storage.db.DbStorage;
import org.apache.ibatis.io.Resources;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DbTestBase {
  private static final String DB_SCHEMA_FILE = "schema/postgresql.sql";

  protected static DbStorage dbStorage;
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
    dbStorage = new DbStorage(new Properties());
    String schema_sql = Files.readString(Path.of(Resources.getResourceURL(DB_SCHEMA_FILE).toURI()));
    try (var session = dbStorage.getSessionFactory().openSession()) {
      var connection = session.getConnection();
      connection.createStatement().execute(schema_sql);
      connection.commit();
    }
  }
}
