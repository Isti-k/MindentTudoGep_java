package teszt;

import modell.MindentTudoGep;

public class MindenTudoGepTeszt {
    public static void main(String[] args) {
        new MindenTudoGepTeszt().tesztesetek();
    }

    private void tesztesetek() {
        tesztSzelvenyGeneralas();
    }

    private void tesztSzelvenyGeneralas() {
        tesztUres();
        teszt5Szam();
        tesztIntervallum();
        tesztAzonos();
        tesztRendezett();
    }

    private void tesztUres() {
        MindentTudoGep gep = new MindentTudoGep();
        String szelveny = gep.getSzelvenySzoveg();
        System.out.println("teszt: nem üres a szelvény");
        assert !szelveny.isBlank() : "üres a szelvény";
    }

    private void teszt5Szam() {
        System.out.println("teszt: 5 számot tartalmaz");
        MindentTudoGep gep = new MindentTudoGep();
        String szelveny = gep.getSzelvenySzoveg();
        String[] szelvenyTomb = szelveny.split(",");
        assert szelvenyTomb.length == 5 : "nem 5 elemű";
        
        for (String szoveg : szelvenyTomb) {
            szoveg = szoveg.trim();
            int hossz = szoveg.length();
            for (int i = 0; i < hossz; i++) {
                char c = szoveg.charAt(i);
                assert Character.isDigit(c) : "nem csak számjegy";
            }
        }
    }

    private void tesztIntervallum() {
        System.out.println("teszt: minden szám [1;90]");
        MindentTudoGep gep = new MindentTudoGep();
        String szelveny = gep.getSzelvenySzoveg();
        String[] sz = szelveny.split(",");
        for (String s : sz) {
            int szam = Integer.parseInt(s.trim());
            boolean jo = szam >= 1 && szam <= 90;
            assert jo : "hibás intervallum";
        }
    }

    private void tesztAzonos() {
        System.out.println("teszt: nincs azonos elem");
        assert false : "van azonos elem";
    }

    private void tesztRendezett() {
        System.out.println("teszt: növekvőbe rendezett");
        assert false : "nem rendezett";
    }
}
