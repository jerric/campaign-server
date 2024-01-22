package net.lliira.game.campaign.common.storage.db;

import net.lliira.game.campaign.common.model.User;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.Optional;

public class UserFactory {

    private final SqlSessionFactory sessionFactory;

    UserFactory(SqlSessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public User createUser(
            String email, String passwordHashed, String userName, boolean isActivated) {
        try (var session = sessionFactory.openSession()) {
            var userMapper = session.getMapper(UserMapper.class);
            if (null != userMapper.selectUserByEmail(email)) {
                throw new IllegalArgumentException("Email already exists");
            }

            var user = new User(userMapper.selectNextUserId())
                    .setEmail(email)
                    .setPasswordHashed(passwordHashed)
                    .setName(userName)
                    .setActivated(isActivated)
                    .setRegisteredTime( new Date());
            userMapper.insertUser(user);
            return user;
        }
    }

    public void deleteUser(long userId) {
        try (var session = sessionFactory.openSession()){
            var userMapper = session.getMapper(UserMapper.class);
            userMapper.deleteUser(userId);
        }
    }

    public Optional<User> getUser(long userId) {
        try (var session = sessionFactory.openSession()) {
            var userMapper = session.getMapper(UserMapper.class);
            return Optional.ofNullable(userMapper.selectUserById(userId));
        }
    }
}
