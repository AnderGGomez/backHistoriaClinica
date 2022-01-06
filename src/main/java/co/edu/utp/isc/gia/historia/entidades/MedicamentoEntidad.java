package co.edu.utp.isc.gia.historia.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "MEDICAMENTO")
public class MedicamentoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(length = 20, nullable = false)
    private String  nombre;

    @Column(length = 20, nullable = false)
    private String  marca;

    @Column(nullable = false)
    private Integer  dosis;

    @Column(length = 20, nullable = false)
    private String  presentacion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date    fechaCaducidad;

}
