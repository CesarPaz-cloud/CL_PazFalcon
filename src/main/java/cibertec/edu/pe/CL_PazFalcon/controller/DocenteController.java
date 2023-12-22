package cibertec.edu.pe.CL_PazFalcon.controller;

import cibertec.edu.pe.CL_PazFalcon.exception.ResourceNotFoundException;
import cibertec.edu.pe.CL_PazFalcon.model.Docente;
import cibertec.edu.pe.CL_PazFalcon.service.DocenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@Controller
@RequestMapping("/api/docente")
public class DocenteController {

    private DocenteService docenteService;


    @PostMapping("")
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.save(docente),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerPorId(@PathVariable Integer id) {
        Docente docente = docenteService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("El Docente con el id nro. "+
                        id + "no existe"));
       return new ResponseEntity<>(docente, HttpStatus.OK);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Docente>> listarDocentes() {
        List<Docente> docentes = new ArrayList<>();
        docenteService.listaDocente().forEach(docentes::add);
        if (docentes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
        return new ResponseEntity<>(docentes,HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizarDocente(
            @PathVariable("id") Integer id,
            @RequestBody Docente docente
    ){
        Docente oldDocente = docenteService.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("El Docente con el Id nro. "+
                                id + " no existe"));
        oldDocente.setNombre(docente.getNombre());
        oldDocente.setDni(docente.getDni());
        oldDocente.setFechnacimiento(docente.getFechnacimiento());
        oldDocente.setSueldo(docente.getSueldo());
        oldDocente.setEmail(docente.getEmail());
        oldDocente.setSexo(docente.getSexo());
        oldDocente.setCategoria(docente.getCategoria());
        return new ResponseEntity<>(
                docenteService.save(oldDocente),HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        docenteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

