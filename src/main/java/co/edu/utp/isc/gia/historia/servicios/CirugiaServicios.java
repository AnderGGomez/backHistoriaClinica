package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.CirugiaDTO;

import java.util.List;

public interface CirugiaServicios {
    CirugiaDTO saveCirugia (CirugiaDTO cirugiasDTO);

    CirugiaDTO getCirugia (Long id);

    List<CirugiaDTO> getAllCirugias();

    boolean deleteCirugia(Long id);

    boolean putCirugia(Long id, CirugiaDTO cirugiaDTO);

    List<CirugiaDTO> getCirugiasByHistoria(Long id);

    boolean existeCirugia(Long id);
}
