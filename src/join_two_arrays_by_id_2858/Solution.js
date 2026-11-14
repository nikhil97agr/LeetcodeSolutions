/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const res = {};
    const data = [...arr1, ...arr2];

    for(let d of data){
        if(d.id in res){
            res[d.id] = {...res[d.id], ...d};
        }else{
            res[d.id] = {...d};
        }
    }

    return Object.values(res);
    
};