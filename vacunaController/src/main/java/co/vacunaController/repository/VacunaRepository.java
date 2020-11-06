package co.vacunaController.repository;

import co.vacunaController.entity.VacunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends JpaRepository<VacunaEntity, Long> {
}

