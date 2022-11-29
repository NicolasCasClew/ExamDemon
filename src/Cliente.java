import java.io.Serializable;

public class Cliente implements Serializable {
    int poliza;
    String cliente;
    String matric;
    Double cuota;

    public Cliente(int poliza, String cliente, String matric, Double cuota) {
        this.poliza = poliza;
        this.cliente = cliente;
        this.matric = matric;
        this.cuota = cuota;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public Double getCuota() {
        return cuota;
    }

    public void setCuota(Double cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "poliza=" + poliza +
                ", cliente='" + cliente + '\'' +
                ", matric='" + matric + '\'' +
                ", cuota=" + cuota +
                '}';
    }
}
