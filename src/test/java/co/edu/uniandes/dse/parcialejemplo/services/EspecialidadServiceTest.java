package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(EspecialidadService.class)
@Transactional
public class EspecialidadServiceTest {

    @Autowired
    private EspecialidadService especialidadService;

    @Test
    public void testCreateEspecialidadSuccess() {
        EspecialidadEntity especialidad = new EspecialidadEntity();
        especialidad.setDescripcion("Descripcion con mas de diez caracteres.");
        EspecialidadEntity result = especialidadService.createEspecialidad(especialidad);
        assertNotNull(result);
    }

    @Test
    public void testCreateEspecialidadFailure() {
        EspecialidadEntity especialidad = new EspecialidadEntity();
        especialidad.setDescripcion("Corta");
        assertThrows(IllegalArgumentException.class, () -> especialidadService.createEspecialidad(especialidad));
    }
}


