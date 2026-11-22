package es.convive.backend.repository;

import es.convive.backend.entity.PagoLiquidacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoLiquidacionRepository extends JpaRepository<PagoLiquidacion, Long> {
    List<PagoLiquidacion> findAllByPisoIdOrderByFechaDescIdDesc(Long pisoId);
}
