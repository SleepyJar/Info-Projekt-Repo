public class Spiel{
    private Spieler[] spieler;
    private static int aktuellerSpieler;
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private Feld[] feld;
    private View view;
    private int spielzustand; //  1 = "Baumodus" oder  2 = "Schiessmodus"
    private String baurichtung; // "vertikal", "horizontal"
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
    
    public void click(int x, int y, int spieler){
        if (spielzustand == 1){
            bauclick(x, y);
        }
        else{
            schussclick(x, y);
        }
        
    }
    
    public void bauclick(int x, int y){
        if(spieler[aktuellerSpieler].schiffeAufstellen(x, y, baurichtung)==false){
        
        }
    }
    
    public void schussclick(int x, int y){
        spieler[aktuellerSpieler].gibFeld().trefferEigenesFeld(x, y);
        
        
        }
    
    
    public void baurichtungAendern(){
        if (baurichtung == "vertikal"){
            baurichtung = "horizontal";
        }
        else{
            baurichtung = "vertikal";
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
    
}
