type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };
type Obj = Record<string, JSONValue> | Array<JSONValue>

function invertObject(obj: Obj): Record<string, JSONValue> {
    const result: Record<string, JSONValue[]> = {};
    if (Array.isArray(obj)) {
        obj.forEach((value, index) => {
            const key = String(value)
            if (!result[key]) {
                result[key] = []
            }

            result[key].push(String(index));
        })
    } else {
        Object.entries(obj).forEach(([key,value]) =>{
            const r= String(value);
            if(!result[r]){
                result[r] = []
            }

            result[r].push(key);
        })
    }

    const data: Record<string, JSONValue> = {}

    Object.entries(result).forEach(([key, value]) =>{
        if(Array.isArray(value)){
            if(value.length > 1){
                data[key] = value;
            }else{
                data[key] = value[0];
            }
        }
    })

    return data;
    

};