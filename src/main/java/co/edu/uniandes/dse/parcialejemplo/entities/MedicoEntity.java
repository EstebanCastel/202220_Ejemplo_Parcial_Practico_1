package co.edu.uniandes.dse.parcialejemplo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
@Entity
public class MedicoEntity extends BaseEntity{

    private String nombre;
    private String apellido;
    private String registroMedico;
    @Id
    private Long id;

    @ManyToMany
    private List<EspecialidadEntity> especialidades = new ArrayList<>();
}

