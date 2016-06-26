#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===

from TestAbcCustom import Custom
try:
    from cStringIO import StringIO
except:
    from StringIO import StringIO
from InvarCodec import DataWriter
from InvarCodec import DataReader

class TestNest(object):

    """测试泛型相互嵌套"""
    CRC32_ = 0x6F0C2598
    SIZE_  = 12

    __slots__ = (
        '_listDict',
        '_dictList',
        '_list5d')
   #__slots__

    def __init__(self):
        self._listDict = []
        self._dictList = {}
        self._list5d   = []
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'TestNest')
        s.write(u',')
        s.write(u' ')
        s.write(u'listDict')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._listDict)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'dictList')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._dictList)))
        s.write(u']')
        s.write(u',')
        s.write(u' ')
        s.write(u'list5d')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._list5d)))
        s.write(u')')
        s.write(u' ')
        s.write(u'}')
        result = s.getvalue()
        s.close()
        return result
   #def __str__

    def __len__(self):
        size = TestNest.SIZE_
        size += 4
        for n1 in self._listDict:
            size += 4
            for (k2,v2) in n1.items():
                size += len(k2)
                size += len(v2)
        size += 4
        for (k1,v1) in self._dictList.items():
            size += 4
            for n2 in k1:
                size += len(n2)
            size += 4
            for n2 in v1:
                size += len(n2)
        size += 4
        for n1 in self._list5d:
            size += 4
            for n2 in n1:
                size += 4
                for n3 in n2:
                    size += 4
                    for n4 in n3:
                        size += 4
                        for n5 in n4:
                            size += len(n5)
        return size
   #def __len__

    def read(r):
        lenListDict = r.readUInt32()
        num = 0
        while num < lenListDict:
            num += 1
            n1 = dict() # read.vec.head
            lenN1 = r.readUInt32()
            num = 0
            while num < lenN1:
                num += 1
                k2 = r.readString()
                v2 = Custom()
                v2.read(r)
                n1[k2] = v2
            self._listDict.append(n1)
        lenDictList = r.readUInt32()
        num = 0
        while num < lenDictList:
            num += 1
            k1 = list() # read.map.head
            lenK1 = r.readUInt32()
            num = 0
            while num < lenK1:
                num += 1
                n2 = r.readString()
                k1.append(n2)
            v1 = list() # read.map.head
            lenV1 = r.readUInt32()
            num = 0
            while num < lenV1:
                num += 1
                n2 = Custom()
                n2.read(r)
                v1.append(n2)
            self._dictList[k1] = v1
        lenList5d = r.readUInt32()
        num = 0
        while num < lenList5d:
            num += 1
            n1 = list() # read.vec.head
            lenN1 = r.readUInt32()
            num = 0
            while num < lenN1:
                num += 1
                n2 = list() # read.vec.head
                lenN2 = r.readUInt32()
                num = 0
                while num < lenN2:
                    num += 1
                    n3 = list() # read.vec.head
                    lenN3 = r.readUInt32()
                    num = 0
                    while num < lenN3:
                        num += 1
                        n4 = list() # read.vec.head
                        lenN4 = r.readUInt32()
                        num = 0
                        while num < lenN4:
                            num += 1
                            n5 = Custom()
                            n5.read(r)
                            n4.append(n5)
                        n3.append(n4)
                    n2.append(n3)
                n1.append(n2)
            self._list5d.append(n1)
   #def read

    def write(w):
        w.writeUInt32(len(self._listDict))
        for n1 in self._listDict:
            w.writeUInt32(len(n1))
            for (k2,v2) in n1.items():
                w.writeString(k2)
                v2.write(w)
        w.writeUInt32(len(self._dictList))
        for (k1,v1) in self._dictList.items():
            w.writeUInt32(len(k1))
            for n2 in k1:
                w.writeString(n2)
            w.writeUInt32(len(v1))
            for n2 in v1:
                n2.write(w)
        w.writeUInt32(len(self._list5d))
        for n1 in self._list5d:
            w.writeUInt32(len(n1))
            for n2 in n1:
                w.writeUInt32(len(n2))
                for n3 in n2:
                    w.writeUInt32(len(n3))
                    for n4 in n3:
                        w.writeUInt32(len(n4))
                        for n5 in n4:
                            n5.write(w)
   #def write

#class TestNest

if '__main__' == __name__:
    print('dir(TestNest()) =>\n' + '\n'.join(dir(TestNest())))
    print('TestNest.__doc__ => ' + TestNest.__doc__)
    print('TestNest.__len__ => ' + str(len(TestNest())))
    print('TestNest.__str__ => ' + str(TestNest()))