package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;

@Service
public class MedicoEspecialidadService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public MedicoEntity addEspecialidad(Long medicoId, Long especialidadId) throws IllegalArgumentException {
        MedicoEntity medico = medicoRepository.findById(medicoId).orElse(null);
        EspecialidadEntity especialidad = especialidadRepository.findById(especialidadId).orElse(null);

        if (medico == null) {
            throw new IllegalArgumentException("El médico con el ID proporcionado no existe.");
        }

        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad con el ID proporcionado no existe.");
        }

        medico.getEspecialidades().add(especialidad);
        especialidad.getMedicos().add(medico);

        return medicoRepository.save(medico);
    }
}
