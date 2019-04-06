package es.asb.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import es.asb.taskapp.entity.UserEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {

	UserEntity findByEmail(String email);
	
}
