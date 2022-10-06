//import java.util.ArrayList;

import java.util.Arrays;

public class User {

    protected int idConta;
    protected String nomePessoa;
    protected String[] emails;
    protected String nomeUsuario;
    protected String senha;
    protected char[] cpf = new char[11];
    protected String cidade;
    protected int transferenciasRealizadas;
    protected float saldoConta;

    public User(int idConta, String nomePessoa, String[] emails, String nomeUsuario, String senha, char[] cpf, String cidade, int transferenciasRealizadas, float saldoConta) {
        this.idConta = idConta;
        this.nomePessoa = nomePessoa;
        this.emails = emails;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.cpf = cpf;
        this.cidade = cidade;
        this.transferenciasRealizadas = transferenciasRealizadas;
        this.saldoConta = saldoConta;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public char[] getCpf() {
        return cpf;
    }

    public void setCpf(char[] cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getTransferenciasRealizadas() {
        return transferenciasRealizadas;
    }

    public void setTransferenciasRealizadas(int transferenciasRealizadas) {
        this.transferenciasRealizadas = transferenciasRealizadas;
    }

    public float getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(float saldoConta) {
        this.saldoConta = saldoConta;
    }

    @Override
    public String toString() {
        return "User{" +
                "idConta=" + idConta +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", emails=" + Arrays.toString(emails) +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf=" + Arrays.toString(cpf) +
                ", cidade='" + cidade + '\'' +
                ", transferenciasRealizadas=" + transferenciasRealizadas +
                ", saldoConta=" + saldoConta +
                '}';
    }
}
