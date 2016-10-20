package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvRequest<
    T extends InvarCodec.ProtocRequest,
    R extends InvarCodec.ProtocResponse> {

    static Map<Class<?>, RecvRequest> map = new HashMap<Class<?>, RecvRequest>(256);

    static public <
        T extends InvarCodec.ProtocRequest,
        R extends InvarCodec.ProtocResponse,
        C extends RecvContext> void recv(C ctx, T req, R resp) {

        if (map.containsKey(req.getClass())) {
            map.get(req.getClass()).handle(req, resp, ctx);
        } else {
            resp.setProtocError(CodecError.ERR_PROTOC_NO_HANDLER);
        }
    }

    public RecvRequest(Class<T> tClass) {
        map.put(tClass, this);
    }

    public abstract void handle(T request, R response, RecvContext context);

}