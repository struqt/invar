/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class RecvRequest<
    T extends InvarCodec.ProtocRequest,
    R extends InvarCodec.ProtocResponse> {

    private static Map<Class<?>, RecvRequest> map = new HashMap<Class<?>, RecvRequest>(256);

    @SuppressWarnings("unchecked")
    static public <
        T extends InvarCodec.ProtocRequest,
        R extends InvarCodec.ProtocResponse,
        C extends RecvContext>
    void recv(C ctx, T req, R resp) {

        if (map.containsKey(req.getClass())) {
            RecvRequest<T, R> recv = map.get(req.getClass());
            recv.handle(req, resp, ctx);
        } else {
            resp.setProtocError(CodecError.ERR_PROTOC_NO_HANDLER);
        }
    }

    @SuppressWarnings("unchecked")
    static public <
        T extends InvarCodec.ProtocRequest>
    String getSessionId(T req) {
        if (map.containsKey(req.getClass())) {
            RecvRequest recv = map.get(req.getClass());
            return recv.sessionId(req);
        } else {
            return null;
        }
    }

    public RecvRequest(Class<T> tClass) {
        map.put(tClass, this);
    }

    public abstract void handle(T request, R response, RecvContext context);

    protected String sessionId(T req) {
        return null;
    }

}