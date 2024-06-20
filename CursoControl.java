import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CursoControl {
    private ObservableList<Curso> lista = 
        FXCollections.observableArrayList();
    private StringProperty id = new SimpleStringProperty("");
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty codCurso = new SimpleStringProperty("");
    private StringProperty nomeCoord = new SimpleStringProperty("");
    private IntegerProperty qtdAluno = new SimpleIntegerProperty();

    public void limparCampos() { 
        id.set("");
        nome.set("");
        codCurso.set("");
        nomeCoord.set("");
        qtdAluno.set(0);
    }

    public Curso toEntity() { 
        Curso a = new Curso();
        a.setId( id.get() );
        a.setNome( nome.get() );
        a.setCodCurso( codCurso.get() );
        a.setNomeCoord( nomeCoord.get() );
        a.setQtdAluno( qtdAluno.get() );
        return a;
    }

    public void fromEntity(Curso a) { 
        nome.set(a.getNome());
        id.set(a.getId());
        codCurso.set(a.getCodCurso());
        nomeCoord.set(a.getNomeCoord());
        qtdAluno.set(a.getQtdAluno());
    }

    public void gravar() { 
        Curso a = toEntity();
        lista.add(a);
        limparCampos();
    }

    public void pesquisar() { 
        for (Curso a : lista) { 
            if (a.getNome().contains( nome.get() )) { 
                fromEntity(a);
            }
        }
    }

    public ObservableList<Curso> getLista() {
        return this.lista;
    }

    public StringProperty nomeProperty() { 
        return this.nome;
    }

    public StringProperty idProperty() { 
        return this.id;
    }

    public StringProperty codCursoProperty() { 
        return this.codCurso;
    }

    public StringProperty nomeCordProperty() {
        return this.nomeCoord;
    }

    public IntegerProperty qtdAlunoProperty() { 
        return this.qtdAluno;
    }
    
}
