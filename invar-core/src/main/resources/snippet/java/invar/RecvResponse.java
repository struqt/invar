package invar;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvResponse<C, R extends invar.InvarCodec.ProtocResponse> {

    static Map<Integer, RecvResponse> map = new HashMap<Integer, RecvResponse>(256);

    public RecvResponse(int protoc) {
        map.put(protoc, this);
    }

    static public <C, T extends invar.InvarCodec.ProtocResponse>
    int recv(C ctx, T resp) {

        if (map.containsKey(resp.getProtocId())) {
            map.get(resp.getProtocId()).handle(ctx, resp);
            return 0;
        } else {
            return 503;
        }
    }

    public abstract void handle(C context, R resp);

}