package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl(){
    }

    @PostConstruct
    private void populateSampleData(){
        users.add( new User( "test@mail.com", "password", "Andres", "Perez" ) );
    }


    @Override
    public List<User> getUsers(){
        return users;
    }

    @Override
    public User getUser( Long id ){
        User u = null;
        for (int i=0; i < users.size(); i++){
            if (users.get(i).getId() == id){
                u = users.get(i);
            }
        }
        return u;
    }

    @Override
    public User createUser( User user ){
        users.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email ){
        User u = null;
        for (int i=0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email)){
                u = users.get(i);
            }
        }
        return u;
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password ){
        User u = null;
        for (int i=0; i < users.size(); i++){
            if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)){
                u = users.get(i);
            }
        }
        return u;
    }

}
