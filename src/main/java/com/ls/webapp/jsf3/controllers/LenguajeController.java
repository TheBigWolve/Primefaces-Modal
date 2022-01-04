package com.ls.webapp.jsf3.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class LenguajeController implements Serializable {

    @Serial
    private static final long serialVersionUID = 361978L;

    private Locale locale;
    private String lenguaje;
    private Map<String, String> lenguajesSoportados;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        lenguajesSoportados = new HashMap<>();
        lenguajesSoportados.put("English", "en");
        lenguajesSoportados.put("Español", "es");
    }

    public void seleccionar(ValueChangeEvent e) {
        String newLocale = e.getNewValue().toString();
        lenguajesSoportados.values().forEach(v -> {
            if (v.equals(newLocale)) {
                this.locale = new Locale(v);
                FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
            }
        });
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Map<String, String> getLenguajesSoportados() {
        return lenguajesSoportados;
    }

    public void setLenguajesSoportados(Map<String, String> lenguajesSoportados) {
        this.lenguajesSoportados = lenguajesSoportados;
    }
}
