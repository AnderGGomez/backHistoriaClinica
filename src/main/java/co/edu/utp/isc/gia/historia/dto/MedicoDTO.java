package co.edu.utp.isc.gia.historia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MedicoDTO extends PersonaDTO implements Serializable {
    /**
     * Esta clase  hereda de la clase PersonaDTO y define los atributos minimos de un medico
     * para el sistema de historias clinicas.
     * @autor Anderson Gomez Gomez
     *
     * @param especialidad es la especialidad del profesional de la salud.
     * @param cargo es el cargo que desempeña el profesional de la salud
     * @param ips Institucion Prestadora de Serivicios a la que se encuentra vinculado el profesional de la salud
     * */
    private String especialidad;
    private String cargo;
    private String ips;
}
