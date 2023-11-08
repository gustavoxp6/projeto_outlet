package ENTIDADES;

import java.sql.Date;

public class Cliente {
    /*  `cpf` CHAR(14) NOT NULL PRIMARY KEY,
  `nome` VARCHAR(100) NOT NULL,
  `datanascimento` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `telefone` CHAR(15) NOT NULL */
  private String cpf;
  private String nome;
  private String datanascimento;
  private String email;
  private String telefone;
protected String strdataretirada;

  public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getDatanascimento() {
    return datanascimento;
}

public void setDatanascimento(String datanascimento) {
    this.datanascimento = datanascimento;
    }

public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getTelefone() {
    return telefone;
}
public void setTelefone(String telefone) {
    this.telefone = telefone;
}
public void setDatanascimento(Date date) {
}

    
}