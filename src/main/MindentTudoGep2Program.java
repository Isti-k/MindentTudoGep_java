package main;

import java.util.ArrayList;
import java.util.List;
import modell.MindentTudoGep;

public class MindentTudoGep2Program {

    public static void main(String[] args) {
        new MindentTudoGep2Program().szelvenyBemutato();
    }

    private void szelvenyBemutato() {
        MindentTudoGep gep = new MindentTudoGep();
        
        /* boole[] */
        /* hibás, ha ezt nem hívjuk */
        //gep.booleSzelvenytGeneral();
        System.out.println("1. (boole) szelvény:");
        boolean[] szelvenyBoole = gep.getSzelvenyBoole();
        booleSzelvenytMutat(szelvenyBoole);
        
        System.out.println("2. (boole) szelvény:");
        gep.booleSzelvenytGeneral();
        szelvenyBoole = gep.getSzelvenyBoole();
        /* a referncián keresztül a rejtett adattagot is elérjük: */
        szelvenyBoole[10] = true;
        szelvenyBoole[11] = true;
        szelvenyBoole[12] = true;
        szelvenyBoole[13] = true;
        szelvenyBoole[14] = true;
        szelvenyBoole = gep.getSzelvenyBoole();
        booleSzelvenytMutat(szelvenyBoole);
        
        /* ez azért kell, mert korábban el tudtuk rontani: */
        gep.booleSzelvenytGeneral();
        
        /* int[] */
        System.out.println("3. (int) szelvény:");
        
        int[] szelvenyInt = gep.getSzelvenyInt();
        szelvenyInt[0] = 1000;
        szelvenyInt = gep.getSzelvenyInt();
        intSzelvenytMutat(szelvenyInt);
        
        /* ELŐNYÖK:
         * Már nem függünk, nem látjuk a tényleges adatszerkezetet 
         * A megjelenítő formát a modell adja
        */
        System.out.println("4. (int  v boole?) szelvény:");
        String szelveny = gep.getSzelvenySzoveg();
        System.out.println(szelveny);
        
        System.out.println("5. (típusa?) szelvény:");
        szelveny = gep.getSzelvenySzoveg();
        System.out.println(szelveny);
        
        System.out.println("6. (típusa?) szelvény:");
        gep.szelvenyGeneral();
        szelveny = gep.getSzelvenySzoveg();
        /* már nincs referencia az adattagra */
        List<Integer> lista = gep.getSzelvenyLista();
        /* Nem módosítható listáűt kapunk, ha módosítani akarjuk, akkor:
        UnsupportedOperationException
        */
        //lista.add(Integer.SIZE);
        //lista.set(0, -50);
        szelveny = gep.getSzelvenySzoveg();
        System.out.println(szelveny);
        
        System.out.println("7. (hash / tree) szelvény:");
        gep.szelvenyGeneral();
        szelveny = gep.getSzelvenySzoveg();
        System.out.println(szelveny);
    }

    /* Meg kellett írni a megjelenítő logikát */
    private void booleSzelvenytMutat(boolean[] szelveny) {
        for (int i = 0; i < szelveny.length; i++) {
            if(szelveny[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    private void intSzelvenytMutat(int[] szelveny) {
        for (int szam : szelveny) {
            System.out.print(szam + " ");
        }
        System.out.println("");
    }
    
    
}
