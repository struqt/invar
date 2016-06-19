package invar.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TypeProtocol extends InvarType {

    static private HashSet<Integer> ids = new HashSet<Integer>(1024);
    static private HashMap<Integer, TypeStruct> mapClients = new HashMap<Integer, TypeStruct>(512);
    static private HashMap<Integer, TypeStruct> mapServers = new HashMap<Integer, TypeStruct>(512);

    static public Iterator<Integer> clientIds() {
        return mapClients.keySet().iterator();
    }

    static public Iterator<Integer> serverIds() {
        return mapServers.keySet().iterator();
    }

    static public TypeStruct findClient(Integer key) {
        return mapClients.get(key);
    }

    static public TypeStruct findServer(Integer key) {
        return mapServers.get(key);
    }

    static public void reset() {
        ids.clear();
        mapClients.clear();
        mapServers.clear();
    }

    //private final Integer protocId;
    private final Integer clientId;
    private final Integer serverId;
    private TypeStruct server;
    private TypeStruct client;
    private TypeStruct request;
    private TypeStruct response;

    public TypeProtocol(Integer id, String name, InvarPackage pack, String comment) {
        super(TypeID.PROTOCOL, name, pack, comment, false);

        if (ids.contains(id)) {
            throw new RuntimeException("Repeated protocol id: " + id);
        }
        //this.protocId = id;
        ///*
        if ((id & 0x01) == 1) {
            this.clientId = id;
            this.serverId = id + 1;
        } else {
            this.clientId = id - 1;
            this.serverId = id;
        }//*/
        /*
        this.clientId = id;
        this.serverId = id;
        //*/
        ids.add(this.clientId);
        ids.add(this.serverId);
    }

    public void reset(List<String> nodes) {
        String suffix;
        int len = nodes.size();
        if (len == 1) {
            suffix = "N";
            TypeStruct t = this.resetByName(nodes.get(0), suffix);
            assert t != null;
            t.setProtocType("ntf");
        } else if (len == 2) {
            request = this.resetByName(nodes.get(0), "");
            request.setProtocType("req");
            response = this.resetByName(nodes.get(1), "R");
            response.setProtocType("resp");
        }
    }

    public TypeStruct getClient() {
        return client;
    }

    public TypeStruct getServer() {
        return server;
    }

    public TypeStruct getRequest() {
        return request; // this.client or this.server
    }

    public TypeStruct getResponse() {
        return response; // this.client or this.server
    }

    public Boolean hasClient() {
        return null != this.client;
    }

    public Boolean hasServer() {
        return null != this.server;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getServerId() {
        return serverId;
    }

    private TypeStruct resetByName(String node, String suffix) {
        if ("client".equals(node)) {
            suffix += "2S";
            client = new TypeStruct(getName() + suffix, getPack(), getComment());
            client.setProtoc(this);
            mapClients.put(clientId, client);
            return client;
        } else if ("server".equals(node)) {
            suffix += "2C";
            server = new TypeStruct(getName() + suffix, getPack(), getComment());
            server.setProtoc(this);
            mapServers.put(serverId, server);
            return server;
        } else {
            return null;
        }
    }
}
