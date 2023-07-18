package ru.netology.proxyonnginx.repository;

import java.util.List;

public interface AuthorizationRepository {

    List<Authorities> getUserAuthorities(String user, String password);
}
