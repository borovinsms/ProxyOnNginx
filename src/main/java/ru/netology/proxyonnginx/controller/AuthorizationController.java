package ru.netology.proxyonnginx.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.proxyonnginx.model.User;
import ru.netology.proxyonnginx.repository.Authorities;
import ru.netology.proxyonnginx.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/authorize")
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user.user(), user.password());
    }
}