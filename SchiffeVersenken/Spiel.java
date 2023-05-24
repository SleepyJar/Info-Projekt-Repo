public class Spiel{
    private Spieler[] spieler;
    private static int aktuellerSpieler;
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private Feld[] feld;
    private View view;
    private int spielzustand; //  1 = "Baumodus" oder  2 = "Schiessmodus"
    
    public Spiel(){
        spieler = new Spieler[2];
        spieler[0] = new Spieler(0);
        spieler[1] = new Spieler(1);
        feld = new Feld[2];
        feld[0] = new Feld();
        feld[1] = new Feld();
        aktuellerSpieler = 0;
        aktuellesFeld = 1;
        spielzustand = 1;
        view = new View(this);
    }
    
    public void click(int x, int y){
        if (spielzustand == 1){
            
        }
        else{
            spieler[aktuellerSpieler].gibFeld().trefferEigenesFeld(x, y);
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
