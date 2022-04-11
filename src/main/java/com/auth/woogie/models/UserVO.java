package com.auth.woogie.models;

public class UserVO {
  private String id;
  private String name;
  private String avatarUrl;

  public UserVO(String id, String name, String avatarUrl) {
    super();
    this.id = id;
    this.name = name;
    this.avatarUrl = avatarUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }  

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @Override
  public String toString() {
    return "UserVO [id=" + id + ",name=" + name + ",avatarUrl=" + avatarUrl + "]";
  }

}
