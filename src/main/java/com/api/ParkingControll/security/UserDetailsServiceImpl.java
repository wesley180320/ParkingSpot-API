package com.api.ParkingControll.security;

import com.api.ParkingControll.models.UserModel;
import com.api.ParkingControll.repositories.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserModelRepository userModelRepository;

    public UserDetailsServiceImpl(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userModelRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found" + username));
        return User
                .builder()
                .username(userModel.getUsername())
                .roles("USER","ADMIN")
                .password(userModel.getPassword())
                .build();
    }


}
