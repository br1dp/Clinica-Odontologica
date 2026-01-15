package logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {

    ControladoraPersistencia cP = new ControladoraPersistencia();

    public void crearUsuario(String nombre, String password, String rol) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setPassword(password);
        usuario.setRol(rol);
        usuario.setEstado("PENDIENTE");

        cP.crearUsuario(usuario);

    }

    public List<Usuario> listarUsuarios() {

        return cP.listarUsuarios();

    }

    public void eliminarUsuario(int idUsuario) {

        cP.eliminarUsuario(idUsuario);

    }

    public Usuario traerUsuario(int idUsuario) {

        return cP.traerUsuario(idUsuario);

    }

    public void editarUsuario(Usuario usuario) {

        cP.editarUsuario(usuario);

    }

    public boolean comprobarIngreso(String nombreUsuario, String password) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        List<Usuario> listaUsuarios = cP.listarUsuarios();

        boolean validacion = false;

        if (usuario.getNombreUsuario().equals("ADMIN") && usuario.getPassword().equals("123")) {

            if (listaUsuarios.contains(usuario)) {

                validacion = true;

            } else {

                usuario.setRol("ADMIN");
                usuario.setEstado("APROBADO");
                cP.crearUsuario(usuario);
                validacion = true;
            }

        } else if (listaUsuarios.contains(usuario)) {

            if (traerUsuario(nombreUsuario, password) != -1) {

                int idUsuario = traerUsuario(nombreUsuario, password);
                usuario = traerUsuario(idUsuario);
                validacion = usuario.getEstado().equals("APROBADO");

            }

        }

        return validacion;
    }

    public int traerUsuario(String usuarioSecretario, String passwordSecretario) {

        int resultado = -1;

        List<Usuario> listaUsuarios = cP.listarUsuarios();

        for (Usuario usu : listaUsuarios) {

            if (usu.getNombreUsuario().equals(usuarioSecretario)
                    && usu.getPassword().equals(passwordSecretario)) {

                resultado = usu.getIdUsuario();

            }

        }

        return resultado;
    }

    public void crearSecretario(String dni, String nombre, String apellido, String telefono, String direccion, String sector, String fechaNac, int idUsuario) {

        Secretario secretario = new Secretario();

        secretario.setSector(sector);
        secretario.setDni(dni);
        secretario.setNombre(nombre);
        secretario.setApellido(apellido);
        secretario.setTelefono(telefono);
        secretario.setDireccion(direccion);

        if (!fechaNac.isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacLocalDate = LocalDate.parse(fechaNac, dtf);
            secretario.setFechaNac(fechaNacLocalDate);
        } else {
            secretario.setFechaNac(null);
        }

        secretario.setUsuario(cP.traerUsuario(idUsuario));

        cP.crearSecretario(secretario);

    }

    public List<Secretario> listarSecretarios() {

        return cP.listarSecretarios();

    }

    public void eliminarSecretario(int idSecretario) {

        cP.eliminarSecretario(idSecretario);

    }

    public Secretario traerSecretario(int idUsuario) {

        return cP.traerSecretario(idUsuario);

    }

    public void editarSecretario(Secretario secretarioEditar) {

        cP.editarSecretario(secretarioEditar);

    }

    public boolean comprobarAdmin(Usuario usuario) {

        boolean validacion = false;

        if (usuario.getNombreUsuario().equals("ADMIN") && usuario.getPassword().equals("123")) {

            validacion = true;
        }

        return validacion;
    }

    public Mensaje crearMensaje(String titulo, String descripcion) {

        Mensaje mensaje = new Mensaje();
        mensaje.setTitulo(titulo);
        mensaje.setDescripcion(descripcion);

        return mensaje;
    }

    public void crearPaciente(String dni, String nombre, String apellido, String telefono, String direccion, String afeccion, String fechaNac, int tieneOs, String tipoSangre, Responsable responsable) {

        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setAfeccion(afeccion);

        if (!fechaNac.isEmpty()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacLocalDate = LocalDate.parse(fechaNac, dtf);
            paciente.setFechaNac(fechaNacLocalDate);
        } else {
            paciente.setFechaNac(null);
        }

        paciente.setTipoSangre(tipoSangre);
        paciente.setResponsable(responsable);

        if (tieneOs == 1) {
            paciente.setTieneOs(true);
        } else {
            paciente.setTieneOs(false);
        }

        cP.crearResponsable(responsable);
        cP.crearPaciente(paciente);

    }

    public List<Paciente> listarPacientes() {

        List<Paciente> listaPacientes = cP.listarPacientes();

        return listaPacientes;

    }

    public Responsable traerResponsable(int idResponsable) {

        return cP.traerResponsable(idResponsable);

    }

    public Paciente traerPaciente(int idPaciente) {

        return cP.traerPaciente(idPaciente);

    }

    public void eliminarPaciente(int idPaciente) {

        cP.eliminarPaciente(idPaciente);

    }

    public void editarPaciente(Paciente pacienteEditar) {

        cP.editarPaciente(pacienteEditar);

    }

    public void editarResponsable(Responsable respEditar) {

        cP.editarResponsable(respEditar);

    }

    public void crearTurno(String fechaTurno, String horaTurno) {

        Turno turno = new Turno();
        if (fechaTurno != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaTurnoLocalDate = LocalDate.parse(fechaTurno, dtf);
            turno.setFechaTurno(fechaTurnoLocalDate);
        } else {
            turno.setFechaTurno(null);
        }
        if (horaTurno != null) {
            turno.setHoraTruno(horaTurno);
        } else {
            turno.setHoraTruno(null);
        }

        cP.crearTurno(turno);

    }

    public List<Turno> listarTurnos() {

        return cP.listarTurnos();

    }

    public void eliminarTurno(int idTurno) {
   
        cP.eliminarTurno(idTurno);
    
    }

    public Turno traerTurno(int idTurno) {

        return cP.traerTurno(idTurno);
        
    }

    public void editarTurno(Turno turnoEditar) {
   
        cP.editarTurno(turnoEditar);
        
        
    }

}
