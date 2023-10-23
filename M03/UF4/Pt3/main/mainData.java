package UF4.Pt3.main;

import UF4.Pt3.act.Data;

public class mainData {
    public static void main(String[] args) {
        Data data1 = new Data(31, 12, 2022);

        System.out.println(data1.toString());

        data1.setDiaSiguiente();
        System.out.println(data1.toString());
    }
}
