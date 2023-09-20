package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcialejemplo.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public EspecialidadEntity createEspecialidad(EspecialidadEntity especialidadEntity) throws IllegalArgumentException {
        if(especialidadEntity.getDescripcion() != null && especialidadEntity.getDescripcion().length() >= 10) {
            return especialidadRepository.save(especialidadEntity);
        } else {
            throw new IllegalArgumentException("La descripción debe tener al menos 10 caracteres.");
        }
    }
}

