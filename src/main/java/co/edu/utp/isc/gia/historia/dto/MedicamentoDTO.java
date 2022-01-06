package co.edu.utp.isc.gia.historia.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor

public class MedicamentoDTO implements Serializable {
    private Long    id;
    private String  nombre;
    private String  marca;
    private Integer  dosis;
    private String  presentacion;
    private Date    fechaCaducidad;
}
