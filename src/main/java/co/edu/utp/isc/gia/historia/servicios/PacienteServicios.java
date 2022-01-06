package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.PacienteDTO;
import co.edu.utp.isc.gia.historia.entidades.PacienteEntidad;

import java.util.List;

public interface PacienteServicios {
    /**
     * Interfaz de servicios prestados a un Paciente.
     * @autor Anderson Gomez Gomez.
     * */
    PacienteDTO savePaciente(PacienteDTO pacienteDTO);

    PacienteDTO getPaciente(Long id);

    List<PacienteDTO> getAllPaciente();

    boolean deletePaciente(Long id);

    boolean putPaciente(Long id, PacienteDTO pacienteDTO);

    //-----------------
    PacienteEntidad getPacienteEntidad(Long id);

    boolean existPaciente(Long id);
}
