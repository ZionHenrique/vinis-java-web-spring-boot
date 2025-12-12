package lrz.ifpe.vinisweb;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lrz.ifpe.vinisweb.model.Cliente;
import lrz.ifpe.vinisweb.model.Compra;
import lrz.ifpe.vinisweb.model.Funcionario;
import lrz.ifpe.vinisweb.model.Vinil;
import lrz.ifpe.vinisweb.repository.ClienteRepository;
import lrz.ifpe.vinisweb.repository.CompraRepository;
import lrz.ifpe.vinisweb.repository.FuncionarioRepository;
import lrz.ifpe.vinisweb.repository.VinilRepository;

@Configuration
@Profile("prod")
public class InitialDataLoader {

    @Bean
    public CommandLineRunner loadInitialData(
            ClienteRepository clienteRepo,
            VinilRepository vinilRepo,
            FuncionarioRepository funcionarioRepo,
            CompraRepository compraRepo) {
        
        return args -> {
            // Verificar se já existem dados
            if (clienteRepo.count() > 0) {
                System.out.println("✓ Base de dados já possui dados. Pulando inicialização.");
                return;
            }
            
            System.out.println("→ Inicializando base de dados com dados de teste...");
            
            // Inserir Clientes
            Cliente c1 = new Cliente();
            c1.setNome("João Silva");
            c1.setEmail("joao@example.com");
            c1.setCpf("12345678901");
            c1.setTipoCliente("Regular");
            clienteRepo.save(c1);
            
            Cliente c2 = new Cliente();
            c2.setNome("Maria Santos");
            c2.setEmail("maria@example.com");
            c2.setCpf("98765432109");
            c2.setTipoCliente("VIP");
            clienteRepo.save(c2);
            
            Cliente c3 = new Cliente();
            c3.setNome("Carlos Oliveira");
            c3.setEmail("carlos@example.com");
            c3.setCpf("55555555555");
            c3.setTipoCliente("Regular");
            clienteRepo.save(c3);
            
            // Inserir Vinis
            Vinil v1 = new Vinil();
            v1.setTitulo("Thriller");
            v1.setArtista("Michael Jackson");
            v1.setGenero("Pop");
            v1.setCodigo(1001);
            v1.setPrecoVenda(150.00);
            v1.setQtdDisponivel(10);
            vinilRepo.save(v1);
            
            Vinil v2 = new Vinil();
            v2.setTitulo("The Dark Side of the Moon");
            v2.setArtista("Pink Floyd");
            v2.setGenero("Rock Progressivo");
            v2.setCodigo(1002);
            v2.setPrecoVenda(180.00);
            v2.setQtdDisponivel(5);
            vinilRepo.save(v2);
            
            Vinil v3 = new Vinil();
            v3.setTitulo("Abbey Road");
            v3.setArtista("The Beatles");
            v3.setGenero("Rock");
            v3.setCodigo(1003);
            v3.setPrecoVenda(200.00);
            v3.setQtdDisponivel(8);
            vinilRepo.save(v3);
            
            Vinil v4 = new Vinil();
            v4.setTitulo("Rumours");
            v4.setArtista("Fleetwood Mac");
            v4.setGenero("Rock");
            v4.setCodigo(1004);
            v4.setPrecoVenda(160.00);
            v4.setQtdDisponivel(12);
            vinilRepo.save(v4);
            
            // Inserir Funcionários
            Funcionario f1 = new Funcionario();
            f1.setNome("Ana Costa");
            f1.setEmail("ana@loja.com");
            f1.setCpf("11111111111");
            f1.setCargo("Vendedor");
            f1.setSalario(2500.00);
            funcionarioRepo.save(f1);
            
            Funcionario f2 = new Funcionario();
            f2.setNome("Pedro Mendes");
            f2.setEmail("pedro@loja.com");
            f2.setCpf("22222222222");
            f2.setCargo("Gerente");
            f2.setSalario(4000.00);
            funcionarioRepo.save(f2);
            
            Funcionario f3 = new Funcionario();
            f3.setNome("Lucas Ferreira");
            f3.setEmail("lucas@loja.com");
            f3.setCpf("33333333333");
            f3.setCargo("Estoquista");
            f3.setSalario(2000.00);
            funcionarioRepo.save(f3);
            
            // Inserir Compras
            Compra compra1 = new Compra(new Date(), c1);
            compra1.adicionarItem(v1, 1);
            compra1.adicionarItem(v2, 1);
            compraRepo.save(compra1);
            
            Compra compra2 = new Compra(new Date(), c2);
            compra2.adicionarItem(v3, 1);
            compraRepo.save(compra2);
            
            System.out.println("✓ Base de dados inicializada com sucesso!");
        };
    }
}
