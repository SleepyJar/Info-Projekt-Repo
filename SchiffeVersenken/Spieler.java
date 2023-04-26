public class Spieler{
    
       private int spielernummer;
        public Feld spielerFeld;
        public int anzahlaufgestelleSchiffe; //damit bei schiffeAufstellen das richtige gesetzt wird
        public Schiff uboot1;
        public Schiff uboot2;
        public Schiff uboot3;
        public Schiff uboot4;
        public Schiff zerstoerer1;
        public Schiff zerstoerer2;
        public Schiff zerstoerer3;
        public Schiff kreuzer1;
        public Schiff kreuzer2;
        public Schiff schlachtschiff;
      public Spieler(int spielernr){
          spielernummer = spielernr;
          spielerFeld = new Feld();
        
        
      }
      public Feld gibFeld(){
        
        return spielerFeld;
        }
        public void schiffeAufstellen(int x, int y,String Ausrichtung){
        switch(anzahlaufgestellteSchiffe){ 
            case 0: 
            uboot1 = new Schiff(2, x, y, Ausrichtung); 
            break;
            case 1: 
            uboot2 = new Schiff(2, x, y, Ausrichtung); 
            break;
            case 2: 
            uboot3 = new Schiff(2, x, y, Ausrichtung); 
            break;
            case 4: 
            uboot1 = new Schiff(2, x, y, Ausrichtung);
            break;
            case 4:
            zerstoerer1 = new Schiff(3, x, y, Ausrichtung);
            break;
            case 5:
            zerstoerer2 = new Schiff(3, x, y, Ausrichtung);
            break;
            case 6:
            zerstoerer3 = new Schiff(3, x, y, Ausrichtung);
            break;
            case 7:
            kreuzer1 = new Schiff(4, x, y, Ausrichtung);
            break;
            case 8:
            kreuzer2 = new Schiff(4, x, y, Ausrichtung);
            break;
            case 9:
            schlachtschiff = new Schiff(5, x, y, Ausrichtung);    
            Spiel.beendeZug();
            anzahlaufgestelleSchiffe=0;
            
            default: 
            System.out.println("i liegt nicht zwischen null und drei"); 
            
        } 
        }
    
}
