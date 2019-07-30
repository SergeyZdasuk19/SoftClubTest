package services;

import entity.User;
import manager.PropertyManager;

public class UserService {
    private User user;

    public User getUser() {
        if (null == user) {
            user = new User();
            user.setUserName(PropertyManager.getUserProperties().getProperty("username"));
            user.setPassword(PropertyManager.getUserProperties().getProperty("password"));
        }
        return user;
    }
}
