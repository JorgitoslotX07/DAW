package UF4.Pt3.act;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {

    private Integer dia = 1;
    private Integer mes = 1;
    private Integer any = 2023;

    public Data(Integer d, Integer m, Integer a) {
        setDia(d);
        setMes(m);
        setAny(a);
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

    public void setDiaSiguiente() {
        int d = getDia() + 1;
        if (esDataValida(d, mes, any)) {
            this.dia = d;
        }
        else {
            this.dia = 1;
            if (getMes() == 12) {
                this.mes = 1;
                this.any++;
            }
            else {
                setMes(mes + 1);
            }
        }
    }

    @Override
    public String toString() {
        return this.getDia() + " / " + this.getMes() + 
            " / " + this.getAny()
        ;
    }

}
