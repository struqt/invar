package invar.lib;

import java.io.*;

public abstract class InvarCodec {

    public interface BinaryEncode {

        void write(OutputStream from) throws IOException;

        void write(DataOutput dest) throws IOException;

    }

    public interface BinaryDecode {

        void read(InputStream from) throws IOException;

        void read(DataInput from) throws IOException;
    }

    public interface JSONEncode {

        String toStringJSON();

        void writeJSON(StringBuilder s);
    }

    public interface XMLEncode {

        String toStringXML();

        void writeXML(StringBuilder s, String name);
    }

    public interface InvarProtoc extends BinaryDecode, BinaryEncode, JSONEncode {

        Integer getProtocId();

        Long getProtocCRC();
    }

    public interface ProtocNotify extends InvarProtoc {
    }

    public interface ProtocRequest extends InvarProtoc {
    }

    public interface ProtocResponse extends InvarProtoc {

        Integer getProtocError();

        void setProtocError(int value);
    }

    public interface ResponseSender {
        void sendResponse(ProtocResponse resp) throws IOException;
    }

    static public final int ERR_NONE                 =   0;
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

}
