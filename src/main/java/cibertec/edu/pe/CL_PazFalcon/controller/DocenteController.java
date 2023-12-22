package cibertec.edu.pe.CL_PazFalcon.controller;

import cibertec.edu.pe.CL_PazFalcon.model.Docente;
import cibertec.edu.pe.CL_PazFalcon.service.DocenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @PostMapping
    public ResponseEntity<Docente> save(@RequestBody Docente docente) {
        Docente docenteSaved = docenteService.save(docente);
        return ResponseEntity.ok(docenteSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> findById(@PathVariable Integer id) {
        Docente docente = docenteService.findById(id);
        if (docente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(docente);
    }

    @GetMapping
    public ResponseEntity<List<Docente>> findAll() {
        List<Docente> docentes = docenteService.findAll();
        return ResponseEntity.ok(docentes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filtrar-por-nombre")
    public ResponseEntity<List<Docente>> filtrarPorNombre(@RequestParam String nombre) {
        List<Docente> docentes = docenteService.fitrarUsuarioPorNombreSQL(nombre);
        return ResponseEntity.ok(docentes);
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<Docente> buscarPorNombre(@RequestParam String nombre) {
        Docente docente = docenteService.findByNombre(nombre);
        return ResponseEntity.ok(docente);
    }
}

