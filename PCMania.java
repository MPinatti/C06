import java.util.ArrayList;
import java.util.List;

class HardwareBasico {
    String nome;
    float capacidade;

    HardwareBasico(String nome, float capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
}

class SistemaOperacional {
    String nome;
    int tipo; // Assuming 1 for 32-bit and 2 for 64-bit

    SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
}

class MemoriaUSB {
    String nome;
    int capacidade;

    MemoriaUSB(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
}

class Computador {
    String marca;
    float preco;
    HardwareBasico hardwareBasico;
    SistemaOperacional sistemaOperacional;
    List<MemoriaUSB> memoriasUSB = new ArrayList<>();

    Computador(String marca, float preco, HardwareBasico hardware, SistemaOperacional so) {
        this.marca = marca;
        this.preco = preco;
        this.hardwareBasico = hardware;
        this.sistemaOperacional = so;
    }

    void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$" + preco);
        System.out.println("Hardware Básico: " + hardwareBasico.nome + " " + hardwareBasico.capacidade);
        System.out.println("Sistema Operacional: " + sistemaOperacional.nome + " " + (sistemaOperacional.tipo == 1 ? "32-bit" : "64-bit"));
        System.out.print("Memória USB: ");
        if (memoriasUSB.isEmpty()) {
            System.out.println("Nenhuma");
        } else {
            memoriasUSB.forEach(usb -> System.out.println(usb.nome + " " + usb.capacidade + "GB"));
        }
    }

    void addMemoriaUSB(MemoriaUSB memoriaUSB) {
        memoriasUSB.add(memoriaUSB);
    }
}

class Cliente {
    String nome;
    long cpf;
    List<Computador> compras = new ArrayList<>();

    Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    float calculaTotalCompra() {
        float total = 0;
        for (Computador computador : compras) {
            total += computador.preco;
        }
        return total;
    }
    
    void adicionaCompra(Computador computador) {
        compras.add(computador);
    }
}

// Example usage
public class PCMania {
    public static void main(String[] args) {
        // Create components
        HardwareBasico cpu1 = new HardwareBasico("Pentium Core i3", 2200);
        SistemaOperacional so1 = new SistemaOperacional("Linux Ubuntu", 1);
        MemoriaUSB usb1 = new MemoriaUSB("Pen-drive 16GB", 16);

        // Create computer with those components
        Computador pc1 = new Computador("Positivo", 3300.00f, cpu1, so1);
        pc1.addMemoriaUSB(usb1);

        // Create client and add computer to his purchases
        Cliente cliente = new Cliente("João", 12345678901L);
        cliente.adicionaCompra(pc1);

        // Display PC configs
        pc1.mostraPCConfigs();
        
        // Calculate total purchase
        System.out.println("Total da compra: R$" + cliente.calculaTotalCompra());
    }
}
