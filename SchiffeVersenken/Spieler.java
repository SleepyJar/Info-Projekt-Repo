public class Spieler{
    
       private int spielernummer;
        public Feld spielerFeld;
        public int anzahlaufzustellendeSchiffe; //damit bei schiffeAufstellen das richtige gesetzt wird, -1 ist nach vollendung desSchiffebauprozesses
      
        public Schiff[] eigeneSchiffe;
      public Spieler(int spielernr){
          spielernummer = spielernr;
          spielerFeld = new Feld();
          anzahlaufzustellendeSchiffe = 9;
          eigeneSchiffe = new Schiff[10];
            
      }
      public Feld gibFeld(){
        
        return spielerFeld;
        }
      public Schiff gibSchiff(int no){ //von 0-9
      
        return eigeneSchiffe[no];
      
      }
        public boolean schiffeAufstellen(int x, int y,String Ausrichtung){ //aktivieren bei Klick. Boolean ist wahr, wenn die Position invalide ist
        switch(anzahlaufzustellendeSchiffe){ 
            case 0: 
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(2, x, y, Ausrichtung);
            anzahlaufzustellendeSchiffe--;
            break;
            case 1: 
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 2: 
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 3: 
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(2, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 4:
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(3, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 5:
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(3, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 6:
            eigeneSchiffe[anzahlaufzustellendeSchiffe]= new Schiff(3, x, y, Ausrichtung);
               anzahlaufzustellendeSchiffe--;
            break;
            case 7:
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(4, x, y, Ausrichtung);
                 anzahlaufzustellendeSchiffe--;
            break;
            case 8:
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(4, x, y, Ausrichtung);
                anzahlaufzustellendeSchiffe--;
            break;
            case 9:
            eigeneSchiffe[anzahlaufzustellendeSchiffe] = new Schiff(5, x, y, Ausrichtung);  
                
            Spiel.beendeZug();
            anzahlaufzustellendeSchiffe= -1;
                
               
            
            default: 
            System.out.println("Fehler"); 
            }
            return baueSchiff(anzahlaufzustellendeSchiffe++);
        } 
        
    public String naechstesSchiffgeben(){
    //gibt das naechste, aufstellbare Schiff und seine Laenge an
    
        switch(anzahlaufzustellendeSchiffe){ 
                case 0: 
                return "U-Boot, 2";
                
                case 1: 
                return "U-Boot, 2";
                
                case 2: 
                return "U-Boot, 2";
                
                case 3: 
                return "U-Boot, 2";
                
                case 4:
                return "Zerstoerer, 3";
                
                case 5:
                return "Zerstoerer, 3";
                
                case 6:
                return "Zerstoerer, 3";
                
                case 7:
                return "Kreuzer, 4";
                
                case 8:
                return "Kreuzer, 4";
                
                case 9:
                return "Schlachtschiff, 5";
                    
                
                default: 
                System.out.println("Fehler");
                return null;
        }
    }
    
    public boolean baueSchiff(int noSchiff){ 
    // setzt ein bestimmtes Schiff im eigenem Feld um
        if(eigeneSchiffe[noSchiff].laengeGeben() +eigeneSchiffe[noSchiff].xGeben() <10){
                //fall innerhalb des Feldes
            if(eigeneSchiffe[noSchiff].ausrichtungGeben() == "vertikal"){
            
                
                    
                    for(int i =0; i<= eigeneSchiffe[noSchiff].laengeGeben();i++){
                       
                        if(spielerFeld.uepruefeValideSchiffposition(eigeneSchiffe[noSchiff].xGeben() , eigeneSchiffe[noSchiff].yGeben()+1)==false){
                        
                             anzahlaufzustellendeSchiffe++;
                            return false;
                        }
                        
                        
                    }
                    for(int i =0; i<= eigeneSchiffe[noSchiff].laengeGeben();i++){
                    
                    spielerFeld.setFeldPosition(eigeneSchiffe[noSchiff].xGeben()+i, eigeneSchiffe[noSchiff].yGeben(), 2);
                    }
                    return true;
                
            }
            else{ //horizontaler Fall
                
                for(int i =0; i<= eigeneSchiffe[noSchiff].laengeGeben();i++){
                       
                        if(spielerFeld.uepruefeValideSchiffposition(eigeneSchiffe[noSchiff].xGeben()+i, eigeneSchiffe[noSchiff].yGeben())==false){
                        
                             anzahlaufzustellendeSchiffe++;
                            return false;
                        }
                        
                        
                        
                    }
                for(int i =0; i<= eigeneSchiffe[noSchiff].laengeGeben();i++){
                    
                    spielerFeld.setFeldPosition(eigeneSchiffe[noSchiff].xGeben()+i, eigeneSchiffe[noSchiff].yGeben(), 2);
                    }
                    
                return true;
                }    
      
        }
        else{
                anzahlaufzustellendeSchiffe++;
                return false;
            }
    }
}
