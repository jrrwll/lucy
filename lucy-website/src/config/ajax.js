import axios from 'axios'
import {pruneObject} from "../util";

const BASE_URL = `http://api.damnpoor.com/v1`;
axios.defaults.timeout = 5000;
axios.defaults.withCredentials = false;
axios.defaults.headers['content-type'] = 'application/json;charset=UTF-8';
axios.defaults.baseURL = BASE_URL;

export const ajax = {
    request(method, {url, data, params, headers = {}, ...config}, prune) {
        return new Promise((resolve, reject) => {
            axios({
                method: method.toLowerCase(),
                url: url,
                headers: headers,
                data: prune ? pruneObject(data) : data,
                params: prune ? pruneObject(params) : params,
                ...config,
            }).then(res => {
                // pass the response object to the returned promise
                resolve(res)
            }, err => {
                if (!err.Cancel) {
                    reject(err)
                }
            }).catch(err => {
                reject(err)
            })
        })
    },
    get(options, prune = true) {
        return ajax.request("get", options, prune);
    },
    post(options, prune = true) {
        return ajax.request("post", options);
    },
    put(options, prune = true) {
        return ajax.request("put", options);
    },
    del(options, prune = true) {
        return ajax.request("delete", options);
    },
    isCancel(err) {
        return axios.isCancel(err);
    },
    BASE_URL: BASE_URL,
};
