package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.HerenciaDTO;

import java.util.List;

public interface HerenciaServicios {
    HerenciaDTO saveHerencia(HerenciaDTO herenciaDTO);

    HerenciaDTO getHerencia(Long id);

    List<HerenciaDTO> getHerenciaByHistoria(Long id);

    List<HerenciaDTO> getAllHerencia();

    boolean deleteHerencia(Long id);

    boolean putHerencia(Long id, HerenciaDTO herenciaDTO);

    boolean existeHerencia(long id);
}
