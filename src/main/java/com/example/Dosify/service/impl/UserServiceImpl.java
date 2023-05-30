package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDTO.UserRequestDto;
import com.example.Dosify.dto.ResponseDTO.UserResponseDto;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.UserRepository;

import com.example.Dosify.service.UserService;
import com.example.Dosify.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {

       // convert request dto to entity so that my database can accept it
//        User user = new User();
//        user.setName(userRequestDto.getName());
//        user.setAge(userRequestDto.getAge());
//        user.setEmailId(userRequestDto.getEmailId());
//        user.setGender(userRequestDto.getGender());
//        user.setMobNo(userRequestDto.getMobNo());

        //writing above code as a professional level coder is not good so i will create some class called transformer
        //which will create objects by just calling this class, it will automatically set all the required attributes

        // Creating User object using builder annotation as already created transformer
        User user = UserTransformer.UserRequestDtoToUser(userRequestDto);

        //save the object in database
        User savedUser = userRepository.save(user);

        //this is how we convert entity -> response dto so to send back response to user
//        UserResponseDto userResponseDto = new UserResponseDto();
//        userResponseDto.setName(savedUser.getName());
//        userResponseDto.setMessage("Congrats! You have registered on Dosify");

        //But instead of above 3 lines of code i will just call response method from transformer class

        UserResponseDto userResponseDto = UserTransformer.UserToUserResponseDto(savedUser);

        return userResponseDto;

    }
}
