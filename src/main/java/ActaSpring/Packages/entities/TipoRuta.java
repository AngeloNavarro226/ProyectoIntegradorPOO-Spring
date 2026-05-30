
package ActaSpring.Packages.entities;


public class TipoRuta {
    private String descTipoRuta;
    private String nombreTipoRuta;

    public TipoRuta() {
    }

    public TipoRuta(String descTipoRuta, String nombreTipoRuta) {
        this.descTipoRuta = descTipoRuta;
        this.nombreTipoRuta = nombreTipoRuta;
    }

    public String getDescTipoRuta() {
        return descTipoRuta;
    }

    public void setDescTipoRuta(String descTipoRuta) {
        this.descTipoRuta = descTipoRuta;
    }

    public String getNombreTipoRuta() {
        return nombreTipoRuta;
    }

    public void setNombreTipoRuta(String nombreTipoRuta) {
        this.nombreTipoRuta = nombreTipoRuta;
    }
    
    public boolean esInternacional(){
        return nombreTipoRuta == "Internacional";
    }
    
    public boolean esNacional(){
        return nombreTipoRuta == "Nacional";
    }
    
    public boolean esProvincial(){
        return nombreTipoRuta == "Provincial";
    }
}
