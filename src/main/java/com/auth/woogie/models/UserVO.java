package com.auth.woogie.models;

public class UserVO {
  private String userId;
  private String userName;
  private String avatarUrl;

  public UserVO(String userId, String userName, String avatarUrl) {
    super();
    this.userId = userId;
    this.userName = userName;
    this.avatarUrl = avatarUrl;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }  

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @Override
  public String toString() {
    return "UserVO [userId=" + userId + ",userName=" + userName + ",avatarUrl=" + avatarUrl + "]";
  }

}
