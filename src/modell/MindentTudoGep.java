package modell;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class MindentTudoGep {
    private boolean[] szelvenyBoole;
    private int[] szelvenyInt;
    /* dinamikus méretű adatszerkezet: */
    private ArrayList<Integer> szelvenyLista;
    
    /* HALMAZ: dinamikus méretű, azonos elemeket nem tárol
    Hash - rendezetlen
    Tree - rendezett
    */
    private HashSet<Integer> szelvenyHalmazRendezetlen;
    private TreeSet<Integer> szelvenyHalmazRendezett;

    public MindentTudoGep() {
        /* boole */
        szelvenyBoole = new boolean[91]; //1..90
        booleSzelvenytGeneral();
        
        szelvenyInt = new int[5];
        intSzelvenytGeneral();
        
        szelvenyLista = new ArrayList<>();
        //szelvenyGeneral();
        
        szelvenyHalmazRendezetlen = new HashSet<>();
        //szelvenyGeneral();
        
        szelvenyHalmazRendezett = new TreeSet<>();
        szelvenyGeneral();
    }
    
    /* már NEM FÜGG a ténylegesen használt adatszerkezettől: */
    public void szelvenyGeneral(){
        /* ArrayList */
//        szelvenyLista.clear();
//        while(szelvenyLista.size() < 5){
//            int v = (int)(Math.random()*90)+1;
//            if(!szelvenyLista.contains(v)){
//                szelvenyLista.add(v);
//            }
//        }
//        Collections.sort(szelvenyLista);

        /* HashSet */
//        while(szelvenyHalmazRendezetlen.size() < 5){
//            int v = (int)(Math.random()*90)+1;
//            szelvenyHalmazRendezetlen.add(v);
//        }
        
        /* TreeSet */
        while(szelvenyHalmazRendezett.size() < 5){
            int v = (int)(Math.random()*90)+1;
            szelvenyHalmazRendezett.add(v);
        }
    }
    
    
    /* FÜGG a ténylegesen használt adatszerkezettől: */
    public void intSzelvenytGeneral() {
        int db = 0;
        while(db < 5){
            int v = (int)(Math.random()*90)+1;
            if(!benneVan(v, db)){
                szelvenyInt[db++] = v;
            }
        }
        Arrays.sort(szelvenyInt);
    }
    
    private boolean benneVan(int szam, int db) {
        int i = 0;
        while(i < db && !(szelvenyInt[i] == szam)){
            i++;
        }
        return i < db;
    }
        
    /* FÜGG a ténylegesen használt adatszerkezettől: */
    public void booleSzelvenytGeneral(){
        Arrays.fill(szelvenyBoole, false);
        int db = 0;
        while(db < 5){
            int v = (int)(Math.random()*90)+1;
            if(!szelvenyBoole[v]){
                szelvenyBoole[v] = true;
                db++;
            }
        }
    }

    /* PROBLÉMÁK:
     * a getter referenciát ad --> setter
     * FÜGG a belső adatszerkezet típusától
    */
    public boolean[] getSzelvenyBoole() {
        /* ez referenciát ad a rejtett adattagra: */
        return szelvenyBoole;
    }

    /* PROBLÉMÁK:
     * a getter referenciát ad --> setter
     * FÜGG a belső adatszerkezet típusától
    */
    public int[] getSzelvenyInt() {
        /* ez referenciát ad a rejtett adattagra: */
        //return szelvenyInt;
        
        /* egy új adatszerkezetet (tömb) adok vissza, már nincs referencia az adattagra: */
        int[] ujTomb = Arrays.copyOf(szelvenyInt, szelvenyInt.length);
        return ujTomb;
    }
 
    /* PROBLÉMÁK:
     * FÜGG a belső adatszerkezet típusától
    */
    public List<Integer> getSzelvenyLista() {
        /* ez referenciát ad a rejtett adattagra: */
        //return szelvenyLista;
        
        /* egy új adatszerkezetet (lista) adok vissza, már nincs referencia az adattagra: */
        //return new ArrayList<>(szelvenyLista);
        
        /* nem módosítható listát adunk vissza */
        return Collections.unmodifiableList(szelvenyLista);
    }
    
    
     /* már NEM FÜGG a ténylegesen használt adatszerkezettől: */
    public String getSzelvenySzoveg(){
        /* boole[] */
//        String s = "";
//        for (int i = 1; i < szelvenyBoole.length; i++) {
//            boolean b = szelvenyBoole[i];
//            if (b) {
//                s += i + ", ";
//            }
//        }
//        return s.substring(0, s.length()-2);
        
        /* int[] */
//        String s = Arrays.toString(szelvenyInt);
//        s = s.substring(1, s.length()-1);
//        return s;

        /* ArrayList */
//        String s = szelvenyLista.toString();
//        s = s.substring(1, s.length()-1);
//        return s;

        /* HashSet */
//        String s = szelvenyHalmazRendezetlen.toString();
//        s = s.substring(1, s.length()-1);
//        return s;
        
        /* HashSet */
        String s = szelvenyHalmazRendezett.toString();
        s = s.substring(1, s.length()-1);
        return s;
    }
}
