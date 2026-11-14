type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>

function deepFilter(obj: Obj, fn: Function): Obj | undefined {
    if(obj === null) return obj;

    if(Array.isArray(obj)){
        const result = []
        for(let x of obj){
            if(Array.isArray(x) || (x !== null && typeof x === 'object')){
                const temp = deepFilter(x, fn);
                if(temp !== undefined){
                    result.push(temp);
                }
                continue;
            }
            if(fn(x)){
                result.push(x);
            }
        }

        if(result.length === 0) return undefined;
        return result;
    }

    if(typeof obj === 'object'){
        const keys = Object.keys(obj);
        const result = {}
        for(let key of keys){
            const val = obj[key];
            if(Array.isArray(val) || (val !== null && typeof val === 'object')){
                const temp = deepFilter(val, fn);
                if(temp !== undefined){
                    result[key] = temp;
                }
                continue;
            }
            if(fn(val)){
                result[key] = val;
            }
        }

        if(Object.keys(result).length === 0) return undefined;
        return result;
    }
    const res = fn(obj);
    if(!res) return undefined;

    return obj;
};