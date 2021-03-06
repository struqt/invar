#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===

from TestProtocTestHeartBeat2C import TestHeartBeat2C
from TestProtocTestHeartBeatR2S import TestHeartBeatR2S
from TestProtocTestServerTimeN2C import TestServerTimeN2C
from TestProtocTestUserLocationN2S import TestUserLocationN2S
from TestProtocTestUserLogin2S import TestUserLogin2S
from TestProtocTestUserLoginR2C import TestUserLoginR2C
import sys

class InvarRuntime:

    @staticmethod
    def HandleProtocAsServer(r):
        id = r.peekUInt16()
        if 0 == id:
            pass
        elif 65527 == id: # 客户端请求,服务端响应
            req = TestUserLogin2S()
            req.read(r)
            resp = TestUserLoginR2C()
            HandleTestUserLogin2S(req, resp)
        elif 65531 == id: # 客户端通知服务端
            ntf = TestUserLocationN2S()
            ntf.read(r)
            HandleTestUserLocationN2S(ntf)
        elif 65533 == id: # 服务端请求,客户端响应
            rep = TestHeartBeatR2S()
            rep.read(r)
            HandleTestHeartBeatR2S(rep)
        else:
            pass
   #def HandleProtocAsServer

    @staticmethod
    def HandleProtocAsClient(r):
        id = r.peekUInt16()
        if 0 == id:
            pass
        elif 65528 == id: # 客户端请求,服务端响应
            rep = TestUserLoginR2C()
            rep.read(r)
            HandleTestUserLoginR2C(rep)
        elif 65530 == id: # 服务器通知客户端
            ntf = TestServerTimeN2C()
            ntf.read(r)
            HandleTestServerTimeN2C(ntf)
        elif 65534 == id: # 服务端请求,客户端响应
            req = TestHeartBeat2C()
            req.read(r)
            resp = TestHeartBeatR2S()
            HandleTestHeartBeat2C(req, resp)
        else:
            pass
   #def HandleProtocAsClient


#end class InvarRuntime

if '__main__' == __name__:
    print(sys.version)
    print(sys.getdefaultencoding())
