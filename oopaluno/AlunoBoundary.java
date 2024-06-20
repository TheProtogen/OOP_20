package oopaluno;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary extends Application{

    private TextField txtId = new TextField();
    private TextField txtRa = new TextField();
    private TextField txtNome = new TextField();
    private DatePicker txtNascimento = new DatePicker();

    private TableView<Aluno> table = new TableView<>();

    private AlunoControl control = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        control = new AlunoControl();

        GridPane pane = new GridPane();

        Scene scn = new Scene (pane, 700, 500);

        pane.add(new Label("Id: "), 0, 0);
        pane.add(txtId, 1, 0);
        pane.add(new Label("Ra: "), 0, 1);
        pane.add(txtRa, 1, 1);
        pane.add(new Label("Nome: "), 0, 2);
        pane.add(txtNome, 1, 2);
        pane.add(new Label("Nascimento: "), 0, 3);
        pane.add(txtNascimento, 1, 3);
        pane.add(table, 1, 6);

        generateBindings();
        createTableView();

        Button btnAdicionar = new Button("Adicionar");
        btnAdicionar.setOnAction(e -> { try{ 
            control.adicionar();
        } catch(Exception err) { 
            System.out.println("Erro ao adicionar");
        }});

        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> { try{ 
            control.pesquisar();
        } catch(Exception err) { 
            System.out.println("Erro ao pesquisar");
        }});

        pane.add(btnAdicionar, 0, 4 );
        pane.add(btnPesquisar, 1, 4 );
        
        


        primaryStage.setScene(scn);
        primaryStage.show();
    }

    

    private void generateBindings() {
        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(txtId.textProperty(), control.idProperty(), converter);
        Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtNascimento.valueProperty(), control.nascimentoProperty());
    }


    private void createTableView() {
        TableColumn<Aluno, Long> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory( new PropertyValueFactory<>("id"));
        TableColumn<Aluno, String> col2 = new TableColumn<>("Ra");
        col2.setCellValueFactory( new PropertyValueFactory<>("ra"));
        TableColumn<Aluno, String> col3 = new TableColumn<>("Nome");
        col3.setCellValueFactory( new PropertyValueFactory<>("nome"));
        TableColumn<Aluno, LocalDate> col4 = new TableColumn<>("Nascimento");
        col4.setCellValueFactory( new PropertyValueFactory<>("nascimento"));
        
        table
        .getSelectionModel()
        .selectedItemProperty().addListener(
            (obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    System.out.println("Selecionado: " + newSelection);
                    control.setEntity(newSelection);
                }
        });


        
        table.setItems( control.getTable() );

        table.getColumns().addAll(col1, col2, col3, col4);

    }
}
