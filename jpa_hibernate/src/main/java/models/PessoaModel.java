package models;

public class PessoaModel {
    public static void create() {
        System.out.println("Criando pessoa...");
    }

    public static void findById(Long id) {
        System.out.println("Buscando pessoa por ID: " + id);
    }

    public static void findAll() {
        System.out.println("Listando todas as pessoas...");
    }

    public static void update(Long id) {
        System.out.println("Atualizando pessoa com ID: " + id);
    }

    public static void delete(Long id) {
        System.out.println("Removendo pessoa com ID: " + id);
    }
}
