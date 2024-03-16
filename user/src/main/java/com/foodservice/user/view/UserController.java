package com.foodservice.user.view;

import com.foodservice.user.domain.service.UserService;
import com.foodservice.user.view.dto.UserRegisterDTO;
import com.foodservice.user.view.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/users")
public record UserController(UserService userService) {

    @PostMapping
    public ResponseEntity register(@RequestBody UserRegisterDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(UserMapper.mapToUser(userDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findOne(id));
    }
}
