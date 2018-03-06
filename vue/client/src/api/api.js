import axios from 'axios';

// user
export const requestLogin = params => { return axios.post(`/public/login`, params).then(res => res.data); };

export const requestRegister = params => { return axios.post(`/public/user/register`, params)};

export const activate = code => { return axios.post(`/public/user/activate/{code}`)};

export const updateUser = params => { return axios.post(`/api/user/updateUser`, params)};

export const addUser = params => { return axios.post(`/api/user/addUser`, params)};
