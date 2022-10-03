package br.com.bb.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Evento extends PanacheEntity {
  public String titulo;
  public String descricao;
  public LocalDateTime dtInicio;
  public LocalDateTime dtTermino;
  public BigDecimal preco;
}