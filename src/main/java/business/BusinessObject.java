package business;

import entity.Message;
import entity.User;
import services.MessageService;
import services.UserService;

public class BusinessObject {
    UserService userService;
    MessageService messageService;

    public User getUser() {
        if (null == userService) {
            userService = new UserService();
        }
        return userService.getUser();
    }

    public Message getMessage() {
        if (null == messageService) {
            messageService = new MessageService();
        }
        return messageService.getMessage();
    }
}
