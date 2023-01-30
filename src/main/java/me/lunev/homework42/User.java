package me.lunev.homework42;

import org.apache.commons.lang3.StringUtils;

public class User {

    private String login;
    private String email;

    public User() {
        setLogin(login);
        setEmail(email);
    }

    public User(String login, String email) {
        setLogin(login);
        setEmail(email);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (StringUtils.isBlank(login)) {
            login = "user";
        }
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Пароль не может быть пустым или состоять из пробелов");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("email должен содержать символы @ и .");
        }
        if (login.equals(email)) {
            throw new IllegalArgumentException("Логин не может совпадать с email");
        }
        this.email = email;
    }
}
