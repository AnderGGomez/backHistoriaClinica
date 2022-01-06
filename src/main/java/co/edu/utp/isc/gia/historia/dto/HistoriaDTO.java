package co.edu.utp.isc.gia.historia.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class HistoriaDTO implements Serializable {
    private Long id;
    private String eps;
    private PacienteDTO paciente;
}
