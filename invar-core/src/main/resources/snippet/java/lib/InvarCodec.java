package invar.lib;

import java.io.*;

public abstract class InvarCodec {

    public interface BinaryEncode {

        void write(OutputStream from) throws IOException;

        void write(DataOutput dest) throws IOException;

    }

    public interface BinaryDecode {

        void read(InputStream from) throws IOException, CodecError;

        void read(DataInput from) throws IOException, CodecError;
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

}
