package com.vstr.integrative.service;

import com.vstr.integrative.dto.UserDto;
import com.vstr.integrative.model.Role;
import com.vstr.integrative.model.User;
import com.vstr.integrative.repository.UserRepository;
import com.vstr.integrative.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public User save(UserDto userDto) throws EmailExistsException {
        // Buscar el rol predeterminado
        Role defaultRole = userRoleRepository.findByName("USER");

        String email = userDto.getEmail();

        // Verificar si el correo electrónico ya está en uso
        if (userRepository.existsByEmail(email)) {
            throw new EmailExistsException("El correo electrónico ya está en uso");
        }

        // Verificar si el rol predeterminado existe
        if (defaultRole == null) {
            throw new IllegalStateException("El rol predeterminado 'USER' no está configurado en la base de datos.");
        }

        User user = new User(userDto.getFullname(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), Arrays.asList(defaultRole));

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email_id) {
        return userRepository.findByEmail(email_id);
    }
}
