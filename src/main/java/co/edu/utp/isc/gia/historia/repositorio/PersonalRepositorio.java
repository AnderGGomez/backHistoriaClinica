package co.edu.utp.isc.gia.historia.repositorio;


import co.edu.utp.isc.gia.historia.entidades.PersonalEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonalRepositorio extends CrudRepository<PersonalEntidad, Long> {
    public List<PersonalEntidad> findByHistoria_Id(Long id);
}
