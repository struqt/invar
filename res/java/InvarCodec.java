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

        StringBuilder toStringJSON();
    }

    public interface XMLEncode {

        StringBuilder toStringXML(String name);
    }

    public interface InvarProtoc {

        Integer getProtocId();

        Long getProtocCRC();
    }

    public interface ProtocNotify extends InvarProtoc {
    }

    public interface ProtocRequest extends InvarProtoc {
    }

    public interface ProtocResponse extends InvarProtoc {

        Integer getProtocError();
    }

}
