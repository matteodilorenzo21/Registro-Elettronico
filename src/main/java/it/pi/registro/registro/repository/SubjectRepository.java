package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}