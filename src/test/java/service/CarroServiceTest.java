package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CarroServiceTest {

//    CarroService carroService;
//    CarroService carroService = new CarroServiceImpl();

    @Ignore
    @Before
    public void setup() {
    }

    @Test
    public void umCarroDeveIniciarDesligado() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);

        //Quando:

        // Então:
        Assert.assertFalse(carro.isLigado());
    }

    @Test
    public void deveLigarCorretamente() {
        //Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);
        //Quando:
        carroService.ligar(carro);
        //Então:
        Assert.assertTrue(carro.isLigado());
    }
    @Test
    public void deveAcelerarCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);
        carroService.ligar(carro);

        // Quando:
        carroService.acelerar(carro, 10);

        // Então:
        Assert.assertTrue(true);
        Assert.assertEquals(carro.getVelocidadeAtual(), 10);
    }

    @Test
    public void deveFrearCorretamente() {
        // Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);

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
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);
        carroService.estadoAtual(carro);
        carroService.ligar(carro);
        //Quando:
        carroService.ligar(carro);
        //Então

    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {
        //Dado:
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);
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
        CarroService carroService = new CarroServiceImpl();
        Carro carro = new Carro("Preto", "Pegout", "207", 2020, 300);
        carroService.ligar(carro);
        //Quando:

        //Então:
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(0, carro.getVelocidadeAtual());
    }


}
