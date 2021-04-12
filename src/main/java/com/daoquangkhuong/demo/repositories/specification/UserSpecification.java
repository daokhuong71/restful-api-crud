package com.daoquangkhuong.demo.repositories.specification;

import com.daoquangkhuong.demo.model.entities.User;
import com.daoquangkhuong.demo.model.request.UserFilterRequest;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filter(UserFilterRequest filterRequest){
        return Specification.where(withName(filterRequest.getName()))
                .and(withAddress(filterRequest.getAddress()));
    }

    private static Specification<User> withName(String name){
        if (name == null || name.isEmpty()) return null;

        //funtional programing
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),"%"+name+"%");
    }

    private static Specification<User> withAddress(String address){
        if (address == null || address.isEmpty()) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("address"),address);
    }
}
