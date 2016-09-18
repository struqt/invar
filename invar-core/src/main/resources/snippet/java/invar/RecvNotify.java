package invar;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvNotify<N extends InvarCodec.ProtocNotify> {

    static Map<Integer, RecvNotify> map = new HashMap<Integer, RecvNotify>(256);

    public RecvNotify(int protoc) {
        map.put(protoc, this);
    }

    static public <
        N extends InvarCodec.ProtocNotify,
        C extends RecvContext> int recv(C ctx, N ntf) {

        if (map.containsKey(ntf.getProtocId())) {
            map.get(ntf.getProtocId()).handle(ntf, ctx);
            return 0;
        } else {
            return 503;
        }
    }

    public abstract void handle(N notify, RecvContext context);

}