package com.api.ParkingControll.services;

import com.api.ParkingControll.dtos.UserDto;
import com.api.ParkingControll.models.UserModel;
import com.api.ParkingControll.repositories.UserModelRepository;
import com.api.ParkingControll.security.WebSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserModelService {

    @Autowired
    private UserModelRepository userModelRepository;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Transactional
    public UserModel saveAll(UserModel userModel){
        String senha = webSecurityConfig.passwordEncoder().encode(userModel.getPassword());
        userModel.setPassword(senha);
        return userModelRepository.save(userModel);
    }

    @Transactional
    public Optional<UserModel> findById(UUID uuid){
        return userModelRepository.findById(uuid);
    }

    @Transactional
    public List<UserDto> findAll(){
        List<UserModel> userModelList = userModelRepository.findAll();
        List<UserDto> userDto = new ArrayList<>();
        for(int i = 0; i<userModelList.size(); i++){
            UserDto userDto1 = new UserDto();
            userDto1.setId((userModelList.get(i).getId()));
            userDto1.setUsername(userModelList.get(i).getUsername());
            userDto.add(userDto1);
        }
        return userDto;
    }

    @Transactional
    public void deleteById(UUID uuid){
        userModelRepository.deleteById(uuid);
    }

}
