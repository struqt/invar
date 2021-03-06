<?php
/*===----------------------------*  PHP 5  *-------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace test\db;

require_once dirname(__FILE__) . '/../../invar/invar.codec.php';

use \invar\BinaryReader;
use \invar\BinaryWriter;

final class MemberEntry
{
    const CRC32 = 0x00240151;

    static public function &CreateFromBytes (& $str)
    {
        $o = new MemberEntry;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $id         ;/* 0 uint32 // 主键，自增长 */
    private $phone      ;/* 1 string // 手机号码 */
    private $nickName   ;/* 2 string // 会员昵称 */
    private $createTime ;/* 3 int64 // 创建时间 */
    private $updateTime ;/* 4 int64 // 创建时间 */
    private $hotfix     ;/* 5 map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->id         = 0;
        $this->phone      = '';
        $this->nickName   = '';
        $this->createTime = -1;
        $this->updateTime = -1;
        $this->hotfix     = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        $this->id = $from->id;
        $this->phone = $from->phone;
        $this->nickName = $from->nickName;
        $this->createTime = $from->createTime;
        $this->updateTime = $from->updateTime;
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
        $this->id = $r->readUInt32();
        $this->phone = $r->readUTF();
        $this->nickName = $r->readUTF();
        $this->createTime = $r->readInt64();
        $this->updateTime = $r->readInt64();
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
        BinaryWriter::writeUInt32($this->id, $str);
        BinaryWriter::writeUTF($this->phone, $str);
        BinaryWriter::writeUTF($this->nickName, $str);
        BinaryWriter::writeInt64($this->createTime, $str);
        BinaryWriter::writeInt64($this->updateTime, $str);
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

    /** 主键，自增长 */
    public function  getId() { return $this->id; }

    /** 手机号码 */
    public function &getPhone() { return $this->phone; }

    /** 会员昵称 */
    public function &getNickName() { return $this->nickName; }

    /** 创建时间 */
    public function  getCreateTime() { return $this->createTime; }

    /** 创建时间 */
    public function  getUpdateTime() { return $this->updateTime; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /** 主键，自增长 */
    public function setId($value) { $this->id = $value; return $this; }

    /** 手机号码 */
    public function setPhone($value) { $this->phone = $value; return $this; }

    /** 会员昵称 */
    public function setNickName($value) { $this->nickName = $value; return $this; }

    /** 创建时间 */
    public function setCreateTime($value) { $this->createTime = $value; return $this; }

    /** 创建时间 */
    public function setUpdateTime($value) { $this->updateTime = $value; return $this; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'id'; $s .= ':';
        $s .= $this->id;
        $s .= ','; $s .= 'phone'; $s .= ':';
        $s .= '"'; $s .= $this->phone; $s .= '"';
        $s .= ','; $s .= 'nickName'; $s .= ':';
        $s .= '"'; $s .= $this->nickName; $s .= '"';
        $s .= ','; $s .= 'createTime'; $s .= ':';
        $s .= $this->createTime;
        $s .= ','; $s .= 'updateTime'; $s .= ':';
        $s .= $this->updateTime;
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
        $s .= '"'; $s .= 'id'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->id;
        $phoneExists = !empty($this->phone);
        if (!empty($comma) && $phoneExists) { $s .= $comma; $comma = ''; }
        if ($phoneExists) {
            $s .= '"'; $s .= 'phone'; $s .= '"'; $s .= ':'; $comma = ',';
            $s .= '"'; $s .= $this->phone; $s .= '"';
        }
        $nickNameExists = !empty($this->nickName);
        if (!empty($comma) && $nickNameExists) { $s .= $comma; $comma = ''; }
        if ($nickNameExists) {
            $s .= '"'; $s .= 'nickName'; $s .= '"'; $s .= ':'; $comma = ',';
            $s .= '"'; $s .= $this->nickName; $s .= '"';
        }
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'createTime'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->createTime;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'updateTime'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->updateTime;
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
        $code .= "\n"; $code .= '<!-- '; $code .= 'MemberEntry'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'MemberEntry');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        $attrs .= ' '; $attrs .= 'id'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->id; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'phone'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->phone; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'nickName'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->nickName; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'createTime'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->createTime; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'updateTime'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->updateTime; $attrs .= '"';
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
