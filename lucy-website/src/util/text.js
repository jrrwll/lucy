// translate (\y\M\d \h\m\s \S \ \\) to (yMd hms S  \)
export function unBackslash(str, backslash = '\\') {
    if (!str) return "";
    let newStr = [];
    let len = str.length;
    for (let i = 0; i < len; i++) {
        if (str[i] === '\\') {
            if (i === len - 1) {
                console.warn('Found unmatched backslash in the end of your string');
                newStr.push(str[i]);
                break;
            } else {
                newStr.push(str[++i]);
                continue;
            }
        }
        newStr.push(str[i]);
    }
    return newStr.join('');
}

export function anyMatch(str, ...patterns) {
    for(let i in patterns) {
        let pattern = patterns[i];
        if (RegExp(pattern).test(str)) return true;
    }
    return false;
}

export function allMatch(str, ...patterns) {
    for(let i in patterns) {
        let pattern = patterns[i];
        if (!RegExp(pattern).test(str)) return false;
    }
    return true;
}

export function anyExt(filename, ...exts) {
    for(let i in exts) {
        let ext = exts[i];
        if (RegExp(`.*\\.${ext}`).test(filename)) return true;
    }
    return false;
}

export function getTextWidth(text) {
    const sensor = document.createElement('pre');
    sensor.innerText = text;
    sensor.style.position = 'absolute';
    sensor.style.left = '-1000px';
    document.body.appendChild(sensor);
    const width = sensor.clientWidth;
    document.body.removeChild(sensor);
    return width;
}

export function reapt(c, n){
    if (typeof n !== 'number') return null
    const num = Number(n)
    if (num < 0 || num > (1<<16)) return null
    let s = ""
    for (let i=0; i<n; i++) {
        s += c;
    }
    return s;
}

/*
reaptStrings(['-', '.'], [1, 2, 3, 4])  -->  -..---....
 */
export function reaptStrings(strs, repeats) {
    let offset = 0
    let mod = strs.length
    let s = ""
    for (let i in repeats) {
        s += reapt(strs[offset], (repeats[i]))
        offset = (offset + 1) % mod;
    }
    return s;
}

// unreaptStrings('-..---....')  -->  [['-', '.'], [1, 2, 3, 4]]
export function unreaptStrings(s) {
    let strs = []
    let repeats = []
    let lastChar
    for (let i = 0, size = s.length; i<size; i++) {
        let c = s[i]
        if (c !== lastChar) {
            repeats.push(1)
            strs.push(c)
            lastChar = c
        } else {
            repeats[repeats.length - 1]++
        }
    }
    return [strs, repeats]
}


