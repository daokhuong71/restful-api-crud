package com.daoquangkhuong.demo.service;

import com.daoquangkhuong.demo.model.entities.User;
import com.daoquangkhuong.demo.model.request.UserFilterRequest;
import com.daoquangkhuong.demo.model.response.UserAddressResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    void save(User user);


    User findById(long id);
    List<UserAddressResponse> getUserByRoleId();

    User findByUserNameAndPassword(String userName, String password);

    //search user theo filter
    Page<User> getAllFilter(UserFilterRequest userFilterRequest);
}
