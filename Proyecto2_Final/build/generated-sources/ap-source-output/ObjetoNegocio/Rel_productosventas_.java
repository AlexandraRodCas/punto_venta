package ObjetoNegocio;

import ObjetoNegocio.Producto;
import ObjetoNegocio.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T13:57:47")
@StaticMetamodel(Rel_productosventas.class)
public class Rel_productosventas_ { 

    public static volatile SingularAttribute<Rel_productosventas, Float> precio;
    public static volatile SingularAttribute<Rel_productosventas, Venta> venta;
    public static volatile SingularAttribute<Rel_productosventas, Long> idrel_productoventa;
    public static volatile SingularAttribute<Rel_productosventas, Integer> cantidad;
    public static volatile SingularAttribute<Rel_productosventas, Producto> producto;
    public static volatile SingularAttribute<Rel_productosventas, Float> montototal;

}