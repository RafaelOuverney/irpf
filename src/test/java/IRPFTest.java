import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.irpf.CalculadoraIRPF;

public class IRPFTest {

    CalculadoraIRPF irpf = new CalculadoraIRPF();

    @Test
    public void testCT01_Isento() {
        assertEquals(0.00, irpf.calcular(1500.00), 0.01, "A renda de 1500 deve ser isenta.");
    }

    @Test
    public void testCT02_Faixa1() {
        assertEquals(7.20, irpf.calcular(2000.00), 0.01, "Cálculo incorreto para a Faixa 1.");
    }

    @Test
    public void testCT03_Faixa2() {
        assertEquals(95.20, irpf.calcular(3000.00), 0.01, "Cálculo incorreto para a Faixa 2.");
    }

    @Test
    public void testCT04_Faixa3() {
        assertEquals(263.87, irpf.calcular(4000.00), 0.01, "Cálculo incorreto para a Faixa 3.");
    }

    @Test
    public void testCT05_Faixa4() {
        assertEquals(1055.64, irpf.calcular(7000.00), 0.01, "Cálculo incorreto para a Faixa 4.");
    }

    @Test
    public void testCT06_RendaNegativa_DeveLancarExcecao() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            irpf.calcular(-500.00);
        });
        assertTrue(exception.getMessage().contains("negativo"), "A mensagem de erro deve indicar valor negativo.");
    }
}
