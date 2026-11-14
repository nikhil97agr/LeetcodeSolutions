type Fn = (...args) => any

interface Function {
    bindPolyfill(obj: Record<any, any>): Fn;
}

Function.prototype.bindPolyfill = function(obj): Fn {
    return (...args : any[]) => this.call(obj, ...args)
}