package com.plannerapp.service.impl;

import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        boolean existsByUsernameOrEmail = userRepository.existsByUsernameOrEmail(
                userRegisterBindingModel.getUsername(),
                userRegisterBindingModel.getEmail());

        if (existsByUsernameOrEmail) {
            return false;
        }

        User user = new User();
        user.setUsername(userRegisterBindingModel.getUsername());
        user.setEmail(userRegisterBindingModel.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));

        userRepository.save(user);

        return true;
    }
}
