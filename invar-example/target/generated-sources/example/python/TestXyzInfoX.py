#!/usr/bin/env python
# -*- coding: utf-8 -*-
# ===------------------------------*  Python  *------------------------------===
#             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
# ===------------------------------------------------------------------------===

from TestAbcConflict import TestAbcConflict
from TestAbcGender import Gender
from TestAbcInfo import Info
from TestXyzConflict import TestXyzConflict
try:
    from cStringIO import StringIO
except:
    from StringIO import StringIO
from InvarCodec import DataWriter
from InvarCodec import DataReader

class InfoX(object):

    """Complex data structure"""
    CRC32_ = 0xF55867E1
    SIZE_  = 41

    __slots__ = (
        '_infos',
        '_conflict_x',
        '_conflict_a',
        '_mConflict',
        '_info2d',
        '_info3d',
        '_info5d',
        '_infovm',
        '_mvei',
        '_mive',
        '_mvive',
        '_vmvive',
        '_hotfix')
   #__slots__

    def __init__(self):
        self._infos      = []
        self._conflict_x = TestXyzConflict()
        self._conflict_a = TestAbcConflict()
        self._mConflict  = {}
        self._info2d     = []
        self._info3d     = []
        self._info5d     = []
        self._infovm     = []
        self._mvei       = {}
        self._mive       = {}
        self._mvive      = {}
        self._vmvive     = []
        self._hotfix     = None
   #def __init__

    def __str__(self):
        s = StringIO()
        s.write(u'{')
        s.write(u' ')
        s.write(u'InfoX')
        s.write(u',')
        s.write(u' ')
        s.write(u'infos')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._infos)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'conflict_x')
        s.write(u':')
        s.write(u'<')
        s.write(u'TestXyzConflict')
        s.write(u'>')
        s.write(u',')
        s.write(u' ')
        s.write(u'conflict_a')
        s.write(u':')
        s.write(u'<')
        s.write(u'TestAbcConflict')
        s.write(u'>')
        s.write(u',')
        s.write(u' ')
        s.write(u'mConflict')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._mConflict)))
        s.write(u']')
        s.write(u',')
        s.write(u' ')
        s.write(u'info2d')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._info2d)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'info3d')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._info3d)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'info5d')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._info5d)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'infovm')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._infovm)))
        s.write(u')')
        s.write(u',')
        s.write(u' ')
        s.write(u'mvei')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._mvei)))
        s.write(u']')
        s.write(u',')
        s.write(u' ')
        s.write(u'mive')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._mive)))
        s.write(u']')
        s.write(u',')
        s.write(u' ')
        s.write(u'mvive')
        s.write(u':')
        s.write(u'[')
        s.write(str(len(self._mvive)))
        s.write(u']')
        s.write(u',')
        s.write(u' ')
        s.write(u'vmvive')
        s.write(u':')
        s.write(u'(')
        s.write(str(len(self._vmvive)))
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
        size = InfoX.SIZE_
        size += 4
        for n1 in self._infos:
            size += 4
            for n2 in n1:
                size += 4
                for n3 in n2:
                    size += 4
                    for n4 in n3:
                        size += 4
                        for n5 in n4:
                            size += len(n5)
        size += len(self._conflict_x)
        size += len(self._conflict_a)
        size += 4
        for (k1,v1) in self._mConflict.items():
            size += sizeof(int32_t)
            size += len(v1)
        size += 4
        for n1 in self._info2d:
            size += 4
            for n2 in n1:
                size += len(n2)
        size += 4
        for n1 in self._info3d:
            size += 4
            for n2 in n1:
                size += 4
                for n3 in n2:
                    size += len(n3)
        size += 4
        for n1 in self._info5d:
            size += 4
            for n2 in n1:
                size += 4
                for n3 in n2:
                    size += 4
                    for n4 in n3:
                        size += 4
                        for n5 in n4:
                            size += len(n5)
        size += 4
        for n1 in self._infovm:
            size += 4
            for (k2,v2) in n1.items():
                size += sizeof(int16_t)
                size += len(v2)
        size += 4
        for (k1,v1) in self._mvei.items():
            if len(k1) > 0:
                size += len(k1) * 4
            size += len(v1)
        size += 4
        for (k1,v1) in self._mive.items():
            size += len(k1)
            if len(v1) > 0:
                size += len(v1) * 4
        size += 4
        for (k1,v1) in self._mvive.items():
            size += 4
            for n2 in k1:
                size += len(n2)
            if len(v1) > 0:
                size += len(v1) * 4
        size += 4
        for n1 in self._vmvive:
            size += 4
            for (k2,v2) in n1.items():
                size += 4
                for n3 in k2:
                    size += len(n3)
                if len(v2) > 0:
                    size += len(v2) * 4
        if self._hotfix is not None:
            size += 4
            for (k1,v1) in self._hotfix.items():
                size += len(k1)
                size += len(v1)
        return size
   #def __len__

    def read(r):
        lenInfos = r.readUInt32()
        num = 0
        while num < lenInfos:
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
                            n5 = Info()
                            n5.read(r)
                            n4.append(n5)
                        n3.append(n4)
                    n2.append(n3)
                n1.append(n2)
            self._infos.append(n1)
        self._conflict_x.read(r)
        self._conflict_a.read(r)
        lenMConflict = r.readUInt32()
        num = 0
        while num < lenMConflict:
            num += 1
            k1 = r.readInt32()
            v1 = TestAbcConflict()
            v1.read(r)
            self._mConflict[k1] = v1
        lenInfo2d = r.readUInt32()
        num = 0
        while num < lenInfo2d:
            num += 1
            n1 = list() # read.vec.head
            lenN1 = r.readUInt32()
            num = 0
            while num < lenN1:
                num += 1
                n2 = Info()
                n2.read(r)
                n1.append(n2)
            self._info2d.append(n1)
        lenInfo3d = r.readUInt32()
        num = 0
        while num < lenInfo3d:
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
                    n3 = Info()
                    n3.read(r)
                    n2.append(n3)
                n1.append(n2)
            self._info3d.append(n1)
        lenInfo5d = r.readUInt32()
        num = 0
        while num < lenInfo5d:
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
                            n5 = Info()
                            n5.read(r)
                            n4.append(n5)
                        n3.append(n4)
                    n2.append(n3)
                n1.append(n2)
            self._info5d.append(n1)
        lenInfovm = r.readUInt32()
        num = 0
        while num < lenInfovm:
            num += 1
            n1 = dict() # read.vec.head
            lenN1 = r.readUInt32()
            num = 0
            while num < lenN1:
                num += 1
                k2 = r.readInt16()
                v2 = Info()
                v2.read(r)
                n1[k2] = v2
            self._infovm.append(n1)
        lenMvei = r.readUInt32()
        num = 0
        while num < lenMvei:
            num += 1
            k1 = list() # read.map.head
            lenK1 = r.readUInt32()
            num = 0
            while num < lenK1:
                num += 1
                n2 = r.readInt32()
                k1.append(n2)
            v1 = Info()
            v1.read(r)
            self._mvei[k1] = v1
        lenMive = r.readUInt32()
        num = 0
        while num < lenMive:
            num += 1
            k1 = Info()
            k1.read(r)
            v1 = list() # read.map.head
            lenV1 = r.readUInt32()
            num = 0
            while num < lenV1:
                num += 1
                n2 = r.readInt32()
                v1.append(n2)
            self._mive[k1] = v1
        lenMvive = r.readUInt32()
        num = 0
        while num < lenMvive:
            num += 1
            k1 = list() # read.map.head
            lenK1 = r.readUInt32()
            num = 0
            while num < lenK1:
                num += 1
                n2 = Info()
                n2.read(r)
                k1.append(n2)
            v1 = list() # read.map.head
            lenV1 = r.readUInt32()
            num = 0
            while num < lenV1:
                num += 1
                n2 = r.readInt32()
                v1.append(n2)
            self._mvive[k1] = v1
        lenVmvive = r.readUInt32()
        num = 0
        while num < lenVmvive:
            num += 1
            n1 = dict() # read.vec.head
            lenN1 = r.readUInt32()
            num = 0
            while num < lenN1:
                num += 1
                k2 = list() # read.map.head
                lenK2 = r.readUInt32()
                num = 0
                while num < lenK2:
                    num += 1
                    n3 = Info()
                    n3.read(r)
                    k2.append(n3)
                v2 = list() # read.map.head
                lenV2 = r.readUInt32()
                num = 0
                while num < lenV2:
                    num += 1
                    n3 = r.readInt32()
                    v2.append(n3)
                n1[k2] = v2
            self._vmvive.append(n1)
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
        w.writeUInt32(len(self._infos))
        for n1 in self._infos:
            w.writeUInt32(len(n1))
            for n2 in n1:
                w.writeUInt32(len(n2))
                for n3 in n2:
                    w.writeUInt32(len(n3))
                    for n4 in n3:
                        w.writeUInt32(len(n4))
                        for n5 in n4:
                            n5.write(w)
        self._conflict_x.write(w)
        self._conflict_a.write(w)
        w.writeUInt32(len(self._mConflict))
        for (k1,v1) in self._mConflict.items():
            w.writeInt32(k1)
            v1.write(w)
        w.writeUInt32(len(self._info2d))
        for n1 in self._info2d:
            w.writeUInt32(len(n1))
            for n2 in n1:
                n2.write(w)
        w.writeUInt32(len(self._info3d))
        for n1 in self._info3d:
            w.writeUInt32(len(n1))
            for n2 in n1:
                w.writeUInt32(len(n2))
                for n3 in n2:
                    n3.write(w)
        w.writeUInt32(len(self._info5d))
        for n1 in self._info5d:
            w.writeUInt32(len(n1))
            for n2 in n1:
                w.writeUInt32(len(n2))
                for n3 in n2:
                    w.writeUInt32(len(n3))
                    for n4 in n3:
                        w.writeUInt32(len(n4))
                        for n5 in n4:
                            n5.write(w)
        w.writeUInt32(len(self._infovm))
        for n1 in self._infovm:
            w.writeUInt32(len(n1))
            for (k2,v2) in n1.items():
                w.writeInt16(k2)
                v2.write(w)
        w.writeUInt32(len(self._mvei))
        for (k1,v1) in self._mvei.items():
            w.writeUInt32(len(k1))
            for n2 in k1:
                w.writeInt32(n2)
            v1.write(w)
        w.writeUInt32(len(self._mive))
        for (k1,v1) in self._mive.items():
            k1.write(w)
            w.writeUInt32(len(v1))
            for n2 in v1:
                w.writeInt32(n2)
        w.writeUInt32(len(self._mvive))
        for (k1,v1) in self._mvive.items():
            w.writeUInt32(len(k1))
            for n2 in k1:
                n2.write(w)
            w.writeUInt32(len(v1))
            for n2 in v1:
                w.writeInt32(n2)
        w.writeUInt32(len(self._vmvive))
        for n1 in self._vmvive:
            w.writeUInt32(len(n1))
            for (k2,v2) in n1.items():
                w.writeUInt32(len(k2))
                for n3 in k2:
                    n3.write(w)
                w.writeUInt32(len(v2))
                for n3 in v2:
                    w.writeInt32(n3)
        if self._hotfix != None:
            w.writeUInt8(0x01)
            w.writeUInt32(len(self._hotfix))
            for (k1,v1) in self._hotfix.items():
                w.writeString(k1)
                w.writeString(v1)
        else:
            w.writeUInt8(0x00)
   #def write

#class InfoX

if '__main__' == __name__:
    print('dir(InfoX()) =>\n' + '\n'.join(dir(InfoX())))
    print('InfoX.__doc__ => ' + InfoX.__doc__)
    print('InfoX.__len__ => ' + str(len(InfoX())))
    print('InfoX.__str__ => ' + str(InfoX()))
