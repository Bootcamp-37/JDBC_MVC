/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author User
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = "Fikri";
        boolean gender = true; //true = laki-laki
        char golDarah = 'A';
        int umur = 23;
        float tinggi = 0.168f;
        final float pi = 3.14f;
        int ruas = 5;
        String[] arrName = new String[ruas];
        
        
        for (int i = 0; i < ruas; i++) {
           arrName[i] = i +" "+name ;
        }
        if (gender) {
            System.out.println("Laki Laki = "+gender);
        }
        else{
            System.out.println("Anda laki laki");
        }
        System.out.println(golDarah);
        System.out.println(umur);
        System.out.println(tinggi);
        System.out.println(ruas*ruas*pi);
        if (ruas == 5) {
            ruas = 10;
            System.out.println("luas baru = "+ruas*ruas*pi);
        }
        for (String x : arrName){
            System.out.println("ini x ke-"+x);
        }
        
    }
    
}
