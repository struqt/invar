export module InvarUtils {

    export class Dict<K, V> {

        private _keys: K[] = []
        private _values: V[] = []

        public get length(): number {
            return this._values.length;
        }

        public getPair(i: number): [K, V] {
            if (i < 0 || i >= this._keys.length) {
                throw new Error("Index out of range.");
            }
            return [this._keys[i], this._values[i]]
        }

        public getValue(key: K): V {
            if (!this.checkKey(key)) {
                return undefined;
            }
            let index: number = this._keys.indexOf(key);
            if (index < 0) {
                return undefined;
            }
            return this._values[index];
        }

        public containsKey(key: K): boolean {
            if (!this.checkKey(key)) {
                return false;
            }
            let index: number = this._keys.indexOf(key);
            if (index < 0) {
                return false;
            }
            return true;
        }

        public add(key: K, value: V): boolean {
            if (this.containsKey(key)) {
                return false;
            }
            this._keys.push(key);
            this._values.push(value);
        }

        public put(key: K, value: V): boolean {
            if (!this.checkKey(key)) {
                return false;
            }
            let index: number = this._keys.indexOf(key);
            if (index < 0) {
                return false;
            }
            this._values[index] = value;
        }

        public remove(key: K): boolean {
            if (!this.checkKey(key)) {
                return false;
            }
            let index: number = this._keys.indexOf(key);
            if (index < 0) {
                return false;
            }
            this._keys.splice(index, 1);
            this._values.splice(index, 1);
            return true;
        }

        private checkKey(key: K) {
            if ((typeof key) === "undefined" || key === null || key.toString() === "") {
                return false;
            }
            return true;
        }
    }

}
