package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvNotify<N extends InvarCodec.ProtocNotify> {

    static Map<Class<?>, RecvNotify> map = new HashMap<Class<?>, RecvNotify>(256);

    static public <
        N extends InvarCodec.ProtocNotify,
        C extends RecvContext> int recv(C ctx, N ntf) {

        if (map.containsKey(ntf.getClass())) {
            map.get(ntf.getClass()).handle(ntf, ctx);
            return InvarCodec.ERR_NONE;
        } else {
            return InvarCodec.ERR_PROTOC_NO_HANDLER;
        }
    }

    public RecvNotify(Class<N> nClass) {
        map.put(nClass, this);
    }

    public abstract void handle(N notify, RecvContext context);

}