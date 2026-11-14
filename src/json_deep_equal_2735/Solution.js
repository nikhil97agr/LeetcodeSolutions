/**
 * @param {null|boolean|number|string|Array|Object} o1
 * @param {null|boolean|number|string|Array|Object} o2
 * @return {boolean}
 */
var areDeeplyEqual = function(o1, o2) {
    if(o1 === undefined && o2 == undefined) return true;
    if(o1 === null && o2 == null) return true;
    if(o1 === null || o2 === null || o1 === undefined || o2 === undefined) return false;
    //Check for arrays
    if(Array.isArray(o1)){
        if(Array.isArray(o2)){
            if(o1.length !== o2.length) return false;
            for(let i =0;i<o1.length;i++){
                if(!areDeeplyEqual(o1[i], o2[i])){
                    return false;
                }
            }

            return true;
        }

        return false;
    }else if(Array.isArray(o2)){
        return false;
    }

    //check for object
    if(typeof o1 === 'object'){
        if(typeof(o2) === 'object'){
            const key1 = Object.keys(o1);
            const key2 = Object.keys(o2);
            key1.sort();
            key2.sort();
            if(!areDeeplyEqual(key1, key2)){
                return false;
            }
            for(let key of key1){

                if(!areDeeplyEqual(o1[key], o2[key])){
                    return false;
                }
            }

            return true;
        }
        return false;
    }else if(typeof o2 === 'object'){
        return false;
    }
    return o1 === o2;
};