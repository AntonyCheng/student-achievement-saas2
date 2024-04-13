import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { MajorVO, MajorForm, MajorQuery } from '@/api/base/major/types';

/**
 * 查询专业列表
 * @param query
 * @returns {*}
 */

export const listMajor = (query?: MajorQuery): AxiosPromise<MajorVO[]> => {
  return request({
    url: '/base/major/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询专业详细
 * @param majorId
 */
export const getMajor = (majorId: string | number): AxiosPromise<MajorVO> => {
  return request({
    url: '/base/major/' + majorId,
    method: 'get'
  });
};

/**
 * 新增专业
 * @param data
 */
export const addMajor = (data: MajorForm) => {
  return request({
    url: '/base/major',
    method: 'post',
    data: data
  });
};

/**
 * 修改专业
 * @param data
 */
export const updateMajor = (data: MajorForm) => {
  return request({
    url: '/base/major',
    method: 'put',
    data: data
  });
};

/**
 * 删除专业
 * @param majorId
 */
export const delMajor = (majorId: string | number | Array<string | number>) => {
  return request({
    url: '/base/major/' + majorId,
    method: 'delete'
  });
};
