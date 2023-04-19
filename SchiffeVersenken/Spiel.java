public class Spiel{
    private Spieler spieler1;
    private Spieler spieler2;
    private static int aktuellerSpieler;
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private View view;
    
    public Spiel(){
        spieler1 = new Spieler();
        spieler2 = new Spieler();
        aktuellerSpieler = 1;
        aktuellesFeld = 1;
    }
    
    public static void beendeZug(){
    
        if(aktuellerSpieler == 1){
            aktuellerSpieler = 2;
        }
        else
        {
            aktuellerSpieler =1;
        }
        
    }
}
