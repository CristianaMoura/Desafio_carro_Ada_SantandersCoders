package service;
import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CarroServiceTest {

    private CarroService carroService;
    private Carro carro;
    @Before
    public void setup() {
        carro = new Carro("Preto", "Peugeot", "308", 2020, 300);
        carroService = new CarroServiceImpl();
    }
    @Test
    public void umCarroDeveIniciarDesligado() {
        // Dado:
        //Quando:
        // Então:
        Assert.assertFalse(carro.isLigado());
    }
    @Test
    public void deveLigarCorretamente() {
        //Dado:
        //Quando:
        carroService.ligar(carro);
        //Então:
        Assert.assertTrue(carro.isLigado());
    }
    @Test
    public void deveAcelerarCorretamente() {
        // Dado:
        // Quando:
        carroService.acelerar(carro, 10);
        // Então:
        Assert.assertTrue(true);
        Assert.assertEquals(carro.getVelocidadeAtual(), 10);
    }
    @Test
    public void deveFrearCorretamente() {
        // Dado:
        // Quando:
        carroService.ligar(carro);
        carroService.acelerar(carro, 20);
        carroService.frear(carro, 10);
        // Então:
        Assert.assertEquals(carro.getVelocidadeAtual(), 10);
    }
    @Test
    public void naoDeveLigarcarroEmMovimento() {
        //Dado:
        carroService.estadoAtual(carro);
        carroService.ligar(carro);
        //Quando:
        carroService.ligar(carro);
        //Então
    }
    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Dado:
        carroService.ligar(carro);
        //Quando:
        carroService.acelerar(carro, 50);
        carroService.acelerar(carro, 250);

        //Então:
        Assert.assertEquals(carro.getVelocidadeMaxima(), carro.getVelocidadeAtual());
    }
    @Test
    public void naoDeveAceitarVelocidadeNegativa() {
        //Dado:
        carroService.ligar(carro);
        //Quando:
        //Então:
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(0, carro.getVelocidadeAtual());
    }
@Test
    public void mostrarEstadoAtual(){
        //Dado:
        carroService.ligar(carro);
        //Quando:

       String estado =  carroService.estadoAtual(carro);
        //Então:
        Assert.assertNotNull(estado);
        Assert.assertTrue(carro.isLigado());

    }
}
