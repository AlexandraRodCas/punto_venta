package ObjetoNegocio;

import ObjetoNegocio.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T13:57:47")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile ListAttribute<Cliente, Venta> ventas;
    public static volatile SingularAttribute<Cliente, String> telefono1;
    public static volatile SingularAttribute<Cliente, String> telefono2;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, Long> idcliente;
    public static volatile SingularAttribute<Cliente, String> rfc;

}