
package ActaSpring.Packages.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.io.Serializable;





@Entity
@Table(name = "vehiculos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Vehiculo extends Base {
    

    
    private String color;
    private String dominio;
    private int anioPatentamiento;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "marca_id")
    private Marca marca;


    
}
