package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class HerenciaDTO implements Serializable {
    private Long        id;

    private String      parentesco;
    private String      nombre;
    private String      segundoNombre;
    private String      primerApellido;
    private String      segundoApellido;

    private Date        fechaCreacion;

    //Foreing Key
    private MedicoDTO   medico;
    private HistoriaDTO historia;
    private List<EnfermedadDTO> enfermedades;
}
