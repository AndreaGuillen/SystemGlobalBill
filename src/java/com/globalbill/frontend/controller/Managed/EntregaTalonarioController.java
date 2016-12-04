/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Empleado;
import com.globalbill.backend.Entities.Entregatalonario;
import com.globalbill.backend.Entities.Talonario;
import com.globalbill.backend.model.EmpleadoFacadeLocal;
import com.globalbill.backend.model.EntregatalonarioFacadeLocal;
import com.globalbill.backend.model.TalonarioFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marihuanita
 */
@Named(value = "entregaTalonarioController")
@SessionScoped
public class EntregaTalonarioController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private TalonarioFacadeLocal talonarioFacade;
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    @EJB
    private EntregatalonarioFacadeLocal entregaTalonarioFacade;
    
    private Talonario talonario;
    private Empleado empleado;
    private Entregatalonario entregaTalonario;
    private List<Talonario> talonarioList;
    private List<Empleado> empleadoList;
    private List<Entregatalonario> entregaTalonarioList;

    public EntregaTalonarioController() {
    }
    
    @PostConstruct()
    public void init() {
        entregaTalonario = new Entregatalonario();
    }

    public EntregaTalonarioController(Entregatalonario entregaTalonario) {
        this.entregaTalonario = entregaTalonario;
    }

    public Entregatalonario getEntregaTalonario() {
        return entregaTalonario;
    }

    public void setEntregaTalonario(Entregatalonario entregaTalonario) {
        this.entregaTalonario = entregaTalonario;
    }

    public List<Entregatalonario> getEntregaTalonarioList() {
        entregaTalonarioList = entregaTalonarioFacade.findAll();
        return entregaTalonarioList;
    }

    public void setEntregaTalonarioList(List<Entregatalonario> entregaTalonarioList) {
        this.entregaTalonarioList = entregaTalonarioList;
    }

    public List<Talonario> getTalonarioList() {
        talonarioList = talonarioFacade.findAll();
        return talonarioList;
    }

    public void setTalonarioList(List<Talonario> talonarioList) {
        this.talonarioList = talonarioList;
    }

    public List<Empleado> getEmpleadoList() {
        empleadoList = empleadoFacade.findAll();
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public void registrarEntregaTalonario() {
        try {
            entregaTalonarioFacade.create(entregaTalonario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha registrado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido registrar"));
        }
    }
    
    public List<Entregatalonario> listarEntregaTalonario(){
        try{
            entregaTalonarioFacade.findAll();
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido registrar la factura"));
        }
        return entregaTalonarioFacade.findAll();
    }
}


