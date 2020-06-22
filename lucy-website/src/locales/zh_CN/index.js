import {head, sidebar} from './common';
import {ip, tool, view} from './home';
import {default as auth} from './auth';
import {flatObject} from "../../util";

export default flatObject({
    common: {
        head, sidebar,
    },
    home: {
        tool, ip, view
    },
    auth,
});
