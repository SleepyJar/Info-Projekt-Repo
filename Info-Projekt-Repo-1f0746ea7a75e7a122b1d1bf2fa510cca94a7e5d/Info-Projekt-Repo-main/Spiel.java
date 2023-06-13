public class Spiel{
    private Spieler[] spieler;
    private int aktuellerSpieler; //0 und 1
    private int andererSpieler; //spieler der nicht am Zug ist, damit der gegnerische Schuss angezeigt wird
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private Feld[] feld;
    private View view1;
    private View view2; //Die Sicht des einen und des anderen spielers
    private String spielzustand; //  "Baumodus", "Schiessmodus"
    private String baurichtung; // "vertikal", "horizontal"
    private Datenbankverbindung liste;
    public Spiel(){
        spieler = new Spieler[2];
        feld = new Feld[2];
        feld[0] = new Feld(this);
        feld[1] = new Feld(this);
        spieler[0] = new Spieler(feld[0], this, 0);
        spieler[1] = new Spieler(feld[1], this, 1);
        aktuellerSpieler = 0;
        aktuellesFeld = 0;
        spielzustand = "Baumodus";
        baurichtung = "vertikal";
        view1 = new View(this, 1);
        view2 = new View(this, 2);
        view2.setVisible(false);
    }

    public void click(int x, int y){
        if (spielzustand == "Baumodus"){
            bauclick(x, y);
        }
        else{
            schussclick(x, y);
        }
    }

    public void bauclick(int x, int y){
        if(spieler[aktuellerSpieler].schiffeAufstellen(x, y, baurichtung) == true){
            spieler[aktuellerSpieler].schiffeAufstellen(x, y, baurichtung);
        }
        else{
            System.out.println("Invalide Position");
        }
    }

    public void schussclick(int x, int y){
        int schussergebnis = spieler[andererSpieler].gibFeld().trefferEigenesFeld(x, y);
        spieler[aktuellerSpieler].gibFeld().setGegnerFeldPosition(x, y, schussergebnis);

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
            aktuellerSpieler = 0;
            andererSpieler = 1;
        }
        
    }
    
    public void sichtWechsel(){
    
        if(aktuellerSpieler == 0){
        
            view1.setVisible(false);
            view2.setVisible(true);
        }
        else{
            view1.setVisible(false);
            view2.setVisible(true);
            
        }
    }
    public void setAktuellesFeld(int aktuellesFeld){
        this.aktuellesFeld = aktuellesFeld;
    }

    public int getaktuellerSpieler(){
        return aktuellerSpieler;
    }

    public Spieler spielerGeben(){
        return spieler[aktuellerSpieler];
    }

    public String spielzustandGeben(){
        return spielzustand;
    }

    public String baurichtungGeben(){
        return baurichtung;
    }
}
