/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EjemploSpringBootDB;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis Angel
 */
@RestController
@RequestMapping("/api")
public class ControllerPersonas {

    @Autowired
    private RepositoryPersonas repositoryPersonas;

    @RequestMapping(value = "/personas", method = RequestMethod.POST)
    public Boolean guardarPersona(@RequestBody ModelPersonas persona) {
        try {
            repositoryPersonas.save(persona);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
    public Boolean eliminarPersona(@PathVariable String id){
        try{
            repositoryPersonas.delete(getPersonaByID(id));
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @RequestMapping(value = "/personas", method = RequestMethod.PUT)
    public Boolean actualizarPersona(@RequestBody ModelPersonas persona) {
        try{
            repositoryPersonas.save(persona);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    

    @GetMapping(path = "/personas/{id}")
    public ModelPersonas getPersonaByID(@PathVariable String id) {
        Optional<ModelPersonas> personas = repositoryPersonas.findById(id);
        return personas.get();
    }

    @GetMapping(path = "/personas")
    public List<ModelPersonas> getPersonas() {
        List<ModelPersonas> lstPersonas = repositoryPersonas.findAll();
        return lstPersonas;
    }
}
