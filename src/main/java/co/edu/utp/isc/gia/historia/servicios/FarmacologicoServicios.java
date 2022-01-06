package co.edu.utp.isc.gia.historia.servicios;

import co.edu.utp.isc.gia.historia.dto.FarmacologicoDTO;

import java.util.List;

public interface FarmacologicoServicios {
    FarmacologicoDTO saveFarmacologico (FarmacologicoDTO farmacologicoDTO);

    FarmacologicoDTO getFarmacologico (Long id);

    List<FarmacologicoDTO> getAllFarmacologico ();

    boolean deleteFarmacologico(Long id);

    boolean putFarmacologico(Long id, FarmacologicoDTO farmacologicoDTO);

    List<FarmacologicoDTO> getFarmacoByHistoria(Long id);

    boolean existeFarmaco (Long id);
}
