

public class Feld
{
    private int zugehörigerSpieler;
    private int [][]gegnerFeld ;
    //0 = leeres Feld, 1 = getroffenes leeres Feld, 2 getroffenes Schiff, 3 gesunkenes SChiff
     private int [][] eigenesFeld;
    //0 leeres Feld, 1 getroffenes leeres Feld, 2 eigenes Schiff, 3 getroffenes Schiff
    public Feld(int Spieler){
    
        gegnerFeld = new int[10][10];
        eigenesFeld = new int[10][10];
    }
    public int trefferEigenesFeld(int x, int y){
    
        if(eigenesFeld[x][y]== 2)
        {
            eigenesFeld[x][y] = 3;
            return 3;
            
        }
         else if(eigenesFeld[x][y] ==0)
         {
            eigenesFeld[x][y]=1;
            Spiel.beendeZug();
             return 1;
         }  
        return -1; // 3= Treffer, 1 ist kein Treffer, -1 ist ein invalider Schuss
    
    }
    public int gibFeldPosition(int x, int y){
    
        return eigenesFeld[x][y];
    }
    public int gibGegnerFeldPosition(int x, int y){
    
        return gegnerFeld[x][y];
    }
    public void setFeldPosition(int x, int y, int neuesInt){
    
         eigenesFeld[x][y]= neuesInt ;
    }
    public void setGegnerFeldPosition(int x, int y, int neuesInt){
    
        gegnerFeld[x][y] = neuesInt;
    }
}
