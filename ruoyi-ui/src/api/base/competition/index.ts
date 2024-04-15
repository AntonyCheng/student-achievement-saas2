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
 * 查询竞赛类型详细
 * @param competitionId
 */
export const getCompetition = (competitionId: string | number): AxiosPromise<CompetitionVO> => {
  return request({
    url: '/base/competition/' + competitionId,
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
 * @param competitionId
 */
export const delCompetition = (competitionId: string | number | Array<string | number>) => {
  return request({
    url: '/base/competition/' + competitionId,
    method: 'delete'
  });
};
