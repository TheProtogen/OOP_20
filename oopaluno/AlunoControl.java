package oopaluno;

import java.time.LocalDate;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class AlunoControl {

    private ObservableList<Aluno> lista = FXCollections.observableArrayList();;
    private AlunoDAO dao;

    private LongProperty id = new SimpleLongProperty(0);
    private StringProperty ra = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private ObjectProperty<LocalDate> nascimento = new SimpleObjectProperty(LocalDate.now()); 


    public AlunoControl() throws AlunoException {
        try {  
            dao = new AlunoDAOImp();
        } catch(Exception e) { 
            throw new AlunoException(e);
        }
    }

    public void adicionar() {
        Aluno a = getEntity();

        dao.adicionar(a);
    }

    public void pesquisar() {
        for (Aluno c : lista) { 
            if (c.getNome().contains( nome.get() )) { 
                setEntity(c);
            }
        }
    }

    public Aluno getEntity() {
        Aluno a = new Aluno();

        a.setId( id.get() );
        a.setRa( ra.get() );
        a.setNome( nome.get() );
        a.setNascimento( nascimento.get() );
        
        return a;
    }

    public void setEntity(Aluno a) {
        id.set(a.getId());
        ra.set(a.getRa());
        nome.set(a.getNome());
        nascimento.set(a.getNascimento());
    }

    public ObservableList<Aluno> getTable() {
        return lista;
        
    }

    public LongProperty idProperty() {
        return id;

    }

    public StringProperty raProperty() {
        return ra;

    }

    public StringProperty nomeProperty() {
        return nome;

    }

    public ObjectProperty<LocalDate> nascimentoProperty() {
        return nascimento;

    }
}
