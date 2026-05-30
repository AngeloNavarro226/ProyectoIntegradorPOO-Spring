
package ActaSpring.Packages.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;







@Entity
@Table(name = "rutas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Ruta extends Base {


    
    private String nombreRuta;
    private String kmRuta;
    
    @Transient
    private TipoRuta tipo;


    
    
    public boolean esRutaInternacional(){
        return tipo.esInternacional();
    }
    
    public boolean esRutaNacional(){
        return tipo.esNacional();
    }
    
    public boolean esRutaProvincial(){
        return tipo.esProvincial();
    }
}
