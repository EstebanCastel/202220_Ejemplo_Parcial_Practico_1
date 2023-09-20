package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(MedicoService.class)
@Transactional
public class MedicoServiceTest {

    @Autowired
    private MedicoService medicoService;

    @Test
    public void testCreateMedicoSuccess() {
        MedicoEntity medico = new MedicoEntity();
        medico.setRegistroMedico("RM12345");
        MedicoEntity result = medicoService.createMedico(medico);
        assertNotNull(result);
    }

    @Test
    public void testCreateMedicoFailure() {
        MedicoEntity medico = new MedicoEntity();
        medico.setRegistroMedico("12345RM");
        assertThrows(IllegalArgumentException.class, () -> medicoService.createMedico(medico));
    }
}


