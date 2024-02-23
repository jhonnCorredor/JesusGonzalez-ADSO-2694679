package com.sena.servicesecurity.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Person;

@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{

	@Query(value = " SELECT "
			+ " id,	"
			+ " CONCAT(first_name,' ',last_name) person, "
			+ " state "
			+ "FROM "
			+ "	person ", nativeQuery = true)
	List<IPersonDto> getList();
}
