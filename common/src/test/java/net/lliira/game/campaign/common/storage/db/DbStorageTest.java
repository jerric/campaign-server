package net.lliira.game.campaign.common.storage.db;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Properties;

public class DbStorageTest extends DbTestBase {

  @Test
  public void getUserFactory() {
    assertNotNull(dbStorage.getUserFactory());
  }
}
