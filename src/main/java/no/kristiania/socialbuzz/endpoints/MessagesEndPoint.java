package no.kristiania.socialbuzz.endpoints;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import no.kristiania.socialbuzz.dao.DaoMessage;
import no.kristiania.socialbuzz.dao.Message;

import java.sql.SQLException;
import java.util.List;

@Path("/messages")
public class MessagesEndPoint {

    @Inject
    private DaoMessage daoMessage;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAllMessages(int idChat) throws SQLException {
        return daoMessage.getAllMessages(idChat);
    }

}
