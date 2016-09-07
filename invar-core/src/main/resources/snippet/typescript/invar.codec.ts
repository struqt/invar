export module InvarCodec {

    export const ERR_NONE                 =   0
    export const ERR_SIZE_TOO_LONG        = 493
    export const ERR_INVALID_REQ          = 494
    export const ERR_DECODE_EOF           = 495
    export const ERR_DECODE_STRING_P      = 496
    export const ERR_DECODE_STRUCT_P      = 497
    export const ERR_DECODE_VEC_MAP_P     = 498
    export const ERR_PROTOC_CRC_MISMATCH  = 499
    export const ERR_PROTOC_UNHANDLED     = 500
    export const ERR_PROTOC_INVALID_ID    = 501
    export const ERR_PROTOC_NO_HANDLER    = 503

    declare function unescape(s: string): string;
    declare function escape(s: string): string;

    let LittleEndian: boolean = false;

    export class BinaryWriter {

        private binary: DataView;
        private offset: number;

        constructor(data: DataView) {
            this.binary = data;
            this.offset = 0;
        }
        public available(): number {
            return this.binary.byteLength - this.offset;
        }
        public canWrite(len: number): boolean {
            return this.binary.byteLength - this.offset >= len;
        }
        public writeInt08(v: number): number {
            if (!this.canWrite(1)) {
                this.offset += 1;
                return 1;
            }
            if (v < -128 || v > 127) {
                return 2;
            }
            this.binary.setInt8(this.offset, v);
            this.offset += 1;
            return 0;
        }
        public writeInt16(v: number): number {
            if (!this.canWrite(2)) {
                this.offset += 2;
                return 1;
            }
            if (v < -32768 || v > 32767) {
                return 2;
            }
            this.binary.setInt16(this.offset, v, LittleEndian);
            this.offset += 2;
            return 0;
        }
        public writeInt32(v: number): number {
            if (!this.canWrite(4)) {
                this.offset += 4;
                return 1;
            }
            if (v < -2147483648 || v > 2147483647) {
                return 2;
            }
            this.binary.setInt32(this.offset, v, LittleEndian);
            this.offset += 4;
            return 0;
        }
        public writeInt64(v: string): number {
            if (!this.canWrite(8)) {
                this.offset += 8;
                return 1;
            }
            /* [-9223372036854774808, 9223372036854774807] */
            const len = 8;
            let bytes: Uint8Array = hex2bytes(v, len);
            if (LittleEndian) {
                bytes.reverse();
            }
            for (let i = 0; i < len; i++) {
                this.binary.setUint8(this.offset, bytes[i]);
                this.offset += 1;
            }
            return 0;
        }
        public writeUint08(v: number): number {
            if (!this.canWrite(1)) {
                this.offset += 1;
                return 1;
            }
            if (v < 0 || v > 255) {
                return 2;
            }
            this.binary.setUint8(this.offset, v);
            this.offset += 1;
            return 0;
        }
        public writeUint16(v: number): number {
            if (!this.canWrite(2)) {
                this.offset += 2;
                return 1;
            }
            if (v < 0 || v > 65535) {
                return 2;
            }
            this.binary.setUint16(this.offset, v, LittleEndian);
            this.offset += 2;
            return 0;
        }
        public writeUint32(v: number): number {
            if (!this.canWrite(4)) {
                this.offset += 4;
                return 1;
            }
            if (v < 0 || v > 4294967295) {
                return 2;
            }
            this.binary.setUint32(this.offset, v, LittleEndian);
            this.offset += 4;
            return 0;
        }
        public writeUint64(v: string): number {
            if (!this.canWrite(8)) {
                this.offset += 8;
                return 1;
            }
            /* [0, 18446744073709551615] */
            let len = 8;
            let bytes: Uint8Array = hex2bytes(v, len);
            if (LittleEndian) {
                bytes.reverse();
            }
            for (let i = 0; i < len; i++) {
                this.binary.setUint8(this.offset, bytes[i]);
                this.offset += 1;
            }
            return 0;
        }
        public writeFloat32(v: number): number {
            if (!this.canWrite(4)) {
                this.offset += 4;
                return 1;
            }
            this.binary.setFloat32(this.offset, v, LittleEndian);
            this.offset += 4;
            return 0;
        }
        public writeFloat64(v: number): number {
            if (!this.canWrite(8)) {
                this.offset += 8;
                return 1;
            }
            this.binary.setFloat64(this.offset, v, LittleEndian);
            this.offset += 8;
            return 0;
        }
        public writeBoolean(b: boolean): number {
            return this.writeUint08(b === true ? 1 : 0);
        }
        public writeUTF8(v: string): number {
            let bytes: string = encodeUTF8(v);
            let len: number = bytes.length;
            let result = this.writeInt32(len);
            if (result != 0) {
                return result;
            }
            if (!this.canWrite(len)) {
                this.offset += len;
                return 1;
            }
            for (let i: number = 0; i < len; i++) {
                this.writeUint08(bytes.charCodeAt(i));
            }
            return 0;
        }
    }

    export class BinaryReader {

        private binary: DataView;
        private offset: number;

        constructor(data: DataView, offset?: number) {
            this.binary = data;
            this.offset = !offset ? 0 : offset;
        }
        public canRead(len: number): boolean {
            return this.binary.byteLength - this.offset >= len;
        }
        public available(): number {
            return this.binary.byteLength - this.offset;
        }
        public readInt08(): number {
            if (!this.canRead(1)) {
                this.offset += 1;
                return -1;
            }
            let v: number = this.binary.getInt8(this.offset);
            this.offset += 1;
            return v;
        }
        public readInt16(): number {
            if (!this.canRead(2)) {
                this.offset += 2;
                return -1;
            }
            let v: number = this.binary.getInt16(this.offset, LittleEndian);
            this.offset += 2;
            return v;
        }
        public readInt32(): number {
            if (!this.canRead(4)) {
                this.offset += 4;
                return -1;
            }
            let v: number = this.binary.getInt32(this.offset, LittleEndian);
            this.offset += 4;
            return v;
        }
        public readInt64(): string {
            if (!this.canRead(8)) {
                this.offset += 8;
                return '';
            }
            /* [-9223372036854774808, 9223372036854774807] */
            const len = 8;
            let bytes: Uint8Array = new Uint8Array(len);
            for (let i = 0; i < len; i++) {
                bytes[i] = this.binary.getUint8(this.offset);
                this.offset += 1;
            }
            if (LittleEndian) {
                bytes.reverse();
            }
            return bytes2hex(bytes, true);
        }
        public readUint08(): number {
            if (!this.canRead(1)) {
                this.offset += 1;
                return 0;
            }
            let v: number = this.binary.getUint8(this.offset);
            this.offset += 1;
            return v;
        }
        public readUint16(): number {
            if (!this.canRead(2)) {
                this.offset += 2;
                return 0;
            }
            let v: number = this.binary.getUint16(this.offset, LittleEndian);
            this.offset += 2;
            return v;
        }
        public readUint32(): number {
            if (!this.canRead(4)) {
                this.offset += 4;
                return 0;
            }
            let v: number = this.binary.getUint32(this.offset, LittleEndian);
            this.offset += 4;
            return v;
        }
        public readUint64(): string {
            if (!this.canRead(8)) {
                this.offset += 8;
                return '';
            }
            /* [0, 18446744073709551615] */
            const len = 8;
            let bytes: Uint8Array = new Uint8Array(len);
            for (let i = 0; i < len; i++) {
                bytes[i] = this.binary.getUint8(this.offset);
                this.offset += 1;
            }
            if (LittleEndian) {
                bytes.reverse();
            }
            return bytes2hex(bytes, true);
        }
        public readFloat32(): number {
            if (!this.canRead(4)) {
                this.offset += 4;
                return 0;
            }
            let v: number = this.binary.getFloat32(this.offset, LittleEndian);
            this.offset += 4;
            return v;
        }
        public readFloat64(): number {
            if (!this.canRead(8)) {
                this.offset += 8;
                return 0;
            }
            let v: number = this.binary.getFloat64(this.offset, LittleEndian);
            this.offset += 8;
            return v;
        }
        public readBoolean(): boolean {
            if (!this.canRead(1)) {
                this.offset += 1;
                return false;
            }
            let b: boolean = this.binary.getUint8(this.offset) == 0 ? false : true;
            this.offset += 1;
            return b;
        }
        public readUTF8(): string {
            let str: string = '';
            let len: number = Math.max(0, this.readInt32());
            if (!this.canRead(len)) {
                this.offset += len;
                return str;
            }
            for (let i = 0; i < len; i++) {
                let code: number = this.readUint08();
                str += String.fromCharCode(code);
            }
            return decodeUTF8(str);
        }
    }

    export function encodeUTF8(s: string): string {
        return unescape(encodeURIComponent(s));
    }

    export function decodeUTF8(s: string): string {
        return decodeURIComponent(escape(s));
    }

    function hex2bytes(v: string, len: number): Uint8Array {
        if (len <= 0) { return new Uint8Array(0); }
        let lastIdx: number = v.length - 1;
        let arr: Uint8Array = new Uint8Array(len);
        for (let i = 0; i < len; i++) {
            let loIdx: number = lastIdx - i * 2;
            let hiIdx: number = loIdx - 1;
            let loStr: string = loIdx < 0 ? '0' : v.charAt(loIdx);
            let hiStr: string = hiIdx < 0 ? '0' : v.charAt(hiIdx);
            let byte: number = parseInt(hiStr + loStr, 16);
            if (isNaN(byte)) {
                byte = 0;
            }
            arr[len - i - 1] = byte;
        }
        return arr;
    }
    function bytes2hex(bytes: Uint8Array, skip0?: boolean): string {
        let str: string = '';
        let len: number = bytes.length;
        let skip_0: boolean = skip0;
        let head_0: boolean = true;
        for (let i = 0; i < len; i++) {
            let byte: number = bytes[i];
            let byteStr: string = '';
            skip0 = skip0 && (byte == 0);
            if (skip0) { continue; }
            if (byte > 0 && byte <= 15) {
                byteStr = (skip_0 && head_0) ? byte.toString(16) : '0' + byte.toString(16);
                head_0 = false;
            }
            else if (byte > 15 && byte <= 255) { byteStr = byte.toString(16); }
            else { byteStr = '0'; }
            str += byteStr.toUpperCase();
        }
        if (str.length == 0) {
            return '0';
        }
        return str;
    }
}
/* http://www.ecma-international.org/ecma-262/6.0/#sec-dataview-constructor */
/* https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView */