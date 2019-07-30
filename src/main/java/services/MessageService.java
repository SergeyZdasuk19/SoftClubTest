package services;

import entity.Message;
import manager.PropertyManager;

public class MessageService {
    private Message message;

    public Message getMessage() {
        if (null == message) {
            message = new Message();
            message.setTextMessage(PropertyManager.getMessageProperties().getProperty("TextMessage"));
            message.setSubjectMessage(PropertyManager.getMessageProperties().getProperty("SubjectMessage"));
        }
        return message;
    }
}
