#pragma once
#include <bits/stdc++.h>
// #include <iostream>
using namespace std;

class User{
    int idConta;
    string np;
    vector<string> email;
    string nu;
    string senha;
    string cpf; // const size = 11 //vector<char> cpf(11);
    string cidade;
    int trf;
    float conta;

    public:
    User(){};
    User (int idConta, string nomePessoa, vector<string> &email, string nomeUsuario, string senha, string cpf, string cidade,
    int transferenciasRealizadas, float saldoConta){
        this->idConta = idConta;
        this->np = nomePessoa;
        this->email = email;
        this->nu = nomeUsuario;
        this->senha = senha;
        this->cpf = cpf;
        this->cidade = cidade;
        this->trf = transferenciasRealizadas;
        this->conta = saldoConta;
    }
    void writeToFile(ofstream &fout);
    ~User(){};
};

void User::writeToFile(ofstream &fout){
    fout << "t\n";
    fout << this->np << endl;
    for(auto& x : this->email) fout << x << " ";
    fout << endl;
        // fout << this->email << endl;
    fout << this->nu << endl;
    fout << this->senha << endl;
    fout << this->cpf << endl;
    fout << this->cidade << endl;
    fout << this->trf << endl;
    fout << this->conta << endl;
}