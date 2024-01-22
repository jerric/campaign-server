package net.lliira.game.campaign.common.storage.file;

import com.google.gson.Gson;
import net.lliira.game.campaign.common.GameConfigurationException;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class FileStorage {
  private static final String RULE_PATH_PROP = "rule_path";

  private final RaceLoader raceLoader;

  public FileStorage(Properties properties) throws GameConfigurationException {
    if (!properties.containsKey(RULE_PATH_PROP)) {
      throw new GameConfigurationException("Missing required property: " + RULE_PATH_PROP);
    }
    Gson gson = new Gson();
    raceLoader = new RaceLoader(gson, new File(properties.getProperty(RULE_PATH_PROP)));
  }

  public RaceLoader getRaceLoader() {
    return raceLoader;
  }
}
