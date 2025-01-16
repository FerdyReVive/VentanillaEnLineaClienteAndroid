package com.example.ventanillaenlineaandroid;

import java.util.Objects;

public class Tramite {
    private int idTramite;
    private String fecha;
    private int idTipoTramite;
    private int idUsuario;
    private int estado;
    private Usuario usuario;

    public Tramite(){
    }

    public Tramite(int idTramite, String fecha, int idTipoTramite, int idUsuario, int estado, Usuario usuario) {
        this.idTramite = idTramite;
        this.fecha = fecha;
        this.idTipoTramite = idTipoTramite;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdTipoTramite() {
        return idTipoTramite;
    }

    public void setIdTipoTramite(int idTipoTramite) {
        this.idTipoTramite = idTipoTramite;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tramite tramite = (Tramite) o;
        return idTramite == tramite.idTramite && idTipoTramite == tramite.idTipoTramite && idUsuario == tramite.idUsuario && estado == tramite.estado && Objects.equals(fecha, tramite.fecha) && Objects.equals(usuario, tramite.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTramite, fecha, idTipoTramite, idUsuario, estado, usuario);
    }
}
