
package ActaSpring.Packages.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;


@Entity
@Table(name = "marcas_auto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Marca extends Base {
    

    
    
    private String marcaAuto;
    
    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;


    public String queModelo(){
        return modelo.getModeloAuto();
    }
}
