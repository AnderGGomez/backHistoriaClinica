package co.edu.utp.isc.gia.historia.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "MEDICO")
public class MedicoEntidad extends PersonaEntidad implements Serializable {
    /**
     * Esta clase  hereda de la clase PersonaEntidad y define los atributos minimos de un medico
     * para el sistema de historias clinicas, esta clase guarda correspondencia con la tabla medicos de la base
     * de datos.
     *
     * @autor Anderson Gomez Gomez
     *
     * @param especialidad es la especialidad del profesional de la salud.
     *                      - Not null
     *                      - Obligatorio
     *                      - Max length: 20
     * @param cargo es el cargo que desempeña el profesional de la salud.
     *                      - No null
     *                      - obligatorio.
     *                      - Max length: 15
     * @param ips Institucion Prestadora de Serivicios a la que se encuentra vinculado el profesional de la salud
     *                      - Not null.
     *                      - Obligatorio
     *                      - Max length: 20
     * */
    @Column(nullable = false, length = 20)
    private String especialidad;

    @Column(nullable = false, length = 20)
    private String cargo;

    @Column(nullable = false, length = 20)
    private String ips;

}
