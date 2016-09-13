package invar;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvNotify<C, N extends invar.InvarCodec.ProtocNotify> {

    static Map<Integer, RecvNotify> map = new HashMap<Integer, RecvNotify>(256);

    public RecvNotify(int protoc) {
        map.put(protoc, this);
    }

    static public <C, N extends invar.InvarCodec.ProtocNotify>
    int recv(C ctx, N ntf) {

        if (map.containsKey(ntf.getProtocId())) {
            map.get(ntf.getProtocId()).handle(ctx, ntf);
            return 0;
        } else {
            return 503;
        }
    }

    public abstract void handle(C context, N notify);

}