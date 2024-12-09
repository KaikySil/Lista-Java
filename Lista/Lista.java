import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lista {
    private List produtos;

    public Lista(List produtos){
        this.produtos = produtos;
    }

    public void adicionarItem(String itemAdicionado){
        produtos.add(itemAdicionado);
    }

    public boolean verificador(){
        return produtos.isEmpty();
    }

    public void removerItem(String itemRemovido){
        if (produtos.contains(itemRemovido)) {
            System.out.printf("Produto '%s' removido com sucesso! \n", itemRemovido);
            produtos.remove(itemRemovido);
        }
        else {
            System.out.printf("Produto '%s' não está na lista! \n", itemRemovido);
        }
    }

    public void verLista(){
        System.out.println("Lista dos produtos:");
        System.out.println(produtos + "\n");
    }

    public void obterIndice(String itemIndice){
        if (produtos.contains(itemIndice)) {
            int indice = produtos.indexOf(itemIndice);
            System.out.printf("Produto '%s' está na posição: '%d' \n", itemIndice, indice);
        } else {
            System.out.printf("Produto '%s' não está na lista! \n", itemIndice);
        }
    }

    public void limparLista(){
        produtos.clear();
        System.out.println("\n Lista Limpa! \n");
    }

    public void organizarLista(){
        Collections.sort(produtos);
        System.out.println("Lista organizada por ordem alfabética! \n");
    }

    public static void main(String[] args) {
        ArrayList<String> listaItens = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Lista itens = new Lista(listaItens);

        while (true){
            boolean listaVazia = itens.verificador();
            System.out.println("""
                    1 - Adicionar produto\s
                    2 - Remover produto\s
                    3 - Buscar produto\s
                    4 - Ver lista\s
                    5 - Organizar\s
                    6 - Limpar lista\

                    7 - Encerrar""");
            String opcao = input.nextLine();
            switch (opcao){

                case "1": // Adicionar produto
                    System.out.println("Digite o nome do produto que deseja adicionar:");
                    while (true){
                        System.out.println("Digite '0' para parar de adicionar");
                        String produtoAdicionado = input.nextLine();
                        if (produtoAdicionado.equals("0")){
                            break;
                        }
                        else {
                            itens.adicionarItem(produtoAdicionado);
                        }
                    }
                    break;

                case "2": // Remover produto
                    if (listaVazia){
                        System.out.println("\n A lista está vazia! \n");
                    }
                    else {
                        System.out.println("Digite o nome do produto que deseja remover:");
                        String produtoRemovido = input.nextLine();
                        itens.removerItem(produtoRemovido);
                    }
                    break;

                case "3": // Buscar produto
                    if (listaVazia){
                        System.out.println("\n A lista está vazia! \n");
                    }
                    else {
                        System.out.println("Digite o nome do produto que deseja buscar sua posição:");
                        String produtoIndice = input.nextLine();
                        itens.obterIndice(produtoIndice);
                    }
                    break;

                case "4": // Ver lista
                    itens.verLista();
                    break;

                case "5": // Organizar lista por ordem alfabética
                    if (listaVazia){
                        System.out.println("\n A lista está vazia! \n");
                    }else {
                        itens.organizarLista();
                    }
                    break;

                case "6": // Apagar todos dados da lista
                    itens.limparLista();
                    break;

                case "7": // Encerrar programa
                    System.out.println("\n Fechando programa... \n");
                    break;

                default:
                    System.out.println("\n Opção inválida! \n");
            }
            if (opcao.equals("7")){
                break;
            }
        }
    }
}