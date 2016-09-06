export module InvarTypes {

    export class Float32 extends Number { }
    export class Float64 extends Number { }
    export class Int08 extends Number { }
    export class Int16 extends Number { }
    export class Int32 extends Number { }
    export class Int64 {
        private _value: string;
        constructor(value: string) {
            this._value = value;
        }
        public get data(): string {
            return this._value;
        }
    }
    export class Uint08 extends Number { }
    export class Uint16 extends Number { }
    export class Uint32 extends Number { }
    export class Uint64 extends Int64 { }

}
