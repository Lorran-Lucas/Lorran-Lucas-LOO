import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SistemaEscola {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Turma> turmasCadastradas = new ArrayList<>();

    public void executar() throws Exception {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Definir a idade de um aluno");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Inserir Aluno na Turma");
            System.out.println("5. Remover Aluno da Turma");
            System.out.println("6. Listar Alunos da Turma");
            System.out.println("7. Remover todos alunos de uma turma");
            System.out.println("8. Cadastrar turmas a partir de um arquivo");
            System.out.println("9. Cadastrar alunos a partir de um arquivo");
            System.out.println("10. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    definirIdadeAluno();
                    break;
                case 3:
                    cadastrarTurma();
                    break;
                case 4:
                    inserirAlunoNaTurma();
                    break;
                case 5:
                try{
                    removerAlunoDaTurma();
                }
                catch(NullPointerException e){
                    System.out.println("\nTurma não encontrada");
                }
                    break;
                case 6:
                    listarAlunosDaTurma();
                    break;
                case 7:
                    removerTodosAlunosDaTurma();
                    break;
                case 8:
                try{
                    cadastrarTurmasPorArquivo();
                }
                catch(FileNotFoundException e){
                    System.out.println("\nArquivos de turma não encontrado!");

                }finally{}
                    
                    break;
                case 9:
                try{
                    cadastrarAlunosPorArquivo();
                }
                    catch(FileNotFoundException e){
                        System.out.println("\nArquivos de turma não encontrado!");
    
                    }finally{}
                        
                    break;
                case 10:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 10);
    }

    public <T> T buscarComando(String textoComando, List<T> lista, Function<T, String> keyExtractor) {
        System.out.print(textoComando);
        String input = scanner.nextLine();
        
        for (T item : lista) {
            if (keyExtractor.apply(item).equals(input)) {
                return item;
            }
        }
        return null; 
    }

    public Aluno buscarAlunoCmd(String textoComando) {
        return buscarComando(textoComando, alunosCadastrados, Aluno::getCpf);
    }

    public Turma buscarTurmaCmd(String textoComando) {
        return buscarComando(textoComando, turmasCadastradas, Turma::getCodigo);
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmasCadastradas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public void cadastrarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        
        if (alunosCadastrados.stream().anyMatch(aluno -> aluno.getCpf().equals(cpf))) {
            System.out.println("Aluno " + nome + " já cadastrado.");
        }
        else{
            Aluno aluno = new Aluno(nome, cpf);
            alunosCadastrados.add(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        }

    }

    public void definirIdadeAluno() {
        Aluno aluno = buscarAlunoCmd("Digite o CPF do aluno a ser editado: ");
        if (aluno != null) {
            System.out.print("Digite a idade do aluno: " + aluno.getNome());
            int idade = scanner.nextInt();
            if(idade<1)
            {
                throw new IllegalArgumentException("Ação rejeitada, a idade não pode conter valores negativos!");
            }
            scanner.nextLine();

            aluno.setIdade(idade);
            System.out.println(aluno.toString());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void cadastrarTurma() {
        System.out.print("Digite o nome da turma: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();
         
        if (turmasCadastradas.stream().anyMatch(turma -> turma.getCodigo().equals(codigo))) {
            System.out.println("Turma " + codigo + " já cadastrada.");
        }
        else{
            Turma turma = new Turma(nome, codigo);
            turmasCadastradas.add(turma);
            System.out.println("Turma cadastrada com sucesso!");
        }

        
    }

    public void inserirAlunoNaTurma() {
        Aluno aluno = buscarAlunoCmd("Digite o CPF do aluno a ser inserido: ");
        if (aluno != null) {
            Turma turma = buscarTurmaCmd("Digite o código da turma que deseja adicionar o aluno: ");
            turma.adicionarAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado. Certifique-se de que o aluno foi cadastrado.");
        }
    }

    public void removerAlunoDaTurma() {
        Aluno aluno = buscarAlunoCmd("Digite o CPF do aluno a ser removido: ");
        if (aluno != null) {
            Turma turma = buscarTurmaCmd("Digite o código da turma que deseja remover o aluno: ");
            turma.removerAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void listarAlunosDaTurma() {
        Turma turma = buscarTurmaCmd("Digite o código da turma que deseja listar os alunos: ");
        turma.listarAlunos();
    }

    public void removerTodosAlunosDaTurma() {
        System.out.println("Você tem certeza que deseja remover todos alunos da turma? \n1. Sim\n2. Não");
        int confirmacaoAcao = scanner.nextInt();
        scanner.nextLine();
        if(confirmacaoAcao == 1){
            Turma turma = buscarTurmaCmd("Digite o código da turma que deseja remover todos alunos: ");
            turma.removerTodos();
        }
    }

    public void cadastrarTurmasPorArquivo() throws FileNotFoundException {
        System.out.print("Digite o nome do arquivo que deseja ler os dados para adição de turmas: ");
        String nomeArquivo = scanner.nextLine();
        String diretorioProjeto = System.getProperty("user.dir");
    
        File arquivo = new File(diretorioProjeto, nomeArquivo);
        Scanner scannerArquivo = new Scanner(arquivo);
    
        if (scannerArquivo.hasNextLine()) {
            String cabecalho = scannerArquivo.nextLine();
            System.out.println("Cabeçalho: " + cabecalho);
        } 
    
        while (scannerArquivo.hasNextLine()) {
            String linha = scannerArquivo.nextLine().trim();
    
            // Verificando se a linha está vazia
            if (linha.isEmpty()) {
                System.out.println("Linha em branco encontrada e desconsiderada ao realizar o cadastro!");
                continue;
            }
    
            String[] dados = linha.split(",");
    
            // Verificando se possui o número correto de colunas e se não há valores vazios
            if (dados.length != 2 || dados[0].isEmpty() || dados[1].isEmpty()) {
                System.out.println("Linha com valores inválidos ou nulos: " + linha);
                continue; 
            }
    
            // Verificando se a turma já está cadastrada
            if (turmasCadastradas.stream().anyMatch(turma -> turma.getCodigo().equals(dados[1]))) {
                System.out.println("Turma " + dados[1] + " já cadastrada.");
                continue;
            }
    
            // Adiciona a nova turma
            Turma turma = new Turma(dados[0], dados[1]);
            turmasCadastradas.add(turma);
            System.out.println("Adicionando a turma: " + dados[0] + "/" + dados[1]);
        }
    
        scannerArquivo.close();
    }
    

    public void cadastrarAlunosPorArquivo() throws FileNotFoundException {
        System.out.print("Digite o nome do arquivo que deseja ler os dados para adição de alunos: ");
        String nomeArquivo = scanner.nextLine();
        String diretorioProjeto = System.getProperty("user.dir");

        File arquivo = new File(diretorioProjeto, nomeArquivo);
        Scanner scanner = new Scanner(arquivo);

        if (scanner.hasNextLine()) {
            String cabecalho = scanner.nextLine();
            System.out.println("Cabeçalho: " + cabecalho);
        } 
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine().trim();

            //Verificando se possui linhas em branco - obs: O continue pausa a execução e pula para a próxima caso não atenda o que foi pedido
            if (linha.isEmpty()) {
                System.out.println("Linha com valores nulos encontrada e desconsiderada ao realizar o cadastro!");
                continue;
            }


            String[] dados = linha.split(",");
             //Verificando se possui colunas em branco - obs: "dados.lenght < 2" verifica se possui menos de duas colunas
             //"dados.length < 2" Verifica se possui mais de duas colunas
             // "dados[0].isEmpty()" e "dados[1].isEmpty()" verificam se colunas possue valores vazios
             if (dados.length < 9 || dados.length > 15 || dados[0].isEmpty() || dados[1].isEmpty() || dados[2].isEmpty() || dados[3].isEmpty() || dados[5].isEmpty() || dados[5].isEmpty() || dados[6].isEmpty() || dados[7].isEmpty() || dados[8].isEmpty()) {
                System.out.println("Linha com valores invalidos ou nulos: " + linha);
                continue; 
            }


            Turma turmaAluno = buscarTurmaPorCodigo(dados[5]);

            //Verifica se existe turma na linha referenciada
            if(turmaAluno == null){
                System.out.println("Turma não encontrada para o aluno " + dados[0]);
                continue;
            }
            else
            {
            turmaAluno.adicionarAluno(new Aluno(dados[0], dados[1]));
            System.out.println("Adicionando a turma: " + dados[5] + " o Aluno:" + dados[0] + "/" + dados[1]);
            }
           
        }
        
        scanner.close();
    }
}
