import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CompetitionVO, CompetitionForm, CompetitionQuery } from '@/api/business/competition/types';

/**
 * 查询在校竞赛管理列表
 * @param query
 * @returns {*}
 */
export const listCompetition = (query?: CompetitionQuery): AxiosPromise<CompetitionVO[]> => {
  return request({
    url: '/business/competition/list',
    method: 'get',
    params: query
  });
};

/**
 * 查询在校竞赛管理详细
 * @param competitionId
 */
export const getCompetition = (competitionId: string | number): AxiosPromise<CompetitionVO> => {
  return request({
    url: '/business/competition/' + competitionId,
    method: 'get'
  });
};

/**
 * 删除在校竞赛管理
 * @param competitionId
 */
export const delCompetition = (competitionId: string | number | Array<string | number>) => {
  return request({
    url: '/business/competition/' + competitionId,
    method: 'delete'
  });
};
