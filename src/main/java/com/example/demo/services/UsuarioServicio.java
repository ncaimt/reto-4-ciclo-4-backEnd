/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nacai
 */
@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepository repositorio;
    
    public List<Usuario> listar(){
        return repositorio.listar();
        
    }
    
    public boolean existeEmail(String email){
        return repositorio.existeEmail(email);       
    }
    
    public Usuario autenticarUsuario(String email, String password ){
        return repositorio.autenticarUsuario(email, password);    
    }
    
    public Optional <Usuario> getUsuariobyId(int id){
        return repositorio.getById(id);
    }
            
    public Usuario create(Usuario usuario) {
        
        
        // obener el id de mayor valor
        Optional<Usuario> userIdMayor = repositorio.lastUserId();
        
        if (usuario.getId() == null) {
            if (!userIdMayor.isPresent()){
                // si el documentos esta vacio entonce
                usuario.setId(1);
                // le asigna el 1
            }
            else{
                usuario.setId(userIdMayor.get().getId()+1);
            }
        }
         
        Optional<Usuario> e = repositorio.getById(usuario.getId());
            if (!e.isPresent()) {
                if (existeEmail(usuario.getEmail()) == false) {

                    System.out.println("se creo usuario");
                    return repositorio.save(usuario);
                    
                } else {
                    System.out.println("no se pudo crear usuario primer else, ya existe email");
                    return usuario;
                    
                }
            } else {
                System.out.println("no se pudo crear usuario segundo else, ya existe ususario con ese id");
                return usuario;
            }
        
    }
        
    public Usuario update(Usuario usuario) {

        if (usuario.getId() != null) {
            Optional<Usuario> usuarioDb = repositorio.getById(usuario.getId());
            if (usuarioDb.isPresent()) {
                if (usuario.getIdentification() != null) {
                    usuarioDb.get().setIdentification(usuario.getIdentification());
                }
                if (usuario.getName() != null) {
                    usuarioDb.get().setName(usuario.getName());
                }
                if (usuario.getAddress() != null) {
                    usuarioDb.get().setAddress(usuario.getAddress());
                }
                if (usuario.getCellPhone() != null) {
                    usuarioDb.get().setCellPhone(usuario.getCellPhone());
                }
                if (usuario.getEmail() != null) {
                    usuarioDb.get().setEmail(usuario.getEmail());
                }
                if (usuario.getPassword() != null) {
                    usuarioDb.get().setPassword(usuario.getPassword());
                }
                if (usuario.getZone() != null) {
                    usuarioDb.get().setZone(usuario.getZone());
                }
                if (usuario.getType() != null) {
                    usuarioDb.get().setType(usuario.getType());
                }
                if(usuario.getBirthtDay()!= null){
                    usuarioDb.get().setBirthtDay(usuario.getBirthtDay());
                }
                if (usuario.getMonthBirthtDay()!= null){
                    usuarioDb.get().setMonthBirthtDay(usuario.getMonthBirthtDay());
                }

                repositorio.update(usuarioDb.get());
                return usuarioDb.get();
            } else {
                return usuario;
            }
        } else {
            return usuario;
        }
    }
    
    
    public boolean delete(int userId) {
        Optional<Usuario> usuario = repositorio.getById(userId);
        
        if (!usuario.isPresent()){
            return false;
        }else{
            repositorio.delete(userId);
            return true;
        }
    }
    
}
