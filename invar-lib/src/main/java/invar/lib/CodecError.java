/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

public class CodecError extends Exception {

    static public final int ERR_NONE                 =   0;
    static public final int ERR_UNKNOWN              =   1;
    static public final int ERR_SIZE_TOO_LONG        = 493;
    static public final int ERR_INVALID_REQ          = 494;
    static public final int ERR_DECODE_EOF           = 495;
    static public final int ERR_DECODE_STRING_P      = 496;
    static public final int ERR_DECODE_STRUCT_P      = 497;
    static public final int ERR_DECODE_VEC_MAP_P     = 498;
    static public final int ERR_PROTOC_CRC_MISMATCH  = 499;
    static public final int ERR_PROTOC_UNHANDLED     = 500;
    static public final int ERR_PROTOC_INVALID_ID    = 501;
    static public final int ERR_PROTOC_NO_HANDLER    = 503;
    static public final int ERR_PROTOC_NO_SESSION    = 403;

    private final int code;

    public CodecError(int code) {
        super(String.valueOf(code));
        this.code = code;
    }

    public CodecError(int code, Throwable cause) {
        super(String.valueOf(code), cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
