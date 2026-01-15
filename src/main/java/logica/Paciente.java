package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Paciente extends Persona implements Serializable {

    private boolean tieneOs;
    private String tipoSangre;
    @OneToMany(mappedBy = "paciente")
    private List<Turno> listaTurnos;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Responsable responsable;
    private String afeccion;

    public Paciente() {
    }

    public Paciente(boolean tieneOs, String tipoSangre, List<Turno> listaTurnos, Responsable responsable, String afeccion, int id, String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fechaNac) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.tieneOs = tieneOs;
        this.tipoSangre = tipoSangre;
        this.listaTurnos = listaTurnos;
        this.responsable = responsable;
        this.afeccion = afeccion;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public boolean isTieneOs() {
        return tieneOs;
    }

    public void setTieneOs(boolean tieneOs) {
        this.tieneOs = tieneOs;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

}
