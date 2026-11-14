/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = async function(functions) {
    
    return new Promise((resolve, reject)=>{
        let res = new Array(functions.length);
        let cnt = 0;
        functions.forEach((fn ,i)=>{
            fn()
            .then(val =>{
                res[i] = val;
                cnt++;
                if(cnt == functions.length) resolve(res);
            })
            .catch(reason => reject(reason))
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */