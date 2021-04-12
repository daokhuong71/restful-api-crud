package com.daoquangkhuong.demo.controller;

import com.daoquangkhuong.demo.model.entities.User;
import com.daoquangkhuong.demo.model.request.UserFilterRequest;
import com.daoquangkhuong.demo.model.response.UserAddressResponse;
import com.daoquangkhuong.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final ObjectMapper objectMapper;

    @GetMapping("/user")
    public ResponseEntity<Void> save(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        User user = userService.findById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAddressResponse>> getAllAddresById(){
        return ResponseEntity.ok(userService.getUserByRoleId());
    }

    @GetMapping("/Upassword")
    public ResponseEntity<User> getByUserNameAndPassWord(@RequestParam(required = false) String userName,
                                                         @RequestParam(required = false) String password){
        return ResponseEntity.ok(userService.findByUserNameAndPassword(userName,password));
    }

    @GetMapping("user/filter")
    public ResponseEntity<Page<User>> searchFilter(@ModelAttribute UserFilterRequest filterRequest){
        return ResponseEntity.ok(userService.getAllFilter(filterRequest));
    }
}
