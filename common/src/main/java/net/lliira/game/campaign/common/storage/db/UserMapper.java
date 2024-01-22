package net.lliira.game.campaign.common.storage.db;

import net.lliira.game.campaign.common.model.User;

/** MyBatis Mapper to provide user related operations. */
public interface UserMapper {

  long selectNextUserId();

  User selectUserById(long userId);

  User selectUserByEmail(String email);

  void insertUser(User user);

  void deleteUser(long userId);
}
