package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    private LocalDate fechaTurno;
    private String horaTruno;
    @ManyToOne
    @JoinColumn(name = "idOdontologo")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    public Turno() {
    }

    public Turno(int idTurno, LocalDate fechaTurno, String horaTruno, String afeccion) {
        this.idTurno = idTurno;
        this.fechaTurno = fechaTurno;
        this.horaTruno = horaTruno;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDate fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getHoraTruno() {
        return horaTruno;
    }

    public void setHoraTruno(String horaTruno) {
        this.horaTruno = horaTruno;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
