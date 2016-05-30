package invar.model;

import java.util.HashSet;
import java.util.List;

public class TypeProtocol extends InvarType {

    static private HashSet<Integer> ids = new HashSet<Integer>(512);

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
        this.clientId = id;
        this.serverId = id/* +1 */;
        ids.add(this.clientId);
        ids.add(this.serverId);
    }

    public void reset(List<String> nodes) {
        String suffix;
        int len = nodes.size();
        if (len == 1) {
            suffix = "N";
            this.resetByName(nodes.get(0), suffix);
        } else if (len == 2) {
            request = this.resetByName(nodes.get(0), "");
            response = this.resetByName(nodes.get(1), "R");
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

    public Boolean isNotify() {
        return hasServer() || hasClient();
    }

    private TypeStruct resetByName(String node, String suffix) {
        if ("client".equals(node)) {
            suffix += "2S";
            client = new TypeStruct(getName() + suffix, getPack(), getComment());
            client.setProtoc(this);
            return client;
        } else if ("server".equals(node)) {
            suffix += "2C";
            server = new TypeStruct(getName() + suffix, getPack(), getComment());
            server.setProtoc(this);
            return server;
        } else {
            return null;
        }
    }
}
