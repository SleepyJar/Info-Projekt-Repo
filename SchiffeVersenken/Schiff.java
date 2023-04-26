public class Schiff{
    private int laenge;
    private int x;
    private int y;
    private boolean getroffen[][];
    private String ausrichtung;
    private boolean gesunken;
    public Schiff(int laenge, int x, int y, String ausrichtung){
        this.laenge = laenge;
        this.x = x;
        this.y = y;
        this.ausrichtung = ausrichtung;
    }
    
    public void trefferSetzen(int x, int y){
        getroffen[x][y] = true;
    }
    
    public void schiffSenken(){
        gesunken = true;
    }
}
