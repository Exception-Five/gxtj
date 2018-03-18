import axios from 'axios';

axios.interceptors.request.use(
   config => {
      if(window.localStorage.getItem('token')){
         config.headers.token = window.localStorage.getItem('token');
      }
     return config;
   },
   err => {
      return Promise.reject(err);
});
// user
export const requestLogin = params => { 
   return axios.post(`/public/login`, params).then((res)=>{
      let token = res.headers.refresh
      window.localStorage.setItem('token',token);
      window.localStorage.setItem('user',JSON.stringify(res.data.result))
      return res
   }); 
};

export const requestRegister = params => { return axios.post(`/public/user/register`, params).then(res => res.data);};

export const activate = code => { return axios.post(`/public/user/activate/${code}`).then(res => res.data)};

export const updateUser = params => { return axios.post(`/api/user/updataUserInfo`, params)};

export const addUser = params => { return axios.post(`/api/user/addUser`, params)};


/* information */
export const getInfoByInfoId = id => { return axios.post(`/public/information/getInfoByInfoId/${id}`).then(res => res.data); };

/* 文章推送 */
export const getPushInfo = param => { return axios.post(`/public/pushInfo`,param).then(res => res.data); };

export const pushUserByLogInfo = () => { return axios.post(`/api/push/pushUserByLogInfo`).then(res => res.data); };


//根据资讯发布时间获取资讯（ 20 条）
export const getInfoByDate = page => { return axios.get(`/public/information/findInfoByDate/${page}`).then(res => res.data); };

//根据id修改资讯
export const updateInfo = param => { return axios.post(`/public/information/updateInfo`, param).then(res => res.data); };

//根据searchContent返回资讯列表
export const getInfoBySearchBar = param => { return axios.post(`/public/search/getInfoBySearchBar`, param).then(res => res.data); };

/* comment */
export const getCommentsByInfoId = id => { return axios.get(`/public/information/${id}/comment`).then(res => res.data); };

export const getHotComments = () => { return axios.get(`/public/information/hotComments`).then(res => res.data); };

export const addComment = param => { return axios.post(`/public/information/${param.infoId}/comment`, param).then(res => res.data); };

export const updateComment = param => { return axios.put(`/public/information/comment`, param).then(res => res.data); };


/* 用户模型 */
export const getUserMod = () => {return axios.get(`/api/userMod/getUserMod`).then(res => res.data); };


/* 用户浏览记录 */
export const getLogInfos = () => {return axios.get(`/api/logInfo/getLogInfos`).then(res => res.data); };
//获取用户最近浏览新闻
export const getLogInfoNowadays = () => {return axios.post(`/api/logInfo/getLogInfoNowadays`).then(res => res.data); };

