package com.example.ventanillaenlineaandroid;

public class LogIn {
    private String clave;
    private String contrasena;

    public LogIn(String clave, String contrasena) {
        this.clave = clave;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
