#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===

from TestProtocProtoc2C import Protoc2C
try:
    from cStringIO import StringIO
except:
    from StringIO import StringIO
from InvarCodec import DataWriter
from InvarCodec import DataReader

class TestUserLoginR2C(object):

    """客户端请求,服务端响应"""
    CRC32_ = 0xAE3BF274
    SIZE_  = 22

    __slots__ = (
        '_protocError',
        '_protocId',
        '_protocCRC',
        '_protoc2C',
        '_userId',
        '_userName',
        '_roles',
        '_hotfix')
   #__slots__

    def __init__(self):
        self._protocError = 0
        self._protocId    = 65528
        self._protocCRC   = TestUserLoginR2C.CRC32_
        self._protoc2C    = None
        self._userId      = ''
        self._userName    = ''
        self._roles       = []
        self._hotfix      = None
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'TestUserLoginR2C')
        s.write(u',')
        s.write(u' ')
        s.write(u'protocError')
        s.write(u':')
        s.write(unicode(self._protocError))
        s.write(u',')
        s.write(u' ')
        s.write(u'protocId')
        s.write(u':')
        s.write(unicode(self._protocId))
        s.write(u',')
        s.write(u' ')
        s.write(u'protocCRC')
        s.write(u':')
        s.write(unicode(self._protocCRC))
        s.write(u',')
        s.write(u' ')
        s.write(u'protoc2C')
        s.write(u':')
        if self._protoc2C is None:
            s.write(u'null')
        else:
            s.write(u'<')
            s.write(u'Protoc2C')
            s.write(u'>')
        s.write(u',')
        s.write(u' ')
        s.write(u'userId')
        s.write(u':')
        s.write(u'"')
        s.write(self._userId)
        s.write(u'"')
        s.write(u',')
        s.write(u' ')
        s.write(u'userName')
        s.write(u':')
        s.write(u'"')
        s.write(self._userName)
        s.write(u'"')
        s.write(u',')
        s.write(u' ')
        s.write(u'roles')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._roles)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'hotfix')
        s.write(u':')
        if self._hotfix is None:
            s.write(u'null')
        else:
            s.write(u'[')
            s.write(str(len(self._hotfix)))
            s.write(u']')
        s.write(u' ')
        s.write(u'}')
        result = s.getvalue()
        s.close()
        return result
   #def __str__

    def __len__(self):
        size = TestUserLoginR2C.SIZE_
        if self._protoc2C is not None:
            size += len(self._protoc2C)
        size += len(self._userId)
        size += len(self._userName)
        if len(self._roles) > 0:
            size += len(self._roles) * 4
        if self._hotfix is not None:
            size += 4
            for (k1,v1) in self._hotfix.items():
                size += len(k1)
                size += len(v1)
        return size
   #def __len__

    def read(r):
        self._protocError = r.readUInt16()
        if self._protocError != 0:
            raise InvarError(self._protocError, "Protoc read error: The code is " + self._protocError)
        self._protocId = r.readUInt16()
        self._protocCRC = r.readUInt32()
        if CRC32 != self._protocCRC:
            raise InvarError(499, "Protoc read error: CRC32 is mismatched.", 499)
        protoc2CExists = r.readInt8()
        if 0x01 == protoc2CExists:
            if self._protoc2C == None:
                self._protoc2C = Protoc2C()
            self._protoc2C.read(r)
        elif 0x00 == protoc2CExists:
            self._protoc2C = None
        else:
            raise InvarError(497, 'Protoc read error: The value of \'protoc2CExists\' is invalid.')
        self._userId = r.readString()
        self._userName = r.readString()
        lenRoles = r.readUInt32()
        num = 0
        while num < lenRoles:
            num += 1
            n1 = r.readInt32()
            self._roles.append(n1)
        hotfixExists = r.readInt8()
        if 0x01 == hotfixExists:
            if self._hotfix == None:
                self._hotfix = dict()
            lenHotfix = r.readUInt32()
            num = 0
            while num < lenHotfix:
                num += 1
                k1 = r.readString()
                v1 = r.readString()
                self._hotfix[k1] = v1
        elif 0x00 == hotfixExists:
            self._hotfix = None
        else:
            raise InvarError(498, 'Protoc read error: The value of \'hotfixExists\' is invalid.')
   #def read

    def write(w):
        w.writeUInt16(self._protocError)
        if self._protocError != 0:
            return
        w.writeUInt16(self._protocId)
        w.writeUInt32(self._protocCRC)
        if self._protoc2C != None:
            w.writeUInt8(0x01)
            self._protoc2C.write(w)
        else:
            w.writeUInt8(0x00)
        w.writeString(self._userId)
        w.writeString(self._userName)
        w.writeUInt32(len(self._roles))
        for n1 in self._roles:
            w.writeInt32(n1)
        if self._hotfix != None:
            w.writeUInt8(0x01)
            w.writeUInt32(len(self._hotfix))
            for (k1,v1) in self._hotfix.items():
                w.writeString(k1)
                w.writeString(v1)
        else:
            w.writeUInt8(0x00)
   #def write

#class TestUserLoginR2C

if '__main__' == __name__:
    print('dir(TestUserLoginR2C()) =>\n' + '\n'.join(dir(TestUserLoginR2C())))
    print('TestUserLoginR2C.__doc__ => ' + TestUserLoginR2C.__doc__)
    print('TestUserLoginR2C.__len__ => ' + str(len(TestUserLoginR2C())))
    print('TestUserLoginR2C.__str__ => ' + str(TestUserLoginR2C()))
