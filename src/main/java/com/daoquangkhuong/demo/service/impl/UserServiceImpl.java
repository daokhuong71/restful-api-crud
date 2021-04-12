package com.daoquangkhuong.demo.service.impl;

import com.daoquangkhuong.demo.model.entities.User;
import com.daoquangkhuong.demo.model.request.UserFilterRequest;
import com.daoquangkhuong.demo.model.response.UserAddressResponse;
import com.daoquangkhuong.demo.repositories.UserRepository;
import com.daoquangkhuong.demo.repositories.specification.UserSpecification;
import com.daoquangkhuong.demo.service.UserService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<UserAddressResponse> getUserByRoleId() {
        return userRepository.findUserByRoleId();
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        User user = userRepository.findByUserNameAndPassword(userName,password);
        return user;
    }

    @Override
    public Page<User> getAllFilter(UserFilterRequest userFilterRequest){
        PageRequest pageRequest = PageRequest.of(userFilterRequest.getPageIndex(), userFilterRequest.getPageSize());
        return userRepository.findAll(UserSpecification.filter(userFilterRequest), pageRequest.previousOrFirst());
    }
}
