public class Spiel{
    private Spieler[] spieler;
   
    private static int aktuellerSpieler;
    private int aktuellesFeld; //aktuelles Feld der beiden Felder
    private View view;
    
    public Spiel(){
        spieler = new Spieler[2]
        spieler[0] = new Spieler();
        spieler[1] = new Spieler();
        aktuellerSpieler = 1;
        aktuellesFeld = 1;
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
    
    public void feldUpdateModel{}
}
