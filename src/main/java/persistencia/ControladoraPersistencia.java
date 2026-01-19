package persistencia;

import java.util.List;
import logica.Odontologo;
import logica.Paciente;
import logica.Responsable;
import logica.Secretario;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    HorarioJpaController horarioJpa = new HorarioJpaController();
    OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    PersonaJpaController personaJpa = new PersonaJpaController();
    ResponsableJpaController responsableJpa = new ResponsableJpaController();
    SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {

        usuarioJpa.create(usuario);

    }

    public List<Usuario> listarUsuarios() {

        return usuarioJpa.findUsuarioEntities();

    }

    public void eliminarUsuario(int idUsuario) {

        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public Usuario traerUsuario(int idUsuario) {

        return usuarioJpa.findUsuario(idUsuario);

    }

    public void editarUsuario(Usuario usuario) {

        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void crearSecretario(Secretario secretario) {

        secretarioJpa.create(secretario);

    }

    public List<Secretario> listarSecretarios() {

        return secretarioJpa.findSecretarioEntities();

    }

    public void eliminarSecretario(int idSecretario) {

        try {
            secretarioJpa.destroy(idSecretario);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public Secretario traerSecretario(int idUsuario) {

        return secretarioJpa.findSecretario(idUsuario);

    }

    public void editarSecretario(Secretario secretarioEditar) {

        try {
            secretarioJpa.edit(secretarioEditar);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void crearPaciente(Paciente paciente) {

        pacienteJpa.create(paciente);

    }

    public void crearResponsable(Responsable responsable) {

        responsableJpa.create(responsable);

    }

    public List<Paciente> listarPacientes() {

        return pacienteJpa.findPacienteEntities();

    }

    public void eliminarPaciente(int idPaciente) {

        try {
            pacienteJpa.destroy(idPaciente);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public Responsable traerResponsable(int idResponsable) {

        return responsableJpa.findResponsable(idResponsable);

    }

    public Paciente traerPaciente(int idPaciente) {

        return pacienteJpa.findPaciente(idPaciente);

    }

    public void eliminarResponsable(int idResponsable) {

        try {
            responsableJpa.destroy(idResponsable);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void editarPaciente(Paciente pacienteEditar) {

        try {
            pacienteJpa.edit(pacienteEditar);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void editarResponsable(Responsable respEditar) {

        try {
            responsableJpa.edit(respEditar);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void crearTurno(Turno turno) {

        turnoJpa.create(turno);
    }

    public List<Turno> listarTurnos() {

        return turnoJpa.findTurnoEntities();

    }

    public void eliminarTurno(int idTurno) {

        try {
            turnoJpa.destroy(idTurno);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public Turno traerTurno(int idTurno) {

        return turnoJpa.findTurno(idTurno);

    }

    public void editarTurno(Turno turnoEditar) {

        try {
            turnoJpa.edit(turnoEditar);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void crearOdontologo(Odontologo odontologo) {

        odontologoJpa.create(odontologo);

    }

    public List<Odontologo> traerOdontologos() {

        return odontologoJpa.findOdontologoEntities();

    }

    public void eliminarOdontologo(int idOdontologo) {

        try {
            odontologoJpa.destroy(idOdontologo);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public Odontologo traerOdontologo(int idOdontologo) {

        return odontologoJpa.findOdontologo(idOdontologo);

    }

    public void editarOdontologo(Odontologo odontologo) {

        try {
            odontologoJpa.edit(odontologo);
        } catch (Exception ex) {
            System.getLogger(ControladoraPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public List<Turno> traerTurnos() {

        return turnoJpa.findTurnoEntities();
    }

}
