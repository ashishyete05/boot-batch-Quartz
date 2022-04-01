package app.springboot.registration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.springboot.registration.entity.User;

@Repository
public interface UserRegistrationRepository extends CrudRepository<User, Long> {

}
