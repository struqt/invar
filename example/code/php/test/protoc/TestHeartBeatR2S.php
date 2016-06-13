<?php
/*===----------------------------*  PHP 5  *-------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace test\protoc;

require_once dirname(__FILE__) . '/../../test/protoc/Protoc2S.php';
require_once dirname(__FILE__) . '/../../invar/invar.codec.php';

use \invar\BinaryReader;
use \invar\BinaryWriter;

final class TestHeartBeatR2S
{
    const CRC32 = 0x629B4C46;

    static public function &CreateFromBytes (& $str)
    {
        $o = new TestHeartBeatR2S;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $protocId    ;/*  uint16 // [AutoAdd] ProtocolID */
    private $protocCRC   ;/*  uint32 // [AutoAdd] Protocol CRC32 */
    private $protocError ;/*  uint16 // [AutoAdd] Protocol error code */
    private $protoc2S    ;/*  test.protoc.Protoc2S // [AutoAdd] 客户端请求的公共数据 */
    private $hotfix      ;/*  map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->protocId    = 65533;
        $this->protocCRC   = self::CRC32;
        $this->protocError = 0;
        $this->protoc2S    = NULL;
        $this->hotfix      = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        $this->protocId = $from->protocId;
        $this->protocCRC = $from->protocCRC;
        $this->protocError = $from->protocError;
        if ($from->protoc2S != NULL) {
            $this->protoc2S.copy($from->protoc2S);
        } else {
            $this->protoc2S = NULL;
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
        $this->protocError = $r->readUInt16();
        if ($this->protocError != 0) {
            throw new \Exception('Protoc read error: The code is ' . $this->protocError, $this->protocError);
        }
        $protoc2SExists = $r->readInt08();
        if (0x01 == $protoc2SExists) {
            if ($this->protoc2S == NULL) { $this->protoc2S = new Protoc2S; }
            $this->protoc2S->read($r);
        }
        else if (0x00 == $protoc2SExists) { $this->protoc2S = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $protoc2SExists . ' is invalid.', 497); }
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
        BinaryWriter::writeUInt16($this->protocError, $str);
        if ($this->protocError != 0) { return; }
        if ($this->protoc2S != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            $this->protoc2S->write($str);
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

    /** [AutoAdd] Protocol error code */
    public function  getProtocError() { return $this->protocError; }

    /** [AutoAdd] 客户端请求的公共数据 */
    public function getProtoc2S() { return $this->protoc2S; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /** [AutoAdd] Protocol error code */
    public function setProtocError($value) { $this->protocError = $value; return $this; }

    /** [AutoAdd] 客户端请求的公共数据 */
    public function setProtoc2S($value) { $this->protoc2S = $value; return $this; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'protocId'; $s .= ':';
        $s .= $this->protocId;
        $s .= ','; $s .= 'protocCRC'; $s .= ':';
        $s .= $this->protocCRC;
        $s .= ','; $s .= 'protocError'; $s .= ':';
        $s .= $this->protocError;
        $s .= ','; $s .= 'protoc2S'; $s .= ':';
        if (isset($this->protoc2S)) { $s .= '<'; $s .= 'Protoc2S'; $s .= '>'; }
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
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'protocError'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->protocError;
        $protoc2SExists = isset($this->protoc2S);
        if (!empty($comma) && $protoc2SExists) { $s .= $comma; $comma = ''; }
        if ($protoc2SExists) {
            $s .= '"'; $s .= 'protoc2S'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->protoc2S->writeJSON($s);
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
        $code .= "\n"; $code .= '<!-- '; $code .= 'TestHeartBeatR2S'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'TestHeartBeatR2S');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        $attrs .= ' '; $attrs .= 'protocId'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->protocId; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'protocCRC'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->protocCRC; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'protocError'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->protocError; $attrs .= '"';
        if (isset($this->protoc2S)) {
            $this->protoc2S->writeXML($nodes, 'protoc2S');
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
