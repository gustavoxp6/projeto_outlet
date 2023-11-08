package ENTIDADES;

public class Produtofornecedor {
   /*
    * CREATE TABLE IF NOT EXISTS `outlet`.`produtofornecedor` (
  `produto_cod` INT NOT NULL,
  `fornecedor_cnpj` CHAR(18) NOT NULL,
  PRIMARY KEY (`produto_cod`, `fornecedor_cnpj`),
  INDEX `fk_produtofornecedor_fornecedor1_idx` (`fornecedor_cnpj` ASC),
  CONSTRAINT `fk_produtofornecedor_produto1`
    FOREIGN KEY (`produto_cod`)
    REFERENCES `outlet`.`produto` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtofornecedor_fornecedor1`
    FOREIGN KEY (`fornecedor_cnpj`)
    REFERENCES `outlet`.`fornecedor` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

    */
    private String produto_cod;
    private String fornecedor_cnpj;
    public String getProduto_cod() {
        return produto_cod;
    }
    public void setProduto_cod(String produto_cod) {
        this.produto_cod = produto_cod;
    }
    public String getFornecedor_cnpj() {
        return fornecedor_cnpj;
    }
    public void setFornecedor_cnpj(String fornecedor_cnpj) {
        this.fornecedor_cnpj = fornecedor_cnpj;
    }
}