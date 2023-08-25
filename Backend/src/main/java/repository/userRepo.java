package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.user;

public interface userRepo extends JpaRepository<user, Long> {

}
