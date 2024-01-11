package net.lliira.game.campaign.model;

import java.util.Date;

public class User {
  private final long id;

  private String email;
  private String name;
  private String passwordHashed;
  private boolean activated;
  private Date registeredTime;

  public User(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getPasswordHashed() {
    return passwordHashed;
  }

  public User setPasswordHashed(String passwordHashed) {
    this.passwordHashed = passwordHashed;
    return this;
  }

  public boolean isActivated() {
    return activated;
  }

  public User setActivated(boolean activated) {
    this.activated = activated;
    return this;
  }

  public Date getRegisteredTime() {
    return registeredTime;
  }

  public User setRegisteredTime(Date registeredTime) {
    this.registeredTime = registeredTime;
    return this;
  }
}
