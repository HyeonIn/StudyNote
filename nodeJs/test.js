const nodemailer = require('nodemailer');
const email = {
    "host" : "",
    "port" : "",
    "secure" : false,
    "auth" : {
        "user" : "",
        "pass" : ""
    }
}
const send = async (option) => {
    nodemailer.createTransport(email)
}