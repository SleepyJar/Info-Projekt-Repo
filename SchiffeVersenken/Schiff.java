public class Schiff{
    private int laenge;
    private int x;
    private int y;
    private int treffer;
    private String ausrichtung;
    private boolean gesunken;
    public Schiff(int laenge, int x, int y, String ausrichtung){
        this.laenge = laenge;
        this.x = x;
        this.y = y;
        this.ausrichtung = ausrichtung;
    }
    
    public void treffen(int x, int y){
        treffer ++;
        if(treffer == length){
        
            this.schiffSenken();
        }
    }
    
    public void schiffSenken(){
        gesunken = true;
    }
}
