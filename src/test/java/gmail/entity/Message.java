package gmail.entity;

public class Message {
    private String textMessage;
    private String subjectMessage;

    public Message(String subjectMessage, String textMessage) {
        this.textMessage = textMessage;
        this.subjectMessage = subjectMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getSubjectMessage() {
        return subjectMessage;
    }

    public void setSubjectMessage(String subjectMessage) {
        this.subjectMessage = subjectMessage;
    }
}
