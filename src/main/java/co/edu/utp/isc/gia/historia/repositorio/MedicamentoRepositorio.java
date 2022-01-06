package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.MedicamentoEntidad;
import org.springframework.data.repository.CrudRepository;

public interface MedicamentoRepositorio extends CrudRepository<MedicamentoEntidad, Long> {
}
