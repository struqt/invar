/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.io.*;
import java.math.BigInteger;

public abstract class InvarCodec {

    private static BigInteger UINT64_MAX = new BigInteger("FFFFFFFFFFFFFFFF", 16);

    public static boolean overRangeUInt64(BigInteger value) {
        return value.compareTo(BigInteger.ZERO) < 0
            || value.compareTo(UINT64_MAX) > 0;
    }

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

    public interface InvarProtoc
        extends BinaryDecode, BinaryEncode, XMLEncode, JSONEncode {

        Integer getProtocId();

        Long getProtocCRC();
    }

    public interface ProtocNotify extends InvarProtoc {
    }

    public interface ProtocRequest extends InvarProtoc {
    }

    public interface ProtocResponse extends InvarProtoc {

        Integer getProtocError();

        void setProtocError(Integer value);
    }

    public interface ResponseSender {

        void sendResponse(ProtocResponse resp) throws IOException;

    }

}
