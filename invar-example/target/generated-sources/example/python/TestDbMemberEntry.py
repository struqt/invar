#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===
try:
    from cStringIO import StringIO
except:
    from StringIO import StringIO
from InvarCodec import DataWriter
from InvarCodec import DataReader

class MemberEntry(object):

    """名字冲突的类型"""
    CRC32_ = 0x240151
    SIZE_  = 29

    __slots__ = (
        '_id',
        '_phone',
        '_nickName',
        '_createTime',
        '_updateTime',
        '_hotfix')
   #__slots__

    def __init__(self):
        self._id         = 0
        self._phone      = ''
        self._nickName   = ''
        self._createTime = -1
        self._updateTime = -1
        self._hotfix     = None
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'MemberEntry')
        s.write(u',')
        s.write(u' ')
        s.write(u'id')
        s.write(u':')
        s.write(unicode(self._id))
        s.write(u',')
        s.write(u' ')
        s.write(u'phone')
        s.write(u':')
        s.write(u'"')
        s.write(self._phone)
        s.write(u'"')
        s.write(u',')
        s.write(u' ')
        s.write(u'nickName')
        s.write(u':')
        s.write(u'"')
        s.write(self._nickName)
        s.write(u'"')
        s.write(u',')
        s.write(u' ')
        s.write(u'createTime')
        s.write(u':')
        s.write(unicode(self._createTime))
        s.write(u',')
        s.write(u' ')
        s.write(u'updateTime')
        s.write(u':')
        s.write(unicode(self._updateTime))
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
        size = MemberEntry.SIZE_
        size += len(self._phone)
        size += len(self._nickName)
        if self._hotfix is not None:
            size += 4
            for (k1,v1) in self._hotfix.items():
                size += len(k1)
                size += len(v1)
        return size
   #def __len__

    def read(r):
        self._id = r.readUInt32()
        self._phone = r.readString()
        self._nickName = r.readString()
        self._createTime = r.readInt64()
        self._updateTime = r.readInt64()
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
        w.writeUInt32(self._id)
        w.writeString(self._phone)
        w.writeString(self._nickName)
        w.writeInt64(self._createTime)
        w.writeInt64(self._updateTime)
        if self._hotfix != None:
            w.writeUInt8(0x01)
            w.writeUInt32(len(self._hotfix))
            for (k1,v1) in self._hotfix.items():
                w.writeString(k1)
                w.writeString(v1)
        else:
            w.writeUInt8(0x00)
   #def write

#class MemberEntry

if '__main__' == __name__:
    print('dir(MemberEntry()) =>\n' + '\n'.join(dir(MemberEntry())))
    print('MemberEntry.__doc__ => ' + MemberEntry.__doc__)
    print('MemberEntry.__len__ => ' + str(len(MemberEntry())))
    print('MemberEntry.__str__ => ' + str(MemberEntry()))