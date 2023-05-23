public class Spiel{
    private Spieler[] spieler;
    private static int aktuellerSpieler;
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private Feld[] feld;
    private View view;
    private String spielzustand; // "Baumodus" oder "Schiessmodus"
    
    public Spiel(){
        spieler = new Spieler[2];
        spieler[0] = new Spieler();
        spieler[1] = new Spieler();
        feld = new Feld[2];
        feld[0] = new Feld();
        feld[1] = new Feld();
        aktuellerSpieler = 1;
        aktuellesFeld = 1;
        view = new View(this);
    }
    
    public void setzeTreffer(int x, int y){
        if (aktuellerSpieler == 0){
            // setzt Treffer bei Spieler1
        }
        else{
            //setzt Treffer bei Spieler1
        }
    }
    public static void beendeZug(){
    
        if(aktuellerSpieler == 0){
            aktuellerSpieler = 1;
        }
        else
        {
            aktuellerSpieler =0;
        }
        
    }
    
    //public void feldUpdateModel{}
}
