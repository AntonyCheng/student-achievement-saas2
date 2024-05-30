import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { HonorVO, HonorForm, HonorQuery } from '@/api/business/honor/types';

/**
 * 查询在校荣誉管理列表
 * @param query
 * @returns {*}
 */
export const listHonor = (query?: HonorQuery): AxiosPromise<HonorVO[]> => {
  return request({
    url: '/business/honor/list',
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
    url: '/business/honor/' + honorId,
    method: 'get'
  });
};

/**
 * 删除在校荣誉管理
 * @param honorId
 */
export const delHonor = (honorId: string | number | Array<string | number>) => {
  return request({
    url: '/business/honor/' + honorId,
    method: 'delete'
  });
};
