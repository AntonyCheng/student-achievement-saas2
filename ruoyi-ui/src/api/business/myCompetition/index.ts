import request from '@/utils/request';
import { AxiosPromise } from 'axios';
import { CompetitionVO, CompetitionForm, CompetitionQuery } from '@/api/business/myCompetition/types';

/**
 * 查询在校竞赛管理列表
 * @param query
 * @returns {*}
 */
export const listCompetition = (query?: CompetitionQuery): AxiosPromise<CompetitionVO[]> => {
  return request({
    url: '/business/competition/my/list',
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
    url: '/business/competition/my/' + competitionId,
    method: 'get'
  });
};

/**
 * 新增在校竞赛管理
 * @param data
 */
export const addCompetition = (data: CompetitionForm) => {
  return request({
    url: '/business/competition/my',
    method: 'post',
    data: data
  });
};

/**
 * 修改在校竞赛管理
 * @param data
 */
export const updateCompetition = (data: CompetitionForm) => {
  return request({
    url: '/business/competition/my',
    method: 'put',
    data: data
  });
};

/**
 * 删除在校竞赛管理
 * @param competitionId
 */
export const delCompetition = (competitionId: string | number | Array<string | number>) => {
  return request({
    url: '/business/competition/my/' + competitionId,
    method: 'delete'
  });
};

/**
 * 佐证材料上传
 * @param data
 */
export const uploadFile = (data: FormData) => {
  return request({
    url: '/business/competition/my/file',
    method: 'post',
    data: data
  });
};
