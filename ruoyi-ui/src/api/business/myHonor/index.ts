import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { HonorVO, HonorForm, HonorQuery } from '@/api/business/myHonor/types';

/**
 * 查询在校荣誉管理列表
 * @param query
 * @returns {*}
 */
export const listHonor = (query?: HonorQuery): AxiosPromise<HonorVO[]> => {
  return request({
    url: '/business/honor/my/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询在校荣誉管理详细
 * @param honorId
 */
export const getHonor = (honorId: string | number): AxiosPromise<HonorVO> => {
  return request({
    url: '/business/honor/my/' + honorId,
    method: 'get'
  });
};

/**
 * 新增在校荣誉管理
 * @param data
 */
export const addHonor = (data: HonorForm) => {
  return request({
    url: '/business/honor/my',
    method: 'post',
    data: data
  });
};

/**
 * 修改在校荣誉管理
 * @param data
 */
export const updateHonor = (data: HonorForm) => {
  return request({
    url: '/business/honor/my',
    method: 'put',
    data: data
  });
};

/**
 * 删除在校荣誉管理
 * @param honorId
 */
export const delHonor = (honorId: string | number | Array<string | number>) => {
  return request({
    url: '/business/honor/my/' + honorId,
    method: 'delete'
  });
};

/**
 * 佐证材料上传
 * @param data
 */
export const uploadFile = (data: FormData) => {
  return request({
    url: '/business/honor/my/file',
    method: 'post',
    data: data
  });
};
