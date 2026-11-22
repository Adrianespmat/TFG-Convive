package es.convive.backend.repository;

import es.convive.backend.entity.Membresia;
import es.convive.backend.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

    Optional<Membresia> findByUsuarioIdAndFechaBajaIsNull(Long usuarioId);

    Optional<Membresia> findByUsuarioIdAndPisoIdAndFechaBajaIsNull(Long usuarioId, Long pisoId);

    List<Membresia> findAllByPisoIdAndFechaBajaIsNullOrderByFechaAltaAsc(Long pisoId);

    boolean existsByUsuarioIdAndFechaBajaIsNull(Long usuarioId);

    boolean existsByPisoIdAndUsuarioIdAndFechaBajaIsNull(Long pisoId, Long usuarioId);

    long countByPisoIdAndRolAndFechaBajaIsNull(Long pisoId, Rol rol);
}
