public class Spiel{
    private Spieler[] spieler;
    private int aktuellerSpieler; //0 und 1
    private int andererSpieler; //spieler der nicht am Zug ist, damit der gegnerische Schuss angezeigt wird
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
    
    public void click(int x, int y){
      if(aktuellesFeld == aktuellerSpieler) {     
        if (spielzustand == 1){
                bauclick(x, y);
            }
            else{
                schussclick(x, y);
            }
      }
    }
    
    public void bauclick(int x, int y, int spielerFeld){
        if(spieler[aktuellerSpieler].schiffeAufstellen(x, y, baurichtung)==false){
        
        }
    }
    
    public void schussclick(int x, int y, int spielerFeld){
        int schussergebnis = spieler[andererSpieler].gibFeld().trefferEigenesFeld(x, y);
        spieler[aktuellerSpieler].gibFeld().setGegnerFeld(x,y, schussergebnis);
        
        
        }
    }
    
    public void baurichtungAendern(){
        if (baurichtung == "vertikal"){
            baurichtung = "horizontal";
        }
        else{
            baurichtung = "vertikal";
        }
    }
    public void beendeZug(){
    
        if(aktuellerSpieler == 0){
            aktuellerSpieler = 1;
            andererSpieler = 0;
        }
        else
        {
            aktuellerSpieler =0;
            andererSpieler =1;
        }
        
    }
    public void setAktuellesFeld(int aktuellesFeldNeu){
    
        aktuellesFeld =aktuellesFeldNeu
    }
    
}
