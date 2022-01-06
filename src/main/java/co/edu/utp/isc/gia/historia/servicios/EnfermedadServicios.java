package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.EnfermedadDTO;

import java.util.List;

public interface EnfermedadServicios {
    EnfermedadDTO saveEnfermedad(EnfermedadDTO enfermedadDTO);

    EnfermedadDTO getEnfermedad(Long id);

    List<EnfermedadDTO> getAllEnfermedades();

    boolean deleteEnfermedad(Long id);

    boolean putEnfermedad(Long id, EnfermedadDTO enfermedadDTO);
}
