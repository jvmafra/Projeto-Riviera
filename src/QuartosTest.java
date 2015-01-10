
import org.junit.Assert;
import org.junit.Test;


public class QuartosTest {
	private Quarto q1;
	
	@Test
	public void testaExecutivoSimples() {
		try {
			q1 = new QuartoExecutivoSimples(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoSimples("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoSimples("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoSimples("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoSimples("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void testaExecutivoDuplo() {
		try {
			q1 = new QuartoExecutivoDuplo(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoDuplo("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoDuplo("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoDuplo("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoDuplo("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void testaExecutivoTriplo() {
		try {
			q1 = new QuartoExecutivoTriplo(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoTriplo("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoExecutivoTriplo("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoTriplo("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoExecutivoTriplo("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void testaLuxoSimples() {
		try {
			q1 = new QuartoLuxoSimples(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoSimples("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoSimples("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoSimples("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoSimples("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}

	@Test
	public void testaLuxoDuplo() {
		try {
			q1 = new QuartoLuxoDuplo(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoDuplo("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoDuplo("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoDuplo("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoDuplo("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void testaLuxoTriplo() {
		try {
			q1 = new QuartoLuxoTriplo(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoTriplo("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoLuxoTriplo("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoTriplo("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoLuxoTriplo("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
	
	@Test
	public void testaPresidencial() {
		try {
			q1 = new QuartoPresidencial(null, 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoPresidencial("Joao", 100);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Hospede invalido");
		}
		try {
			q1 = new QuartoPresidencial("Joao Bezerra", 0);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoPresidencial("Joao Bezerra", -10);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(), "Numero do Quarto invalido");
		}
		try {
			q1 = new QuartoPresidencial("Joao Bezerra", 100);
		} catch (Exception e) {
			Assert.fail();
		}

	}
}
