type Fn = () => Promise<any>

function delayAll(functions: Fn[], ms: number): Fn[] {
    const res :Fn[]= []

    functions.forEach(async (fn, index) =>{
        res[index] = ()=>{

                return new Promise((resolve, reject)=>{
                    setTimeout(()=>{
                        fn().then(result => resolve(result))
                        .catch(err => reject(err));

                    }, ms)



                });




        }

    });

    return res;
    
};