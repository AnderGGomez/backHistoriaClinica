package co.edu.utp.isc.gia.historia.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "ANT_CIRUGIA")
public class CirugiaEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(length = 50, nullable = false)
    private String  procedimiento;

    @Column(nullable = false)
    private String  descripcion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date    fechaProcedimiento;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date    fechaCreacion;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historia_id")
    private HistoriaEntidad historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private MedicoEntidad    medico;
}
