import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEscola {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Aluno> alunosCadastrados = new ArrayList<>();
    private ArrayList<Turma> turmasCadastradas = new ArrayList<>();

    public void executar() {
        int opcao;

        do {
            System.out.println("\n========== Menu ==========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Inserir Aluno na Turma");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Lista de Alunos");
            System.out.println("5. Editar idade");
            System.out.println("6. Remover Todos Alunos");
            System.out.println("7. Cadastrar Turmas");
            System.out.println("8. Lista de Turmas");
            System.out.println("9. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    inserirAlunoNaTurma();
                    break;
                case 3:
                    remocaoAlunos();
                    break;
                case 4:
                    listaDeAluno();
                    break;
                case 5:
                    editarIdade();
                    break;
                case 6:
                    remocaoTodosAlunos();
                    break;
                case 7:
                    cadastrarTurma();
                    break;
                case 8:
                    listarTurmas();
                    break;
                case 9:
                    System.out.println("\nSaindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

    public void cadastrarAluno() {
        System.out.println("\n--------------------------------");
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = new Aluno(nome, cpf);
        alunosCadastrados.add(aluno);
        System.out.println("\nAluno cadastrado com sucesso!");
        System.out.println("--------------------------------\n");
    }

    public void inserirAlunoNaTurma() {
        System.out.println("\n--------------------------------");
        System.out.print("Digite o CPF do aluno a ser inserido: ");
        String cpf = scanner.nextLine();
        Aluno aluno = buscarAlunoPorCpf(cpf);

        System.out.print("Informe o codigo da turma: ");
        String codigo = scanner.nextLine();
        Turma turma = buscarTurmaPorCodigo(codigo);

        if (aluno != null && turma != null) {
            turma.adicionarAluno(aluno);
            System.out.println("\nAluno " + aluno.getNome() + " adicionado na " + turma.getNome());
        } else if (aluno == null && turma == null) {
            System.out.println("\nAluno e turma não encontrados. Certifique-se que foram cadastrados.");
        } else if (aluno == null){
            System.out.println("\nAluno não encontrado. Certifique-se de que o aluno foi cadastrado.");
        } else if (turma == null) {
            System.out.println("\nTurma não encontrada. Certifique-se de que a turma foi cadastrada.");
        }
        System.out.println("--------------------------------\n");
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void remocaoAlunos() {
        System.out.println("\n--------------------------------------");
        System.out.print("Digite o codigo da Turma, para procurar o aluno: ");
        String codigo = scanner.nextLine();

        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            System.out.println(turma.getNome() + "\n");
            System.out.print("Digite o CPF do aluno a ser removido: ");
            String cpf = scanner.nextLine();

            Aluno aluno = buscarAlunoPorCpf(cpf);
            turma.removerAluno(aluno);
        }
        System.out.println("--------------------------------------\n");
    }

    public void listaDeAluno() {
        System.out.println("\n--------------------------------------");
        System.out.print("Digite o código da turma: ");
        String codigo = scanner.nextLine();

        Turma turma = buscarTurmaPorCodigo(codigo);

        if (turma != null) {
            if (turma.estavazia()) {
                System.out.println("\nTurma vazia!");
            } else {
                turma.listarAlunos();
            }
        } else {
            System.out.println("Turma não encontrada!");
        }
        System.out.println("--------------------------------------\n");
    }

    public void editarIdade() {
        System.out.println("\n-----------------------------------------------");
        System.out.print("Digite o CPF do aluno a ser editado: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            System.out.println("\nDigite a idade do aluno: " + aluno.getNome());
            int idade = scanner.nextInt();
            scanner.nextLine();
            aluno.setIdade(idade);
        } else {
            System.out.println("Aluno não encontrado!");
        }

        System.out.println("\n" + aluno);
        System.out.println("-----------------------------------------------\n");
    }

    public void remocaoTodosAlunos() {
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Digite o codigo da turma: ");
        String codigo = scanner.nextLine();

        Turma turma = buscarTurmaPorCodigo(codigo);
 
        if (turma != null) {
            turma.listarAlunos();
        } else {
            System.out.println("Turma não encontrada!");
        }

        System.out.println("Tem certeza que deseja remover todos alunos da turma?");
        System.out.println("1. SIM  2. NÃO");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                turma.removerTodosAlunos();
                System.out.println("-----------------------------------------------------\n");
                break;
            case 2:
                System.out.println("-----------------------------------------------------\n");
                return;
        
            default:
                System.out.println("Opção inválida, tente novamente!");
                break;
        }
    }

    public void cadastrarTurma() {
        System.out.println("\n--------------------------------");
        System.out.print("Digite o nome da Turma: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o código: ");
        String codigo = scanner.nextLine();

        Turma turma = new Turma(nome, codigo);
        turmasCadastradas.add(turma);
        System.out.println("\nTurma cadastrada com sucesso!");
        System.out.println("--------------------------------\n");
    }

    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmasCadastradas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public void listarTurmas() {
        for (int i = 0; i < turmasCadastradas.size(); i++) {
            Turma turma = turmasCadastradas.get(i);
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Posição do ArrayList [" + i + "] " + turma.getNome() + " - Código: " + turma.getCodigo());
            System.out.println("------------------------------------------------------------------------------");
        }
    }
}
