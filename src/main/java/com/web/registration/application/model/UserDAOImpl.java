package com.web.registration.application.model;


import com.web.registration.application.util.DatabaseConnection;
import com.web.registration.application.view.UserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOG = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public UserView getUserById(Long id) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        String insertQuery = "INSERT INTO users " +
                "( username, password, first_name, last_name, middle_name, gender, date_of_birth) " +
                "VALUES (?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = DatabaseConnection.getConnection()
                    .prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getMiddleName());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setString(7, user.getDateOfBirth().toString());

            LOG.info( String.format("preparedStatement: %s", preparedStatement));
            int result = preparedStatement.executeUpdate();
            LOG.info( String.format("result: %d", result));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (NullPointerException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<UserView> getUsers() {
        return null;
    }
}
