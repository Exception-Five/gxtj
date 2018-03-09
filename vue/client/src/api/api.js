import axios from 'axios';

// user
export const requestLogin = params => { return axios.post(`/public/login`, params).then(res => res.data); };

export const requestRegister = params => { return axios.post(`/public/user/register`, params).then(res => res.data);};

export const activate = code => { return axios.post(`/public/user/activate/${code}`).then(res => res.data)};

export const updateUser = params => { return axios.post(`/api/user/updateUser`, params)};

export const addUser = params => { return axios.post(`/api/user/addUser`, params)};


//information
export const getInfoByInfoId = id => { return axios.get(`/public/information/getInfoByInfoId/${id}`).then(res => res.data); };

//根据阅读的文章推送优质文章
export const getPushInfo = param => { return axios.post(`/public/pushInfo`,param).then(res => res.data); };

