package edu.javainreal.SpringBootFirstApp.repositories;

import edu.javainreal.SpringBootFirstApp.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
}
