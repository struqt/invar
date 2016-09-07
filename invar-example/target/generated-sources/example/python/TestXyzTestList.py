#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===

from TestAbcCustom import Custom
from TestAbcGender import Gender
try:
    from cStringIO import StringIO
except:
    from StringIO import StringIO
from InvarCodec import DataWriter
from InvarCodec import DataReader

class TestList(object):

    """测试基本的列表类型"""
    CRC32_ = 0x5FD1194A
    SIZE_  = 56

    __slots__ = (
        '_listI08',
        '_listI16',
        '_listI32',
        '_listI64',
        '_listU08',
        '_listU16',
        '_listU32',
        '_listU64',
        '_listSingle',
        '_listDouble',
        '_listBoolean',
        '_listString',
        '_listEnum',
        '_listStruct')
   #__slots__

    def __init__(self):
        self._listI08     = []
        self._listI16     = []
        self._listI32     = []
        self._listI64     = []
        self._listU08     = []
        self._listU16     = []
        self._listU32     = []
        self._listU64     = []
        self._listSingle  = []
        self._listDouble  = []
        self._listBoolean = []
        self._listString  = []
        self._listEnum    = []
        self._listStruct  = []
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'TestList')
        s.write(u',')
        s.write(u' ')
        s.write(u'listI08')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listI08)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listI16')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listI16)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listI32')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listI32)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listI64')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listI64)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listU08')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listU08)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listU16')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listU16)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listU32')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listU32)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listU64')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listU64)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listSingle')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listSingle)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listDouble')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listDouble)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listBoolean')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listBoolean)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listString')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listString)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listEnum')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listEnum)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'listStruct')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listStruct)))
        s.write(u')')
        s.write(u' ')
        s.write(u'}')
        result = s.getvalue()
        s.close()
        return result
   #def __str__

    def __len__(self):
        size = TestList.SIZE_
        if len(self._listI08) > 0:
            size += len(self._listI08) * 1
        if len(self._listI16) > 0:
            size += len(self._listI16) * 2
        if len(self._listI32) > 0:
            size += len(self._listI32) * 4
        if len(self._listI64) > 0:
            size += len(self._listI64) * 8
        if len(self._listU08) > 0:
            size += len(self._listU08) * 1
        if len(self._listU16) > 0:
            size += len(self._listU16) * 2
        if len(self._listU32) > 0:
            size += len(self._listU32) * 4
        if len(self._listU64) > 0:
            size += len(self._listU64) * 4
        if len(self._listSingle) > 0:
            size += len(self._listSingle) * 4
        if len(self._listDouble) > 0:
            size += len(self._listDouble) * 8
        if len(self._listBoolean) > 0:
            size += len(self._listBoolean) * 1
        size += 4
        for n1 in self._listString:
            size += len(n1)
        if len(self._listEnum) > 0:
            size += len(self._listEnum) * 4
        size += 4
        for n1 in self._listStruct:
            size += len(n1)
        return size
   #def __len__

    def read(r):
        lenListI08 = r.readUInt32()
        num = 0
        while num < lenListI08:
            num += 1
            n1 = r.readInt8()
            self._listI08.append(n1)
        lenListI16 = r.readUInt32()
        num = 0
        while num < lenListI16:
            num += 1
            n1 = r.readInt16()
            self._listI16.append(n1)
        lenListI32 = r.readUInt32()
        num = 0
        while num < lenListI32:
            num += 1
            n1 = r.readInt32()
            self._listI32.append(n1)
        lenListI64 = r.readUInt32()
        num = 0
        while num < lenListI64:
            num += 1
            n1 = r.readInt64()
            self._listI64.append(n1)
        lenListU08 = r.readUInt32()
        num = 0
        while num < lenListU08:
            num += 1
            n1 = r.readUInt8()
            self._listU08.append(n1)
        lenListU16 = r.readUInt32()
        num = 0
        while num < lenListU16:
            num += 1
            n1 = r.readUInt16()
            self._listU16.append(n1)
        lenListU32 = r.readUInt32()
        num = 0
        while num < lenListU32:
            num += 1
            n1 = r.readUInt32()
            self._listU32.append(n1)
        lenListU64 = r.readUInt32()
        num = 0
        while num < lenListU64:
            num += 1
            n1 = r.readUInt32()
            self._listU64.append(n1)
        lenListSingle = r.readUInt32()
        num = 0
        while num < lenListSingle:
            num += 1
            n1 = r.readSingle()
            self._listSingle.append(n1)
        lenListDouble = r.readUInt32()
        num = 0
        while num < lenListDouble:
            num += 1
            n1 = r.readDouble()
            self._listDouble.append(n1)
        lenListBoolean = r.readUInt32()
        num = 0
        while num < lenListBoolean:
            num += 1
            n1 = r.readBoolean()
            self._listBoolean.append(n1)
        lenListString = r.readUInt32()
        num = 0
        while num < lenListString:
            num += 1
            n1 = r.readString()
            self._listString.append(n1)
        lenListEnum = r.readUInt32()
        num = 0
        while num < lenListEnum:
            num += 1
            n1 = r.readInt32()
            self._listEnum.append(n1)
        lenListStruct = r.readUInt32()
        num = 0
        while num < lenListStruct:
            num += 1
            n1 = Custom()
            n1.read(r)
            self._listStruct.append(n1)
   #def read

    def write(w):
        w.writeUInt32(len(self._listI08))
        for n1 in self._listI08:
            w.writeInt8(n1)
        w.writeUInt32(len(self._listI16))
        for n1 in self._listI16:
            w.writeInt16(n1)
        w.writeUInt32(len(self._listI32))
        for n1 in self._listI32:
            w.writeInt32(n1)
        w.writeUInt32(len(self._listI64))
        for n1 in self._listI64:
            w.writeInt64(n1)
        w.writeUInt32(len(self._listU08))
        for n1 in self._listU08:
            w.writeUInt8(n1)
        w.writeUInt32(len(self._listU16))
        for n1 in self._listU16:
            w.writeUInt16(n1)
        w.writeUInt32(len(self._listU32))
        for n1 in self._listU32:
            w.writeUInt32(n1)
        w.writeUInt32(len(self._listU64))
        for n1 in self._listU64:
            w.writeUInt32(n1)
        w.writeUInt32(len(self._listSingle))
        for n1 in self._listSingle:
            w.writeFloat(n1)
        w.writeUInt32(len(self._listDouble))
        for n1 in self._listDouble:
            w.writeDouble(n1)
        w.writeUInt32(len(self._listBoolean))
        for n1 in self._listBoolean:
            w.writeBool(n1)
        w.writeUInt32(len(self._listString))
        for n1 in self._listString:
            w.writeString(n1)
        w.writeUInt32(len(self._listEnum))
        for n1 in self._listEnum:
            w.writeInt32(n1)
        w.writeUInt32(len(self._listStruct))
        for n1 in self._listStruct:
            n1.write(w)
   #def write

#class TestList

if '__main__' == __name__:
    print('dir(TestList()) =>\n' + '\n'.join(dir(TestList())))
    print('TestList.__doc__ => ' + TestList.__doc__)
    print('TestList.__len__ => ' + str(len(TestList())))
    print('TestList.__str__ => ' + str(TestList()))