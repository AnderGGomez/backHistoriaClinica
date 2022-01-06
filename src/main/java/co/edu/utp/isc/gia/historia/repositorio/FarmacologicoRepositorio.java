package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.FarmacologicoEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FarmacologicoRepositorio extends CrudRepository<FarmacologicoEntidad, Long> {
    List<FarmacologicoEntidad> findByHistoria_Id(Long id);
}
