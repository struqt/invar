
import { Invar } from "./invar.codec"

function hello() {
    var data: DataView = new DataView(new ArrayBuffer(90))
    var w: Invar.BinaryWriter = new Invar.BinaryWriter(data)
    w.writeInt08(1);
    w.writeInt16(2);
    w.writeInt32(3);
    w.writeInt64('4');
    w.writeUint08(5);
    w.writeUint16(6);
    w.writeUint32(7);
    w.writeUint64('8');
    w.writeFloat32(9.0001);
    w.writeFloat64(10.0000000000001234);
    w.writeBoolean(true);
    w.writeUTF8('Hello世界123--!');
    //
    w.writeBoolean(false);
    w.writeInt64('GG');
    w.writeInt64('FFFEFDFCFBFAF9F8');
    w.writeUint64('FFFEFDFCFBFAF9F8');
    console.log('+-------------------------')
    console.log(w.available())

    //////
    var r: Invar.BinaryReader = new Invar.BinaryReader(data)
    console.log('+-------------------------')
    console.log('| ' + r.readInt08())
    console.log('| ' + r.readInt16())
    console.log('| ' + r.readInt32())
    console.log('| ' + r.readInt64())
    console.log('| ' + r.readUint08())
    console.log('| ' + r.readUint16())
    console.log('| ' + r.readUint32())
    console.log('| ' + r.readUint64())
    console.log('| ' + r.readFloat32())
    console.log('| ' + r.readFloat64())
    console.log('| ' + r.readBoolean())
    console.log('| ' + r.readUTF8())
    console.log('|-------------------------')
    console.log('| ' + r.readBoolean())
    console.log('| ' + r.readInt64())
    console.log('| ' + r.readInt64())
    console.log('| ' + r.readUint64())
    console.log('+-------------------------')
    console.log(r.available())
}

hello();
