package com.example.clientsservice.security;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login);
        System.err.println("User Detail Service: " + user);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImplement(user);
    }
}
