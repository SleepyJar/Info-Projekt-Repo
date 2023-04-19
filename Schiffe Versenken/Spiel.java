public class Spiel{
    private Spieler spieler1;
    private Spieler spieler2;
    private int aktuellerSpieler;
    private int aktuellesFeld //aktuelles Feld der beiden Felder
    private View view;
    
    public Spiel(){
        spieler1 = new Spieler();
        spieler2 = new Spieler();
        aktuellerSpieler = 1;
        aktuellesFeld = 1
    }
    
    public void beendeZug{
    
        if(aktuellerspieler == 1){
            aktuellerSpieler = 2;
        }
        else
        {
            aktuellerSpieler =1;
        }
        
    }
}
