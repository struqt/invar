package invar.model;

import java.util.HashSet;

public class TypeProtocol extends InvarType {

    static private HashSet<Integer> ids = new HashSet<Integer>(512);

    private final Integer clientId;
    private final Integer serverId;

    private TypeStruct server;
    private TypeStruct client;
    private Boolean noClient;
    private Boolean noServer;

    public TypeProtocol(Integer id, String name, InvarPackage pack, String comment) {
        super(TypeID.PROTOCOL, name, pack, comment, false);
        if (ids.contains(id)) {
            throw new RuntimeException("Repeated protocol id: " + id);
        }
        this.clientId = id;
        this.serverId = id;
        ids.add(this.clientId);
        ids.add(this.serverId);
        client = new TypeStruct(name + "2S", pack, comment);
        server = new TypeStruct(name + "2C", pack, comment);
        noClient = true;
        noServer = true;
        client.setProtoc(this);
        server.setProtoc(this);
    }

    public TypeStruct getClient() {
        return client;
    }

    public TypeStruct getServer() {
        return server;
    }

    public TypeProtocol setNoClient(Boolean bool) {
        noClient = bool;
        return this;
    }

    public TypeProtocol setNoServer(Boolean bool) {
        noServer = bool;
        return this;
    }

    public Boolean hasClient() {
        return !noClient;
    }

    public Boolean hasServer() {
        return !noServer;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getServerId() {
        return serverId;
    }
}
