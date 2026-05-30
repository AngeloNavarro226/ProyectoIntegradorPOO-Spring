
package ActaSpring.Packages.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "modelos_auto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited

public class Modelo extends Base {
    

      
    private String modeloAuto;
    
    
}
