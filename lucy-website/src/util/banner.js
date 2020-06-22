import {unreaptStrings} from "./text";


export function showBannerCode(banner) {
    let s = `var _1=(c, n)=>{let s = "";for(let i=0;i<n;i++){s+=c;}return s;};`
    s += `var _2=(s, p)=>{let o = 0;let m = s.length;let r = "";for (let i in p) {r += _1(s[o],(p[i]));o=(o+1)%m;}return r;};`
    s += `var _3=console.log;`

    let lines = banner.split('\n')
    for (let i = 0, size = lines.length; i < size; i++) {
        let [strs, repeats] = unreaptStrings(lines[i]);
        s += `_3(_2([${strs.map(it => `'${it}'`).join(",")}],[${repeats}]));`
    }
    return s
}


var _1 = (c, n) => {
    let s = "";
    for (let i = 0; i < n; i++) {
        s += c;
    }
    return s;
};
var _2 = (s, p) => {
    let o = 0;
    let m = s.length;
    let r = "";
    for (let i in p) {
        r += _1(s[o], (p[i]));
        o = (o + 1) % m;
    }
    return r;
};
var _3 = console.log;
