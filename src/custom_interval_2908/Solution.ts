let nextId = 0;
const map: Map<number, NodeJS.Timeout> = new Map();
function customInterval(fn: Function, delay: number, period: number): number {
    const timeoutId = nextId++;
    let count= 0;

    const recurs = () =>{
        const nextTime = delay + period*count;
        const id = setTimeout(()=>{
            fn();
            recurs();
        }, nextTime);

        count++;
        map.set(timeoutId, id);
    }


    recurs();

    return timeoutId

}

function customClearInterval(id: number): void {
    if(map.get(id)){
        const i = map.get(id);
        clearTimeout(i);
        map.delete(id);
    }
}