package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.PersonalDTO;

import java.util.List;

public interface PersonalServicios {
    PersonalDTO savePersonal (PersonalDTO personalDTO);

    PersonalDTO getPersonal (Long id);

    List<PersonalDTO> getAllPersonal();

    boolean deletePersonal (Long id);

    boolean putPersonal(Long id, PersonalDTO personalDTO);

    List<PersonalDTO> getPersonalByHistoria(Long id);

    boolean existePersonal(Long id);
}
