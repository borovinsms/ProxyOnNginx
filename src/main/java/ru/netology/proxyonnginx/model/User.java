package ru.netology.proxyonnginx.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public record User(@NotBlank @Size(min = 2, max = 10) String user,
                   @NotBlank @Size(min = 4, max = 100) String password) {

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String user() {
        return user;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user1)) return false;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
