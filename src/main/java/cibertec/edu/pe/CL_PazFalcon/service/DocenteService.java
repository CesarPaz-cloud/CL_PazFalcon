package cibertec.edu.pe.CL_PazFalcon.service;

import cibertec.edu.pe.CL_PazFalcon.model.Docente;
import cibertec.edu.pe.CL_PazFalcon.repository.DocenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DocenteService {
    private DocenteRepository docenteRepository;

    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Docente findById(Integer id) {
        return docenteRepository.findById(id).orElse(null);
    }

    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    public void deleteById(Integer id) {
        docenteRepository.deleteById(id);
    }

    public List<Docente> fitrarUsuarioPorNombreSQL(String filtro) {
        return docenteRepository.fitrarUsuarioPorNombreSQL(filtro);
    }

    public Docente findByNombre(String nombre) {
        return docenteRepository.findByNombre(nombre);
    }
}
