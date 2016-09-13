package invar;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvRequest
    <C, T extends invar.InvarCodec.ProtocRequest, R extends invar.InvarCodec.ProtocResponse> {

    static Map<Integer, RecvRequest> map = new HashMap<Integer, RecvRequest>(256);

    static public <C, T extends invar.InvarCodec.ProtocRequest, R extends invar.InvarCodec.ProtocResponse>
    void recv(C ctx, T req, R resp) {

        if (map.containsKey(req.getProtocId())) {
            map.get(req.getProtocId()).handle(ctx, req, resp);
        } else {
            resp.setProtocError(503);
        }
    }

    public RecvRequest(int protoc) {
        map.put(protoc, this);
    }

    public abstract void handle(C context, T req, R resp);

}