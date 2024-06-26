package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.UserSubjects;
import it.pi.registro.registro.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<Long, UserType> {
    UserType findByType(String type);
}
