package co.historicoVacuna.repository;

import co.historicoVacuna.entity.HistoricoVacunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoVacunaRepository extends JpaRepository<HistoricoVacunaEntity, Long> {
    //List<HistoricoVacunaEntity> findByFechaAplicación();
}
