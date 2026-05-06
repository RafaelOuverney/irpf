import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.irpf.Calendario;

public class CalendarioTest{
    Calendario cal = new Calendario();

    @Test
    public void test01_NenhumParametro(){
        String resultado = cal.getCalendario();
        assertNotNull(resultado);
        assertFalse(resultado.isEmpty(), "Resultado não deve ser vazio");
    }

    @Test
    public void test02_AnoValido(){
        String resultado = cal.getCalendario(2025);
        assertTrue (resultado.contains("Janeiro") && resultado.contains("Dezembro"), "Deve exibir todos os meses do ano");
    }

    @Test
    public void test03_AnoInvalido(){
        assertThrows(IllegalArgumentException.class, () -> cal.getCalendario(0), "Deve lançar exceção para ano inválido (menor que 1)");
    }

    @Test
    public void test04_MesEAnoValidos(){
        String resultado = cal.getCalendario(5, 2025);
        assertTrue(resultado.contains("Maio") && resultado.contains("2025"), "Deve exibir o mês de Maio de 2025");
    }

    @Test
    public void test05_MesInvalidoAnoValido(){
        assertThrows(IllegalArgumentException.class, () -> {
            cal.getCalendario(13, 2026);
        }, "Deve lançar exceção para mês inválido (fora do intervalo 1-12)");
    }

    @Test
    public void test06_MaisDeDoisParametros(){
        String resultado = cal.getCalendario(5,2025, "terceiro");
        assertTrue(resultado.contains("Maio") && resultado.contains("2025"), "Deve exibir o mês de Maio de 2025, ignorando o terceiro parâmetro");
    }

    @Test
    public void test07_FormatoInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {
            cal.getCalendario("dois mil e vinte seis");
        }, "Deve rejeitar strings não numéricas como entrada para o ano");
    }

    @Test
    public void test08_ReformaGregoriana(){
        String resultado = cal.getCalendario(9, 1752);
        assertTrue(resultado.contains("Reforma Gregoriana") || !resultado.contains("dia 5"), "Deve indicar que os dias de 5 a 14 de setembro de 1752 foram omitidos devido à reforma gregoriana");
    }
}