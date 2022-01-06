package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.HistoriaDTO;
import co.edu.utp.isc.gia.historia.entidades.HistoriaEntidad;

import java.util.List;

public interface HistoriaServicios {

    HistoriaDTO saveHistoria(HistoriaDTO historiaDTO);

    HistoriaDTO getHistoria(Long id);

    HistoriaDTO getHistoriaByPaciente(Long user_id);

    List<HistoriaDTO> getAllHistorias();

    boolean deleteHistoria(Long id);

    boolean putHistoria(Long id, HistoriaDTO historiaDTO);

    //more services
    boolean existHistoria(Long id);
    HistoriaEntidad getHistoriaEntidad(Long id);

    boolean getHaveHistory(Long id);
}
