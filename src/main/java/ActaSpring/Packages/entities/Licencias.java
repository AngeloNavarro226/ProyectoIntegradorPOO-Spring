
package ActaSpring.Packages.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "licencias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Licencias extends Base {
    

    private String fechaDeVto;
    private int puntosInicialesLicencia;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conductor_id")
    private Conductor conductor = new Conductor();



    
    
    
}
