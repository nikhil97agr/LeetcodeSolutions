/** 
 * @return {string}
 */
Date.prototype.nextDay = function() {
    let today= new Date(this);
    today.setDate(today.getDate()+ 1);
    const year = today.getFullYear();
    const month = today.getMonth()+1;
    const date = today.getDate();

    return `${year}-${month < 10 ? `0${month}` : month}-${date < 10 ? `0${date}` : date}`
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */