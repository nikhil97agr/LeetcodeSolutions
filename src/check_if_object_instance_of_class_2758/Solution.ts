function checkIfInstanceOf(obj: any, classFunction: any): boolean {
    if((obj === undefined || obj === null || typeof classFunction !== 'function')) return false;
    let protoType = Object.getPrototypeOf(obj);
    while(protoType !== null){
        if(protoType === (classFunction as Function).prototype) return true;
        protoType = Object.getPrototypeOf(protoType);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */