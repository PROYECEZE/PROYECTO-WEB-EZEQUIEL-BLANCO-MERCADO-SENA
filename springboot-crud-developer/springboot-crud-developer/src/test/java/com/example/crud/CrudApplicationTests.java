

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CrudApplicationTests {

	@InjectMocks
	private RegistrarseController registrarseController;

	@Mock
	private RegistrarseRepository registrarseRepository;

	@Test
	public void testGetAllregistrarse() {
		// Simula el comportamiento de findAll en el repositorio
		when(registrarseRepository.findAll()).thenReturn(Arrays.asList(new Registrarse(), new Registrarse()));

		// Llama al método del controlador y verifica la respuesta
		List<Registrarse> registrarseList = registrarseController.getAllregistrarse();

		assertThat(registrarseList).hasSize(2);
	}

	@Test
	public void testCreateRegistrarse() {
		// Crea una instancia de Registrarse para simular la entrada del usuario
		Registrar
		se registrarse = new Registrarse();

		// Simula el comportamiento de save en el repositorio
		when(registrarseRepository.save(registrarse)).thenReturn(registrarse);

		// Llama al método del controlador y verifica la respuesta
		Registrarse createdRegistrarse = registrarseController.createRegistrarse(registrarse);

		assertThat(createdRegistrarse).isEqualTo(registrarse);
	}

	@Test
	public void testAuthenticate_ValidCredentials() {
		// Crea una instancia de Registrarse para simular la entrada del usuario
		Registrarse request = new Registrarse();
		request.setUsuario("usuario");
		request.setContraseña("contraseña");



		// Simula el comportamiento de findByUsuario en el repositorio
		when(registrarseRepository.findByUsuario("usuario")).thenReturn(request);

		// Llama al método del controlador y verifica la respuesta
		String result = registrarseController.authenticate(request);

		assertThat(result).isEqualTo("si");
	}

	@Test
	public void testAuthenticate_InvalidCredentials() {
		// Crea una instancia de Registrarse para simular la entrada del usuario
		Registrarse request = new Registrarse();
		request.setUsuario("usuario");
		request.setContraseña("contraseña");
		// Simula el comportamiento de findByUsuario en el repositorio
		when(registrarseRepository.findByUsuario("usuario")).thenReturn(null);
		// Llama al método del controlador y verifica la respuesta
		String result = registrarseController.authenticate(request);

		assertThat(result).isEqualTo("no");
	}

}
