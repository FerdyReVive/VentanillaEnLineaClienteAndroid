package com.example.ventanillaenlineaandroid;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String clave;
    private String correo;
    private String contrasena;
    private int idTipoUsuario;
    private int idSecretarioAsignado;
    private int estado;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String clave, String correo, String contrasena, int idTipoUsuario, int idSecretarioAsignado, int estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idTipoUsuario = idTipoUsuario;
        this.idSecretarioAsignado = idSecretarioAsignado;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdSecretarioAsignado() {
        return idSecretarioAsignado;
    }

    public void setIdSecretarioAsignado(int idSecretarioAsignado) {
        this.idSecretarioAsignado = idSecretarioAsignado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
