package com.web.registration.application.model;

import com.web.registration.application.view.UserView;

import java.util.List;

public interface UserDAO {
    UserView getUserById(Long id);
    void saveUser(User user);
    List<UserView> getUsers();
}
