package invar.lib;

import java.net.SocketAddress;

public interface RecvContext {

    String getSessionId();

    String clientName();

    long getCreateTime();

    SocketAddress getLocalAddress();

    SocketAddress getRemoteAddress();

}