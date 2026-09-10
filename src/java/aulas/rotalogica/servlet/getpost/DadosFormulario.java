package aulas.rotalogica.servlet.getpost;

public class DadosFormulario {
    
    private String campoA;
    private String opcaoA;

    public String getCampoA() {
        return campoA;
    }

    public void setCampoA(String campoA) {
        this.campoA = campoA;
    }

    public String getOpcaoA() {
        return opcaoA;
    }

    public void setOpcaoA(String opcaoA) {
        this.opcaoA = opcaoA;
    }

    @Override
    public String toString() {
        return getCampoA() + " " + getOpcaoA();
    }
    
    
    
}
