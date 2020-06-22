// based on window.location.search
export function getSearchValue(key, defaultValue) {
    let search = window.location.search;
    if (search) {
        search = search.slice(1);
        const query = queryStringToObject(search);
        if (query && query[key]) {
            if (typeof defaultValue === 'number') {
                let value = Number(query[key]);
                if (Number.isNaN(value)) value = defaultValue;
                return value;
            } else {
                return query[key];
            }
        }
    }
    return defaultValue;
}

export function queryStringToObject(queryString, alsoStatement = false) {
    if (!queryString) {
        if (alsoStatement) {
            return {
                query: {},
                statement: "",
            }
        } else return {};
    }

    let query = {};
    let statement = "";
    let len = queryString.length;
    let i = queryString.indexOf('#');
    if (i !== -1) {
        if (alsoStatement && i !== len - 1) {
            statement = queryString.slice(i + 1);
        }
        queryString = queryString.slice(0, i);
    }
    queryString.split('&').forEach((value, index) => {
        let i = value.indexOf('=');
        if (i !== -1 && i !== value.length - 1) {
            query[value.slice(0, i)] = value.slice(i + 1);
        }
    });

    if (alsoStatement) {
        return {
            query: query,
            statement: statement,
        }
    } else return query;
}

export function getOrigin() {
    return window.location.protocol + "//" + window.location.host;
}

export function openLink(url, target = undefined) {
    let link = document.createElement("a");
    link.href = url;
    link.style = "visibility:hidden";
    if (target) link.target = target;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}

export function openBlankLink(url) {
    openLink(url, '_blank')
}

//// //// ////    //// //// ////    //// //// ////    //// //// ////    //// //// ////

// only works for firefox
export function getInternalIP(callback) {
    //compatibility for firefox and chrome
    window.RTCPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;

    const pc = new RTCPeerConnection({iceServers: []});
    const noop = () => {
    };

    //listen for candidate events
    pc.onicecandidate = (ice) => {
        if (ice.candidate) {
            handleCandidate(ice.candidate.candidate, callback);
        }
    };

    //create a bogus data channel
    pc.createDataChannel('');

    // create offer and set local description
    pc.createOffer(pc.setLocalDescription.bind(pc), noop);
}

function handleCandidate(candidate, callback) {
    let ip_regexp = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/;
    let ip_match = candidate.match(ip_regexp);
    if (ip_match && ip_match[1]) {
        callback(ip_match[1]);
    }
}

