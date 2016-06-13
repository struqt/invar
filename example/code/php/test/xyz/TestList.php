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

final class TestList
{
    const CRC32 = 0xEAC770C2;

    static public function &CreateFromBytes (& $str)
    {
        $o = new TestList;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $listI08     ;/* 0 vec<int8> // 有符号的8位整数 */
    private $listI16     ;/* 1 vec<int16> // 有符号的16位整数 */
    private $listI32     ;/* 2 vec<int32> // 有符号的32位整数 */
    private $listI64     ;/* 3 vec<int64> // 有符号的64位整数 */
    private $listU08     ;/* 4 vec<uint8> // 无符号的8位整数 */
    private $listU16     ;/* 5 vec<uint16> // 无符号的16位整数 */
    private $listU32     ;/* 6 vec<uint32> // 无符号的32位整数 */
    private $listU64     ;/* 7 vec<uint64> // 无符号的64位整数 */
    private $listSingle  ;/* 8 vec<float> // 单精度浮点小数 */
    private $listDouble  ;/* 9 vec<double> // 双精度浮点小数 */
    private $listBoolean ;/* 10 vec<bool> // 布尔值 */
    private $listString  ;/* 11 vec<string> // 字符串 */
    private $listEnum    ;/* 12 vec<test.abc.Gender> // 枚举值 */
    private $listStruct  ;/* 13 vec<test.abc.Custom> // 自定义结构 */
    private $hotfix      ;/* 14 map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->listI08     = array();
        $this->listI16     = array();
        $this->listI32     = array();
        $this->listI64     = array();
        $this->listU08     = array();
        $this->listU16     = array();
        $this->listU32     = array();
        $this->listU64     = array();
        $this->listSingle  = array();
        $this->listDouble  = array();
        $this->listBoolean = array();
        $this->listString  = array();
        $this->listEnum    = array();
        $this->listStruct  = array();
        $this->hotfix      = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        if ($from->listI08 != NULL) {
            $this->listI08 = array_merge($from->listI08);
        } else {
            $this->listI08 = array();
        }
        if ($from->listI16 != NULL) {
            $this->listI16 = array_merge($from->listI16);
        } else {
            $this->listI16 = array();
        }
        if ($from->listI32 != NULL) {
            $this->listI32 = array_merge($from->listI32);
        } else {
            $this->listI32 = array();
        }
        if ($from->listI64 != NULL) {
            $this->listI64 = array_merge($from->listI64);
        } else {
            $this->listI64 = array();
        }
        if ($from->listU08 != NULL) {
            $this->listU08 = array_merge($from->listU08);
        } else {
            $this->listU08 = array();
        }
        if ($from->listU16 != NULL) {
            $this->listU16 = array_merge($from->listU16);
        } else {
            $this->listU16 = array();
        }
        if ($from->listU32 != NULL) {
            $this->listU32 = array_merge($from->listU32);
        } else {
            $this->listU32 = array();
        }
        if ($from->listU64 != NULL) {
            $this->listU64 = array_merge($from->listU64);
        } else {
            $this->listU64 = array();
        }
        if ($from->listSingle != NULL) {
            $this->listSingle = array_merge($from->listSingle);
        } else {
            $this->listSingle = array();
        }
        if ($from->listDouble != NULL) {
            $this->listDouble = array_merge($from->listDouble);
        } else {
            $this->listDouble = array();
        }
        if ($from->listBoolean != NULL) {
            $this->listBoolean = array_merge($from->listBoolean);
        } else {
            $this->listBoolean = array();
        }
        if ($from->listString != NULL) {
            $this->listString = array_merge($from->listString);
        } else {
            $this->listString = array();
        }
        if ($from->listEnum != NULL) {
            $this->listEnum = array_merge($from->listEnum);
        } else {
            $this->listEnum = array();
        }
        if ($from->listStruct != NULL) {
            $this->listStruct = array_merge($from->listStruct);
        } else {
            $this->listStruct = array();
        }
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
        $this->listI08 = array();
        $lenListI08 = $r->readUInt32();
        for ($iListI08 = 0; $iListI08 < $lenListI08; ++$iListI08) {
            $n1 = $r->readInt08();
            $this->listI08[] = $n1;
        }
        $this->listI16 = array();
        $lenListI16 = $r->readUInt32();
        for ($iListI16 = 0; $iListI16 < $lenListI16; ++$iListI16) {
            $n1 = $r->readInt16();
            $this->listI16[] = $n1;
        }
        $this->listI32 = array();
        $lenListI32 = $r->readUInt32();
        for ($iListI32 = 0; $iListI32 < $lenListI32; ++$iListI32) {
            $n1 = $r->readInt32();
            $this->listI32[] = $n1;
        }
        $this->listI64 = array();
        $lenListI64 = $r->readUInt32();
        for ($iListI64 = 0; $iListI64 < $lenListI64; ++$iListI64) {
            $n1 = $r->readInt64();
            $this->listI64[] = $n1;
        }
        $this->listU08 = array();
        $lenListU08 = $r->readUInt32();
        for ($iListU08 = 0; $iListU08 < $lenListU08; ++$iListU08) {
            $n1 = $r->readUInt08();
            $this->listU08[] = $n1;
        }
        $this->listU16 = array();
        $lenListU16 = $r->readUInt32();
        for ($iListU16 = 0; $iListU16 < $lenListU16; ++$iListU16) {
            $n1 = $r->readUInt16();
            $this->listU16[] = $n1;
        }
        $this->listU32 = array();
        $lenListU32 = $r->readUInt32();
        for ($iListU32 = 0; $iListU32 < $lenListU32; ++$iListU32) {
            $n1 = $r->readUInt64();
            $this->listU32[] = $n1;
        }
        $this->listU64 = array();
        $lenListU64 = $r->readUInt32();
        for ($iListU64 = 0; $iListU64 < $lenListU64; ++$iListU64) {
            $n1 = $r->readUInt64();
            $this->listU64[] = $n1;
        }
        $this->listSingle = array();
        $lenListSingle = $r->readUInt32();
        for ($iListSingle = 0; $iListSingle < $lenListSingle; ++$iListSingle) {
            $n1 = $r->readFloat32();
            $this->listSingle[] = $n1;
        }
        $this->listDouble = array();
        $lenListDouble = $r->readUInt32();
        for ($iListDouble = 0; $iListDouble < $lenListDouble; ++$iListDouble) {
            $n1 = $r->readFloat64();
            $this->listDouble[] = $n1;
        }
        $this->listBoolean = array();
        $lenListBoolean = $r->readUInt32();
        for ($iListBoolean = 0; $iListBoolean < $lenListBoolean; ++$iListBoolean) {
            $n1 = $r->readBoolean();
            $this->listBoolean[] = $n1;
        }
        $this->listString = array();
        $lenListString = $r->readUInt32();
        for ($iListString = 0; $iListString < $lenListString; ++$iListString) {
            $n1 = $r->readUTF();
            $this->listString[] = $n1;
        }
        $this->listEnum = array();
        $lenListEnum = $r->readUInt32();
        for ($iListEnum = 0; $iListEnum < $lenListEnum; ++$iListEnum) {
            $n1 = $r->readInt32();
            $this->listEnum[] = $n1;
        }
        $this->listStruct = array();
        $lenListStruct = $r->readUInt32();
        for ($iListStruct = 0; $iListStruct < $lenListStruct; ++$iListStruct) {
            $n1 = new Custom();
            $n1->read($r);
            $this->listStruct[] = $n1;
        }
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
        BinaryWriter::writeInt32(count($this->listI08), $str);
        foreach ($this->listI08 as &$n1) {
            BinaryWriter::writeInt08($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listI16), $str);
        foreach ($this->listI16 as &$n1) {
            BinaryWriter::writeInt16($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listI32), $str);
        foreach ($this->listI32 as &$n1) {
            BinaryWriter::writeInt32($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listI64), $str);
        foreach ($this->listI64 as &$n1) {
            BinaryWriter::writeInt64($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listU08), $str);
        foreach ($this->listU08 as &$n1) {
            BinaryWriter::writeUInt08($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listU16), $str);
        foreach ($this->listU16 as &$n1) {
            BinaryWriter::writeUInt16($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listU32), $str);
        foreach ($this->listU32 as &$n1) {
            BinaryWriter::writeUInt64($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listU64), $str);
        foreach ($this->listU64 as &$n1) {
            BinaryWriter::writeUInt64($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listSingle), $str);
        foreach ($this->listSingle as &$n1) {
            BinaryWriter::writeFloat32($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listDouble), $str);
        foreach ($this->listDouble as &$n1) {
            BinaryWriter::writeFloat64($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listBoolean), $str);
        foreach ($this->listBoolean as &$n1) {
            BinaryWriter::writeBoolean($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listString), $str);
        foreach ($this->listString as &$n1) {
            BinaryWriter::writeUTF($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listEnum), $str);
        foreach ($this->listEnum as &$n1) {
            BinaryWriter::writeInt32($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->listStruct), $str);
        foreach ($this->listStruct as &$n1) {
            $n1->write($str);
        }
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

    /** 有符号的8位整数 */
    public function &getListI08() { return $this->listI08; }

    /** 有符号的16位整数 */
    public function &getListI16() { return $this->listI16; }

    /** 有符号的32位整数 */
    public function &getListI32() { return $this->listI32; }

    /** 有符号的64位整数 */
    public function &getListI64() { return $this->listI64; }

    /** 无符号的8位整数 */
    public function &getListU08() { return $this->listU08; }

    /** 无符号的16位整数 */
    public function &getListU16() { return $this->listU16; }

    /** 无符号的32位整数 */
    public function &getListU32() { return $this->listU32; }

    /** 无符号的64位整数 */
    public function &getListU64() { return $this->listU64; }

    /** 单精度浮点小数 */
    public function &getListSingle() { return $this->listSingle; }

    /** 双精度浮点小数 */
    public function &getListDouble() { return $this->listDouble; }

    /** 布尔值 */
    public function &getListBoolean() { return $this->listBoolean; }

    /** 字符串 */
    public function &getListString() { return $this->listString; }

    /** 枚举值 */
    public function &getListEnum() { return $this->listEnum; }

    /** 自定义结构 */
    public function &getListStruct() { return $this->listStruct; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'listI08'; $s .= ':';
        $s .= '('; $s .= count($this->listI08); $s .= ')';
        $s .= ','; $s .= 'listI16'; $s .= ':';
        $s .= '('; $s .= count($this->listI16); $s .= ')';
        $s .= ','; $s .= 'listI32'; $s .= ':';
        $s .= '('; $s .= count($this->listI32); $s .= ')';
        $s .= ','; $s .= 'listI64'; $s .= ':';
        $s .= '('; $s .= count($this->listI64); $s .= ')';
        $s .= ','; $s .= 'listU08'; $s .= ':';
        $s .= '('; $s .= count($this->listU08); $s .= ')';
        $s .= ','; $s .= 'listU16'; $s .= ':';
        $s .= '('; $s .= count($this->listU16); $s .= ')';
        $s .= ','; $s .= 'listU32'; $s .= ':';
        $s .= '('; $s .= count($this->listU32); $s .= ')';
        $s .= ','; $s .= 'listU64'; $s .= ':';
        $s .= '('; $s .= count($this->listU64); $s .= ')';
        $s .= ','; $s .= 'listSingle'; $s .= ':';
        $s .= '('; $s .= count($this->listSingle); $s .= ')';
        $s .= ','; $s .= 'listDouble'; $s .= ':';
        $s .= '('; $s .= count($this->listDouble); $s .= ')';
        $s .= ','; $s .= 'listBoolean'; $s .= ':';
        $s .= '('; $s .= count($this->listBoolean); $s .= ')';
        $s .= ','; $s .= 'listString'; $s .= ':';
        $s .= '('; $s .= count($this->listString); $s .= ')';
        $s .= ','; $s .= 'listEnum'; $s .= ':';
        $s .= '('; $s .= count($this->listEnum); $s .= ')';
        $s .= ','; $s .= 'listStruct'; $s .= ':';
        $s .= '('; $s .= count($this->listStruct); $s .= ')';
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
        $listI08Exists = (isset($this->listI08) && count($this->listI08) > 0);
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
        $listI16Exists = (isset($this->listI16) && count($this->listI16) > 0);
        if (!empty($comma) && $listI16Exists) { $s .= $comma; $comma = ''; }
        if ($listI16Exists) {
            $s .= '"'; $s .= 'listI16'; $s .= '"'; $s .= ':'; $comma = ',';
            $listI16Size = (!isset($this->listI16) ? 0 : count($this->listI16));
            $s .= "\n"; $s .= '[';
            $listI16Idx = 0;
            foreach ($this->listI16 as &$n1) {
                $s .= $n1;
                ++$listI16Idx;
                if ($listI16Idx != $listI16Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listI32Exists = (isset($this->listI32) && count($this->listI32) > 0);
        if (!empty($comma) && $listI32Exists) { $s .= $comma; $comma = ''; }
        if ($listI32Exists) {
            $s .= '"'; $s .= 'listI32'; $s .= '"'; $s .= ':'; $comma = ',';
            $listI32Size = (!isset($this->listI32) ? 0 : count($this->listI32));
            $s .= "\n"; $s .= '[';
            $listI32Idx = 0;
            foreach ($this->listI32 as &$n1) {
                $s .= $n1;
                ++$listI32Idx;
                if ($listI32Idx != $listI32Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listI64Exists = (isset($this->listI64) && count($this->listI64) > 0);
        if (!empty($comma) && $listI64Exists) { $s .= $comma; $comma = ''; }
        if ($listI64Exists) {
            $s .= '"'; $s .= 'listI64'; $s .= '"'; $s .= ':'; $comma = ',';
            $listI64Size = (!isset($this->listI64) ? 0 : count($this->listI64));
            $s .= "\n"; $s .= '[';
            $listI64Idx = 0;
            foreach ($this->listI64 as &$n1) {
                $s .= $n1;
                ++$listI64Idx;
                if ($listI64Idx != $listI64Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listU08Exists = (isset($this->listU08) && count($this->listU08) > 0);
        if (!empty($comma) && $listU08Exists) { $s .= $comma; $comma = ''; }
        if ($listU08Exists) {
            $s .= '"'; $s .= 'listU08'; $s .= '"'; $s .= ':'; $comma = ',';
            $listU08Size = (!isset($this->listU08) ? 0 : count($this->listU08));
            $s .= "\n"; $s .= '[';
            $listU08Idx = 0;
            foreach ($this->listU08 as &$n1) {
                $s .= $n1;
                ++$listU08Idx;
                if ($listU08Idx != $listU08Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listU16Exists = (isset($this->listU16) && count($this->listU16) > 0);
        if (!empty($comma) && $listU16Exists) { $s .= $comma; $comma = ''; }
        if ($listU16Exists) {
            $s .= '"'; $s .= 'listU16'; $s .= '"'; $s .= ':'; $comma = ',';
            $listU16Size = (!isset($this->listU16) ? 0 : count($this->listU16));
            $s .= "\n"; $s .= '[';
            $listU16Idx = 0;
            foreach ($this->listU16 as &$n1) {
                $s .= $n1;
                ++$listU16Idx;
                if ($listU16Idx != $listU16Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listU32Exists = (isset($this->listU32) && count($this->listU32) > 0);
        if (!empty($comma) && $listU32Exists) { $s .= $comma; $comma = ''; }
        if ($listU32Exists) {
            $s .= '"'; $s .= 'listU32'; $s .= '"'; $s .= ':'; $comma = ',';
            $listU32Size = (!isset($this->listU32) ? 0 : count($this->listU32));
            $s .= "\n"; $s .= '[';
            $listU32Idx = 0;
            foreach ($this->listU32 as &$n1) {
                $s .= $n1;
                ++$listU32Idx;
                if ($listU32Idx != $listU32Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listU64Exists = (isset($this->listU64) && count($this->listU64) > 0);
        if (!empty($comma) && $listU64Exists) { $s .= $comma; $comma = ''; }
        if ($listU64Exists) {
            $s .= '"'; $s .= 'listU64'; $s .= '"'; $s .= ':'; $comma = ',';
            $listU64Size = (!isset($this->listU64) ? 0 : count($this->listU64));
            $s .= "\n"; $s .= '[';
            $listU64Idx = 0;
            foreach ($this->listU64 as &$n1) {
                $s .= $n1;
                ++$listU64Idx;
                if ($listU64Idx != $listU64Size) { $s .= ','; }
            }
            $s .= ']';
        }
        $listSingleExists = (isset($this->listSingle) && count($this->listSingle) > 0);
        if (!empty($comma) && $listSingleExists) { $s .= $comma; $comma = ''; }
        if ($listSingleExists) {
            $s .= '"'; $s .= 'listSingle'; $s .= '"'; $s .= ':'; $comma = ',';
            $listSingleSize = (!isset($this->listSingle) ? 0 : count($this->listSingle));
            $s .= "\n"; $s .= '[';
            $listSingleIdx = 0;
            foreach ($this->listSingle as &$n1) {
                $s .= number_format($n1, 6, '.', '');
                ++$listSingleIdx;
                if ($listSingleIdx != $listSingleSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $listDoubleExists = (isset($this->listDouble) && count($this->listDouble) > 0);
        if (!empty($comma) && $listDoubleExists) { $s .= $comma; $comma = ''; }
        if ($listDoubleExists) {
            $s .= '"'; $s .= 'listDouble'; $s .= '"'; $s .= ':'; $comma = ',';
            $listDoubleSize = (!isset($this->listDouble) ? 0 : count($this->listDouble));
            $s .= "\n"; $s .= '[';
            $listDoubleIdx = 0;
            foreach ($this->listDouble as &$n1) {
                $s .= $n1;
                ++$listDoubleIdx;
                if ($listDoubleIdx != $listDoubleSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $listBooleanExists = (isset($this->listBoolean) && count($this->listBoolean) > 0);
        if (!empty($comma) && $listBooleanExists) { $s .= $comma; $comma = ''; }
        if ($listBooleanExists) {
            $s .= '"'; $s .= 'listBoolean'; $s .= '"'; $s .= ':'; $comma = ',';
            $listBooleanSize = (!isset($this->listBoolean) ? 0 : count($this->listBoolean));
            $s .= "\n"; $s .= '[';
            $listBooleanIdx = 0;
            foreach ($this->listBoolean as &$n1) {
                $s .= $n1 ? "true" : "false";
                ++$listBooleanIdx;
                if ($listBooleanIdx != $listBooleanSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $listStringExists = (isset($this->listString) && count($this->listString) > 0);
        if (!empty($comma) && $listStringExists) { $s .= $comma; $comma = ''; }
        if ($listStringExists) {
            $s .= '"'; $s .= 'listString'; $s .= '"'; $s .= ':'; $comma = ',';
            $listStringSize = (!isset($this->listString) ? 0 : count($this->listString));
            $s .= "\n"; $s .= '[';
            $listStringIdx = 0;
            foreach ($this->listString as &$n1) {
                $s .= '"'; $s .= $n1; $s .= '"';
                ++$listStringIdx;
                if ($listStringIdx != $listStringSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $listEnumExists = (isset($this->listEnum) && count($this->listEnum) > 0);
        if (!empty($comma) && $listEnumExists) { $s .= $comma; $comma = ''; }
        if ($listEnumExists) {
            $s .= '"'; $s .= 'listEnum'; $s .= '"'; $s .= ':'; $comma = ',';
            $listEnumSize = (!isset($this->listEnum) ? 0 : count($this->listEnum));
            $s .= "\n"; $s .= '[';
            $listEnumIdx = 0;
            foreach ($this->listEnum as &$n1) {
                $s .= $n1;
                ++$listEnumIdx;
                if ($listEnumIdx != $listEnumSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $listStructExists = (isset($this->listStruct) && count($this->listStruct) > 0);
        if (!empty($comma) && $listStructExists) { $s .= $comma; $comma = ''; }
        if ($listStructExists) {
            $s .= '"'; $s .= 'listStruct'; $s .= '"'; $s .= ':'; $comma = ',';
            $listStructSize = (!isset($this->listStruct) ? 0 : count($this->listStruct));
            $s .= "\n"; $s .= '[';
            $listStructIdx = 0;
            foreach ($this->listStruct as &$n1) {
                $n1->writeJSON($s);
                ++$listStructIdx;
                if ($listStructIdx != $listStructSize) { $s .= ','; }
            }
            $s .= ']';
        }
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
        $code .= "\n"; $code .= '<!-- '; $code .= 'TestList'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'TestList');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        if (count($this->listI08) > 0) {
            $nodes .= '<'; $nodes .= 'listI08'; $nodes .= '>';
            foreach ($this->listI08 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listI08'; $nodes .= '>';
        }
        if (count($this->listI16) > 0) {
            $nodes .= '<'; $nodes .= 'listI16'; $nodes .= '>';
            foreach ($this->listI16 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listI16'; $nodes .= '>';
        }
        if (count($this->listI32) > 0) {
            $nodes .= '<'; $nodes .= 'listI32'; $nodes .= '>';
            foreach ($this->listI32 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listI32'; $nodes .= '>';
        }
        if (count($this->listI64) > 0) {
            $nodes .= '<'; $nodes .= 'listI64'; $nodes .= '>';
            foreach ($this->listI64 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listI64'; $nodes .= '>';
        }
        if (count($this->listU08) > 0) {
            $nodes .= '<'; $nodes .= 'listU08'; $nodes .= '>';
            foreach ($this->listU08 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listU08'; $nodes .= '>';
        }
        if (count($this->listU16) > 0) {
            $nodes .= '<'; $nodes .= 'listU16'; $nodes .= '>';
            foreach ($this->listU16 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listU16'; $nodes .= '>';
        }
        if (count($this->listU32) > 0) {
            $nodes .= '<'; $nodes .= 'listU32'; $nodes .= '>';
            foreach ($this->listU32 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listU32'; $nodes .= '>';
        }
        if (count($this->listU64) > 0) {
            $nodes .= '<'; $nodes .= 'listU64'; $nodes .= '>';
            foreach ($this->listU64 as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listU64'; $nodes .= '>';
        }
        if (count($this->listSingle) > 0) {
            $nodes .= '<'; $nodes .= 'listSingle'; $nodes .= '>';
            foreach ($this->listSingle as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $number_format($n1, 6, '.', ''); $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listSingle'; $nodes .= '>';
        }
        if (count($this->listDouble) > 0) {
            $nodes .= '<'; $nodes .= 'listDouble'; $nodes .= '>';
            foreach ($this->listDouble as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listDouble'; $nodes .= '>';
        }
        if (count($this->listBoolean) > 0) {
            $nodes .= '<'; $nodes .= 'listBoolean'; $nodes .= '>';
            foreach ($this->listBoolean as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1 ? "true" : "false"; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listBoolean'; $nodes .= '>';
        }
        if (count($this->listString) > 0) {
            $nodes .= '<'; $nodes .= 'listString'; $nodes .= '>';
            foreach ($this->listString as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listString'; $nodes .= '>';
        }
        if (count($this->listEnum) > 0) {
            $nodes .= '<'; $nodes .= 'listEnum'; $nodes .= '>';
            foreach ($this->listEnum as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'listEnum'; $nodes .= '>';
        }
        if (count($this->listStruct) > 0) {
            $nodes .= '<'; $nodes .= 'listStruct'; $nodes .= '>';
            foreach ($this->listStruct as &$n1) {
                $n1->writeXML($nodes, 'n1');
            }
            $nodes .= '</'; $nodes .= 'listStruct'; $nodes .= '>';
        }
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
