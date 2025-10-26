package demo;

import models.PessoaModel;
import models.ProdutoModel;

public class AdministrativoApp {
    public static void main(String[] args) {
        System.out.println("Aplicação administrativa iniciada.");
        PessoaModel.listarPessoas();
        ProdutoModel.listarProdutos();
    }
}
