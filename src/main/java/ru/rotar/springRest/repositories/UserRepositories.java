package ru.rotar.springRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rotar.springRest.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
}