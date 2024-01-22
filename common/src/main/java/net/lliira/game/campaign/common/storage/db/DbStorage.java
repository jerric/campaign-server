package net.lliira.game.campaign.common.storage.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbStorage {
  private static final String DB_CONFIG_FILE = "mybatis/mybatis-config.xml";

  private final SqlSessionFactory sessionFactory;

  private final Object userFactoryLock = new Object();
  private UserFactory userFactory;

  public DbStorage(Properties properties) {
    try {
      InputStream inputStream = Resources.getResourceAsStream(DB_CONFIG_FILE);
      sessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  SqlSessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public UserFactory getUserFactory() {
    if (userFactory != null) {
      return userFactory;
    }
    synchronized (userFactoryLock) {
      if (userFactory == null) {
        userFactory = new UserFactory(sessionFactory);
      }
    }
    return userFactory;
  }
}
