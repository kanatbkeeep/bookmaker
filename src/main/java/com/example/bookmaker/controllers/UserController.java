package com.example.bookmaker.controllers;

import com.example.bookmaker.dto.LoginRequest;
import com.example.bookmaker.entity.User;
import com.example.bookmaker.helper.TokenHelper;
import com.example.bookmaker.models.UserRequest;
import com.example.bookmaker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserRequest userRequest) {
        boolean result = userService.addUser(userRequest);
        if (result) {
            return new ResponseEntity("user created", HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body("bad request");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest requestUser) {
        if (userService.loginUser(requestUser)) {
            String token = TokenHelper.getToken(requestUser.getEmail());
            userService.addToken(token);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("incorrect email or password");
    }

    @GetMapping("/read")
    public ResponseEntity getUserById(@RequestHeader Integer id) {
        User userRequest = userService.getUser(id);
        if (userRequest == null) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(userRequest);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestParam String token, String whichParamUpdate, String newValue) {
        User user = userService.getUserByToken(token);
        if (user == null) {
            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        } else if (whichParamUpdate.equals("password")) {
            userService.updateUserPassword(token, newValue);
        } else if (whichParamUpdate.equals("firstName")) {
            userService.updateUserFirstName(token, newValue);
        } else if (whichParamUpdate.equals("secondName")) {
            userService.updateUserSecondName(token, newValue);
        } else if (whichParamUpdate.equals("age")) {
            userService.updateUserAge(token, Integer.parseInt(newValue));
        } else if (whichParamUpdate.equals("email") || whichParamUpdate.equals("UIN")) {
            return ResponseEntity.badRequest().body("Impossible to change");
        } else {
            return ResponseEntity.badRequest().body("Incorrect parameter");
        }
        return ResponseEntity.ok("Updated");
    }

    @GetMapping("/delete")
    public ResponseEntity deleteUser(@RequestHeader String token) {
        User user = userService.getUserByToken(token);
        String email = user.getEmail();
        if (userService.deleteUser(token) && user != null) {
            return ResponseEntity.badRequest().body("user deleted");
        }
        return ResponseEntity.badRequest().body("invalid token");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader String token) {
        User user = userService.getUserByToken(token);
        if (user != null) {
            userService.deleteToken(token);
            return ResponseEntity.ok("You successfully logout");
        }
        return ResponseEntity.badRequest().body("incorrect token");
    }

    @PostMapping("/addBalance")
    public ResponseEntity addBalance(@RequestParam String token, float money) {
        User user = userService.getUserByToken(token);
        if (user != null) {
            userService.addBalance(user, money);
            return ResponseEntity.ok("You successfully topped up the balance");
        }
        return ResponseEntity.badRequest().body("incorrect token");
    }
}
