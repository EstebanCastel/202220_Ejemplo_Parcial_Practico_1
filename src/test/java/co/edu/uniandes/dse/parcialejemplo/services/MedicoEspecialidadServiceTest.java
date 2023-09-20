package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.EspecialidadRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

@DataJpaTest
@Import(MedicoEspecialidadService.class)
@Transactional
public class MedicoEspecialidadServiceTest {

    @Autowired
    private MedicoEspecialidadService medicoEspecialidadService;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @BeforeEach
    public void setup() {
        MedicoEntity medico = new MedicoEntity();
        medico.setRegistroMedico("RM12345");
        medicoRepository.save(medico);

        EspecialidadEntity especialidad = new EspecialidadEntity();
        especialidad.setDescripcion("Descripcion valida");
        especialidadRepository.save(especialidad);
    }

    @Test
    public void testAddEspecialidadSuccess() {
        // Aquí asumimos que ya existen un médico con id 1 y una especialidad con id 1.
        MedicoEntity result = medicoEspecialidadService.addEspecialidad(1L, 1L);
        assertNotNull(result);
    }

    @Test
    public void testAddEspecialidadMedicoNotExist() {
        assertThrows(IllegalArgumentException.class, () -> medicoEspecialidadService.addEspecialidad(999L, 1L));
    }

    @Test
    public void testAddEspecialidadEspecialidadNotExist() {
        assertThrows(IllegalArgumentException.class, () -> medicoEspecialidadService.addEspecialidad(1L, 999L));
    }
}
