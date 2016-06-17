<?php
/*===----------------------------*  PHP 5  *-------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace test\abc;

require_once dirname(__FILE__) . '/../../test/xyz/Conflict.php';
require_once dirname(__FILE__) . '/../../test/abc/Gender.php';
require_once dirname(__FILE__) . '/../../test/abc/Conflict.php';
require_once dirname(__FILE__) . '/../../invar/invar.codec.php';

use \invar\BinaryReader;
use \invar\BinaryWriter;

final class Info
{
    const CRC32 = 0xD718E7CE;

    static public function &CreateFromBytes (& $str)
    {
        $o = new Info;
        $o->read(new BinaryReader($str));
        return $o;
    }

    private $key           ;/* f0 int32 */
    private $number01      ;/* f1 int8 */
    private $number02      ;/* f2 int16 */
    private $number03      ;/* f3 int32 */
    private $number04      ;/* f4 int64 // Test field comments */
    private $number05      ;/* f5 uint8 */
    private $number06      ;/* f6 uint16 */
    private $number07      ;/* f7 uint32 */
    private $number08      ;/* f8 uint64 */
    private $number09      ;/* f9 float */
    private $number10      ;/* f10 double */
    private $isReal        ;/* f11 bool */
    private $s             ;/* f12 string // a string */
    private $world         ;/* f13 vec<string> */
    private $gender        ;/* f14 test.abc.Gender */
    private $next          ;/* f15 test.abc.Info */
    private $conflict      ;/* f16 test.abc.Conflict */
    private $conflicts     ;/* f17 vec<test.xyz.Conflict> */
    private $numbers       ;/* f18 vec<double> */
    private $mapInfoG      ;/* f19 map<test.abc.Info,test.abc.Gender> */
    private $mapGenderInfo ;/* f20 map<test.abc.Gender,test.abc.Info> */
    private $mapDouble     ;/* f21 map<int32,double> */
    private $hotfix        ;/* f22 map<string,string> // [AutoAdd] Hotfix */

    function __construct()
    {
        $this->key           = 123;
        $this->number01      = -1;
        $this->number02      = -1;
        $this->number03      = -1;
        $this->number04      = -1;
        $this->number05      = 0;
        $this->number06      = 0;
        $this->number07      = 0;
        $this->number08      = 0;
        $this->number09      = 0.0;
        $this->number10      = 0.00;
        $this->isReal        = FALSE;
        $this->s             = 'hello';
        $this->world         = array();
        $this->gender        = Gender::NONE;
        $this->next          = NULL;
        $this->conflict      = new test\abc\Conflict;
        $this->conflicts     = array();
        $this->numbers       = array();
        $this->mapInfoG      = array();
        $this->mapGenderInfo = array();
        $this->mapDouble     = array();
        $this->hotfix        = NULL;
    }
    /* End of constructor() */

    public function &copy (& $from)
    {
        if ($this == $from || $from == NULL) {
            return this;
        }
        $this->key = $from->key;
        $this->number01 = $from->number01;
        $this->number02 = $from->number02;
        $this->number03 = $from->number03;
        $this->number04 = $from->number04;
        $this->number05 = $from->number05;
        $this->number06 = $from->number06;
        $this->number07 = $from->number07;
        $this->number08 = $from->number08;
        $this->number09 = $from->number09;
        $this->number10 = $from->number10;
        $this->isReal = $from->isReal;
        $this->s = $from->s;
        if ($from->world != NULL) {
            $this->world = array_merge($from->world);
        } else {
            $this->world = array();
        }
        $this->gender = $from->gender;
        if ($from->next != NULL) {
            $this->next.copy($from->next);
        } else {
            $this->next = NULL;
        }
        $this->conflict = $from->conflict;
        if ($from->conflicts != NULL) {
            $this->conflicts = array_merge($from->conflicts);
        } else {
            $this->conflicts = array();
        }
        if ($from->numbers != NULL) {
            $this->numbers = array_merge($from->numbers);
        } else {
            $this->numbers = array();
        }
        if ($from->mapInfoG != NULL) {
            $this->mapInfoG = array_merge($from->mapInfoG);
        } else {
            $this->mapInfoG = array();
        }
        if ($from->mapGenderInfo != NULL) {
            $this->mapGenderInfo = array_merge($from->mapGenderInfo);
        } else {
            $this->mapGenderInfo = array();
        }
        if ($from->mapDouble != NULL) {
            $this->mapDouble = array_merge($from->mapDouble);
        } else {
            $this->mapDouble = array();
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
        $this->key = $r->readInt32();
        $this->number01 = $r->readInt08();
        $this->number02 = $r->readInt16();
        $this->number03 = $r->readInt32();
        $this->number04 = $r->readInt64();
        $this->number05 = $r->readUInt08();
        $this->number06 = $r->readUInt16();
        $this->number07 = $r->readUInt32();
        $this->number08 = $r->readUInt64();
        $this->number09 = $r->readFloat32();
        $this->number10 = $r->readFloat64();
        $this->isReal = $r->readBoolean();
        $this->s = $r->readUTF();
        $this->world = array();
        $lenWorld = $r->readUInt32();
        for ($iWorld = 0; $iWorld < $lenWorld; ++$iWorld) {
            $n1 = $r->readUTF();
            $this->world[] = $n1;
        }
        $this->gender = $r->readInt32();
        $nextExists = $r->readInt08();
        if (0x01 == $nextExists) {
            if ($this->next == NULL) { $this->next = new Info; }
            $this->next->read($r);
        }
        else if (0x00 == $nextExists) { $this->next = NULL; }
        else { throw new \Exception('Protoc read error: The value of ' . $nextExists . ' is invalid.', 497); }
        $this->conflict->read($r);
        $this->conflicts = array();
        $lenConflicts = $r->readUInt32();
        for ($iConflicts = 0; $iConflicts < $lenConflicts; ++$iConflicts) {
            $n1 = new testxyzConflict();
            $n1->read($r);
            $this->conflicts[] = $n1;
        }
        $this->numbers = array();
        $lenNumbers = $r->readUInt32();
        for ($iNumbers = 0; $iNumbers < $lenNumbers; ++$iNumbers) {
            $n1 = $r->readFloat64();
            $this->numbers[] = $n1;
        }
        $this->mapInfoG = array();
        $lenMapInfoG = $r->readUInt32();
        for ($iMapInfoG = 0; $iMapInfoG < $lenMapInfoG; ++$iMapInfoG) {
            $k1 = new Info();
            $k1->read($r);
            $v1 = $r->readInt32();
            $this->mapInfoG[$k1] = $v1;
        }
        $this->mapGenderInfo = array();
        $lenMapGenderInfo = $r->readUInt32();
        for ($iMapGenderInfo = 0; $iMapGenderInfo < $lenMapGenderInfo; ++$iMapGenderInfo) {
            $k1 = $r->readInt32();
            $v1 = new Info();
            $v1->read($r);
            $this->mapGenderInfo[$k1] = $v1;
        }
        $this->mapDouble = array();
        $lenMapDouble = $r->readUInt32();
        for ($iMapDouble = 0; $iMapDouble < $lenMapDouble; ++$iMapDouble) {
            $k1 = $r->readInt32();
            $v1 = $r->readFloat64();
            $this->mapDouble[$k1] = $v1;
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
        BinaryWriter::writeInt32($this->key, $str);
        BinaryWriter::writeInt08($this->number01, $str);
        BinaryWriter::writeInt16($this->number02, $str);
        BinaryWriter::writeInt32($this->number03, $str);
        BinaryWriter::writeInt64($this->number04, $str);
        BinaryWriter::writeUInt08($this->number05, $str);
        BinaryWriter::writeUInt16($this->number06, $str);
        BinaryWriter::writeUInt32($this->number07, $str);
        BinaryWriter::writeUInt64($this->number08, $str);
        BinaryWriter::writeFloat32($this->number09, $str);
        BinaryWriter::writeFloat64($this->number10, $str);
        BinaryWriter::writeBoolean($this->isReal, $str);
        BinaryWriter::writeUTF($this->s, $str);
        BinaryWriter::writeInt32(count($this->world), $str);
        foreach ($this->world as &$n1) {
            BinaryWriter::writeUTF($n1, $str);
        }
        BinaryWriter::writeInt32($this->gender, $str);
        if ($this->next != NULL) {
            BinaryWriter::writeInt08(0x01, $str);
            $this->next->write($str);
        } else {
            BinaryWriter::writeInt08(0x00, $str);
        }
        $this->conflict->write($str);
        BinaryWriter::writeInt32(count($this->conflicts), $str);
        foreach ($this->conflicts as &$n1) {
            $n1->write($str);
        }
        BinaryWriter::writeInt32(count($this->numbers), $str);
        foreach ($this->numbers as &$n1) {
            BinaryWriter::writeFloat64($n1, $str);
        }
        BinaryWriter::writeInt32(count($this->mapInfoG), $str);
        foreach ($this->mapInfoG as $k1 => &$v1) {
            $k1->write($str);
            BinaryWriter::writeInt32($v1, $str);
        }
        BinaryWriter::writeInt32(count($this->mapGenderInfo), $str);
        foreach ($this->mapGenderInfo as $k1 => &$v1) {
            BinaryWriter::writeInt32($k1, $str);
            $v1->write($str);
        }
        BinaryWriter::writeInt32(count($this->mapDouble), $str);
        foreach ($this->mapDouble as $k1 => &$v1) {
            BinaryWriter::writeInt32($k1, $str);
            BinaryWriter::writeFloat64($v1, $str);
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

    /**  */
    public function  getKey() { return $this->key; }

    /**  */
    public function  getNumber01() { return $this->number01; }

    /**  */
    public function  getNumber02() { return $this->number02; }

    /**  */
    public function  getNumber03() { return $this->number03; }

    /** Test field comments */
    public function  getNumber04() { return $this->number04; }

    /**  */
    public function  getNumber05() { return $this->number05; }

    /**  */
    public function  getNumber06() { return $this->number06; }

    /**  */
    public function  getNumber07() { return $this->number07; }

    /**  */
    public function  getNumber08() { return $this->number08; }

    /**  */
    public function  getNumber09() { return $this->number09; }

    /**  */
    public function  getNumber10() { return $this->number10; }

    /**  */
    public function  getIsReal() { return $this->isReal; }

    /** a string */
    public function &getS() { return $this->s; }

    /**  */
    public function &getWorld() { return $this->world; }

    /**  */
    public function  getGender() { return $this->gender; }

    /**  */
    public function getNext() { return $this->next; }

    /**  */
    public function &getConflict() { return $this->conflict; }

    /**  */
    public function &getConflicts() { return $this->conflicts; }

    /**  */
    public function &getNumbers() { return $this->numbers; }

    /**  */
    public function &getMapInfoG() { return $this->mapInfoG; }

    /**  */
    public function &getMapGenderInfo() { return $this->mapGenderInfo; }

    /**  */
    public function &getMapDouble() { return $this->mapDouble; }

    /** [AutoAdd] Hotfix */
    public function getHotfix() { return $this->hotfix; }

    /**  */
    public function setKey($value) { $this->key = $value; return $this; }

    /**  */
    public function setNumber01($value) { $this->number01 = $value; return $this; }

    /**  */
    public function setNumber02($value) { $this->number02 = $value; return $this; }

    /**  */
    public function setNumber03($value) { $this->number03 = $value; return $this; }

    /** Test field comments */
    public function setNumber04($value) { $this->number04 = $value; return $this; }

    /**  */
    public function setNumber05($value) { $this->number05 = $value; return $this; }

    /**  */
    public function setNumber06($value) { $this->number06 = $value; return $this; }

    /**  */
    public function setNumber07($value) { $this->number07 = $value; return $this; }

    /**  */
    public function setNumber08($value) { $this->number08 = $value; return $this; }

    /**  */
    public function setNumber09($value) { $this->number09 = $value; return $this; }

    /**  */
    public function setNumber10($value) { $this->number10 = $value; return $this; }

    /**  */
    public function setIsReal($value) { $this->isReal = $value; return $this; }

    /** a string */
    public function setS($value) { $this->s = $value; return $this; }

    /**  */
    public function setGender($value) { $this->gender = $value; return $this; }

    /**  */
    public function setNext($value) { $this->next = $value; return $this; }

    /**  */
    public function setConflict($value) { $this->conflict = $value; return $this; }

    /** [AutoAdd] Hotfix */
    public function setHotfix($value) { $this->hotfix = $value; return $this; }

    public function &toString()
    {
        $s  = '{'; $s .= get_class($this);
        $s .= ','; $s .= 'key'; $s .= ':';
        $s .= $this->key;
        $s .= ','; $s .= 'number01'; $s .= ':';
        $s .= $this->number01;
        $s .= ','; $s .= 'number02'; $s .= ':';
        $s .= $this->number02;
        $s .= ','; $s .= 'number03'; $s .= ':';
        $s .= $this->number03;
        $s .= ','; $s .= 'number04'; $s .= ':';
        $s .= $this->number04;
        $s .= ','; $s .= 'number05'; $s .= ':';
        $s .= $this->number05;
        $s .= ','; $s .= 'number06'; $s .= ':';
        $s .= $this->number06;
        $s .= ','; $s .= 'number07'; $s .= ':';
        $s .= $this->number07;
        $s .= ','; $s .= 'number08'; $s .= ':';
        $s .= $this->number08;
        $s .= ','; $s .= 'number09'; $s .= ':';
        $s .= $this->number09;
        $s .= ','; $s .= 'number10'; $s .= ':';
        $s .= $this->number10;
        $s .= ','; $s .= 'isReal'; $s .= ':';
        $s .= $this->isReal == TRUE ? 'True' : 'False';
        $s .= ','; $s .= 's'; $s .= ':';
        $s .= '"'; $s .= $this->s; $s .= '"';
        $s .= ','; $s .= 'world'; $s .= ':';
        $s .= '('; $s .= count($this->world); $s .= ')';
        $s .= ','; $s .= 'gender'; $s .= ':';
        $s .= $this->gender;
        $s .= ','; $s .= 'next'; $s .= ':';
        if (isset($this->next)) { $s .= '<'; $s .= 'Info'; $s .= '>'; }
        else { $s .= 'null'; }
        $s .= ','; $s .= 'conflict'; $s .= ':';
        $s .= '<'; $s .= 'testabcConflict'; $s .= '>';
        $s .= ','; $s .= 'conflicts'; $s .= ':';
        $s .= '('; $s .= count($this->conflicts); $s .= ')';
        $s .= ','; $s .= 'numbers'; $s .= ':';
        $s .= '('; $s .= count($this->numbers); $s .= ')';
        $s .= ','; $s .= 'mapInfoG'; $s .= ':';
        $s .= '['; $s .= count($this->mapInfoG); $s .= ']';
        $s .= ','; $s .= 'mapGenderInfo'; $s .= ':';
        $s .= '['; $s .= count($this->mapGenderInfo); $s .= ']';
        $s .= ','; $s .= 'mapDouble'; $s .= ':';
        $s .= '['; $s .= count($this->mapDouble); $s .= ']';
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
        $s .= '"'; $s .= 'key'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->key;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number01'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number01;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number02'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number02;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number03'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number03;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number04'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number04;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number05'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number05;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number06'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number06;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number07'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number07;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number08'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number08;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number09'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= number_format($this->number09, 6, '.', '');
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'number10'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->number10;
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'isReal'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->isReal ? "true" : "false";
        $sExists = !empty($this->s);
        if (!empty($comma) && $sExists) { $s .= $comma; $comma = ''; }
        if ($sExists) {
            $s .= '"'; $s .= 's'; $s .= '"'; $s .= ':'; $comma = ',';
            $s .= '"'; $s .= $this->s; $s .= '"';
        }
        $worldExists = (isset($this->world) && count($this->world) > 0);
        if (!empty($comma) && $worldExists) { $s .= $comma; $comma = ''; }
        if ($worldExists) {
            $s .= '"'; $s .= 'world'; $s .= '"'; $s .= ':'; $comma = ',';
            $worldSize = (!isset($this->world) ? 0 : count($this->world));
            $s .= "\n"; $s .= '[';
            $worldIdx = 0;
            foreach ($this->world as &$n1) {
                $s .= '"'; $s .= $n1; $s .= '"';
                ++$worldIdx;
                if ($worldIdx != $worldSize) { $s .= ','; }
            }
            $s .= ']';
        }
        if (!empty($comma)) { $s .= $comma; $comma = ''; }
        $s .= '"'; $s .= 'gender'; $s .= '"'; $s .= ':'; $comma = ',';
        $s .= $this->gender;
        $nextExists = isset($this->next);
        if (!empty($comma) && $nextExists) { $s .= $comma; $comma = ''; }
        if ($nextExists) {
            $s .= '"'; $s .= 'next'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->next->writeJSON($s);
        }
        $conflictExists = isset($this->conflict);
        if (!empty($comma) && $conflictExists) { $s .= $comma; $comma = ''; }
        if ($conflictExists) {
            $s .= '"'; $s .= 'conflict'; $s .= '"'; $s .= ':'; $comma = ',';
            $this->conflict->writeJSON($s);
        }
        $conflictsExists = (isset($this->conflicts) && count($this->conflicts) > 0);
        if (!empty($comma) && $conflictsExists) { $s .= $comma; $comma = ''; }
        if ($conflictsExists) {
            $s .= '"'; $s .= 'conflicts'; $s .= '"'; $s .= ':'; $comma = ',';
            $conflictsSize = (!isset($this->conflicts) ? 0 : count($this->conflicts));
            $s .= "\n"; $s .= '[';
            $conflictsIdx = 0;
            foreach ($this->conflicts as &$n1) {
                $n1->writeJSON($s);
                ++$conflictsIdx;
                if ($conflictsIdx != $conflictsSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $numbersExists = (isset($this->numbers) && count($this->numbers) > 0);
        if (!empty($comma) && $numbersExists) { $s .= $comma; $comma = ''; }
        if ($numbersExists) {
            $s .= '"'; $s .= 'numbers'; $s .= '"'; $s .= ':'; $comma = ',';
            $numbersSize = (!isset($this->numbers) ? 0 : count($this->numbers));
            $s .= "\n"; $s .= '[';
            $numbersIdx = 0;
            foreach ($this->numbers as &$n1) {
                $s .= $n1;
                ++$numbersIdx;
                if ($numbersIdx != $numbersSize) { $s .= ','; }
            }
            $s .= ']';
        }
        $mapInfoGExists = (isset($this->mapInfoG) && count($this->mapInfoG) > 0);
        if (!empty($comma) && $mapInfoGExists) { $s .= $comma; $comma = ''; }
        if ($mapInfoGExists) {
            $s .= '"'; $s .= 'mapInfoG'; $s .= '"'; $s .= ':'; $comma = ',';
            $mapInfoGSize = (!isset($this->mapInfoG) ? 0 : count($this->mapInfoG));
            $s .= "\n"; $s .= '{';
            $mapInfoGIdx = 0;
            foreach ($this->mapInfoG as $k1 => &$v1) {
                $k1->writeJSON($s);
                $s .= $v1;
                ++$mapInfoGIdx;
                if (mapInfoGIdx != $mapInfoGSize) { $s .= ','; }
            }
            $s .= '}';
        }
        $mapGenderInfoExists = (isset($this->mapGenderInfo) && count($this->mapGenderInfo) > 0);
        if (!empty($comma) && $mapGenderInfoExists) { $s .= $comma; $comma = ''; }
        if ($mapGenderInfoExists) {
            $s .= '"'; $s .= 'mapGenderInfo'; $s .= '"'; $s .= ':'; $comma = ',';
            $mapGenderInfoSize = (!isset($this->mapGenderInfo) ? 0 : count($this->mapGenderInfo));
            $s .= "\n"; $s .= '{';
            $mapGenderInfoIdx = 0;
            foreach ($this->mapGenderInfo as $k1 => &$v1) {
                $s .= $k1;
                $v1->writeJSON($s);
                ++$mapGenderInfoIdx;
                if (mapGenderInfoIdx != $mapGenderInfoSize) { $s .= ','; }
            }
            $s .= '}';
        }
        $mapDoubleExists = (isset($this->mapDouble) && count($this->mapDouble) > 0);
        if (!empty($comma) && $mapDoubleExists) { $s .= $comma; $comma = ''; }
        if ($mapDoubleExists) {
            $s .= '"'; $s .= 'mapDouble'; $s .= '"'; $s .= ':'; $comma = ',';
            $mapDoubleSize = (!isset($this->mapDouble) ? 0 : count($this->mapDouble));
            $s .= "\n"; $s .= '{';
            $mapDoubleIdx = 0;
            foreach ($this->mapDouble as $k1 => &$v1) {
                $s .= $k1;
                $s .= $v1;
                ++$mapDoubleIdx;
                if (mapDoubleIdx != $mapDoubleSize) { $s .= ','; }
            }
            $s .= '}';
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
        $code .= "\n"; $code .= '<!-- '; $code .= 'Info'; $code .= '.CRC32: 0x';
        $code .= strtoupper(dechex(self::CRC32)); $code .= ' -->';
        $code .= "\n"; $this->writeXML($code, 'Info');
        return $code;
    }

    public function writeXML (& $s, $name)
    {
        $attrs = ''; $nodes = '';
        $attrs .= ' '; $attrs .= 'key'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->key; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number01'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number01; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number02'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number02; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number03'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number03; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number04'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number04; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number05'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number05; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number06'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number06; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number07'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number07; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number08'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number08; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number09'; $attrs .= '=';
        $attrs .= '"'; $attrs .= number_format($this->number09, 6, '.', ''); $attrs .= '"';
        $attrs .= ' '; $attrs .= 'number10'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->number10; $attrs .= '"';
        $attrs .= ' '; $attrs .= 'isReal'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->isReal ? "true" : "false"; $attrs .= '"';
        $attrs .= ' '; $attrs .= 's'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->s; $attrs .= '"';
        if (count($this->world) > 0) {
            $nodes .= '<'; $nodes .= 'world'; $nodes .= '>';
            foreach ($this->world as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'world'; $nodes .= '>';
        }
        $attrs .= ' '; $attrs .= 'gender'; $attrs .= '=';
        $attrs .= '"'; $attrs .= $this->gender; $attrs .= '"';
        if (isset($this->next)) {
            $this->next->writeXML($nodes, 'next');
        }
        $this->conflict->writeXML($nodes, 'conflict');
        if (count($this->conflicts) > 0) {
            $nodes .= '<'; $nodes .= 'conflicts'; $nodes .= '>';
            foreach ($this->conflicts as &$n1) {
                $n1->writeXML($nodes, 'n1');
            }
            $nodes .= '</'; $nodes .= 'conflicts'; $nodes .= '>';
        }
        if (count($this->numbers) > 0) {
            $nodes .= '<'; $nodes .= 'numbers'; $nodes .= '>';
            foreach ($this->numbers as &$n1) {
                $nodes .= '<'; $nodes .= 'n1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$n1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'numbers'; $nodes .= '>';
        }
        if (count($this->mapInfoG) > 0) {
            $nodes .= '<'; $nodes .= 'mapInfoG'; $nodes .= '>';
            foreach ($this->mapInfoG as $k1 => &$v1) {
                $k1->writeXML($nodes, 'k1');
                $nodes .= '<'; $nodes .= 'v1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$v1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'mapInfoG'; $nodes .= '>';
        }
        if (count($this->mapGenderInfo) > 0) {
            $nodes .= '<'; $nodes .= 'mapGenderInfo'; $nodes .= '>';
            foreach ($this->mapGenderInfo as $k1 => &$v1) {
                $nodes .= '<'; $nodes .= 'k1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$k1; $nodes .= '"';  $nodes .= '/>';
                $v1->writeXML($nodes, 'v1');
            }
            $nodes .= '</'; $nodes .= 'mapGenderInfo'; $nodes .= '>';
        }
        if (count($this->mapDouble) > 0) {
            $nodes .= '<'; $nodes .= 'mapDouble'; $nodes .= '>';
            foreach ($this->mapDouble as $k1 => &$v1) {
                $nodes .= '<'; $nodes .= 'k1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$k1; $nodes .= '"';  $nodes .= '/>';
                $nodes .= '<'; $nodes .= 'v1'; $nodes .= ' ';
                $nodes .= 'value'; $nodes .= '='; $nodes .= '"';
                $nodes .= $$v1; $nodes .= '"';  $nodes .= '/>';
            }
            $nodes .= '</'; $nodes .= 'mapDouble'; $nodes .= '>';
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
