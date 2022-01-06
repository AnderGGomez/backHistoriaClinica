package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.HistoriaEntidad;
import org.springframework.data.repository.CrudRepository;

public interface HistoriaRepositorio extends CrudRepository<HistoriaEntidad, Long> {
    HistoriaEntidad findByPaciente_Id(Long id);
    boolean existsByPaciente_Id(Long id);
}
