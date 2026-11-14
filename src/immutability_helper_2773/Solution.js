var ImmutableHelper = function(obj) {
    this.obj = obj;
    this.changed = false;

    this.getPartial = (actual, curr) =>{
        const set = (target, prop, value) =>{
            if(target[prop] !== value){
                curr[prop] = value;
                this.changed= true;
            }
        }

        const get = (target, prop)=>{
            if(target[prop] !== null && typeof target[prop] === 'object'){
                if(curr[prop] === undefined){
                    curr[prop] = {}
                }
                return this.getPartial(target[prop], curr[prop])
            }

            return curr[prop] === undefined ? Reflect.get(target, prop) : curr[prop]
        }

        return new Proxy(actual, {set: set.bind(this), get:get.bind(this)})
    }

    this.getClone = (actual, curr)=>{
        if(actual == null || typeof actual !== 'object' || typeof curr !== 'object'){
            return curr;
        }
        let ans;

        if(Array.isArray(actual)){
            ans = [...actual]
            for(let [key, value] of Object.entries(curr)){
                const ind = parseInt(key, 10);
                ans[ind] =this.getClone(actual[ind], value);
            }
        }else{
            ans = {...actual}
            for(let [key, value] of Object.entries(curr)){
                ans[key] = this.getClone(actual[key], value);
            }
        }

        return ans;
    }
};

/** 
 * @param {Function} mutator
 * @return {JSON} clone of obj
 */
ImmutableHelper.prototype.produce = function(mutator) {
    const ans = {}
    mutator(this.getPartial(this.obj, ans))
    if(this.changed){
        this.changed = false;
        return this.getClone(this.obj, ans);
    }

    return this.obj
};

/**
 * const originalObj = {"x": 5};
 * const mutator = new ImmutableHelper(originalObj);
 * const newObj = mutator.produce((proxy) => {
 *   proxy.x = proxy.x + 1;
 * });
 * console.log(originalObj); // {"x: 5"}
 * console.log(newObj); // {"x": 6}
 */