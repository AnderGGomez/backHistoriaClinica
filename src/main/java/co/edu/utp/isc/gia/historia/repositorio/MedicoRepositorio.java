package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.MedicoEntidad;
import org.springframework.data.repository.CrudRepository;

public interface MedicoRepositorio extends CrudRepository<MedicoEntidad, Long> {
}
