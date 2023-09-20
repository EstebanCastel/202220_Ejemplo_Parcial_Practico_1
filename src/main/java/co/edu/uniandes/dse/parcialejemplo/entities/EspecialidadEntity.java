package co.edu.uniandes.dse.parcialejemplo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
@Entity
public class EspecialidadEntity extends BaseEntity{
    private String nombre;
    private String descripcion;


    @ManyToMany(mappedBy = "especialidades")
    private List<MedicoEntity> medicos = new ArrayList<>();
}
