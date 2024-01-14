package net.lliira.game.campaign.storage.db;

import net.lliira.game.campaign.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest extends DbTestBase {

  private final UserFactory userFactory = DbStorage.DB_STORAGE.getUserFactory();

  @Test
  public void createUser() {
    String email = "test@test.com";
    String password = "testPass";
    String userName = "Test Name";
    boolean isActivated = true;
    User user = userFactory.createUser(email, password, userName, isActivated);
    assertEquals(email, user.getEmail());
    assertEquals(password, user.getPasswordHashed());
    assertEquals(userName, user.getName());
    assertEquals(isActivated, user.isActivated());
    assertTrue(user.getId() > 0);
    userFactory.deleteUser(user.getId());
  }

  @Test
  public void deleteUser() {
    User user = userFactory.createUser("test@test.com", "testPass", "Test Name", true);
    userFactory.deleteUser(user.getId());
    assertTrue(userFactory.getUser(user.getId()).isEmpty());
  }
}
