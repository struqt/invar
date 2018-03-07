/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class RecvResponse<
    T extends InvarCodec.ProtocRequest,
    R extends InvarCodec.ProtocResponse> {

    static private final Map<Object, RecvResponse> map = new ConcurrentHashMap<Object, RecvResponse>(256);

    @SuppressWarnings("unchecked")
    static public <
        R extends InvarCodec.ProtocResponse,
        C extends SendContext> int recv(C ctx, R resp) {
        assert ctx != null;
        Object req = ctx.getRequest();
        if (req == null) {
            return CodecError.ERR_UNKNOWN;
        }
        RecvResponse recv;
        synchronized (RecvResponse.class) {
            if (map.containsKey(req)) {
                recv = map.get(req);
                map.remove(req);
            } else {
                return CodecError.ERR_PROTOC_NO_HANDLER;
            }
        }
        recv.handle(resp, ctx);
        return CodecError.ERR_NONE;
    }

    public RecvResponse(T request) {
        map.put(request, this);
    }

    public abstract void handle(R response, SendContext context);

}