package ru.netology.proxyonnginx.service;

import org.springframework.stereotype.Service;
import ru.netology.proxyonnginx.exception.InvalidCredentials;
import ru.netology.proxyonnginx.exception.UnauthorizedUser;
import ru.netology.proxyonnginx.repository.Authorities;
import ru.netology.proxyonnginx.repository.AuthorizationRepository;

import java.util.List;

@Service
public class AuthorizationService {

    private final AuthorizationRepository repository;

    public AuthorizationService(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        final var userAuthorities = repository.getUserAuthorities(user, password);
        if (userAuthorities == null || isEmpty(userAuthorities)) throw new UnauthorizedUser("Unknown user: " + user);
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
