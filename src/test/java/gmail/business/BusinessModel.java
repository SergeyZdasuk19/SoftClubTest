package gmail.business;

import gmail.entity.Message;
import gmail.entity.User;
import gmail.pages.LoginPage;
import gmail.pages.MainPage;

public class BusinessModel {
    private User user;
    private Message message;
    private LoginPage loginPage;
    private MainPage mainPage;

    public BusinessModel(User user, Message message, LoginPage loginPage, MainPage mainPage) {
        this.user = user;
        this.message = message;
        this.loginPage = loginPage;
        this.mainPage = mainPage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }
}
