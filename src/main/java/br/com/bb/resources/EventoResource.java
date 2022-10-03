package br.com.bb.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.bb.domain.ApiResponse;
import br.com.bb.dto.EventoDto;
import br.com.bb.model.Evento;
import br.com.bb.services.EventoService;

@Path("/eventos")
@Tag(name = "Eventos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventoResource {

    @Inject
    EventoService service;

    @GET
    public ApiResponse<List<Evento>> list() throws NotFoundException {
        List<Evento> list = service.listEventos();
        return new ApiResponse<List<Evento>>("Eventos encontrados", list);
    }

    @GET
    @Path("/{id}")
    public ApiResponse<Evento> get(Long id) throws NotFoundException {
        Evento entityFound = service.findEvento(id);
        return new ApiResponse<Evento>("Evento encontrado", entityFound);
    }

    @POST
    @Transactional
    public ApiResponse<Evento> create(EventoDto bodyReq) {
        Evento created = service.createEvento(bodyReq);
        return new ApiResponse<Evento>("Evento criado", created);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public ApiResponse<Evento> update(Long id, EventoDto bodyReq) throws NotFoundException {
        Evento updated = service.updateEvento(id, bodyReq);
        return new ApiResponse<Evento>("Evento atualizado", updated);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public ApiResponse<Null> delete(Long id) {
        service.deleteEvento(id);
        return new ApiResponse<Null>("Evento deletado", null);
    }
}
