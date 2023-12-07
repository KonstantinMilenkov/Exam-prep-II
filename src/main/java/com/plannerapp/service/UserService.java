package com.plannerapp.service;

import com.plannerapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);
}
