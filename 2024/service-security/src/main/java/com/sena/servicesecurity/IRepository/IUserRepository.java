package com.sena.servicesecurity.IRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.User;
import com.sena.servicesecurity.DTO.IUserDto;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long>{

	@Query(value = " SELECT "
			+ " u.id,	"
			+ " u.username user, "
			+ " CONCAT(p.first_name,' ',p.last_name) personName, "
			+ " p.email personEmail, "
			+ " u.state "
			+ "FROM "
			+ "	user u "
			+ "    INNER JOIN person p ON p.id = u.person_id "
			+ "WHERE "
			+ "	u.username = :username AND "
			+ " u.password = :password  ", nativeQuery = true)
	Optional<IUserDto> getLogin(String username, String password);
	
	@Query(value = " SELECT "
			+ " u.id,	"
			+ " u.username user, "
			+ " CONCAT(p.first_name,' ',p.last_name) personName, "
			+ " u.state "
			+ "FROM "
			+ "	user u "
			+ "    INNER JOIN person p ON p.id = u.person_id ", nativeQuery = true)
	List<IUserDto> getList();
}
