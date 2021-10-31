package com.example.bookmaker.services;

import com.example.bookmaker.dto.LoginRequest;
import com.example.bookmaker.entity.Token;
import com.example.bookmaker.entity.User;
import com.example.bookmaker.helper.TokenHelper;
import com.example.bookmaker.models.UserRequest;
import com.example.bookmaker.repository.TokenRepository;
import com.example.bookmaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private TokenRepository TokenRepository;

    public boolean addUser(UserRequest userRequest) {
        if (UserRepository.findByEmail(userRequest.getEmail()) != null) {
            return false;
        }

        User user = new User(userRequest.getEmail(), userRequest.getPassword(), userRequest.getFirstName(), userRequest.getSecondName(), userRequest.getAge(), userRequest.getUIN());
        UserRepository.save(user);
        return true;
    }

    public boolean loginUser(LoginRequest requestUser) {
        User user = UserRepository.findByEmail(requestUser.getEmail());
        if(user != null && user.getPassword().equals(requestUser.getPassword())) {
            return true;
        }
        return false;
    }

    public User getUser(Integer id) {
        return UserRepository.findById(id.longValue()).orElse(null);
    }

    public User getUserByToken(String token) {
        return UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
    }

    public boolean deleteUser(String token) {
        User user = UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
        UserRepository.delete(user);
        return true;
    }

    public void addToken(String token) {
        Token token1 = new Token(token);
        TokenRepository.save(token1);
    }

    public void deleteToken(String token) {
        Token token1 = TokenRepository.findByToken(token);
        TokenRepository.delete(token1);
    }

    public void updateUserPassword(String token, String newPassword) {
        User user = UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setPassword(newPassword);
        UserRepository.save(user);
    }

    public void updateUserFirstName(String token, String newFirstName) {
        User user = UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setFirstName(newFirstName);
        UserRepository.save(user);
    }

    public void updateUserSecondName(String token, String newSecondName) {
        User user = UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setSecondName(newSecondName);
        UserRepository.save(user);
    }

    public void updateUserAge(String token, int newAge) {
        User user = UserRepository.findByEmail(TokenHelper.getEmailByToken(token));
        user.setAge(newAge);
        UserRepository.save(user);
    }

    public void addBalance(User user, float money) {
        float balance = user.getBalance() + money;
        user.setBalance(balance);
        UserRepository.save(user);
    }

}
