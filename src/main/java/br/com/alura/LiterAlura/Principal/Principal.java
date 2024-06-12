package br.com.alura.LiterAlura.Principal;

import br.com.alura.LiterAlura.Models.Authors;
import br.com.alura.LiterAlura.Models.Autor;
import br.com.alura.LiterAlura.Models.Dados;
import br.com.alura.LiterAlura.Models.Livro;
import br.com.alura.LiterAlura.Repository.IAutoresRepository;
import br.com.alura.LiterAlura.Repository.ILivrosRepository;
import br.com.alura.LiterAlura.Service.ConsumoApi;
import br.com.alura.LiterAlura.Service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner scanner= new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();
    private ILivrosRepository livrosRepository;
    private IAutoresRepository autoresRepository;
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private String menu = "\n-----------------\n"
            +"Escolha o número de sua opção:\n"
            +"1 - Buscas livro pelo título.\n"
            +"2 - Listar livros registrados.\n"
            +"3 - Listar Autores registrados.\n"
            +"0 - Sair\n";

    public Principal(ILivrosRepository livrosRepository,IAutoresRepository autoresRepository) {
        this.livrosRepository = livrosRepository;
        this.autoresRepository = autoresRepository;
    }


    public void exibirMenu(){

        var opcao = -1;

        do {
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 0:
                    System.out.println("Saindo....");
                    break;
                case 1:
                    buscarLivros();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                default:
                    System.out.println("Opção ínvalida! Digite uma opção valida.");
                    break;
            }

        }while (opcao!=0);


    }

    private void listarAutoresRegistrados() {

        autores = autoresRepository.findAll();

        System.out.println("Autores: ");
        autores.stream().forEach(System.out::println);

    }

    private void listarLivrosRegistrados() {
        try {
            livros = livrosRepository.findAll();

            livros.stream().
                    sorted(Comparator.comparing(Livro::getTitle))
                    .forEach(System.out::println);
        }catch (NullPointerException e){
            System.out.println("Erro: Sem livros registrados! "+e.getMessage());
        }
    }

    private void buscarLivros() {
        System.out.println("Digite o nome do livro: ");
        var nomeLivro = scanner.nextLine();

        var json = consumoApi.comunicaoApi(nomeLivro);
        Dados dados = converteDados.obterDados(json, Dados.class);
        Livro livro = new Livro(dados);
        Autor autor = new Autor(dados.results().get(0).authors().get(0));

        Optional<Livro> livroBuscado = livrosRepository.findByTitleContaining(livro.getTitle());
        Optional<Autor> autorBuscado = autoresRepository.findByNomeContaining(autor.getNome());

        if (autorBuscado.isPresent()){
            var autorEncontrado = autorBuscado.get();
            autorEncontrado.setLivros(livro);
            autoresRepository.save(autorEncontrado);
        }else{
            autor.setLivros(livro);
            autoresRepository.save(autor);
        }

        if (livroBuscado.isPresent()){
            System.out.println("Livro cadastrado no Banco");
        }else {
            livrosRepository.save(livro);
        }

        System.out.println(livro);
    }
}
