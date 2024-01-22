package net.lliira.game.campaign.common;

import net.lliira.game.campaign.common.storage.db.DbStorage;
import net.lliira.game.campaign.common.storage.file.FileStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CommonFactory {
  private static final String DEFAULT_PROPERTIES_FILE = "game-campaign.properties";

  private final Properties properties;
  private DbStorage dbStorage;
  private FileStorage fileStorage;

  private static Properties loadDefaultProperties() throws IOException {
    Properties properties = new Properties();
    properties.load(new FileReader(DEFAULT_PROPERTIES_FILE));
    return properties;
  }

  public CommonFactory() throws IOException {
    this(loadDefaultProperties());
  }

  public CommonFactory(Properties properties) throws IOException {
    this.properties = properties;
  }

  public synchronized DbStorage getDbStorage() {
    if (dbStorage == null) {
      dbStorage = new DbStorage(properties);
    }
    return dbStorage;
  }

  public synchronized FileStorage getFileStorage() {
    if (fileStorage == null) {
      fileStorage = new FileStorage(properties);
    }
    return fileStorage;
  }
}
