package com.web.registration.application.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import com.web.registration.application.model.User;
import com.web.registration.application.model.UserDAO;
import com.web.registration.application.model.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;


@WebServlet(urlPatterns = "/users", name = "users-controller", displayName = "users-controller")
public class UserController extends HttpServlet {
    private UserMapper mapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Get Request Made");
        resp.getWriter().append("Nothing Yet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        LOGGER.info("Post Request Made");
        BufferedReader reader = null;
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
       
        try {
            reader = request.getReader();
            assert reader != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserDTO userDTO = gson.fromJson(reader, UserDTO.class);

        assert userDTO != null;

//        User user = mapper.toEntity(userDTO);
        User user = new User();
        user.setDateOfBirth(Date.valueOf(userDTO.dateOfBirth));
        user.setUserName(userDTO.username);
        user.setPassword(userDTO.password);
        user.setGender(userDTO.getGender());
        user.setMiddleName(userDTO.getMiddleName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());


        UserDAO userDAO = new UserDAOImpl();
        userDAO.saveUser(user);
        
        
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
