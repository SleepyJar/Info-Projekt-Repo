public class Spieler{
    
       private int spielernummer;
        public Feld spielerFeld;
        public int anzahlaufzustellendeSchiffe; //damit bei schiffeAufstellen das richtige gesetzt wird, -1 ist nach vollendung desSchiffebauprozesses
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
          anzahlaufgestellteSchiffe = 9;
        
      }
      public Feld gibFeld(){
        
        return spielerFeld;
        }
        public void schiffeAufstellen(int x, int y,String Ausrichtung){
        switch(anzahlaufgestellteSchiffe){ 
            case 0: 
            uboot1 = new Schiff(2, x, y, Ausrichtung);
            anzahlaufzustellendeSchiffe--;
            break;
            case 1: 
            uboot2 = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 2: 
            uboot3 = new Schiff(2, x, y, Ausrichtung);
                aanzahlaufzustellendeSchiffe--;
            break;
            case 3: 
            uboot4 = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 4:
            zerstoerer1 = new Schiff(3, x, y, Ausrichtung);
                anzahlaufgestellteSchiffe--;
            break;
            case 5:
            zerstoerer2 = new Schiff(3, x, y, Ausrichtung);
                anzahlaufgestellteSchiffe--;
            break;
            case 6:
            zerstoerer3 = new Schiff(3, x, y, Ausrichtung);
               anzahlaufzustellendeSchiffe--;
            break;
            case 7:
            kreuzer1 = new Schiff(4, x, y, Ausrichtung);
                 anzahlaufzustellendeSchiffe--1
            break;
            case 8:
            kreuzer2 = new Schiff(4, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 9:
            schlachtschiff = new Schiff(5, x, y, Ausrichtung);  
                
            Spiel.beendeZug();
            anzahlaufzustellendeSchiffe== -1;
                
               
            
            default: 
            System.out.println("Fehler"); 
            
        } 
        
    public String naechstesSchiff geben(){
    //gibt das naechste, aufstellbare Schiff und seine Laenge an
    
    switch(anzahlaufgestellteSchiffe){ 
            case 0: 
            return "U-Boot, 2";
            break;
            case 1: 
            return "U-Boot, 2";
            break;
            case 2: 
            return "U-Boot, 2";
            break;
            case 3: 
            eturn "U-Boot, 2";;
            break;
            case 4:
            return "Zerstoerer, 3";
            break;
            case 5:
            return "Zerstoerer, 3";
            break;
            case 6:
            return "Zerstoerer, 3";
            break;
            case 7:
            return "Kreuzer, 4"
            break;
            case 8:
            return "Kreuzer, 4";
            break;
            case 9:
            return "Schlachtschiff, 5";
                
            
            default: 
            System.out.println("Fehler"); 
    }
}
