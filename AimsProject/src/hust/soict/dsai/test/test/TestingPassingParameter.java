package hust.soict.dsai.test.test;

import hust.soict.dsai.aims.disc.*;

public class TestingPassingParameter {
    public static void main(String[] args) {
        DVD jungleDVD = new DVD("Jungle");
        DVD cinderellaDVD = new DVD("Cinderella");
        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle DVD title: " + jungleDVD.getName());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getName());

        changeName(jungleDVD, cinderellaDVD.getName());
        System.out.println("Jungle DVD title: " + jungleDVD.getName());
    }
    
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeName(DVD dvd, String name) {
        String old = dvd.getName();
        dvd.setName(name);
        dvd = new DVD(old);
    }
}