type F = (...args: number[]) => void

function throttle(fn: F, t: number): F {
    let id = null;
    let nextCallTime = 0;
    return function (...args) {
        const delay = Math.max(0, nextCallTime - Date.now());
        clearTimeout(id);
        id = setTimeout(()=>{
            fn(...args);
            nextCallTime = Date.now() + t;
        }, delay);
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */