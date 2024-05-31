package com.example.AuthorizationService;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private Map<String, String> userPasswords = new HashMap<>();
    private Map<String, List<Authorities>> userAuthorities = new HashMap<>();

    public UserRepository() {
        userPasswords.put("john", "password123");
        userPasswords.put("jane", "securePass");
        userPasswords.put("admin", "adminPass");

        userAuthorities.put("john", Arrays.asList(Authorities.READ, Authorities.WRITE));
        userAuthorities.put("jane", Arrays.asList(Authorities.READ));
        userAuthorities.put("admin", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (userPasswords.containsKey(user) && userPasswords.get(user).equals(password)) {
            return userAuthorities.getOrDefault(user, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
