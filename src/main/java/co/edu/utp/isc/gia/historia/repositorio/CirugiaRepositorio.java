package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.CirugiaEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CirugiaRepositorio extends CrudRepository<CirugiaEntidad, Long> {
    public List<CirugiaEntidad> findByHistoria_Id(Long id);
}
