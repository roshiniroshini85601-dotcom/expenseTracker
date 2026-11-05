package com.roshini.task1.Service;

import com.roshini.task1.Dto.RequestDto;
import com.roshini.task1.Dto.ResponseDto;
import com.roshini.task1.Model.User;
import com.roshini.task1.Service.JwtService;

import com.roshini.task1.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final JwtService jwtService;



    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public ResponseDto register(RequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        userRepository.save(user);

        ResponseDto response = new ResponseDto();
        response.setUsername(user.getUsername());
        return response;
    }
    public String login(RequestDto dto) {

        User user = userRepository
                .findByUsername(dto.getUsername())
                .orElseThrow(() -> new RuntimeException("user not found"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("password invalid");
        }
    return jwtService.generateToken(user.getUsername());
    }
    }


