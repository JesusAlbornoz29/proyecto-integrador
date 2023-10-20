package com.grupo3.digitalbook.demo.service.impl;

import com.grupo3.digitalbook.demo.entity.AppUser;
import com.grupo3.digitalbook.demo.entity.AppUserRole;
import com.grupo3.digitalbook.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("admin");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("user");

        userRepository.save(new AppUser("Jesus","jesus","jesus@admin.com",hashedPassword1, AppUserRole.ADMIN));
        userRepository.save(new AppUser("User","user","user@user.com",hashedPassword2,AppUserRole.USER));

    }
}
