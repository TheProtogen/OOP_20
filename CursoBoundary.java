import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class CursoBoundary extends Application {
    private TextField txtId = new TextField("");
    private TextField txtNome = new TextField("");
    private TextField txtCodCurso = new TextField("");
    private TextField txtNomeCord = new TextField("");
    private TextField txtQtdAluno = new TextField("0");

    private CursoControl control = new CursoControl();

    private TableView<Curso> table = new TableView<>();

    public void generateTable() { 
        TableColumn<Curso, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory( new PropertyValueFactory<>("id"));

        TableColumn<Curso, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory( new PropertyValueFactory<>("nome"));

        TableColumn<Curso, String> colCodCurso = new TableColumn<>("Código do curso");
        colCodCurso.setCellValueFactory( new PropertyValueFactory<>("codCurso"));

        TableColumn<Curso, String> colNomeCoord = new TableColumn<>("Nome do coordenador");
        colCodCurso.setCellValueFactory( new PropertyValueFactory<>("nomeCoord"));

        TableColumn<Curso, Integer> colQtdAluno = new TableColumn<>("Qtd de alunos");
        colCodCurso.setCellValueFactory( new PropertyValueFactory<>("qtdAluno"));
        

        table.getColumns().addAll(colId,colNome,colCodCurso,colNomeCoord,colQtdAluno);
        table.setItems( control.getLista() );

        table
        .getSelectionModel()
        .selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    System.out.println("Selecionado: "+ newSelection);
                    control.fromEntity(newSelection);
                }
            }
        );
    }

    public void bind() { 
        StringConverter<Number> numberConverter = new NumberStringConverter();
        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtCodCurso.textProperty(), control.codCursoProperty());
        Bindings.bindBidirectional(txtNomeCord.textProperty(), control.nomeCordProperty());
        Bindings.bindBidirectional(txtQtdAluno.textProperty(), control.qtdAlunoProperty(),
        (StringConverter<Number>)numberConverter);
    }

    public void start(Stage stage) { 
        BorderPane panePrincipal = new BorderPane();
        Scene scn = new Scene( panePrincipal, 500, 300);

        GridPane paneForm = new GridPane();

        Button btnGravar = new Button("Gravar");
        Button btnPesquisar = new Button("Pesquisar");

        paneForm.add(new Label("ID: "), 0, 0);
        paneForm.add(txtId, 1, 0);

        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);

        paneForm.add(new Label("Codigo do curso: "), 0, 2);
        paneForm.add(txtCodCurso, 1, 2);

        paneForm.add(new Label("Nome do coordenador: "), 0, 3);
        paneForm.add(txtNomeCord, 1, 3);

        paneForm.add(new Label("Qtd de alunos: "), 0, 4);
        paneForm.add(txtQtdAluno, 1, 4);

        paneForm.add(btnGravar, 0,5);
        paneForm.add(btnPesquisar, 1,5);

        bind();
        generateTable();

        btnGravar.setOnAction( e-> control.gravar() );
        btnPesquisar.setOnAction( e-> control.pesquisar() );
        
        panePrincipal.setTop( paneForm );
        panePrincipal.setCenter( table );
        stage.setScene(scn);
        stage.setTitle("Cursos");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(CursoBoundary.class, args);
    }
    
}
