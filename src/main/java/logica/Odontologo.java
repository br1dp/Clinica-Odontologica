package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Odontologo extends Persona implements Serializable {

    private String especialidad;
    @OneToOne
    private Horario horario;
    @OneToMany(mappedBy = "odontologo")
    private List<Turno> listaTurnos;
    @OneToOne
    private Usuario usuario;

    public Odontologo() {
    }

    public Odontologo(String especialidad, Horario horario, List<Turno> listaTurnos, Usuario usuario, int id, String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.especialidad = especialidad;
        this.horario = horario;
        this.listaTurnos = listaTurnos;
        this.usuario = usuario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

}
