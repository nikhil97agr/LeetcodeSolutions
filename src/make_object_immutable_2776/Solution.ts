type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Array<JSONValue> | Record<string, JSONValue>;

function makeImmutable(obj: Obj): Obj {
    return new Proxy(obj, {
        set(target, prop, value, receiver){
            if(Array.isArray(target) && typeof prop === 'string'){
                const index = Number(prop);
                if(index !== undefined){
                    throw `Error Modifying Index: ${prop}`;
                }
            }

            throw `Error Modifying: ${String(prop)}`;
        },
        get(target, prop){
            if(Array.isArray(target) && (
                prop === 'pop' || prop ==='push' || prop === 'shift' || prop === 'unshift' || prop === 'splice' || prop === 'sort' || prop === 'reverse'
            )){
                return (...arg) => {throw `Error Calling Method: ${prop}`}
            }

            if(typeof obj[prop] === 'object' && obj[prop] !== null){
                return makeImmutable(obj[prop]);
            }

            return Reflect.get(target, prop);
        }
    });
};

/**
 * const obj = makeImmutable({x: 5});
 * obj.x = 6; // throws "Error Modifying x"
 */