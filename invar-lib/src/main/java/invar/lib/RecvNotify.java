/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvNotify<N extends InvarCodec.ProtocNotify> {

    static Map<Class<?>, RecvNotify> map = new HashMap<Class<?>, RecvNotify>(256);

    @SuppressWarnings("unchecked")
    static public <
        N extends InvarCodec.ProtocNotify,
        C extends RecvContext> int recv(C ctx, N ntf) {

        if (map.containsKey(ntf.getClass())) {
            map.get(ntf.getClass()).handle(ntf, ctx);
            return CodecError.ERR_NONE;
        } else {
            return CodecError.ERR_PROTOC_NO_HANDLER;
        }
    }

    public RecvNotify(Class<N> nClass) {
        map.put(nClass, this);
    }

    public abstract void handle(N notify, RecvContext context);

}