package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvResponse<R extends InvarCodec.ProtocResponse> {

    static Map<Class<?>, RecvResponse> map = new HashMap<Class<?>, RecvResponse>(256);

    static public <
        T extends InvarCodec.ProtocResponse,
        C extends RecvContext> int recv(C ctx, T resp) {

        if (map.containsKey(resp.getClass())) {
            map.get(resp.getClass()).handle(resp, ctx);
            return CodecError.ERR_NONE;
        } else {
            return CodecError.ERR_PROTOC_NO_HANDLER;
        }
    }

    public RecvResponse(Class<R> rClass) {
        map.put(rClass, this);
    }

    public abstract void handle(R response, RecvContext context);

}