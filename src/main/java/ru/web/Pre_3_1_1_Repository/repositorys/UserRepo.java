package ru.web.Pre_3_1_1_Repository.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.web.Pre_3_1_1_Repository.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
