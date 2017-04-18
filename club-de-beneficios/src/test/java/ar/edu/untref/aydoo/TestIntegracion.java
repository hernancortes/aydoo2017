package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestIntegracion {
    
    private ClubDeBeneficios nuevoClub;
    private Cliente carlos;
    private Cliente juan;
    private Establecimiento heladeriaA;
    private Establecimiento restoranB;
    private Establecimiento libreriaElAltillo;
    private Sucursal sucursalHeladeriaA_S1;
    private Sucursal sucursalHeladeriaA_S2;
    private Sucursal sucursalRestoranB_S3;
    private Sucursal sucursalLibreriaElAltillo_S4;
    private Producto kiloDeHelado;
    private Producto menuEjecutivo;
    private Producto libroMartinFierro;
    private Producto libroElCantarDelCid;
    private Integer mes;
    private Integer anio;
    private BeneficioDescuento beneficio50PorCientoDeDescuento;
    //private BeneficioDosPorUno beneficioDosPorUno;

    @Before
    public void inicializar() {
        nuevoClub = new ClubDeBeneficios();
        carlos = new Cliente("Carlos", "carlos@gmail.com", Tarjeta.CLASSIC);
        juan = new Cliente("Juan", "juan@gmail.com", Tarjeta.PREMIUM);
        heladeriaA = new Establecimiento("Heladeria A");
        restoranB = new Establecimiento("Restoran B");
        libreriaElAltillo = new Establecimiento("Libreria El Altillo");
        sucursalHeladeriaA_S1 = new Sucursal("Heladeria A - Sucursal S1", heladeriaA);
        sucursalHeladeriaA_S2 = new Sucursal("Heladeria A - Sucursal S2", heladeriaA);
        sucursalRestoranB_S3 = new Sucursal("Restoran B - Sucursal S3", restoranB);
        sucursalLibreriaElAltillo_S4 = new Sucursal("Libreria El Altillo - Sucursal S4", libreriaElAltillo);
        kiloDeHelado = new Producto("1 kilo de helado", 100);
        menuEjecutivo = new Producto("1 menu ejecutivo", 200);
        libroMartinFierro = new Producto("1 libro Martin Fierro", 300);
        libroElCantarDelCid = new Producto("1 libro El Cantar del Cid", 150);
        mes = 4;
        anio = 2017;
        nuevoClub.agregarEstablecimiento(this.restoranB);
        nuevoClub.agregarEstablecimiento(this.heladeriaA);
        heladeriaA.agregarSucursal(sucursalHeladeriaA_S1);
        heladeriaA.agregarSucursal(sucursalHeladeriaA_S2);
        restoranB.agregarSucursal(sucursalRestoranB_S3);
        libreriaElAltillo.agregarSucursal(sucursalLibreriaElAltillo_S4);
        beneficio50PorCientoDeDescuento = new BeneficioDescuento(Tarjeta.PREMIUM, 50);
        //beneficioDosPorUno = new BeneficioDosPorUno();
    }
    
    @Test
	public void juanCompraUnKiloDeHeladoQueVale100ConBeneficioDe50PorCientoDeDescuentoElMontoAPagarDeberiaSerDe50Pesos() throws Exception{
            List<Producto> productosAComprar = new ArrayList<>();
            productosAComprar.add(kiloDeHelado);
            Operacion nuevaOperacion = new Operacion(beneficio50PorCientoDeDescuento, sucursalHeladeriaA_S1, productosAComprar, juan, 4, 2017);		
            double resultadoEsperado = 100 - (100 * 0.5);

            Assert.assertEquals(resultadoEsperado, nuevaOperacion.getMontoTotalConDescuentos(), 0.005);
	}
        
}
