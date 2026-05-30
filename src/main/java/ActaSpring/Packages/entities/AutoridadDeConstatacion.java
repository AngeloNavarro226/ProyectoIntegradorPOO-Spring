
package ActaSpring.Packages.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;





@Entity
@Table(name = "autoridades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class AutoridadDeConstatacion extends Persona {

    
    @Column(name = "nro_placa")
    private int idPlaca;
    
    @Column(name = "nro_legajo")
    private int idLegajo;


    


    
}
