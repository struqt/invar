<?php
/*===----------------------------*  PHP 5  *-------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace test\xyz;

require_once dirname(__FILE__) . '/../../test/abc/Gender.php';
require_once dirname(__FILE__) . '/../../test/abc/Custom.php';
require_once dirname(__FILE__) . '/../../invar/invar.codec.php';

use \invar\BinaryReader;
use \invar\BinaryWriter;
use \test\abc\Custom;
use \test\abc\Gender;

final class TestPointer
{
    const CRC32 = 0xDF23C954;

    static public function &CreateFromBytes (& $str)
    {
        $o = new TestPointer;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $self         ;/* 0 test.xyz.TestPointer */
    private $stringValue  ;/* 1 string */
    private $other        ;/* 2 test.abc.Custom */
    private $listI08      ;/* 3 vec<int8> */
    private $dictI08      ;/* 4 map<int8,int8> */
    private $listNested   ;/* 5 vec<vec<vec<vec<test.xyz.TestPointer>>>> */
    private $numberSingle ;/* 6 float */
    private $enumValue    ;/* 7 test.abc.Gender */
    private $hotfix       ;/* 8 map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->self         = NULL;
        $this->stringValue  = NULL;
        $this->other        = NULL;
        $this->listI08      = NULL;
        $this->dictI08      = NULL;
        $this->listNested   = NULL;
        $this->numberSingle = 0.0;
        $this->enumValue    = Gender::NONE;
        $this->hotfix       = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        if ($from->self != NULL) {
            $this->self.copy($from->self);
        } else {
            $this->self = NULL;
        }
        $this->stringValue = $from->stringValue;
        if ($from->other != NULL) {
            $this->other.copy($from->other);
        } else {
            $this->other = NULL;
        }
        if ($from->listI08 != NULL) {
            $this->listI08 = array();
            $this->listI08 = array_merge($from->listI08);
        } else {
            $this->listI08 = NULL;
        }
        if ($from->dictI08 != NULL) {
            $this->dictI08 = array();
            $this->dictI08 = array_merge($from->dictI08);
        } else {
            $this->dictI08 = NULL;
        }
        if ($from->listNested != NULL) {
            $this->listNested = array();
            $this->listNested = array_merge($from->listNested);
        } else {
            $this->listNested = NULL;
        }
        $this->numberSingle = $from->numberSingle;
        $this->enumValue = $from->enumValue;
        if ($from->hotfix != NULL) {
            $this->hotfix = array();
            $this->hotfix = array_merge($from->hotfix);
        } else {
            $this->hotfix = NULL;
        }
        return $this;
    }
    /* End of copy(...) */

    public function &read (& $r)
    {
        $selfExists = $r->readInt08();
        if (0x01 == $selfExists) {
            if ($this->self == NULL) { $this->self = new TestPointer; }
            $this->self->read($r);
        }
        else if (0x00 == $selfExists) { $this->self = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $selfExists . ' is invalid.', 497); }
        $stringValueExists = $r->readInt08();
        if (0x01 == $stringValueExists) { $this->stringValue = $r->readUTF(); }
        else if (0x00 == $stringValueExists) { $this->stringValue = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $stringValueExists . ' is invalid.', 496); }
        $otherExists = $r->readInt08();
        if (0x01 == $otherExists) {
            if ($this->other == NULL) { $this->other = new Custom; }
            $this->other->read($r);
        }
        else if (0x00 == $otherExists) { $this->other = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $otherExists . ' is invalid.', 497); }
        $listI08Exists = $r->readInt08();
        if (0x01 == $listI08Exists) {
            if ($this->listI08 == NULL) { $this->listI08 = array(); }
            $lenListI08 = $r->readUInt32();
            for ($iListI08 = 0; $iListI08 < $lenListI08; ++$iListI08) {
                $n1 = $r->readInt08();
                $this->listI08[] = $n1;
            }
        }
        else if (0x00 == $listI08Exists) { $this->listI08 = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $listI08Exists . ' is invalid.', 498); }
        $dictI08Exists = $r->readInt08();
        if (0x01 == $dictI08Exists) {
            if ($this->dictI08 == NULL) { $this->dictI08 = array(); }
            $lenDictI08 = $r->readUInt32();
            for ($iDictI08 = 0; $iDictI08 < $lenDictI08; ++$iDictI08) {
                $k1 = $r->readInt08();
                $v1 = $r->readInt08();
                $this->dictI08[$k1] = $v1;
            }
        }
        else if (0x00 == $dictI08Exists) { $this->dictI08 = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $dictI08Exists . ' is invalid.', 498); }
        $listNestedExists = $r->readInt08();
        if (0x01 == $listNestedExists) {
            if ($this->listNested == NULL) { $this->listNested = array(); }
            $lenListNested = $r->readUInt32();
            for ($iListNested = 0; $iListNested < $lenListNested; ++$iListNested) {
                $n1 = array(); //read.vec.head
                $lenN1 = $r->readUInt32();
                for ($iN1 = 0; $iN1 < $lenN1; ++$iN1) {
                    $n2 = array(); //read.vec.head
                    $lenN2 = $r->readUInt32();
                    for ($iN2 = 0; $iN2 < $lenN2; ++$iN2) {
                        $n3 = array(); //read.vec.head
                        $lenN3 = $r->readUInt32();
                        for ($iN3 = 0; $iN3 < $lenN3; ++$iN3) {
                            $n4 = new TestPointer();
                            $n4->read($r);
                            $n3[] = $n4;
                        }
                        $n2[] = $n3;
                    }
                    $n1[] = $n2;
                }
                $this->listNested[] = $n1;
            }
        }
        else if (0x00 == $listNestedExists) { $this->listNested = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $listNestedExists . ' is invalid.', 498); }
        $this->numberSingle = $r->readFloat32();
        $this->enumValue = $r->readInt32();
        $hotfixExists = $r->readInt08();
        if (0x01 == $hotfixExists) {
            if ($this->hotfix == NULL) { $this->hotfix = array(); }
            $lenHotfix = $r->readUInt32();
            for ($iHotfix = 0; $iHotfix < $lenHotfix; ++$iHotfix) {
                $k1 = $r->readUTF();
                $v1 = $r->readUTF();
                $this->hotfix[$k1] = $v1;
            }
        }
        else if (0x00 == $hotfixExists) { $this->hotfix = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $hotfixExists . ' is invalid.', 498); }
        return $this;
    }
    /* End of read(...) */

    public function write (& $str)
    {
        if ($this->self != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            $this->self->write($str);
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        if ($this->stringValue != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            BinaryWriter::writeUTF($this->stringValue, $str);
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        if ($this->other != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            $this->other->write($str);
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        if ($this->listI08 != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            BinaryWriter::writeInt32(count($this->listI08), $str);
            foreach ($this->listI08 as &$n1) {
                BinaryWriter::writeInt08($n1, $str);
            }
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        if ($this->dictI08 != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            BinaryWriter::writeInt32(count($this->dictI08), $str);
            foreach ($this->dictI08 as $k1 => &$v1) {
                BinaryWriter::writeInt08($k1, $str);
                BinaryWriter::writeInt08($v1, $str);
            }
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        if ($this->listNested != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            BinaryWriter::writeInt32(count($this->listNested), $str);
            foreach ($this->listNested as &$n1) {
                BinaryWriter::writeInt32(count($n1), $str);
                foreach ($n1 as &$n2) {
                    BinaryWriter::writeInt32(count($n2), $str);
                    foreach ($n2 as &$n3) {
                        BinaryWriter::writeInt32(count($n3), $str);
                        foreach ($n3 as &$n4) {
                            $n4->write($str);
                        }
                    }
                }
            }
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        BinaryWriter::writeFloat32($this->numberSingle, $str);
        BinaryWriter::writeInt32($this->enumValue, $str);
        if ($this->hotfix != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            BinaryWriter::writeInt32(count($this->hotfix), $str);
            foreach ($this->hotfix as $k1 => &$v1) {
                BinaryWriter::writeUTF($k1, $str);
                BinaryWriter::writeUTF($v1, $str);
            }
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
    }
    /* End of write(...) */

    /**  */
    public function getSelf() { return $this->self; }

    /**  */
    public function getStringValue() { return $this->stringValue; }

    /**  */
    public function getOther() { return $this->other; }

    /**  */
    public function getListI08() { return $this->listI08; }

    /**  */
    public function getDictI08() { return $this->dictI08; }

    /**  */
    public function getListNested() { return $this->listNested; }

    /**  */
    public function  getNumberSingle() { return $this->numberSingle; }

    /**  */
    public function  getEnumValue() { return $this->enumValue; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /**  */
    public function setSelf($value) { $this->self = $value; return $this; }

    /**  */
    public function setStringValue($value) { $this->stringValue = $value; return $this; }

    /**  */
    public function setOther($value) { $this->other = $value; return $this; }

    /**  */
    public function setListI08($value) { $this->listI08 = $value; return $this; }

    /**  */
    public function setDictI08($value) { $this->dictI08 = $value; return $this; }

    /**  */
    public function setListNested($value) { $this->listNested = $value; return $this; }

    /**  */
    public function setNumberSingle($value) { $this->numberSingle = $value; return $this; }

    /**  */
    public function setEnumValue($value) { $this->enumValue = $value; return $this; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'self'; $s .= ':';
        if (isset($this->self)) { $s .= '<'; $s .= 'TestPointer'; $s .= '>'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'stringValue'; $s .= ':';
        if (isset($this->stringValue)) { $s .= '"'; $s .= $this->stringValue; $s .= '"'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'other'; $s .= ':';
        if (isset($this->other)) { $s .= '<'; $s .= 'Custom'; $s .= '>'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'listI08'; $s .= ':';
        if (isset($this->listI08)) { $s .= '('; $s .= count($this->listI08); $s .= ')'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'dictI08'; $s .= ':';
        if (isset($this->dictI08)) { $s .= '['; $s .= count($this->dictI08); $s .= ']'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'listNested'; $s .= ':';
        if (isset($this->listNested)) { $s .= '('; $s .= count($this->listNested); $s .= ')'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'numberSingle'; $s .= ':';
        $s .= $this->numberSingle;
        $s .= ','; $s .= 'enumValue'; $s .= ':';
        $s .= $this->enumValue;
        $s .= ','; $s .= 'hotfix'; $s .= ':';
        if (isset($this->hotfix)) { $s .= '['; $s .= count($this->hotfix); $s .= ']'; }
        else { $s .= 'null'; }
        $s .= '}';
        return $s;
    }
    /* End of toString() */

    public function &toStringJSON()
    {
        $code = '';
        $this->writeJSON($code);
        return $code;
    }

    public function writeJSON(& $s)
    {
        $s .= "\n"; $s .= '{';
        $selfExists = isset($this->self);
        if ($selfExists) {
            $s .= '"'; $s .= 'self'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->self->writeJSON($s);
        }
        $stringValueExists = !empty($this->stringValue);
        if (!empty($comma) && $stringValueExists) { $s .= $comma; $comma = ''; }
        if ($stringValueExists) {
            $s .= '"'; $s .= 'stringValue'; $s .= '"'; $s .= ':'; $comma = ',';
            $s .= '"'; $s .= $this->stringValue; $s .= '"';
        }
        $otherExists = isset($this->other);
        if (!empty($comma) && $otherExists) { $s .= $comma; $comma = ''; }
        if ($otherExists) {
            $s .= '"'; $s .= 'other'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->other->writeJSON($s);
        }
        $listI08Exists = (isset($this->listI08) && count($this->listI08) > 0);
        if (!empty($comma) && $listI08Exists) { $s .= $comma; $comma = ''; }
        if ($listI08Exists) {
            $s .= '"'; $s .= 'listI08'; $s .= '"'; $s .= ':'; $comma = ',';
            $listI08Size = (!isset($this->listI08) ? 0 : count($this->listI08));
            $s .= "\n"; $s .= '[';
            $listI08Idx = 0;
            foreach ($this->listI08 as &$n1) {
                $s .= $n1;
                ++$listI08Idx;
                if ($listI08Idx != $listI08Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $dictI08Exists = (isset($this->dictI08) && count($this->dictI08) > 0);
        if (!empty($comma) && $dictI08Exists) { $s .= $comma; $comma = ''; }
        if ($dictI08Exists) {
            $s .= '"'; $s .= 'dictI08'; $s .= '"'; $s .= ':'; $comma = ',';
            $dictI08Size = (!isset($this->dictI08) ? 0 : count($this->dictI08));
            $s .= "\n"; $s .= '{';
            $dictI08Idx = 0;
            foreach ($this->dictI08 as $k1 => &$v1) {
                $s .= $k1;
                $s .= $v1;
                ++$dictI08Idx;
                if (dictI08Idx != $dictI08Size) { $s .= ','; }
            }
            $s .= '}';
        }
        $listNestedExists = (isset($this->listNested) && count($this->listNested) > 0);
        if (!empty($comma) && $listNestedExists) { $s .= $comma; $comma = ''; }
        if ($listNestedExists) {
            $s .= '"'; $s .= 'listNested'; $s .= '"'; $s .= ':'; $comma = ',';
            $listNestedSize = (!isset($this->listNested) ? 0 : count($this->listNested));
            $s .= "\n"; $s .= '[';
            $listNestedIdx = 0;
            foreach ($this->listNested as &$n1) {
                $n1Size = (!isset($n1) ? 0 : count($n1));
                $s .= "\n"; $s .= '[';
                $n1Idx = 0;
                foreach ($n1 as &$n2) {
                    $n2Size = (!isset($n2) ? 0 : count($n2));
                    $s .= "\n"; $s .= '[';
                    $n2Idx = 0;
                    foreach ($n2 as &$n3) {
                        $n3Size = (!isset($n3) ? 0 : count($n3));
                        $s .= "\n"; $s .= '[';
                        $n3Idx = 0;
                        foreach ($n3 as &$n4) {
                            $n4->writeJSON($s);
                            ++$n3Idx;
                            if ($n3Idx != $n3Size) { $s .= ','; }
                        }
                        $s .= ']';
                        ++$n2Idx;
                        if ($n2Idx != $n2Size) { $s .= ','; }
                    }
                    $s .= ']';
                    ++$n1Idx;
                    if ($n1Idx != $n1Size) { $s .= ','; }
                }
                $s .= ']';
                ++$listNestedIdx;
                if ($listNestedIdx != $listNestedSize) { $s .= ','; }
            }
            $s .= ']';
        }
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'numberSingle'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= number_format($this->numberSingle, 6, '.', '');
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'enumValue'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->enumValue;
        $hotfixExists = (isset($this->hotfix) && count($this->hotfix) > 0);
        if (!empty($comma) && $hotfixExists) { $s .= $comma; $comma = ''; }
        if ($hotfixExists) {
            $s .= '"'; $s .= 'hotfix'; $s .= '"'; $s .= ':'; $comma = ',';
            $hotfixSize = (!isset($this->hotfix) ? 0 : count($this->hotfix));
            $s .= "\n"; $s .= '{';
            $hotfixIdx = 0;
            foreach ($this->hotfix as $k1 => &$v1) {
                $s .= '"'; $s .= $k1; $s .= '"';
                $s .= '"'; $s .= $v1; $s .= '"';
                ++$hotfixIdx;
                if (hotfixIdx != $hotfixSize) { $s .= ','; }
            }
            $s .= '}';
        }
        $s .= '}'; $s .= "\n";
    }
    /* End of writeJSON(...) */

    public function &toStringXML()
    {
        $code  = '<?xml version="1.0" encoding="UTF-8"?>';
        $code .= "\n"; $code .= '<!-- '; $code .= 'TestPointer'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'TestPointer');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        if (isset($this->self)) {
            $this->self->writeXML($nodes, 'self');
        }
        if (isset($this->stringValue)) {
            $attrs .= ' stringValue="';
            $attrs .= $$this->stringValue;
            $attrs .= '"';
        }
        if (isset($this->other)) {
            $this->other->writeXML($nodes, 'other');
        }
        if (isset($this->listI08) && count($this->listI08) > 0) {
            $nodes .= '<'; $nodes .= 'listI08'; $nodes .= '>';
            foreach ($this->listI08 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listI08'; $nodes .= '>';
        }
        if (isset($this->dictI08) && count($this->dictI08) > 0) {
            $nodes .= '<'; $nodes .= 'dictI08'; $nodes .= '>';
            foreach ($this->dictI08 as $k1 => &$v1) {
                $nodes .= '<'; $nodes .= 'k1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$k1; $nodes .= '"';  $nodes .= '/>';
                $nodes .= '<'; $nodes .= 'v1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$v1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'dictI08'; $nodes .= '>';
        }
        if (isset($this->listNested) && count($this->listNested) > 0) {
            $nodes .= '<'; $nodes .= 'listNested'; $nodes .= '>';
            foreach ($this->listNested as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= '>';
                foreach ($n1 as &$n2) {
                    $nodes .= '<'; $nodes .= 'n2'; $nodes .= '>';
                    foreach ($n2 as &$n3) {
                        $nodes .= '<'; $nodes .= 'n3'; $nodes .= '>';
                        foreach ($n3 as &$n4) {
                            $n4->writeXML($nodes, 'n4');
                        }
                        $nodes .= '</'; $nodes .= 'n3'; $nodes .= '>';
                    }
                    $nodes .= '</'; $nodes .= 'n2'; $nodes .= '>';
                }
                $nodes .= '</'; $nodes .= 'n1'; $nodes .= '>';
            }
            $nodes .= '</'; $nodes .= 'listNested'; $nodes .= '>';
        }
        $attrs .= ' '; $attrs .= 'numberSingle'; $attrs .= '=';
        $attrs .= '"'; $attrs .= number_format($this->numberSingle, 6, '.', ''); $attrs .= '"';
        $attrs .= ' '; $attrs .= 'enumValue'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->enumValue; $attrs .= '"';
        if (isset($this->hotfix) && count($this->hotfix) > 0) {
            $nodes .= '<'; $nodes .= 'hotfix'; $nodes .= '>';
            foreach ($this->hotfix as $k1 => &$v1) {
                $nodes .= '<'; $nodes .= 'k1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$k1; $nodes .= '"';  $nodes .= '/>';
                $nodes .= '<'; $nodes .= 'v1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$v1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'hotfix'; $nodes .= '>';
        }
        $s .= '<';
        $s .= $name;
        $s .= $attrs;
        if (strlen($nodes) == 0) {
            $s .= '/>';
        } else {
            $s .= '>'; $s .= $nodes;
            $s .= '</'; $s .= $name; $s .= '>';
        }
    }
    /* End of writeXML(...) */

}
