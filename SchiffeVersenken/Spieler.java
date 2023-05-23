public class Spieler{
    
       private int spielernummer;
        public Feld spielerFeld;
        public int anzahlaufzustellendeSchiffe; //damit bei schiffeAufstellen das richtige gesetzt wird, -1 ist nach vollendung desSchiffebauprozesses
      
        public Schiff[] eigeneSchiffe;
      public Spieler(int spielernr){
          spielernummer = spielernr;
          spielerFeld = new Feld();
          anzahlaufgestellteSchiffe = 9;
          eigeneSchiffe = new Schiff[10];
        
      }
      public Feld gibFeld(){
        
        return spielerFeld;
        }
      public Schiff gibSchiff(int no){ //von 0-9
      
        return eigeneSchiffe[no];
      
      }
        public boolean schiffeAufstellen(int x, int y,String Ausrichtung){ //aktivieren bei Klick. Boolean ist wahr, wenn die Position invalide ist
        switch(anzahlaufgestellteSchiffe){ 
            case 0: 
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(2, x, y, Ausrichtung);
            anzahlaufzustellendeSchiffe--;
            break;
            case 1: 
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 2: 
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 3: 
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 4:
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(3, x, y, Ausrichtung);
                anzahlaufgestellteSchiffe--;
            break;
            case 5:
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(3, x, y, Ausrichtung);
                anzahlaufgestellteSchiffe--;
            break;
            case 6:
            eigeneSchiffe[anzahlaufgestellteSchiffe]= new Schiff(3, x, y, Ausrichtung);
               anzahlaufzustellendeSchiffe--;
            break;
            case 7:
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(4, x, y, Ausrichtung);
                 anzahlaufzustellendeSchiffe--1
            break;
            case 8:
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(4, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 9:
            eigeneSchiffe[anzahlaufgestellteSchiffe] = new Schiff(5, x, y, Ausrichtung);  
                
            Spiel.beendeZug();
            anzahlaufzustellendeSchiffe== -1;
                
               
            
            default: 
            System.out.println("Fehler"); 
            }
            return pruefeSchiff(anzahlaufgestellteSchiffe++);
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
            return "U-Boot, 2";;
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
    }}
    
    public boolean pruefeSchiff(int noSchiff){ 
    // setzt ein bestimmtes Schiff im eigenem Feld um
        if(eigeneSchiffe[noSchiff] == "vertikal"){
        
            if(eigeneSchiffe[noSchiff].laengeGeben() +eigeneSchiffe[noSchiff].xGeben() <10){
                //fall Horizontal, innerhalb des Feldes
                
                for(int i =0; i=< eigeneSchiffe[noSchiff].laengeGeben();i++){
                   
                    if(ueberpruefeValideSchiffposition(eigeneSchiffe[noSchiff].xGeben() +i, eigeneSchiffe[noSchiff].yGeben())){
                    
                         
                    }
                    else{
                        anzahlaufgestellteSchiffe++;
                        return false;
                    }
                }
                }
            else{
                anzahlaufgestellteSchiffe++;
                return false;
            }
        }
        else{ //horizontaler Fall
            if(eigeneSchiffe[noSchiff].laengeGeben() +eigeneSchiffe[noSchiff].yGeben() <10){
                //fall vertikal, innerhalb des Feldes
                }
            else{ 
                anzahlaufgestellteSchiffe++;
                return false;
            }
        
        }    
      
    
    }
    
}
