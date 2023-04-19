

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
    public void trefferEigenesFeld(int x, int y){
    
        if(eigenesFeld[x][y]== 2)
        {
            eigenesFeld[x][y] = 3;
            
        }
         else if(eigenesFeld[x][y] ==0)
         {
            eigenesFeld[x][y]=1;
            Spiel.beendeZug();
         }  
        
     
    }
}
