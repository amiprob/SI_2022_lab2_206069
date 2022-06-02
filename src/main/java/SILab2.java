import java.util.ArrayList;
import java.util.List;

public class SILab2 {
    public static List<String> function(List<String> list) {
        if (list.size() <= 0) { // ako dolzinata na listata e negativna ili ednakva na 0
            throw new IllegalArgumentException("List length should be greater than 0");
        }
        int n = list.size(); // se prezema dolzinata na listata
        int rootOfN = (int) Math.sqrt(n); // kvadraten koren od dolzinata na listata
        if (rootOfN * rootOfN  != n) { // proverka dali e cist koren dobien t.e da ne e bil decimalen broj korenot
            throw new IllegalArgumentException("List length should be a perfect square");
        }
        List<String> numMines = new ArrayList<>(); // broj na bombi
        for (int i = 0; i < n; i++) { // for ciklus koj pocnuva od 0 i mine niz cela matrica fakticki ( ja gleda kako 1 lista)
            if (!list.get(i).equals("#")) { // ako na mestoto vo matricata ima 0
                int num = 0; // brojacBombi = 0
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ) { // prakticno proveruvas dali levo od tebe ili desno ima bomba. Ako ima vleguvas vo uslov
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) ){ // ako levo i desno ima bomba
                        num += 2;
                    }
                    else {
                        num  += 1; // ako samo na ednata strana ima bomba ( sekakо e plus 1 oti za da vleze vo toj uslov, mora da e imalo edna levo ili desno), ne moze da nema od dvete strani
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){ // za gore dali ima bomba
                    num++;
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){ // za dole dali ima bomba
                    num++;
                }
                numMines.add(String.valueOf(num)); // kolku bombi ima izbroeno
            }
            else {
                numMines.add(list.get(i)); // staj toa so go ima (#)
            }
        }
        return numMines;
    }
}
