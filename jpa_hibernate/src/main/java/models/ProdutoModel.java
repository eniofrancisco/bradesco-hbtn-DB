package models;

public class ProdutoModel {
    public static void create() {
        System.out.println("Criando produto...");
    }

    public static void findById(Long id) {
        System.out.println("Buscando produto por ID: " + id);
    }

    public static void findAll() {
        System.out.println("Listando todos os produtos...");
    }

    public static void update(Long id) {
        System.out.println("Atualizando produto com ID: " + id);
    }

    public static void delete(Long id) {
        System.out.println("Removendo produto com ID: " + id);
    }
}
