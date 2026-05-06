package com.irpf;

public class CalculadoraIRPF {
    
    private static final double FAIXA_ISENCAO = 1903.98;
    private static final double LIMITE_FAIXA1 = 2826.65;
    private static final double LIMITE_FAIXA2 = 3751.05;
    private static final double LIMITE_FAIXA3 = 4664.68;
    
    private static final double ALIQUOTA_FAIXA1 = 0.075;  // 7.5%
    private static final double ALIQUOTA_FAIXA2 = 0.15;   // 15%
    private static final double ALIQUOTA_FAIXA3 = 0.225;  // 22.5%
    private static final double ALIQUOTA_FAIXA4 = 0.275;  // 27.5%
    
    public double calcular(double renda) {
        if (renda < 0) {
            throw new IllegalArgumentException("A renda não pode ser um valor negativo");
        }
        
        if (renda <= FAIXA_ISENCAO) {
            return 0.0;
        }
        
        double ir = 0.0;
        
        if (renda > FAIXA_ISENCAO) {
            double rendaFaixa1 = Math.min(renda, LIMITE_FAIXA1) - FAIXA_ISENCAO;
            ir += rendaFaixa1 * ALIQUOTA_FAIXA1;
        }
        
        if (renda > LIMITE_FAIXA1) {
            double rendaFaixa2 = Math.min(renda, LIMITE_FAIXA2) - LIMITE_FAIXA1;
            ir += rendaFaixa2 * ALIQUOTA_FAIXA2;
        }
        
        if (renda > LIMITE_FAIXA2) {
            double rendaFaixa3 = Math.min(renda, LIMITE_FAIXA3) - LIMITE_FAIXA2;
            ir += rendaFaixa3 * ALIQUOTA_FAIXA3;
        }
        
        if (renda > LIMITE_FAIXA3) {
            double rendaFaixa4 = renda - LIMITE_FAIXA3;
            ir += rendaFaixa4 * ALIQUOTA_FAIXA4;
        }
        
        return Math.round(ir * 100.0) / 100.0;
    }
}
