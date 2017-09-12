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

    private static Map<String, RecvRequest> map = new HashMap<String, RecvRequest>(256);

    @SuppressWarnings("unchecked")
    static public <
        T extends InvarCodec.ProtocRequest,
        R extends InvarCodec.ProtocResponse,
        C extends RecvContext>
    void recv(C ctx, T req, R resp) {
        String key = ctx.handlerId();
        if (key == null || key.length() <= 0) {
            key = req.getProtocId().toString();
        }
        if (map.containsKey(key)) {
            RecvRequest<T, R> recv = map.get(key);
            recv.handle(req, resp, ctx);
        } else {
            resp.setProtocError(CodecError.ERR_PROTOC_NO_HANDLER);
        }
    }

    @SuppressWarnings("unchecked")
    static public <
        T extends InvarCodec.ProtocRequest>
    String getSessionId(T req, RecvContext ctx) {
        String key = ctx.handlerId();
        if (map.containsKey(key)) {
            RecvRequest recv = map.get(key);
            return recv.sessionId(req);
        } else {
            return null;
        }
    }

    public abstract void handle(T request, R response, RecvContext context);

    private String id;

    protected void setHandlerId(String id) {
        if (this.id != null) {
            map.remove(this.id);
        }
        if (id != null && id.length() > 0 && !map.containsKey(id)) {
            map.put(id, this);
        }
    }

    protected String sessionId(T req) {
        return null;
    }

}