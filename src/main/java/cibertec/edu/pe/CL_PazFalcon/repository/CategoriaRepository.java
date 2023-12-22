package cibertec.edu.pe.CL_PazFalcon.repository;

import cibertec.edu.pe.CL_PazFalcon.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNombre(String nombre);

    List<Categoria> findByCategorynameContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM Category c WHERE c.categoryname LIKE %:filtro%")
    List<Categoria> filtrarCategoriasPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM categories WHERE categoryname LIKE %:filtro%",
            nativeQuery = true)
    List<Categoria> filtrarCategoriasPorNombreSQL(@Param("filtro") String filtro);

}
