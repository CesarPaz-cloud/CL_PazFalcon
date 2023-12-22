package cibertec.edu.pe.CL_PazFalcon.repository;

import cibertec.edu.pe.CL_PazFalcon.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente,Integer> {

    @Query(value = "Select * from docente where nombre LIKE %:filtro%", nativeQuery = true)
    List<Docente> fitrarUsuarioPorNombreSQL(@Param("filtro") String filtro);

    Docente findByNombre(String nombre);
}
