type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function jsonToMatrix(arr: JSONValue[]): (null | boolean | number | string)[][] {
    const map: Map<string, Array<{ rowIndex: number; value: any }>> = new Map();

    const process = (obj: JSONValue, row: number, keyPrefix = "")=>{
        for( const {0: key, 1:  value} of Object.entries(obj)){
            const newKey = keyPrefix + key;
            if(value !== null && typeof value === 'object'){
                process(value, row, newKey+".")
            }else{
                const prev = map.get(newKey);
                if(prev){
                    prev.push({rowIndex: row, value: value});
                }else{
                    map.set(newKey, [{rowIndex: row, value}]);
                }
            }
        }
    }

    for(let row =0;row < arr.length;row++){
        process(arr[row], row + 1, "");
    }

    const result = Array.from({ length: arr.length + 1}, ()=> Array.from({length: map.size}, () => ""));

    result[0] = Array.from(map.keys()).sort((a,b)=> a.localeCompare(b));

    for(const {0: key, 1 : value} of map.entries()){
        for(const {rowIndex, value: val} of value){
            const col = result[0].findIndex(cell => cell === key);
            result[rowIndex][col] = val;
        }
    }

    return result;
};

