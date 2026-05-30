
package ActaSpring.Packages.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import  java.util.List;





@Entity
@Table(name = "infracciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Infraccion extends Base {

    
    
    private String descipInfraccion;
    private double importedeInfraccion;
    
    @Transient
    private List<TipoDeInfraccion> InfraccionNomenclada = new ArrayList();


    public List<TipoDeInfraccion> getTipoDeInfraccion() {
        return InfraccionNomenclada;
    }

    public void addInfraccionNomenclada(TipoDeInfraccion InfraccionNomenclada) {
        this.InfraccionNomenclada.add(InfraccionNomenclada);
    }
    
    public void removeInfraccionNomenclada(TipoDeInfraccion InfraccionNomenclada) {
        this.InfraccionNomenclada.add(InfraccionNomenclada);
    }

    
    
}
