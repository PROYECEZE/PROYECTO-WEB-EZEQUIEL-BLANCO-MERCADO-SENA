package com.example.crud.controller;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Registrarse;
import com.example.crud.repository.RegistrarseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegistrarseController {

    @Autowired
    RegistrarseRepository registrarseRepository;

    @GetMapping("/registrarse")
    public List<Registrarse> getAllregistrarse() {
        return registrarseRepository.findAll();
    }

    @PostMapping("/registrarse")
    public Registrarse createRegistrarse(@Valid @RequestBody Registrarse registrarse) {
        return registrarseRepository.save(registrarse);
    }


    @PostMapping("/login")
    public String  authenticate(@Valid @RequestBody Registrarse request) {
        String email = request.getUsuario();
        String contraseña = request.getContraseña();

        // Buscar en la base de datos un registro con el email proporcionado
        Registrarse existingRegistrarse = registrarseRepository.findByUsuario(email);

        if (existingRegistrarse != null && existingRegistrarse.getContraseña().equals(contraseña)) {
            // Las credenciales son válidas, puedes devolver el objeto Registrarse
            return "si";
        } else {
            // Las credenciales no son válidas, puedes devolver un objeto nulo o lanzar una excepción, según tu elección.
            return "no";
        }
    }

    @GetMapping("/registrarse/{id}")
    public Registrarse getRegistrarseById(@PathVariable(value = "id") Long Id) {
        return registrarseRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Registrarse", "id", Id));
    }

    @PutMapping("/registrarse/{id}")
    public Registrarse updateRegistrarse(@PathVariable(value = "id") Long Id,
                                           @Valid @RequestBody Registrarse registrarseDetails) {

        Registrarse registrarse = registrarseRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Registrarse", "id", Id));

        registrarse.setUsuario(registrarseDetails.getUsuario());

        Registrarse updatedregistrarse = registrarseRepository.save(registrarse);
        return updatedregistrarse;
    }


}
