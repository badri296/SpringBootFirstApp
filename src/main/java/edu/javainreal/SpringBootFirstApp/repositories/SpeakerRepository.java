package edu.javainreal.SpringBootFirstApp.repositories;

import edu.javainreal.SpringBootFirstApp.model.Session;
import edu.javainreal.SpringBootFirstApp.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
