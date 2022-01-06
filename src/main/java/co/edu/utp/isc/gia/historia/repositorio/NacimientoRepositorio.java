package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.NacimientoEntidad;
import org.springframework.data.repository.CrudRepository;

public interface NacimientoRepositorio extends CrudRepository<NacimientoEntidad, Long> {
    NacimientoEntidad findByHistoria_Id(Long id);
}
