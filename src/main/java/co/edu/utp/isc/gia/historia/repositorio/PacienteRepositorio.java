package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.PacienteEntidad;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepositorio extends CrudRepository<PacienteEntidad,Long> {
}
