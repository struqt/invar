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

class TestRefer(object):

    """引用类型测试"""
    CRC32_ = 0xBBD63AFD
    SIZE_  = 60

    __slots__ = (
        '_numberi08',
        '_numberi16',
        '_numberi32',
        '_numberi64',
        '_numberu08',
        '_numberu16',
        '_numberu32',
        '_numberu64',
        '_numberSingle',
        '_numberDouble',
        '_boolValue',
        '_stringValue',
        '_enumValue',
        '_other',
        '_self',
        '_listI08',
        '_dictI08')
   #__slots__

    def __init__(self):
        self._numberi08    = -1
        self._numberi16    = -1
        self._numberi32    = -1
        self._numberi64    = -1
        self._numberu08    = 0
        self._numberu16    = 0
        self._numberu32    = 0
        self._numberu64    = 0
        self._numberSingle = 0.0
        self._numberDouble = 0.00
        self._boolValue    = False
        self._stringValue  = ''
        self._enumValue    = Gender.NONE
        self._other        = Custom()
        self._self         = None
        self._listI08      = []
        self._dictI08      = {}
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'TestRefer')
        s.write(u',')
        s.write(u' ')
        s.write(u'numberi08')
        s.write(u':')
        s.write(unicode(self._numberi08))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberi16')
        s.write(u':')
        s.write(unicode(self._numberi16))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberi32')
        s.write(u':')
        s.write(unicode(self._numberi32))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberi64')
        s.write(u':')
        s.write(unicode(self._numberi64))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberu08')
        s.write(u':')
        s.write(unicode(self._numberu08))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberu16')
        s.write(u':')
        s.write(unicode(self._numberu16))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberu32')
        s.write(u':')
        s.write(unicode(self._numberu32))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberu64')
        s.write(u':')
        s.write(unicode(self._numberu64))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberSingle')
        s.write(u':')
        s.write(unicode(self._numberSingle))
        s.write(u',')
        s.write(u' ')
        s.write(u'numberDouble')
        s.write(u':')
        s.write(unicode(self._numberDouble))
        s.write(u',')
        s.write(u' ')
        s.write(u'boolValue')
        s.write(u':')
        s.write(unicode(self._boolValue))
        s.write(u',')
        s.write(u' ')
        s.write(u'stringValue')
        s.write(u':')
        s.write(u'"')
        s.write(self._stringValue)
        s.write(u'"')
        s.write(u',')
        s.write(u' ')
        s.write(u'enumValue')
        s.write(u':')
        s.write(unicode(self._enumValue))
        s.write(u',')
        s.write(u' ')
        s.write(u'other')
        s.write(u':')
        s.write(u'<')
        s.write(u'Custom')
        s.write(u'>')
        s.write(u',')
        s.write(u' ')
        s.write(u'self')
        s.write(u':')
        if self._self is None:
            s.write(u'null')
        else:
            s.write(u'<')
            s.write(u'TestRefer')
            s.write(u'>')
        s.write(u',')
        s.write(u' ')
        s.write(u'listI08')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listI08)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'dictI08')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._dictI08)))
        s.write(u']')
        s.write(u' ')
        s.write(u'}')
        result = s.getvalue()
        s.close()
        return result
   #def __str__

    def __len__(self):
        size = TestRefer.SIZE_
        size += len(self._stringValue)
        size += len(self._other)
        if self._self is not None:
            size += len(self._self)
        if len(self._listI08) > 0:
            size += len(self._listI08) * 1
        if len(self._dictI08) > 0:
            size += len(self._dictI08) * 2
        return size
   #def __len__

    def read(r):
        self._numberi08 = r.readInt8()
        self._numberi16 = r.readInt16()
        self._numberi32 = r.readInt32()
        self._numberi64 = r.readInt64()
        self._numberu08 = r.readUInt8()
        self._numberu16 = r.readUInt16()
        self._numberu32 = r.readUInt32()
        self._numberu64 = r.readUInt64()
        self._numberSingle = r.readSingle()
        self._numberDouble = r.readDouble()
        self._boolValue = r.readBoolean()
        self._stringValue = r.readString()
        self._enumValue = r.readInt32()
        self._other.read(r)
        selfExists = r.readInt8()
        if 0x01 == selfExists:
            if self._self == None:
                self._self = TestRefer()
            self._self.read(r)
        elif 0x00 == selfExists:
            self._self = None
        else:
            raise InvarError(497, 'Protoc read error: The value of \'selfExists\' is invalid.')
        lenListI08 = r.readUInt32()
        num = 0
        while num < lenListI08:
            num += 1
            n1 = r.readInt8()
            self._listI08.append(n1)
        lenDictI08 = r.readUInt32()
        num = 0
        while num < lenDictI08:
            num += 1
            k1 = r.readInt8()
            v1 = r.readInt8()
            self._dictI08[k1] = v1
   #def read

    def write(w):
        w.writeInt8(self._numberi08)
        w.writeInt16(self._numberi16)
        w.writeInt32(self._numberi32)
        w.writeInt64(self._numberi64)
        w.writeUInt8(self._numberu08)
        w.writeUInt16(self._numberu16)
        w.writeUInt32(self._numberu32)
        w.writeUInt64(self._numberu64)
        w.writeFloat(self._numberSingle)
        w.writeDouble(self._numberDouble)
        w.writeBool(self._boolValue)
        w.writeString(self._stringValue)
        w.writeInt32(self._enumValue)
        self._other.write(w)
        if self._self != None:
            w.writeUInt8(0x01)
            self._self.write(w)
        else:
            w.writeUInt8(0x00)
        w.writeUInt32(len(self._listI08))
        for n1 in self._listI08:
            w.writeInt8(n1)
        w.writeUInt32(len(self._dictI08))
        for (k1,v1) in self._dictI08.items():
            w.writeInt8(k1)
            w.writeInt8(v1)
   #def write

#class TestRefer

if '__main__' == __name__:
    print('dir(TestRefer()) =>\n' + '\n'.join(dir(TestRefer())))
    print('TestRefer.__doc__ => ' + TestRefer.__doc__)
    print('TestRefer.__len__ => ' + str(len(TestRefer())))
    print('TestRefer.__str__ => ' + str(TestRefer()))
