import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { HonorVO, HonorForm, HonorQuery } from '@/api/business/stuHonor/types';

/**
 * 查询在校荣誉管理列表
 * @param query
 * @returns {*}
 */
export const listHonor = (query?: HonorQuery): AxiosPromise<HonorVO[]> => {
  return request({
    url: '/business/honor/stu/list',
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
    url: '/business/honor/stu/' + honorId,
    method: 'get'
  });
};

/**
 * 修改在校荣誉管理
 * @param data
 */
export const updateHonor = (data: HonorForm) => {
  return request({
    url: '/business/honor/stu',
    method: 'put',
    data: data
  });
};
