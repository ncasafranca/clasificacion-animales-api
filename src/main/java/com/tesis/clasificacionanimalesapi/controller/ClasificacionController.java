package com.tesis.clasificacionanimalesapi.controller;

import com.tesis.clasificacionanimalesapi.exception.UnKnownException;
import com.tesis.clasificacionanimalesapi.model.Clasificacion;
import com.tesis.clasificacionanimalesapi.model.User;
import com.tesis.clasificacionanimalesapi.repository.ClasificacionRepository;
import com.tesis.clasificacionanimalesapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clasificacion")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class ClasificacionController {
    @Autowired
    ClasificacionRepository clasificacionRepository;

    // Create clasification
    @PostMapping
    public ResponseEntity<Clasificacion> createClasificacion
    (@RequestBody Clasificacion clasificacion) {
        try {

            Clasificacion newclasificacion = new Clasificacion(clasificacion.getAnimal(),
                    clasificacion.getRaza(), clasificacion.getPrediction());
            clasificacionRepository.save(newclasificacion);
            return new ResponseEntity<>(newclasificacion,
                    HttpStatus.CREATED);
        } catch (Exception e) {
            throw new UnKnownException(e.getMessage());
        }
    }
}
