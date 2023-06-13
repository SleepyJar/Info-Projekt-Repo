public class Feld
{
    private int zugehörigerSpieler;
    private int [][]gegnerFeld ;
    //0 = leeres Feld, 1 = getroffenes leeres Feld, 2 getroffenes Schiff, 3 gesunkenes Schiff
    private int [][] eigenesFeld;
    //0 leeres Feld, 1 getroffenes leeres Feld, 2 eigenes Schiff, 3 getroffenes Schiff
    private Spiel spiel;
    public Feld(Spiel spiel){
        this.spiel = spiel;
        gegnerFeld = new int[10][10];
        eigenesFeld = new int[10][10];
    }

    public int trefferEigenesFeld(int x, int y){

        if(eigenesFeld[x][y] == 2)
        {
            eigenesFeld[x][y] = 3;
            return 3;

        }
        else if(eigenesFeld[x][y] == 0)
        {
            eigenesFeld[x][y]=1;
            spiel.beendeZug();
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
    
    public boolean uepruefeValideSchiffposition(int x, int y){ //ueberprueft ob das Feld ein anliegendes Schiff hat

        boolean valide = true;

        for(int i = -1; i<2; i++){
            for(int z=-1; z<2; z++){
                if(x+i<0 || x+z<0){
                    valide = true;
                }
                else{
                    valide = (eigenesFeld[x+i][y+z] != 2);
                }

                if(valide== false){return valide;}
            }
        }
        return valide;

    }
}
