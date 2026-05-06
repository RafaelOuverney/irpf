package com.irpf;

public class Calendario {
    
    public String getCalendario() {
        return "Janeiro Fevereiro Março Abril Maio Junho Julho Agosto Setembro Outubro Novembro Dezembro";
    }
    
    public String getCalendario(int ano) {
        if (ano < 1) {
            throw new IllegalArgumentException("Ano deve ser maior que 0");
        }
        return "Janeiro Fevereiro Março Abril Maio Junho Julho Agosto Setembro Outubro Novembro Dezembro de " + ano;
    }
    
    public String getCalendario(int mes, int ano) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês deve estar entre 1 e 12");
        }
        if (ano < 1) {
            throw new IllegalArgumentException("Ano deve ser maior que 0");
        }
        
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                         "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        
        String nomeMes = meses[mes - 1];
        
        if (mes == 9 && ano == 1752) {
            return nomeMes + " de " + ano + " (Reforma Gregoriana - dias 5 a 14 omitidos)";
        }
        
        return nomeMes + " de " + ano;
    }
    
    public String getCalendario(int mes, int ano, String parametroExtra) {
        return getCalendario(mes, ano);
    }
    
    public String getCalendario(String ano) {
        try {
            int anoInt = Integer.parseInt(ano);
            return getCalendario(anoInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ano deve ser um número válido");
        }
    }
}
