package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import models.users;

public interface usersRepository extends JpaRepository<users,Integer>{

}
