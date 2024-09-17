package com.vstr.integrative.service;

import com.vstr.integrative.dto.UserDto;
import com.vstr.integrative.model.User;

public interface UserService {

    User save(UserDto userDto) throws EmailExistsException;

    User findByEmail(String email_id);
}
