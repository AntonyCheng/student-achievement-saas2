import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CompetitionVO, CompetitionForm, CompetitionQuery } from '@/api/base/competition/types';

/**
 * 查询竞赛类型列表
 * @param query
 * @returns {*}
 */

export const listCompetition = (query?: CompetitionQuery): AxiosPromise<CompetitionVO[]> => {
  return request({
    url: '/base/competition/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询有效竞赛类型列表
 */
export const listCompetitionAvailable = () => {
  return request({
    url: '/base/competition/list/available',
    method: 'get'
  });
};

/**
 * 查询竞赛类型详细
 * @param competitionTypeId
 */
export const getCompetition = (competitionTypeId: string | number): AxiosPromise<CompetitionVO> => {
  return request({
    url: '/base/competition/' + competitionTypeId,
    method: 'get'
  });
};

/**
 * 新增竞赛类型
 * @param data
 */
export const addCompetition = (data: CompetitionForm) => {
  return request({
    url: '/base/competition',
    method: 'post',
    data: data
  });
};

/**
 * 修改竞赛类型
 * @param data
 */
export const updateCompetition = (data: CompetitionForm) => {
  return request({
    url: '/base/competition',
    method: 'put',
    data: data
  });
};

/**
 * 删除竞赛类型
 * @param competitionTypeId
 */
export const delCompetition = (competitionTypeId: string | number | Array<string | number>) => {
  return request({
    url: '/base/competition/' + competitionTypeId,
    method: 'delete'
  });
};
