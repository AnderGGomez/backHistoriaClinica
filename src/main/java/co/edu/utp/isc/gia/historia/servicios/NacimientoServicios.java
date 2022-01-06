package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.NacimientoDTO;

import java.util.List;

public interface NacimientoServicios {
    NacimientoDTO saveNacimiento(NacimientoDTO nacimientoDTO);

    NacimientoDTO getNacimiento(Long id);

    List<NacimientoDTO> getAllNacimientos();

    boolean deleteNacimiento(Long id);

    boolean putNacimiento(Long id, NacimientoDTO nacimientoDTO);

    NacimientoDTO getNacimientoByHistoria(Long id);

    boolean existeNacimiento(Long id);
}
