package invar;

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

    public interface InvarProtoc {

        Integer getProtocId();

        Long getProtocCRC();
    }

    public interface ProtocNotify extends InvarProtoc, BinaryDecode, BinaryEncode {
    }

    public interface ProtocRequest extends InvarProtoc, BinaryDecode {
    }

    public interface ProtocResponse<T> extends InvarProtoc, BinaryEncode {

        Integer getProtocError();

        T setProtocError(int value);
    }

    public interface ResponseSender {

        <T> void sendResponse(ProtocResponse<T> resp) throws IOException;
    }

}
