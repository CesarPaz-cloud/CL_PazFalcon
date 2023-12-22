package cibertec.edu.pe.CL_PazFalcon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Docente {

    @Id
    @Column(name = "iddocente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fechNacimiento")
    private Date fechaNacimiento;

    @Column(name = "sueldo")
    private Double sueldo;

    @Column(name = "email")
    private String email;

    @Column(name = "sexo")
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    private Categoria categoria;
}
