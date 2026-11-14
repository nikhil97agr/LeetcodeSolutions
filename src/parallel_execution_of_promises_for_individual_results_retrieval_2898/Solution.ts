type FulfilledObj = {
    status: 'fulfilled';
    value: string;
}
type RejectedObj = {
    status: 'rejected';
    reason: string;
}
type Obj = FulfilledObj | RejectedObj;

function promiseAllSettled(functions: Function[]): Promise<Obj[]> {
    return new Promise(resolve =>{
        if(functions.length ===0){
            resolve([]);
            return;
        }

        const result : Obj[] = new Array(functions.length).fill(null);
        let total = 0;

        functions.forEach(async (func, index)=>{
            func().then(res =>{
                result[index] = {status: 'fulfilled', value: res};
            }).catch(err =>{
                result[index] = {status: 'rejected', reason: err};
            }).finally(()=>{
                total++;
                if(total === functions.length) resolve(result);
            })
        })


    })
};


/**
 * const functions = [
 *    () => new Promise(resolve => setTimeout(() => resolve(15), 100))
 * ]
 * const time = performance.now()
 *
 * const promise = promiseAllSettled(functions);
 *              
 * promise.then(res => {
 *     const out = {t: Math.floor(performance.now() - time), values: res}
 *     console.log(out) // {"t":100,"values":[{"status":"fulfilled","value":15}]}
 * })
 */