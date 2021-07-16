package com.xiaopantx.data.jpa.service;

import com.xiaopantx.data.jpa.dao.UserRepository;
import com.xiaopantx.data.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author panxj
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUser() {
        return userRepository.findAll();
    }

    public boolean batchSave(List<User> users) {
        List<User> list = userRepository.saveAllAndFlush(users);
        return list.stream()
                .map(User::getId)
                .allMatch(Objects::nonNull);
    }
}
