package br.com.bb.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.NotFoundException;

import br.com.bb.dto.EventoDto;
import br.com.bb.model.Evento;

@ApplicationScoped
public class EventoService {
  public Evento updateEvento (Long id, EventoDto bodyReq) throws NotFoundException {
    Evento entity = Evento.findById(id);
    if(entity == null) {
      throw new NotFoundException("Nenhum evento encontrado");
    }

    entity.titulo = bodyReq.titulo;
    entity.descricao = bodyReq.descricao;
    entity.dtInicio = bodyReq.dtInicio;
    entity.dtTermino = bodyReq.dtTermino;
    entity.preco = bodyReq.preco;

    return entity;
  }

  public Evento createEvento (EventoDto bodyReq) {
    Evento entity = new Evento();

    entity.titulo = bodyReq.titulo;
    entity.descricao = bodyReq.descricao;
    entity.dtInicio = bodyReq.dtInicio;
    entity.dtTermino = bodyReq.dtTermino;
    entity.preco = bodyReq.preco;

    entity.persist();

    return entity;
  }

  public List<Evento> listEventos () throws NotFoundException {
    List<Evento> entityList = Evento.listAll();
    if(entityList.size() == 0) {
      throw new NotFoundException("Nenhum evento encontrado");
    } else {
      return entityList;
    }
  }

  public Evento findEvento (Long id) throws NotFoundException {
    Evento entity = Evento.findById(id);
    if(entity == null) {
      throw new NotFoundException("Nenhum evento encontrado");
    } else {
      return entity;
    }
  }

  public void deleteEvento (Long id) throws NotFoundException {
    Evento entity = Evento.findById(id);
    if(entity == null) {
      throw new NotFoundException("Nenhum evento encontrado");
    } else {
      entity.delete();
    }
  }
}
