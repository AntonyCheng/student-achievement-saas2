import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CompetitionVO, CompetitionForm, CompetitionQuery } from '@/api/business/stuCompetition/types';

/**
 * 查询在校竞赛管理列表
 * @param query
 * @returns {*}
 */
export const listCompetition = (query?: CompetitionQuery): AxiosPromise<CompetitionVO[]> => {
  return request({
    url: '/business/competition/stu/list',
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
    url: '/business/competition/stu/' + competitionId,
    method: 'get'
  });
};

/**
 * 修改在校竞赛管理
 * @param data
 */
export const updateCompetition = (data: CompetitionForm) => {
  return request({
    url: '/business/competition/stu',
    method: 'put',
    data: data
  });
};
