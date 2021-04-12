package com.daoquangkhuong.demo.repositories;

import com.daoquangkhuong.demo.model.entities.User;
import com.daoquangkhuong.demo.model.response.UserAddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends BaseRepository<User, Long> {

//    @Query(value = "SELECT new com.daoquangkhuong.demo.model.response.UserAddressResponse(u.address, count(u.id)) FROM User u GROUP BY u.address")
//    List<UserAddressResponse> findUserByRoleId();
//
//    User findByUserNameAndPassword(String userName, String password);
}
