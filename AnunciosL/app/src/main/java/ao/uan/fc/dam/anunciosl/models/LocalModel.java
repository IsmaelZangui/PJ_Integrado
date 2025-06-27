package ao.uan.fc.dam.anunciosl.models;

import java.util.List;

public class LocalModel {

    private String nome;
    private double latitude;
    private double longitude;
    private double raio;
    private List<String> ssidWiFi;

    // Construtor vazio
    public LocalModel() {}

    // Construtor completo
    public LocalModel(String nome, double latitude, double longitude, double raio, List<String> ssidWiFi) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.raio = raio;
        this.ssidWiFi = ssidWiFi;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getRaio() { return raio; }
    public void setRaio(double raio) { this.raio = raio; }

    public List<String> getSsidWiFi() { return ssidWiFi; }
    public void setSsidWiFi(List<String> ssidWiFi) { this.ssidWiFi = ssidWiFi; }
}
