package com.auth.woogie.models;

public class UserSessionVO {

  private String userId;
  private String userName;
  private String sessionId;
  private String avatarUrl;
  
  public UserSessionVO(String userId, String userName, String sessionId, String avatarUrl) {
    super();
    this.userId = userId;
    this.userName = userName;
    this.sessionId = sessionId;
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

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }
  
  @Override
  public String toString() {
    return "UserSessionVO [userId=" + userId + ",userName= " + userName + ",sessionId= " + sessionId + ", avatarUrl= " + avatarUrl + "]";
  }

}
