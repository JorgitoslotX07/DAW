package dawmainm03.M03.UF4.Pt2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
    private Integer dia = 1;
    private Integer mes = 1;
    private Integer any = 2023;

    public Date(Integer d, Integer m, Integer a) {
        setDia(d);
        setMes(m);
        setAny(a);
    }

    public static final void main(String[] args) {
        Date data1 = new Date(33, 1, 2020);
        Date data2 = new Date(20, 4, 2020);

        System.out.println("\n" + data1.getDia() + " " + data1.getMes() + " " + data1.getAny());

        System.out.println("\n-----------------------------------\n");
        
        System.out.println("\n" + data2.getDia() + " " + data2.getMes() + " " + data2.getAny());
    }

    private boolean esDataValida(int dia, int mes, int any) {
        if (any < 1 || mes < 1 || mes > 12) {
            return false;
        }

        if (dia < 1 || dia > diesDelMes(mes, any)) {
            return false;
        }

        return true;
    }

    private int diesDelMes(int mes, int any) {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, any);
        calendar.set(Calendar.MONTH, mes - 1); 
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAny() {
        return any;
    }

    public void setDia(Integer d) {
        if (esDataValida(d, mes, any)) {
            this.dia = d;
        }
    }

    public void setMes(Integer m) {
        if (esDataValida(dia, m, any)) {
            this.mes = m;
        }
    }

    public void setAny(Integer a) {
        if (esDataValida(dia, mes, a)) {
            this.any = a;
        }
    }

}
