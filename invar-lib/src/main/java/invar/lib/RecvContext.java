/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.net.SocketAddress;

public interface RecvContext extends SendContext {

    String handlerId();

    String getSessionId();

    String clientName();

    long getCreateTime();

    SocketAddress getLocalAddress();

    SocketAddress getRemoteAddress();

}