package it.pi.registro.registro.controller;

import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.service.UserService;
import it.pi.registro.registro.service.UserTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/userTypes")
public class UserTypeController {

    private UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserType>> getAllUsers(){
        List<UserType> users = userTypeService.getAllUserTypes();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserType> createUserType(@Valid @RequestBody UserType userType){
        UserType savedUserType = userTypeService.createUserType(userType);
        return new ResponseEntity<>(savedUserType, HttpStatus.CREATED);
    }

    /*@GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        User updatedUser = userService.getUserById(userId);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        userService.updateUser(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }*/

}
