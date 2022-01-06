package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.MedicoDTO;

import java.util.List;

public interface MedicoServicios {
    /**
     * Interfaz de servicios prestados a un Medico
     * @autor Anderson Gomez Gomez.
     * */
    MedicoDTO saveMedico(MedicoDTO medicoDTO);

    MedicoDTO getMedico(Long id);

    List<MedicoDTO> getAllMedicos();

    boolean deleteMedico(Long id);

    boolean putMedico(Long id, MedicoDTO medicoDTO);

    //more services
    boolean existMedico(Long id);
}
