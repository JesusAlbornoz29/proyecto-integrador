package com.grupo3.digitalbook.demo.service.impl;

import com.grupo3.digitalbook.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Autowired
    public AppUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // return userRepository.findByEmail(email).get();
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No ha sido encontrado ese usuario en la base de datos"));
    }
}
