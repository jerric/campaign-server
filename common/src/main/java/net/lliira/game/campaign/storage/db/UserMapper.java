package net.lliira.game.campaign.storage.db;

import net.lliira.game.campaign.model.User;

import java.util.Date;

/** MyBatis Mapper to provide user related operations. */
public interface UserMapper {

  long selectNextUserId();

  User selectUserById(long userId);

  User selectUserByEmail(String email);

  void insertUser(User user);

  void deleteUser(long userId);
}
