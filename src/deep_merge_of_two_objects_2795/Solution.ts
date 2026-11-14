type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function deepMerge(obj1: JSONValue, obj2: JSONValue): JSONValue {
    if(obj1 === null || obj2 === null) return obj2;
    if(Array.isArray(obj1) && Array.isArray(obj2)){
        let len = Math.max(obj1.length, obj2.length);
        const result  = []

        for(let i=0;i<len;i++){
            if(i >= obj1.length){
                result.push(obj2[i]);
            }else if(i >= obj2.length){
                result.push(obj1[i]);
            }else{
                result.push(deepMerge(obj1[i], obj2[i]));
            }
        }

        return result;
    }
    if(Array.isArray(obj1) || Array.isArray(obj2)) return obj2;
    if(typeof obj1 === 'object' && typeof obj2 === 'object'){
        const result = {};

        for( let key in obj1){
            if(key in obj2){
                result[key] = deepMerge(obj1[key], obj2[key]);
            }else{
                result[key] = obj1[key]
            }
        }

        for(let key in obj2){
            if(! (key in obj1)){
                result[key] = obj2[key];
            }
        }

        return result;
    }
    return obj2;
};

/**
 * let obj1 = {"a": 1, "c": 3}, obj2 = {"a": 2, "b": 2};
 * deepMerge(obj1, obj2); // {"a": 2, "c": 3, "b": 2}
 */
