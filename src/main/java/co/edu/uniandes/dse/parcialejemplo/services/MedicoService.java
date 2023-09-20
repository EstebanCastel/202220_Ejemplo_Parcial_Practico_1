package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoEntity createMedico(MedicoEntity medicoEntity) throws IllegalArgumentException {
        if(medicoEntity.getRegistroMedico().startsWith("RM")) {
            return medicoRepository.save(medicoEntity);
        } else {
            throw new IllegalArgumentException("El registro médico debe comenzar con 'RM'");
        }
    }
}

