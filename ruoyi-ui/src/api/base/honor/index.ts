import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { HonorVO, HonorForm, HonorQuery } from '@/api/base/honor/types';

/**
 * 查询荣誉类型列表
 * @param query
 * @returns {*}
 */

export const listHonor = (query?: HonorQuery): AxiosPromise<HonorVO[]> => {
  return request({
    url: '/base/honor/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询荣誉类型详细
 * @param honorTypeId
 */
export const getHonor = (honorTypeId: string | number): AxiosPromise<HonorVO> => {
  return request({
    url: '/base/honor/' + honorTypeId,
    method: 'get'
  });
};

/**
 * 新增荣誉类型
 * @param data
 */
export const addHonor = (data: HonorForm) => {
  return request({
    url: '/base/honor',
    method: 'post',
    data: data
  });
};

/**
 * 修改荣誉类型
 * @param data
 */
export const updateHonor = (data: HonorForm) => {
  return request({
    url: '/base/honor',
    method: 'put',
    data: data
  });
};

/**
 * 删除荣誉类型
 * @param honorTypeId
 */
export const delHonor = (honorTypeId: string | number | Array<string | number>) => {
  return request({
    url: '/base/honor/' + honorTypeId,
    method: 'delete'
  });
};
