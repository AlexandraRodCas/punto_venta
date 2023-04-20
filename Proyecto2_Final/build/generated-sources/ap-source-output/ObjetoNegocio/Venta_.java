package ObjetoNegocio;

import ObjetoNegocio.Cliente;
import ObjetoNegocio.Rel_productosventas;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T13:57:47")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Long> idventa;
    public static volatile SingularAttribute<Venta, Calendar> fecha;
    public static volatile SingularAttribute<Venta, Float> montofinal;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Float> descuento;
    public static volatile ListAttribute<Venta, Rel_productosventas> rel_productosventas;

}