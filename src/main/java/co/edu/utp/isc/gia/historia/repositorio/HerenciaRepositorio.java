package co.edu.utp.isc.gia.historia.repositorio;

import co.edu.utp.isc.gia.historia.entidades.HerenciaEntidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HerenciaRepositorio extends CrudRepository<HerenciaEntidad, Long> {
    List<HerenciaEntidad> findByHistoria_Id(Long id);
    boolean existsByHistoria_Id(Long id);
}
