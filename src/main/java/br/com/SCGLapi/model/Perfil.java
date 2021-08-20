package br.com.SCGLapi.model;

public enum Perfil {
    ADM("Administrador"), 
    CLI("Cliente"),
    FIS("Fisioterapeuta"),
    COL("Colaborador");

    private String perfil;

    Perfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}