package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvResponse<R extends InvarCodec.ProtocResponse> {

    static Map<Integer, RecvResponse> map = new HashMap<Integer, RecvResponse>(256);

    public RecvResponse(int protoc) {
        map.put(protoc, this);
    }

    static public <
        T extends InvarCodec.ProtocResponse,
        C extends RecvContext> int recv(C ctx, T resp) {

        if (map.containsKey(resp.getProtocId())) {
            map.get(resp.getProtocId()).handle(resp, ctx);
            return 0;
        } else {
            return 503;
        }
    }

    public abstract void handle(R response, RecvContext context);

}