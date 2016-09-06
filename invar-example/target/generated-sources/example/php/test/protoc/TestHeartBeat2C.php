<?php
/*===----------------------------*  PHP 5  *-------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace test\protoc;

require_once dirname(__FILE__) . '/../../invar/invar.codec.php';
require_once dirname(__FILE__) . '/../../test/protoc/Protoc2C.php';

use \invar\BinaryReader;
use \invar\BinaryWriter;

final class TestHeartBeat2C
{
    const CRC32 = 0xCC52B7AE;

    static public function &CreateFromBytes (& $str)
    {
        $o = new TestHeartBeat2C;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $protocId  ;/*  uint16 // [AutoAdd] ProtocolID */
    private $protocCRC ;/*  uint32 // [AutoAdd] Protocol CRC32 */
    private $protoc2C  ;/*  test.protoc.Protoc2C // [AutoAdd] 服务端响应的公共数据 */
    private $hotfix    ;/*  map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->protocId  = 65534;
        $this->protocCRC = self::CRC32;
        $this->protoc2C  = NULL;
        $this->hotfix    = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        $this->protocId = $from->protocId;
        $this->protocCRC = $from->protocCRC;
        if ($from->protoc2C != NULL) {
            $this->protoc2C.copy($from->protoc2C);
        } else {
            $this->protoc2C = NULL;
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
        $this->protocId = $r->readUInt16();
        $this->protocCRC = $r->readUInt32();
        if (self::CRC32 != $this->protocCRC) { throw new \Exception('Protoc read error: CRC32 is mismatched', 499); }
        $protoc2CExists = $r->readInt08();
        if (0x01 == $protoc2CExists) {
            if ($this->protoc2C == NULL) { $this->protoc2C = new Protoc2C; }
            $this->protoc2C->read($r);
        }
        else if (0x00 == $protoc2CExists) { $this->protoc2C = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $protoc2CExists . ' is invalid.', 497); }
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
        BinaryWriter::writeUInt16($this->protocId, $str);
        BinaryWriter::writeUInt32($this->protocCRC, $str);
        if ($this->protoc2C != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            $this->protoc2C->write($str);
        } else {
            BinaryWriter::writeInt08(0x00, $str);
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

    /** [AutoAdd] ProtocolID */
    public function  getProtocId() { return $this->protocId; }

    /** [AutoAdd] Protocol CRC32 */
    public function  getProtocCRC() { return $this->protocCRC; }

    /** [AutoAdd] 服务端响应的公共数据 */
    public function getProtoc2C() { return $this->protoc2C; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /** [AutoAdd] 服务端响应的公共数据 */
    public function setProtoc2C($value) { $this->protoc2C = $value; return $this; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'protocId'; $s .= ':';
        $s .= $this->protocId;
        $s .= ','; $s .= 'protocCRC'; $s .= ':';
        $s .= $this->protocCRC;
        $s .= ','; $s .= 'protoc2C'; $s .= ':';
        if (isset($this->protoc2C)) { $s .= '<'; $s .= 'Protoc2C'; $s .= '>'; }
        else { $s .= 'null'; }
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
        $s .= '"'; $s .= 'protocId'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->protocId;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'protocCRC'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->protocCRC;
        $protoc2CExists = isset($this->protoc2C);
        if (!empty($comma) && $protoc2CExists) { $s .= $comma; $comma = ''; }
        if ($protoc2CExists) {
            $s .= '"'; $s .= 'protoc2C'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->protoc2C->writeJSON($s);
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
        $code .= "\n"; $code .= '<!-- '; $code .= 'TestHeartBeat2C'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'TestHeartBeat2C');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        $attrs .= ' '; $attrs .= 'protocId'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->protocId; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'protocCRC'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->protocCRC; $attrs .= '"';
        if (isset($this->protoc2C)) {
            $this->protoc2C->writeXML($nodes, 'protoc2C');
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
