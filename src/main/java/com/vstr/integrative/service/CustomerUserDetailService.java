package com.vstr.integrative.service;

import com.vstr.integrative.model.Role;
import com.vstr.integrative.model.User;
import com.vstr.integrative.repository.UserRepository;
import com.vstr.integrative.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);


        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Role role = userRoleRepository.findRoleByUsers_Id(user.getId());

        if (role == null) {
            throw new UsernameNotFoundException("Rol no asignado para este usuario");
        }
        return new CustomerUserDetail(user, role);
    }
}
