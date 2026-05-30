



package ActaSpring.Packages.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "actas_constatacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class ActaDeConstatacion extends Base {

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Infraccion> infraccion = new ArrayList<>();
    
    
    private String fechaDeLabrado;
    private String horaDeLabrado;
    private String fechaVtoPagoVolun;
    private String lugarDeConstatacion;
    

    
    
    private String observaciones;
    
    @Transient
    private OrganizacionEstatal organizacion;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;
    
    @Transient
    private EstadoDelActa estadoActa;
    
    @ManyToOne
    @JoinColumn(name = "autoridad_id")
    private AutoridadDeConstatacion autoridadConstatacion;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "licencia_id")
    private Licencias licencia;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;


    public void addInfraccion(Infraccion infraccion) {
        this.infraccion.add(infraccion);
    }
    
    public void removeInfraccion(Infraccion infraccion) {
        this.infraccion.remove(infraccion);
    }



    

    
}
