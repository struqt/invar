/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.abc;

import invar.lib.InvarEnum;

/** 性别的枚举类型 */
public enum Gender implements InvarEnum
{
    
    NONE   (-1),
    /* Enum male */
    MALE   (10),
    /* Enum female */
    FEMALE (20),;

    public Integer value() { return value; }
    public String  toString() { return name() + "(" + value + ")"; }

    private Integer value;

    Gender(Integer v)
    {
        this.value = v;
    }

    static public Gender valueOf(Integer v)
    {
        Gender[] es = Gender.values();
        for (Gender e : es) {
            if(e.value().equals(v)) {
                return e;
            }
        }
        return es[0];
    }
}

