package m03.uf5.p2.collections;

import java.util.ArrayList;
import java.util.List;

public class p2exercici1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        for (String e : list) {
            System.out.println(e);
        }
    }
}
