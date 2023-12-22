package cibertec.edu.pe.CL_PazFalcon.service;

import cibertec.edu.pe.CL_PazFalcon.model.Categoria;
import cibertec.edu.pe.CL_PazFalcon.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategoria() {return categoriaRepository.findAll();}

    public Categoria guardar(Categoria categoria){return categoriaRepository.save(categoria);}

    public Optional<Categoria> obtenerCategoriaPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return (categoria.isEmpty()) ? Optional.empty() : categoria;
    }

    public void eliminarCategoria(Integer id){
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> obtenerCategoriasPorFiltro(String filtro){
        return categoriaRepository.filtrarCategoriasPorNombreSQL(filtro);
    }
}
