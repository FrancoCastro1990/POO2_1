package view;

import model.User;

public class UserView {
    public void displayUserInfo(User user) {
        System.out.println("User: " + user.getName() + ", Email: " + user.getEmail());
    }
}
