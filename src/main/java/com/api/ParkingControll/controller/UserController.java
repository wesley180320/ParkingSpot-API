package com.api.ParkingControll.controller;

import com.api.ParkingControll.dtos.UserDto;
import com.api.ParkingControll.models.ParkingSpotModel;
import com.api.ParkingControll.models.UserModel;
import com.api.ParkingControll.services.UserModelService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot/user")
public class UserController {

    @Autowired
    private UserModelService userModelService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> saveAll(@RequestBody UserModel userModel){
        userModelService.saveAll(userModel);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){
         return ResponseEntity.ok().body(userModelService.findAll());
    }

}
