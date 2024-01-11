package net.lliira.game.campaign.storage.db;

import net.lliira.game.campaign.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Optional;

public class DbStorage {
  private static final String DB_CONFIG_FILE = "mybatis/mybatis-config.xml";

  public static final DbStorage DB_STORAGE = new DbStorage();

  private final UserFactory userFactory;

  private DbStorage() {
    try {
      InputStream inputStream = Resources.getResourceAsStream(DB_CONFIG_FILE);
      SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      userFactory = new UserFactory(sessionFactory);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public UserFactory getUserFactory() {
    return userFactory;
  }
}
