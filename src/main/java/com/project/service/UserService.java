package com.project.service;

import com.project.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findByNameIsLike(String name);

    User findByPhone(String phone);

    Page<User> findAll(Specification<User> specification, Pageable pageable);

    User findByUserName(String userName);
    User findById(Long id);
}
