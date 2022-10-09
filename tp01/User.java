import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;

public class User {

    protected int idConta;
    protected String nomePessoa;
    protected ArrayList<String> emails;
    protected String nomeUsuario;
    protected String senha;
    protected String cpf;// = new char[11];
    protected String cidade;
    protected int transferenciasRealizadas;
    protected float saldoConta;

    public User(int idConta, String nomePessoa, ArrayList<String> emails, String nomeUsuario, String senha, String cpf, String cidade, int transferenciasRealizadas, float saldoConta) {
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

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutput dos = new DataOutputStream(baos);
        dos.writeInt(idConta);
        dos.writeUTF(nomePessoa);
        dos.writeUTF(emails.toString());
        dos.writeUTF(nomeUsuario);
        dos.writeUTF(senha);
        dos.writeUTF(cpf);
        dos.writeUTF(cidade);
        dos.writeInt(transferenciasRealizadas);
        dos.writeFloat(saldoConta);
        return baos.toByteArray();
    }

    public void fromByteArray(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        idConta = dis.readInt();
        nomePessoa = dis.readUTF();
        for(int i = 0; i < emails.size(); ++i) emails.set(i, dis.readUTF()); 
        nomeUsuario = dis.readUTF();
        senha = dis.readUTF();
        cpf = dis.readUTF();
        cidade = dis.readUTF();
        transferenciasRealizadas = dis.readInt();
        saldoConta = dis.readFloat();
    }

}
