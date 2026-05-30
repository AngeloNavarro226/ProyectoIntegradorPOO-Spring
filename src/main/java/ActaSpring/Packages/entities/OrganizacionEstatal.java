
package ActaSpring.Packages.entities;


public class OrganizacionEstatal {
    private String nombreOrganizacion;
    private String localidad;

    public OrganizacionEstatal() {
    }

    public OrganizacionEstatal(String nombreOrganizacion, String localidad) {
        this.nombreOrganizacion = nombreOrganizacion;
        this.localidad = localidad;
    }

    public String getNombreOrganizacion() {
        return nombreOrganizacion;
    }

    public void setNombreOrganizacion(String nombreOrganizacion) {
        this.nombreOrganizacion = nombreOrganizacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
}
